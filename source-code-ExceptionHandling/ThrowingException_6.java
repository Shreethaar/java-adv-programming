/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex06;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ThrowingException_6 
{
    public static void main(String[] args) 
    {
        ThrowingException_6 test = new ThrowingException_6();
        try
        {
            test.doWork();
        }
        catch(ArithmeticException ex)
        {
            System.out.println("The message  = "+ex.getMessage());
        }
        
    }
    
    public void doWork()
    {
        Scanner input = new Scanner(System.in);
        int nom1=2;
        System.out.print("Enter the second number = ");
        int nom2 = input.nextInt();
        if (nom2 == 0)
            throw new ArithmeticException("cannot put 0 for the second number");
        int result = nom1 / nom2; //Arithmetic Exception ; divide by 0
        System.out.println("The result = "+result);
       
    }
}
