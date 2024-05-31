package ex01;


public class ExceptionWithoutCatch_1 
{
    public static void main(String[] args) 
    {
        int nom1 = 10;
        int nom2 = 0 ;
        //         10/0
        int result = nom1 / nom2; //Arithmetic Exception ; divide by 0
        
        System.out.println("The result = "+result);
    }
    
}
