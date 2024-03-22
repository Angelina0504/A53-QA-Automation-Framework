package Practice;

import java.util.Scanner;

public class Practice4 {
    public static void main(String[] args) {

        final int LIMIT = 10;
        String str = "Provide number: \n";
        String report1 = "Number < LIMIT: \n";
        String report2 = "Number = LIMIT: \n";
        String report3 = "Number > LIMIT: \n";
        System.out.println(str);
        Scanner objIn = new Scanner(System.in);
        float number = objIn.nextFloat();
        objIn.close();
        if (number < LIMIT) {
            System.out.println(report1);
        } else if (number == LIMIT) {
            System.out.println(report2);
        } else {
            System.out.println(report3);
        }
    }
}
