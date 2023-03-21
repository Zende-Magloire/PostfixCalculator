import java.util.StringTokenizer;

public class PostfixCalculator {
    public PostfixCalculator() {
    }

    private String operator;

    public static int precedenceLevel(String op)
    {
        switch (op)
        {
            case "+":
            case "-":
                return 0;
            case "*":
            case "/":
            case "^":
                return 1;
            case "(":
            case ")":
                return 2;
            default:
                return -1;
        }
    }

    public static boolean isOperator(String token)
    {
        if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*") || token.equals("^"))
        {
            return true;
        }
        return false;
    }


    public static double operate(String op, double a, double b)
    {
        String operator = op;
        switch (op)
        {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return Math.pow(a,b);
            default:
                return 0;
        }
    }

    public static String infix2postfix(String infix) {
        String operator = "";

        // Algorithm to convert infix string to postfix string
        // create an empty string for postfix expression
        String postfix = new String();
        // create a stack of strings
        Stack<String> mStack = new Stack<>();
        // tokenize the infix expression with a delimiter of space
        StringTokenizer tokenizer = new StringTokenizer(infix, " ");
        // while tokenizer has more tokens
        while (tokenizer.hasMoreTokens()) {
            //   token = get next token from tokenizer
            String token = tokenizer.nextToken();

            //   if token is an open parenthesis
            if (token.equals("("))
            {
                //  push token on stack
                mStack.push(token);
            }

            //   else if token is a close parenthesis
            else if (token.equals(")")) {
                //  operator = pop top from stack
                operator = mStack.pop();
                //  while operator doesn't equal open parenthesis
                while (!operator.equals("("))
                {
                    // append operator and a single space to postfix expression
                    postfix += operator + " ";
                    // operator = pop top from stack
                    operator = mStack.pop();
                }
            }

            //   else if token is an operator
            else if (isOperator(token))
           {
                // while stack is not empty and precedence of token is less than top of stack (peek)
                while (!mStack.isEmpty() && precedenceLevel(token) < precedenceLevel(mStack.peek()))
                {
                    // pop top from stack and append it and single space to postfix expression
                    String tp = mStack.pop();
                    postfix += tp + " ";
                }
                //  after loop, push operator token onto stack
                mStack.push(token);
           }

            //   else
            else {
                //  append token and single space to postfix expression
                postfix += token + " ";
            }
        }

        // while stack is not empty
        while (!mStack.isEmpty())
        {
            //   pop and append operator and single space to postfix expression
            operator = mStack.pop();
            postfix += operator + " ";
            //  return postfix expression
        }
        System.out.println("Postfix: " + postfix);
        return postfix;
    }

    public static double solve(String postfix) {
        // Algorithm to solve postfix expression
        //
        // create a stack of doubles
        Stack<Double> dStack = new Stack<>();
        // tokenize the postfix expression with a delimiter of space
        StringTokenizer tokenizer = new StringTokenizer(postfix, " ");
        // while tokenizer has more tokens
        while (tokenizer.hasMoreTokens())
        {
            //   token = get next token from tokenizer
            String dToken = tokenizer.nextToken();
            //   if token is an operator
            if (isOperator(dToken))
            {
                //     operand b = pop top of stack
                Double operandB = dStack.pop();
                //     operand a = pop top of stack
                Double operandA = dStack.pop();
                //     result = a operator b
                Double result = operate(dToken, operandA, operandB);
                //     push result onto stack
                dStack.push(result);
            }
            //   else
            else
            {
                // convert token to double and push onto stack
                try
                {
                    Double token_doub = Double.valueOf(String.valueOf(dToken));
                    dStack.push(token_doub);
                }
                catch(NumberFormatException e )
                {

                }
            }
        }
            // there should only be 1 element left in the stack now
            // if there is more than 1 element or the stack is empty, you have a bug
            // answer = pop off top of stack
            Double answer = dStack.pop();
            // return answer
        return answer;
    }
}
