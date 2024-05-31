import java.util.*;

public class Main {
	public static void main(String[] args) {
		NavigableSet<String> set1 = new TreeSet<>();
		set1.add("Geek");
		set1.add("For");
		set1.add("Geeks");

		System.out.println("Tree set is " + set1);

		String check = "Geeks";
		System.out.println("Contains " + check + " " + set1.contains(check));

		System.out.println("First value " + set1.first());
		System.out.println("Last value " + set1.last());

		String val = "Geek";
		System.out.println("Higher: " + set1.higher(val));
		System.out.println("Lower: " + set1.lower(val));

	}

}
