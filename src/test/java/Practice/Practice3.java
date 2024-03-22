package Practice;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args){

    final float R = 1.5f;
    String str9 = "Coordinates x and y: \n";
    String report9 = "The dot in the circle 2: \n";
    String report10 = "The dot outside of the circle 2: \n";

        System.out.println(str9);
    Scanner objIn = new Scanner(System.in);
    float x = objIn.nextFloat();
    float y= objIn.nextFloat();
    objIn.close();
    //
    final boolean AREA1 = x * x + y * y <= R * R;
    final boolean AREA2 = x <= 0;
    final boolean AREA3 = y >= 0;
    //
        if (AREA1 & AREA2 & AREA3){
        System.out.println(report9);
        }
        else {
            System.out.println(report10);
        }
    }
}
