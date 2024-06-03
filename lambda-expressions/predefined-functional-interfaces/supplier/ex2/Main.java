//connected or disconnected

import java.util.function.Supplier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Is the network connected (Yes/No)");
		String input = sc.nextLine();
		
		Supplier<String> messageSupplier = () -> {
			if (input.equals("Yes")){
				return "Reconnected";
			} else {
				return "All good";
			}
		};

		System.out.println(messageSupplier.get());

	}
}
	
