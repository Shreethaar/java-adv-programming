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
public class ThrowingException 
{
    public static void main(String[] args) throws Exception
    {
        ThrowingException test = new ThrowingException();
        test.methodA(-10);
    }
    
    // exception thrower - In specfic - exception propagator
    public void methodA(int num) throws Exception
    {
        if (num < 0)
            throw new Exception("Input is invalid because it is less than 0");
        System.out.println("Input is valid because the value is "+num);
    }
}
