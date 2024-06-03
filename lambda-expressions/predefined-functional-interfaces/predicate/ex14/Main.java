//male or female

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> gender = (String i) -> (i.equals("Male"));
		String gender1 = "Male";
		String gender2 = "Female";
		System.out.println(gender.test(gender1));
		System.out.println(gender.test(gender2));
	}
}
