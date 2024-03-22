package Practice;

import java.util.Scanner;

public class Practice6 {
    public static void main(String[] args) {
        String declaration = "Input sign: ";
        String report = "Result work switch: ";
        //input of sign from console
        System.out.println(declaration);
        Scanner objIn = new Scanner(System.in);
        final char CH = objIn.next().charAt(0);
        //System.out.println(CH);
        int i = 0;

         switch (CH)
        {
            case 'a' : i += 2;       //i=i+2, i=0+2
            break;
            case 'b' : i *= 3;
            break;
            case 'c' : i /= 2;
            break;
            // 102 : code 'f', Why we have to enter 'f'
            case 102: i -= 5;
            break;
            //case 'f' : i -= 5;
            // break;
            case 53: i += 53;//53 is equal to 5 in decimal system
            break;
            default: ;
            break; //empty operator

        }
        System.out.println(report + i);
    }
}
