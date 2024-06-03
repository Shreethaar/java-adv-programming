//hungry or not

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> verifyHunger = (String i) -> (i.equals("Hungry"));
		String hunger1 = "Hungry";
		String hunger2 = "Not hungry";
		System.out.println(verifyHunger.test(hunger1));
		System.out.println(verifyHunger.test(hunger2));
	}
}

