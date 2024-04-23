package ex07;


import java.util.Scanner;


public class ThrowsException_3 
{
    public int getAge() throws NumberFormatException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input an integer number = ");
        String inputStr = scan.next();
        
        int age = Integer.parseInt(inputStr); // convert String to Integer
      
        return age;
    }
    
    public static void main(String[] args) 
    {
        ThrowsException_3 test = new ThrowsException_3();
        System.out.println("The entered data = "+test.getAge());
    }
}
