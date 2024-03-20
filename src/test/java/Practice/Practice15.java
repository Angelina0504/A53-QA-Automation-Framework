package Practice;

public class Practice15 {
    public static int uniqueNumber(){
        int x = 0;
        while(x <= 10) {
        System.out.print("x is =  "  + x);}
        x++;
        return x;

    }

    public static int addNumber(){
        int i = 0;
        while (i < 10){
            System.out.println("20:  ");
        }
        return 20;
    }
    public static void main (String [] args){
        int AddVariable = addNumber();
        System.out.println("Return number is : " + AddVariable);

        int NewNumbers = uniqueNumber();
        System.out.println("Return numbers are: " + NewNumbers);
    }
}
