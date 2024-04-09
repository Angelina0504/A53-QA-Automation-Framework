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
        //Scanner in = new Scanner(System.in);
        //System.out.println("Enter b number: ");
        //int b = in.nextInt();
        int b = 12;
        int exp = 2;
        if (b >= 10) {
            for (int a = 10; a <= b; a++) {
                double result = Math.pow(a, exp);

                System.out.println("Power is equal to:  " + result);
            }

        }
        return 0;
    }
    //public static float task5_4(){
       // int a = 5;
        //int b = 10;

   // }
    public static double cbrtTask5_3_3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = in.nextInt();
        int exp = 3;
        if (a <= 50) {
            for (int j = a;  j <=50 ; j++) {
                double result1 = Math.pow(j, exp);
                System.out.println("Power is equal to:  " + result1);
            }
        } return 0;
    }
    public static void main (String [] args){
        int DecNumbers = task5_3();
            System.out.println("Return number is :  "  + DecNumbers);
        double SqrtNumber = sqrtTask5_3_1();
        //System.out.println("b is equal to 11.");
        double cubicNumber = cbrtTask5_3_3();


        //System.out.println(cubicNumber.int);
    }
}
