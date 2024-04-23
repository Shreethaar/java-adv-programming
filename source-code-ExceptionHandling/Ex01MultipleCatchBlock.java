package ex03;


import java.util.*;
import java.util.Scanner;

public class Ex01MultipleCatchBlock 
{
    public static void main(String[] args) 
    {
        int num1;
        double num2;
        String nama;
        
        Scanner scan = new Scanner(System.in);
        
        try
        {
            System.out.print("Input integer value = ");
            num1 = scan.nextInt(); // InputMismtachException
            
            System.out.println("average part");
            double avg = 4/1; // ArithmeticException -divide by 0
            
            System.out.println("Array Part");
            int nom [] = new int[3];
            nom[3] = 10; // ArrayIndexOutOfBoundsException
            
            
        }
        
        catch (ArithmeticException ex)
        {
            System.out.println("error divide by 0");
            ex.printStackTrace();
        }
        catch (InputMismatchException ex)
        {
            System.out.println("Mismatch value");
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
        }
        
        catch (ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("error - index out of bound");
            ex.printStackTrace();
        }
                      
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        // statement after tr catch block
        System.out.println("The end of this coding");
        
    } // main
    
} // class
