public class Main {
	public static void main(String[] args) {
		try {
			int i = 2;
			int j = 0;
			int division=i/j;
			System.out.println("Division of " + i + " and " + j + " = " + division);
		}
		catch(ArithmeticException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
