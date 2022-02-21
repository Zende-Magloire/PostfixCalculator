import java.util.StringTokenizer;

public class PostfixCalculator
{
    public PostfixCalculator()
    {
    }

    public static String infix2postfix(String infix)
    {
        // Algorithm to convert infix string to postfix string
        // create an empty string for postfix expression
        String postfix = new String();
        // create a stack of strings
        Stack<String> mStack = new Stack<>();
        // tokenize the infix expression with a delimiter of space
        StringTokenizer tokenizer = new StringTokenizer(infix, " ");
        // while tokenizer has more tokens
        while (tokenizer.hasMoreTokens())
        {
            //   token = get next token from tokenizer
            String token = tokenizer.nextToken();

            //   if token is an open parenthesis
            if (token.equals("("))
            {
                //  push token on stack
                mStack.push(token);
            }
            //   else if token is a close parenthesis
            else if (token.equals(")")) ;
            {
                //  operator = pop top from stack
                String operator = mStack.pop();
                //  while operator doesn't equal open parenthesis
                while (!operator.equals("(")) {
                    // append operator and a single space to postfix expression
                    mStack.push(operator);
                    mStack.push(" ");
                    // operator = pop top from stack
                    operator = mStack.pop();
                }
            }
            //   else if token is an operator
            else if ()
            {
                // while stack is not empty and precedence of token is less than top of stack (peek)
                while (!mStack.isEmpty())
                {
                    // pop top from stack and append it and single space to postfix expression
                }
                //  after loop, push operator token onto stack
            }
            //
            //   else
            {
                //  append token and single space to postfix expression
            }
        }
        // while stack is not empty
        while (!mStack.isEmpty()) {
            //   pop and append operator and single space to postfix expression

            //  return postfix expression
            return postfix;
        }
        return "";
    }

    public static double solve(String postfix)
    {
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
            if ()
            {
                //     operand b = pop top of stack
                Double operandB = dStack.peek();
                //     operand a = pop top of stack
                Double operandA = dStack.peek();
                //     result = a operator b
                Double result = ;
                //     push result onto stack
                dStack.push(result);
            }
            //   else
            else
            //     convert token to double and push onto stack
                String dToken = tokenizer.nextToken();
        }
        // there should only be 1 element left in the stack now
        // if there is more than 1 element or the stack is empty, you have a bug
        // answer = pop off top of stack
        Double answer = dStack.pop();
        // return answer

        return 0;
    }
}
