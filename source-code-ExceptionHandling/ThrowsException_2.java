package ex07;


import java.util.InputMismatchException;
import java.util.Scanner;


public class ThrowsException_2 
{
    public static void main(String[] args) //throws InputMismatchException
    {
        ThrowsException_2 example = new ThrowsException_2();
        example.inputData();
    }
    
    public void inputData() throws InputMismatchException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input integer value = ");
        int num1 = scan.nextInt();
        System.out.println("you have entered the value of = "+num1);
    }
}
