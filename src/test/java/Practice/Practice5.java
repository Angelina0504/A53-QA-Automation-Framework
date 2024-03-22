package Practice;

import java.util.Scanner;

public class Practice5 {
    public static void main(String[] args) {
        // method1();
        // method2();
        //Practice7 myPractice7 = new Practice7();
       // myPractice7.main();


        final int LIMIT = 10;
        final String DECL1 = "Provide binary sign:" + "operation\n";
        final String DECL2 = "Provide in order:" + "both numbers\n";
        final String REPORT = "Result: \n";
        //input the sign and two numbers
        Scanner objIn = new Scanner(System.in);
        System.out.println(DECL1);
        // specification of input of the sign
        final char operationSign = objIn.next().charAt(0);//return index, so the 1st index will be return
        // If we are using Strings, charAt method, start counting from 0, Example 0,1,2,3, and so on.
        // If we enter 2 and provide in the console +-*/ we will get only * sign, because we apply only number 2
        System.out.println(operationSign);
        System.out.println(DECL2);
        float x = objIn.nextFloat();
        float y = objIn.nextFloat();
        float result = 0;
        //Example
        //float result = 12;
        // float result;
        //provide the absolute value to the variable

        if (operationSign == '-') {
            result = x - y;
            //float result = x - y;
            //System.out.println(REPORT + result);
        } else if (operationSign == '+') {
            result = x + y;
            //System.out.println(REPORT + result);
        } else if (operationSign == '*') {
            result = x * y;
           // System.out.println(REPORT + result);
        } else if (operationSign == '/') {
             result = x / y;
            //System.out.println(REPORT + result);
        }else {
            System.out.println(false);
           return;
        }
        System.out.println(REPORT + result);
    }
}
/*class Practice7 {
    public static void main(String[] args) {

        String declaration = "Input sign: ";
        String report = "Result work switch: ";
        //input of sign from console
        System.out.println(declaration);
        Scanner objInt = new Scanner(System.in);
        final char CH = objInt.next().charAt(0);
        int i = 0;
        switch (CH) {
            case 'a':
                i += 2;
                break;
            case 'b':
                i *= 3;
                break;
            case 'c':
                i /= 2;
                break;
            // 102 : code 'f', Why we have to enter 'f'
            case 102:
                i -= 5;
                break;
            default:
                ;
                break; //empty operator

        }
        System.out.println(report + i);
    }
}
*/

