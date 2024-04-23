package ex05;


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
public class ThrowWithThrowsHandling01 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input an integer number-mark = ");
        int num = scanner.nextInt(); //value must be in between 0..100
        if (num > 100 || num < 0) // 
        { 
            //"Out of bound" is a message ;
            //checked exception
            throw new Exception("Nom is greater than 100 or less than 0"); // must handle the exception - report
            
        }
        System.out.println("You have input the value of = "+num);
        
    }

    
}
