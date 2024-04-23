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
public class Ex03ExceptionSubClass 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try
        {
            System.out.print("Enter an integer = ");
            num = scan.nextInt();
            
            int res = 4/1;
        } // try
        catch (InputMismatchException e)
        {
                
           System.out.println("You must enter only integer value");
        } // catch (InputMismatchException e)
        catch (Exception e)
        {                
           System.out.println("I am super clas - I will handle any kind of exception");
        } // catch (Exception e)
        finally
        {
            System.out.println("The finally statement(s) will be executed either you have exception");
            System.out.println("or no exception");
        }//finally
        //outside of try cTCH BLOCK
        System.out.println("The number you entered is " +num);
    }
    
}
