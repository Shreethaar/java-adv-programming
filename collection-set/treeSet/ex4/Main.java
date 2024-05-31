import java.util.*;

public class Main {
	public static void main(String[] args) {
		NavigableSet<String> set1 = new TreeSet<>();

		set1.add("Geek");
		set1.add("For");
		set1.add("Geeks");
		set1.add("A");
		set1.add("B");
		set1.add("Z");

		System.out.println("Initial TreeSet " + set1);
		set1.remove("B");
		System.out.println("After removing element " + set1);
		set1.pollFirst();
		System.out.println("After removing first " + set1);
		set1.pollLast();
		System.out.println("After removing last " + set1);
	}
}

