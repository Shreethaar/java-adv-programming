import java.util.Scanner;
public class TestThrow1 {
	public static void validate(int age) {
		if(age<18) {
			throw new ArithmeticException("Person is not eligible to vote");
		}
		else {
			System.out.println("Person is eligible to vote!!");
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter your age");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		validate(age);
		System.out.println("rest of the code...");
	}
}

