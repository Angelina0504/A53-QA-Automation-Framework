package Practice;


import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        // java.util.Scanner in = new java.util.Scanner(System.in);
        //Task 1

        Scanner in = new Scanner(System.in);
        int a = 10, b = 4;

        int c = a + b;
        int c1 = a - b;
        int c2 = a*b;
        int c3 = a/b;

        System.out.printf("%s, %s, %s, %s\n" , c, c1, c2, c3);

       /* // second one
        System.out.println("a = : ");
        a = in.nextInt();
        System.out.println("b = : ");
        b = in.nextInt();
        int d = a + b;

        System.out.println(d);
        // 3rd
        System.out.println("a = : ");
        a = in.nextInt();
        System.out.println("b = : ");
        b = in.nextInt();
        int x = a + b;

        int x1 = a - b;
        int x2 = a * b;
        double temp = a;

        double x3 = temp/ b;
        System.out.printf("%s, %s, %s\n" , x, x1, x2);
        System.out.println( x3);
        System.out.println(a + " + " + b + " = " + x);

        System.out.printf("%d -  %d = %d\n" , a, b, x1);
        //System.out.printf("%s -  %s = %s\n" , a, b, x1);
        System.out.printf("%d *  %d = %d\n" , a, b, x2);
        System.out.printf("%s /  %d = %s\n" , a, b, x3);
        System.out.printf("%s /  %d = %.3f\n" , a, b, x3);

        String result = String.format("%s /  %d = %.3f" , a, b, x3);
        System.out.println(result);
        //
        int k1 = 402;
        int k2 = 16;
//      int k 2.5 = 16.5;      Increased by %.1f%% in %d
        int k3 = 2024;
        int k4 = 12;
        String sentence = String.format("BofA Report Finds %d(k) Account Balances Increased by %d%% in %d, Health Savings Account Balances Increased by %d%% ", k1, k2, k3, k4);
        System.out.println(sentence);




        //Example 2
        //System.out.println("a = : ");
        //a = in.nextInt();
        //System.out.println("b = : ");
        //b = in.nextInt();
        //System.out.println("c = : ");
        //c = in.nextInt();
        //double z = ((abs (a-c))/b+c)*(a)




       System.out.print("Input a Language: ");
        String n = in.nextLine();

        System.out.print("Input a Language: ");
        String n1 = in.nextLine();

        System.out.print("Input a Language: ");
        String n2 = in.nextLine();

        System.out.printf("%s-%s-%s\n", n, n1, n2);

        //Task 2
        System.out.println("First Name: ");
        String n3 = in.nextLine();

        System.out.println("Last Name: ");
        String n4 = in.nextLine();

        System.out.println("Age: ");
        int age = in.nextInt();

        System.out.printf("His name is:%s %s. His age=: %d\n", n3, n4, age);

        //Task 2 Practice: Name, Age, Height
        System.out.println("Input name: ");
        String name = in.nextLine();

        System.out.print("Input age: ");
        int age1 = in.nextInt();

        System.out.print("Input height: ");
        float height = in.nextFloat();

        System.out.printf("Name:%s.\t Age:%d.\t Height: %.2f \n", name, age1, height);

        //Task 3 practice: month, dateOfMonth, year, abnAmro, bankOFAmerica
        System.out.println("Input month: ");
        int month = in.nextInt();
        System.out.println("Input dateOfMonth: ");
        int dateOfMonth = in.nextInt();
        System.out.println("Input year: ");
        int year = in.nextInt();
        System.out.println("Amount spent $ billons: ");
        int abnAmro = in.nextInt();
        System.out.println("Amount gain $ billions: ");
        float bankOFAmerica = in.nextFloat();
        System.out.printf("Date of sale :%d-%d-%d Amount spent: %d  Amount gain: %.1f \n",
                month, dateOfMonth, year, abnAmro, bankOFAmerica);

        //Task 4 practice :accountBalance, balanceIncreased, year1, healthSavingsBalanceIncreased
        System.out.println("Account Balance (k): ");
        int accountBalance = in.nextInt();
        System.out.println("Balance Increased by: ");
        int balanceIncreased = in.nextInt();
        //System.out.println("Balance Increased: ");
        //double balanceIncreased = in.nextDouble();
        System.out.println("Input year: ");
        int year1 = in.nextInt();
        System.out.println("Balance Increased by: ");
        int healthSavingsBalanceIncreased = in.nextInt();
        System.out.printf("Account Balance: %d  Balance Increased: %d  Year: %d Balance Increased by: %d \n",
                accountBalance, balanceIncreased, year1, healthSavingsBalanceIncreased);

        //Task 5 HomeworkPractice
        System.out.println("Decimal number: ");
        int decNumber = in.nextInt();
        String binDec = Integer.toBinaryString(decNumber);
        System.out.printf("Decimal number: %d Binary number: %s\n", decNumber, binDec);

        System.out.print("Octal number: ");
        int octNumber = in.nextInt(8);
        //int binOct = Integer.parseInt(Integer.toString(octNumber), 8);
        String binNum = Integer.toBinaryString(octNumber);
        System.out.printf("Octal number: %o Binary number: %s%n \n", octNumber, binNum);



        System.out.print("Hex number: ");
        int hexNumber = in.nextInt(16);

        String binN = Integer.toBinaryString(hexNumber);
        System.out.printf("Hex number: %x Binary number: %s%n \n", hexNumber, binN);


        // Example 5
        int v1 = 12;
        int v2 = 123;
        int v3 = 1234;
        int v4 = 12345;
        System.out.printf( "'%-5d'\n",  v1);

        System.out.printf( "'%5.5s'\n",  v2);
        System.out.printf( "'%5.5s'\n",  v3);
        System.out.printf( "'%5.5s'\n",  v4);
        System.out.printf( "'%-10.5s'\n",  v1);
        System.out.printf( "'%-5.5s'\n",  v2);
        System.out.printf( "'%-5.5s'\n",  v3);
        System.out.printf( "'%-5.2s'\n",  v4);
        // do tochki eto "pole" razmer polia,
        // posle tochki skolko elementov iz stroki mu rozpechataem.

       // String s1 = String.format("%5.5s", v4); string formatiryem stroki
        String s1 = String.format("'%10d'", v4);
        String s2 = String.format("'%3d'", v4);

        System.out.println(s1);
        System.out.println(s2);


    //Example 6
        //System.out.print("Sn: ");
        float x1 = 2.234f;
        //System.out.print("Sm: ");
        float x2 = 3.342f;
        System.out.printf("Sn = %.2f; Sm = %.2f \n", x1, x2);
        //System.out.printf("Sn = %,2f; Sm = %,2f \n", x1, x2);
        //reading 2.234000, and 3.342000
        String b1 = "2.23";
        String b2 = "2,23";
        System.out.print(b1==b2);
        //boolean False
        // System.out.print(b1!=b2);
        //boolean True


        //Test practice 3#
        System.out.println("Enter decimal number: ");
        int d=in.nextInt();
        System.out.print(" Binary equivalent of " +d+" is : ");
        System.out.print(Integer.toBinaryString(d));
        int d1=in.nextInt();
        System.out.print(" Octal equivalent of " +d+" is : ");
        System.out.print(Integer.toOctalString(d));
        int d2=in.nextInt();
        System.out.println(" Hexadecimal equivalent of " +d+" is : ");
        System.out.println(Integer.toHexString(d));

        // Test practice #4
        System.out.println("Enter decimal number: ");
        int k =in.nextInt();
        System.out.print(" Binary equivalent of " +k+" is : ");
        System.out.print(Integer.toBinaryString(k));

        System.out.println("Enter Octal number: ");
        int l =in.nextInt();
        System.out.print(" Binary equivalent of " +l+" is : ");
        System.out.print(Integer.toBinaryString(l));

        System.out.println("Enter Hexadecimal number: ");
        int s =in.nextInt();
        System.out.print(" Binary equivalent of " +s+" is : ");
        System.out.print(Integer.toBinaryString(s));
*/


        in.close();
    }
}









