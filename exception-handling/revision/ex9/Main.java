import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter first number: ");
			int a=sc.nextInt();
			System.out.println("Enter second number: ");
			int b=sc.nextInt();
			int c=addNum(a,b);
			System.out.println(c);

		}
		
		catch(InputMismatchException e) {
			System.out.println(e.getMessage());

		}

	}
	public static int addNum(int x, int y) {
		int output = x+y;
		return output;
	}
}

