/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ExceptionWithCatch_1 
{
    public static void main(String[] args) 
    {
        int nom1;
        int nom2 ;
        int result=0;
        
        Scanner input = new Scanner(System.in);
        try
        {
            System.out.print("Enter the first number = ");
            nom1 = input.nextInt();
            System.out.print("Ent4er the second number = ");
            nom2 = input.nextInt();
            result = nom1 / nom2; //Arithmetic Exception ; divide by 0
        }
        catch(ArithmeticException ex)
        {
            System.out.println("Our message = nom2 cannot be 0 because divide by 0");
            System.out.println("System message - toString() = "+ex.toString());
            System.out.println("System message - getMessage()= "+ex.getMessage());
            ex.printStackTrace();
        }
        
        System.out.println("The result = "+result);
    }
}
