//-------------------------------------------------------------------
// DO NOT MAKE ANY CHANGES TO THIS CLASS
//
// If this class is not compiling, it is because of code you are
//  missing in your project (necessary classes or methods) which must
//  be named exactly correct for this class to compile.
//
// There are no bugs in this file. If an exception occurs, it is
//  because of something in one of your other classes.
//
// Any changes you make to this class will not be used for grading.
//-------------------------------------------------------------------

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner scanner_one = new Scanner(System.in);

        System.out.println("Enter infix equation (eg. 3 + -2 * 2): ");
        String infix = scanner_one.nextLine();
        System.out.println("Infix: " + infix);
        if (args != null && args.length > 0)
            infix = args[0];

        String postfix = PostfixCalculator.infix2postfix(infix);
        double result = PostfixCalculator.solve(postfix);
        System.out.println("Answer: " + result);
    }
}
