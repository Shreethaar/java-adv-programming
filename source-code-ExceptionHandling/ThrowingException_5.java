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
public class ThrowingException_5 
{
    public static void main(String[] args) throws ArithmeticException
    {
        ThrowingException_5 test = new ThrowingException_5();
        test.doWork();
    }
    
    public void doWork()
    {
        Scanner input = new Scanner(System.in);
        int nom1=2;
        System.out.print("Enter the second number = ");
        int nom2 = input.nextInt();
        if (nom2 == 0)
            throw new ArithmeticException();
        int result = nom1 / nom2; //Arithmetic Exception ; divide by 0
        System.out.println("The result = "+result);
       
    }
}
