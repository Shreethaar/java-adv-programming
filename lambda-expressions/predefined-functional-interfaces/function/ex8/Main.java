// single or not

import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		Function<String,String> verifyMaritialStatus = status -> status.equalsIgnoreCase("single") ?"Nk cari jodoh ke" : "Jaga bini kau";
		String status1 = "single";
		String status2 = "married";
		System.out.println(verifyMaritialStatus.apply(status1));
		System.out.println(verifyMaritialStatus.apply(status2));
	}
}

