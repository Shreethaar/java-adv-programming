package ex02;


import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Example5SpecificExceptionNotCaught 
{
    public static void main(String[] args) 
    {
        int nom1;
        int nom2;
        int result=0;
        
        Scanner input = new Scanner(System.in);
        
        try
        {
            System.out.print("Enter value of nom1 = ");
            nom1 = input.nextInt();
            System.out.print("Enter value of nom2 = ");
            nom2 = input.nextInt();
            
            //Did not catch the /Arithmetic Exception ; divide by 0
            result = nom1 / nom2; 
        
        }
        catch(InputMismatchException ex)
        {
            System.out.println("integer value please....");
        }
        System.out.println("The result = "+result);
    }
    
}