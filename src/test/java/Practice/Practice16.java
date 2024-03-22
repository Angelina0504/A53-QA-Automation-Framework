package Practice;

import java.util.Scanner;

public class Practice16 {
    public static int task5_3() {
        int number = 20;
        for (int i = 20; i <= 35; i++) {
            System.out.println(i);
        } return number;
    }
    public static double sqrtTask5_3_1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter b number: ");
        int b = in.nextInt();
        //b = 12
        if (b >= 10) {
            for (int a = 10; a <= b; a++) {
                double sqrt = Math.sqrt(a);
                System.out.println("Sqrt root of  " + a + "  is equal to:  " + sqrt);
            }
        }
            else {
                System.out.println("b is greater or equal to 10" );
            } return b;
    }
    public static double cbrtTask5_3_3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = in.nextInt();
        //a=48
        if (a <= 50) {
            for (int j = a;  j <=50 ; j++) {
                double cubicRoot = Math.cbrt(j);
                System.out.println("Cubic root of  " + j + "  is equal to:  " + cubicRoot);
            }
        } else {
            System.out.println("a is greater or equal to 50" );
        } return a;
    }
    public static void main (String [] args){
        int DecNumbers = task5_3();
            System.out.println("Return number is :  "  + DecNumbers);
        double SqrtNumber = sqrtTask5_3_1();
        //System.out.println("b is equal to 11.");
        //double cubicNumber = cbrtTask5_3_3();


        //System.out.println(cubicNumber.int);
    }
}
