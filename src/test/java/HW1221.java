import org.testng.annotations.Test;
import java.util.*;
public class HW1221 {
    public static void main(String[] args) {
        //java.util.Scanner in = new java.util.Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        int num = in1.nextInt();
        System.out.printf("Your number: %d \n", num);

        System.out.println("Hello World");

        System.out.print("Hello ");
        System.out.println("World!");

        System.out.print("Hello\n");
        // \n-move to the other line
        System.out.println("World!");

        System.out.println("Hello World");
        // Example x and y
        short x = 5;
        double y = 4.5;
        float z = 1.2f;
        System.out.println(x);
        System.out.println("x = " + x);
        System.out.println("x = " + x + ", y = " + y);

        System.out.printf("x = %d, y = %.1f, z = %.2f\n", x, y, z);
        // extra after decimal point 1.20f


        //can't change the constant value, and PI-capital letters for constant
        //you declare a constant using the 'final' keyword
        //Example for "b"
        final double PI = 3.14;
        short a;
        short b = 9;
        System.out.println(b);
        //Example for "e"
        int A, B;
        double e = 5.5, f;
        //float var_f = 3.5f;

        char ch = 'b';
        boolean fl = true, flF = false;

        System.out.println(e);

        //Example for "i" and "c"
        short c;
        c = 6;

        int i = 1;
        i = i + 1;
        System.out.println(i);
        System.out.println(c);

       /*
        // Example a=b
        int j = 10;
        short h = 5;
        j = h;
        //Example bring changes to an h=j, 1st before the j provide type(short),
        // so "j" variable will become an short, and only then it will become an b
        //h = (short)j;
        System.out.println();
        */
        float var_f = 8.7f;
        int var_i;
        var_i = (int)var_f;
        System.out.println(var_i);
        // Run = 8, only the whole number, vat_i = 8;


    }
}
