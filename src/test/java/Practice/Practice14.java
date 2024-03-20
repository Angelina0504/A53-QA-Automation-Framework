package Practice;

import java.util.Scanner;

public class Practice14 {
    public static void main (String args[]){
        String call = "Enter x and to the n power: ";
        String report = "x to the n power = ";

        System.out.println(call);
        Scanner objIn = new Scanner(System.in);
        double x = objIn.nextDouble();
        int n = objIn.nextInt();
        objIn.close();
        double product = 1;
        for(int i = 0; i < n; i++) {
            product = product * (-1) * x;
        }
        System.out.println(report + product);
    }

}
