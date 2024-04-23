
import java.util.InputMismatchException;
import java.util.Scanner;



public class UnCheckedException 
{
    public int getAge() throws InputMismatchException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input your age = ");
               
        int age = scan.nextInt(); //       
        return age;
    }
    
    // unchecked exception for method getAge() can be handled by 
        // 1) either;throws or try catch or 
        // 2) nothing to be handled manually
    public static void main(String[] args) //throws InputMismatchException   
    {
        UnCheckedException test = new UnCheckedException();
        //System.out.println("The entered data = "+test.getAge());
                
        try {
            System.out.println("The entered data = "+test.getAge());
        } catch (InputMismatchException ex) {
            System.out.println("Invalid integer value");
        }
        
    }
}
