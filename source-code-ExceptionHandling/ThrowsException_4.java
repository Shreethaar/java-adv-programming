package ex07;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ThrowsException_4 
{
    public int getAge() throws Exception
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input your age = ");
               
        int age = scan.nextInt(); // convert String to Integer
        if (age < 0) throw new Exception("Invalid age");
      
        return age;
    }
    
    public static void main(String[] args) //throws Exception  
    {
        ThrowsException_4 test = new ThrowsException_4();
        //System.out.println("The entered data = "+test.getAge());
        
        try {
            System.out.println("The entered data = "+test.getAge());
        } catch (Exception ex) {
            System.out.println("Invalid age from method main");
        }
        
    }
}
