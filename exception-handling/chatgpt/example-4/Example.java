public class Example {
	public static void main(String[] args) {
		try {
			divide(10,0);
		}
		catch(ArithmeticException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}

	public static int divide(int numerator, int denominator) throws ArithmeticException {
		if (denominator==0){
			throw new ArithmeticException("Division by zero is not allowed");
		}
		return numerator/denominator;
	}
}

