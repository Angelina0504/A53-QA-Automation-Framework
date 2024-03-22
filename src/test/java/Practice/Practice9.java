package Practice;

import java.util.Scanner;

public class Practice9 {
    public static void main (String args[]) {
        String call = "Enter a number: ";
        String report = "Factorial = ";

        System.out.println(call);
        Scanner objIn = new Scanner(System.in);
        int n = objIn.nextInt();
        objIn.close();
        int product = 1;
        for (int i = 2; i <= n; i++){
        product = product * i;
        }
        System.out.println(report + product);
    }
}
