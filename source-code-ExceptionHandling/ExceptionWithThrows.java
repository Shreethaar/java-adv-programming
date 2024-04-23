/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex04;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ExceptionWithThrows 
{
    public static void main(String[] args) throws  ArithmeticException
    {
        int nom1;
        int nom2 ;
        int result=0;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the first number = ");
        nom1 = input.nextInt();
        System.out.print("Ent4er the second number = ");
        nom2 = input.nextInt();
        result = nom1 / nom2; //Arithmetic Exception ; divide by 0
                       
        System.out.println("The result = "+result);
    }
}
