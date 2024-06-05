import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public int getAge() throws InputMismatchException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your age = ");
		int age = sc.nextInt();
		return age;
	}

	public static void main(String[] args) {
		Main test = new Main();
		try {
			System.out.println("The entered data = " + test.getAge());
		}
		catch (InputMismatchException ex) {
			System.out.println("Invalid integer value");
		}
	}
}

