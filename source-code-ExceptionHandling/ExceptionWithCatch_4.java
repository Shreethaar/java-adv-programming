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
public class ExceptionWithCatch_4 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int age=0;
        System.out.print("Please input an integer number = ");
        String inputStr = scan.next();
        
        try
        {
            //NumberFormatException
            age = Integer.parseInt(inputStr); // convert String to Integer
        }
        catch(java.lang.NumberFormatException ex)
        {
            System.out.println("You must enter only integer value");
            System.out.println("System message - toString() = "+ex.toString());
            System.out.println("System message - getMessage()= "+ex.getMessage());
        }
        age++;
        System.out.println("The entered data = "+age);
    }
}
