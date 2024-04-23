package ex01;


public class ExceptionWithoutCatch_3 
{
    public static void main(String[] args) 
    {
        int [] matrikc = new int[3]; // indeks 0..2
        
        matrikc[1] = 20;
        System.out.println("Display content in matrikc[1] = "+matrikc[1]);
        matrikc[4] = 10; // ArrayIndexOutOfBoundException
        System.out.println("Display content in matrikc[4] = "+matrikc[4]);
    }
    
}
