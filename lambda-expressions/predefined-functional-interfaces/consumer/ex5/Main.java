// on duty or off duty

import java.util.function.Consumer;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Consumer<String> c = s -> System.out.println(s);
		System.out.println("Are you on duty or not (Yes/No)");
		String input = sc.nextLine();
		c.accept(input);
	}
}

