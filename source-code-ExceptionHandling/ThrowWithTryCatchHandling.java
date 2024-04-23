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
public class ThrowWithTryCatchHandling 
{
    public static void main(String[] args) //throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        try 
        { 
            System.out.print("Input an integer number = ");
            int num = scanner.nextInt();
            if (num > 100)
            { 
                //message "Out of bound" will be caught and displayed 
                // caught and displayed at catch (Exception ex);
                //checked exception
                throw new Exception("Out of bound");
            }
        } 
        catch (InputMismatchException e)
        {
            System.out.println("Invalid Entry");
        } //catch (InputMismatchException e)
        
        catch (Exception ex)
        {
            System.out.println("Kesalahan = "+ex.getMessage());
        }//catch (Exception ex)
        //finally(Exception e)
        finally
        {
            System.out.println("DONE");
        }
    }
    
}
