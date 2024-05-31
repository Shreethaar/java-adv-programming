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
public class ThrowWithThrowsHandling02_2 {

    public static void main(String[] args)  
    {
        int nom = 0;
        int result=0;

        try 
        {
            if (nom == 0) {
                throw new ArithmeticException("our message - nom cannot be zero");
            } else {
                result = 4 / nom;
            }
        } catch (ArithmeticException ex) 
        {
                System.out.println("messsage - "+ex.getMessage());
        }

        System.out.println("The result is = " + result);

    }

}
