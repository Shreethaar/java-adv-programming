import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");

		Predicate<String> startsWithA = name -> name.startsWith("A");
		List<String> filteredNames = names.stream()
			.filter(startsWithA)
			.collect(Collectors.toList());
		System.out.println(filteredNames);
	}
}

