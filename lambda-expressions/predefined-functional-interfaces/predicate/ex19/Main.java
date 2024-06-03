// available or not available

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> verifyAvailability=(String i) -> (i.equals("Available"));
		String ava1 = "Available";
		String ava2 = "Not Available";
		System.out.println(verifyAvailability.test(ava1));
		System.out.println(verifyAvailability.test(ava2));

	}
}

