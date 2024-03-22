package Practice;

import java.util.Scanner;

public class Practice10 {
    public static void main (String args[]){
        String call = "Enter a number: ";
        String report = "Double Factorial = ";

        System.out.println(call);
        Scanner objIn = new Scanner(System.in);
        int n = objIn.nextInt();
        objIn.close();
        int product = 1;
        for (int i = n; i > 1; i = i-2){
            product = product * i;
        }
        System.out.println(report + product);
    }
}
