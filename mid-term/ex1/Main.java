import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter an integer:");
			int number = sc.nextInt();
			if(number<0) {
				throw new IllegalArgumentException("Number must be non-negative");
			}
			System.out.println("Square root " + number + " is " + Math.sqrt(number));
		}
	       	catch (InputMismatchException e) {
			System.out.println("Please enter a valid integer.");
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();
			System.out.println("Scanner closed");
		}
	}
}

		
