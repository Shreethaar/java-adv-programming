/* write a Java program that throws an exception and catch it using try-catch block */

public class Main {
	public static void main(String[] args) {
		try {
			int result=divideNumber(4,0);
			System.out.println("Result: " + result);
		}
		catch (ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		}



	}

	public static int divideNumber(int dividend, int divisor) {
		if(divisor==0) {
			throw new ArithmeticException("Cannot divide the given number by zero!");
		}
		return dividend/divisor;
	}
}

