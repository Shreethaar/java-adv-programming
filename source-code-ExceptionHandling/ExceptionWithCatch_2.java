package ex02;


import java.util.InputMismatchException;
import java.util.Scanner;


public class ExceptionWithCatch_2 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try
        {
            System.out.print("Enter an integer = ");
            num = scan.nextInt(); // related to InputMismatchException - invalid input
            System.out.println("statement after input integer value");
        }
        catch (InputMismatchException e)
        {
                
           System.out.println("You must enter only integer value");
           System.out.println("System message - toString() = "+e.toString());
           System.out.println("System message - getMessage()= "+e.getMessage());
           e.printStackTrace();
        }
        
        System.out.println("The number you entered is " +num);
        //int average = 4/0;  // ArithmeticException -divide by 0
        int nom [] = new int[3]; // index  = 0..2
        //nom[3] = 2;  // ArrayIndexOutOfBoundsException
        nom[2] = 10;
        //Student stud = new Student();
       int nomInt = (int)24.5; // explicit casting - convert from double to int
       System.out.println("Value of nomInt = "+nomInt);
       
       double nomDouble1 = Double.parseDouble("2"); // convert from string into double
       System.out.println("value of nomDouble1 = "+nomDouble1);
       
       //double nomDouble2 = Double.parseDouble("two"); // NumberFormatException
    }
}
