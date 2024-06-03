//single or not

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> verifyMaritialStatus = (String i) -> i.equals("Single");
		String status1 = "Single";
		String status2 = "Married";
		System.out.println(verifyMaritialStatus.test(status1));
		System.out.println(verifyMaritialStatus.test(status2));

	}
}
				
