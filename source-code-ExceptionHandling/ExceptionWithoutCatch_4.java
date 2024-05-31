/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex01;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ExceptionWithoutCatch_4 
{
       
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input an integer number = ");
        String inputStr = scan.next(); // "3"
        
        //NumberFormatException
        int age = Integer.parseInt(inputStr); // convert String to Integer "3"-> 3
      
        age++;
        System.out.println("The entered data = "+age);
    }
    
}
