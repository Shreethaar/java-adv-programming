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
 * @author DELL
 */
public class Ex05ExceptionSuperClass 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try
        {
            System.out.print("Enter an integer = ");
            num = scan.nextInt();
        }
        catch (Exception e)
        {                
           System.out.println("I am superclass - You must enter only integer value");
        }
        catch (InputMismatchException e)
        {
                
           System.out.println("You must enter only integer value");
        }
        System.out.println("The number you entered is " +num);
    }
    
}
