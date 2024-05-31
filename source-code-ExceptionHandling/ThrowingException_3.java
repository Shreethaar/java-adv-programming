package ex06;

public class ThrowingException_3 
{
    public static void main(String[] args) //throws Exception
    {
        ThrowingException_3 test = new ThrowingException_3();
        test.methodA();
    }
    
    // exception thrower - In specfic - exception catcher
    public void methodA() 
    {
        int res=0;
        try
        {
            res = 4/0;
            
        }
        catch(Exception ex)
        {
            System.out.println("cannot divide by 0");
        }
    }
}