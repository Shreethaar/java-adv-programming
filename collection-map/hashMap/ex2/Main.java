import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<String, Integer> numbers = new HashMap<>();
		System.out.println("Initial HashMap: " + numbers);
		
		numbers.put("One", 1);
		numbers.put("Two", 2);
		numbers.put("Three", 3);
		numbers.put("Four", 4);
		System.out.println("HashMap after put(): " + numbers);

	}
}

