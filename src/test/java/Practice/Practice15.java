package Practice;

public class Practice15 {
    public static int task5_0() {
        int x = 1;
        while (x <= 10){
            System.out.print(x);
            x++;
        }
        return x;
    }
    public static int task5_1(){
        int i = 0;
        while (i < 10){
            i++;
            System.out.print("20  " );
        }
        return 20;
    }
    public static void main (String [] args){

        int NewNumbers = task5_0();
        System.out.println("  Return numbers are: " + NewNumbers);

        int AddVariable = task5_1();
        System.out.println("Return number is: " + AddVariable);
    }
}
