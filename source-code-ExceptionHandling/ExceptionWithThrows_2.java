/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex04;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ExceptionWithThrows_2 
{
    public static void main(String[] args) throws InputMismatchException
    {
        Scanner scan = new Scanner(System.in);
        int num = 0;
       
        System.out.print("Enter an integer = ");
        num = scan.nextInt(); // related to InputMismatchException - invalid input
        System.out.println("statement after input integer value");
        
        System.out.println("The number you entered is " +num);
    }
}
