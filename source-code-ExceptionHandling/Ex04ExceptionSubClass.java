package ex03;


import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Ex04ExceptionSubClass 
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
            num1 = scan.nextInt();
            
            double avg = 4/0;
            
        }
        
        catch (InputMismatchException ex) // InputMismatchException
        {
            System.out.println("Mismatch value");
        }
        
        catch (Exception ex) // ArithmeticException
        {
            System.out.println("error divide by 0");
        }
        
        // statement after catch block
        System.out.println("The end of this coding");
        
    } // main
    
}
