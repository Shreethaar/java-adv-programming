/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CallSequenceException 
{
    public static void main(String[] args) 
    {
        CallSequenceException test2 = new CallSequenceException();
        test2.methodA();
    }
    
    public void methodA()
    {
        /*
        try
        {
            methodB();
        }
        catch(Exception e)
        {
            System.out.println("from Method A");
        }
        */
        methodB();
        
    }
    
    public void methodB() //throws Exception
    {
        //methodC();
        
        try
        {
            methodC();
        }
        catch(Exception e)
        {
            System.out.println("from Method B");
        }
        
    }
    
    public void methodC() throws Exception
    {
        methodD();
        /*
        try
        {
            methodD();
        }
        catch(Exception e)
        {
            System.out.println("from Method C");
        }
        */
    }
    
    public void methodD() throws Exception
    {
        int num = -1;
        
        if (num < 0)
            throw new Exception();
        System.out.println("The value of num = "+num);
    }
}
