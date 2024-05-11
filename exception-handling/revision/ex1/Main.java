/* Write a Java program that throws an exception and catch it using a try-catch block
 */

public class Main {
	public static void main(String[] args) {
		try {
			int x=5;
			int y=0;
			int div=x/y;
			System.out.println(div);

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

