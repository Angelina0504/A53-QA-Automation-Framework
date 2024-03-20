package Practice;

public class Practice8 {
    //create methods for adding new parameters, for better reading
    //Method to calculate Box
    public static double addBox (double a, double b){
        return a + b;
    }

    //Method to calculate SumValue loop for
    public static int sumValue(){
        int Sum = 0;
        int i;
        for(i = 1; i<=10; i++) {
            Sum = Sum + i * i;  }   //counter last assign number 11 , not 10
            System.out.println("Sum = " + Sum);
        return Sum;
    }

    //Main method
    public static void main (String[] args){
        //we do not write a code in here
        //using this code for calling the other methods on the top

        //run method addBox
        double a = 2.0;
        double b = 1.0;
        double sumBox = addBox(a, b);
        System.out.println("SumBox coffee: " + sumBox);

        // run method sumValue
        //int SumVariable = sumValue();
        sumValue();
       // System.out.println("SummaVariable: " + SumVariable);
    }

}
