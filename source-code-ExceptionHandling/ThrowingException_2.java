package ex06;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ThrowingException_2 
{
    // exception catcher
    public static void main(String[] args)
    {
        ThrowingException test = new ThrowingException();
        try
        {
            test.methodA(-1);
        }
        catch (Exception ex)
        {
            System.out.println("System is terminated because invalid input");
            System.out.println(ex.getMessage());
        }
    }
    
    // // exception thrower - In specfic - exception propagator
    public void methodA(int num) throws Exception
    {
        if (num < 0)
            throw new Exception("Input is invalid because it is less than 0");
        System.out.println("Input is valid >= 1");
    }
}
