/* Write a Java program to create a method that takes an integer as a parameter and throws an exception if the number is odd */

public class Main {
	public static void main(String[] args) {
		try {
			boolean detect = detectOdd(4);
			System.out.println(detect);
		}
		catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}


	}

	public static boolean detectOdd(int num) {
		if(num%2==0) {
			throw new ArithmeticException("Number is odd");
		}
		return false;
	}
}

