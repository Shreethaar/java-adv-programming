package ex02;


import java.util.Scanner;

public class Example2 
{
    public static void main(String[] args) 
    {
        int num1;
        double num2;
        String nama;
        
        Scanner scan = new Scanner(System.in);
        
        try
        {
            System.out.print("Input integer value = ");
            num1 = scan.nextInt();
            
            System.out.print("Input double value = ");
            num2 = scan.nextDouble();
            
            System.out.print("Input String value = ");
            nama = scan.next()+ scan.nextLine();
            
        }
        catch (Exception ex)
        {
            System.out.println("Mismatch value");
            System.out.println(ex.getMessage());
            //ex.printStackTrace();
        }
        
        System.out.println("The end of this coding");
        
    }
    
}
