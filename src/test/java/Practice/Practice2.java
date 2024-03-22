package Practice;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        final int LIMIT = 10;
        String str = "Number: ";
        String report1 = "Number < LIMIT\n";
        String report2 = "Number >= LIMIT\n";

        System.out.print(str);
        Scanner objIn = new Scanner(System.in);
        // int number = objIn.nextInt();
        float number = objIn.nextFloat();
        //objIn.close();
        if (number < LIMIT) { //false state because number is equal to 10
            // if number is equal to 9, returns true statement, and if statement = report1 = "Number < LIMIT
            System.out.print(report1);
        } else {
            System.out.print(report2);
        }
        int i = 4;
        int j = 1;
        if (i > j) {
            i++;
            System.out.println(i);
        } else {
            j = i - 3;
            i--;
            System.out.println(j);
            System.out.println(i);
        }

        final float R = 1.5f;
        String str1 = "Coordinates x and y: \n";
        String report3 = "The dot in the circle: \n";
        String report4 = "The dot outside of the circle: \n";

        System.out.println(str1);
        //Scanner objInt1 = new Scanner(System.in);
        float x = objIn.nextFloat();
        float y = objIn.nextFloat();
        //objIn.close();
        boolean condition = x * x + y * y <= R * R;
        if (condition) {
            System.out.println(report3);
        }
        else{
            System.out.println(report4);
        }
        final float R1 = 1.5f;
        String str2 = "Coordinates x and y: \n";
        String report5 = "The dot in the circle: \n";
        String report6 = "The dot outside of the circle: \n";

        System.out.println(str2);
        //S
    }


    /*//practice 1
    int age = 75;
    if(age>=18){
        System.out.println("You are an adult!");
    }
    if (age>=75){
        System.out.println("You have an discount!");
    }
    else{
        System.out.println("You age is invalid!");
        // write an exception

    }*/

}
