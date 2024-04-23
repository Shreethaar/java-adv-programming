import java.util.Scanner;

public class ExceptionHandlingExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter two integers:");
			try{
				int num1=sc.nextInt();
				int num2=sc.nextInt();
	
				int result=divide(num1,num2);
				System.out.println("Result of division: " + result);
			}
			catch(ArithmeticException e) {
				System.out.println("Error: Division by zero is not allowed.");
			}
			catch(Exception e) {
				System.out.println("An error occurred: " + e.getMessage());
			}
			finally {
				sc.close();
			}		
		}
	public static int divide(int num1, int num2) {
		return num1/num2;
	}
}


