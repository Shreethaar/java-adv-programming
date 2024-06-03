//employed or unemployeed

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> verifyEmployed = (String i) -> (i.equals("Employed"));
		String employee1 = "Employed";
		String employee2 = "Not employed";
		System.out.println(verifyEmployed.test(employee1));
		System.out.println(verifyEmployed.test(employee2));
	}
}

