/*
 * try {
    // Code that may throw exceptions
} catch (NullPointerException e) {
    // Handle NullPointerException
    System.out.println("NullPointerException caught: " + e.getMessage());
} catch (Exception e) {
    // Handle all other exceptions
    System.out.println("General exception caught: " + e.getMessage());
}

*/

import java.util.Scanner;
public class Labtest {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
        try{
		int a=5;
		int b=0;
		int c=a/b;
		System.out.println(c);
        }
        catch(ArithmeticException e){
        System.out.println("Mahmoud punde");
        }
        catch(Exception e){
            System.out.println("Hey brotha you are wrong");
        } 
	//catch(ArithmeticException e) {
	//	System.out.println("lmao");
	//}
	finally {
		System.out.println("The code finally runss");
	}

        
    }
}
