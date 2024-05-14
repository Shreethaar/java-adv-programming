import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter age");
			String age = sc.nextLine();
			int output=getAge(age);
			System.out.println(output);
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}

	}

	public static int getAge(String n) throws NumberFormatException {
		int age = Integer.parseInt(n);
		return age;
	}
}

