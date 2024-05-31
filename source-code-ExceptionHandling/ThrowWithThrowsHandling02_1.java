package ex05;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ThrowWithThrowsHandling02_1 
{
    public static void main(String[] args) throws ArithmeticException
    {
        int nom = 0;
        int result;
        
        if (nom == 0) 
            throw new ArithmeticException("our message - nom cannot be zero");
        else
         result = 4/nom;
        System.out.println("The result is = "+result);
        
    }
    
    
}
