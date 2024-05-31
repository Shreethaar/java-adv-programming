import java.util.*;

public class Main {
	public static void main(String[] args) {
		Set<String> set1 = new TreeSet<>();

		set1.add("Geek");
		set1.add("For");
		set1.add("Geeks");
		set1.add("A");
		set1.add("B");
		set1.add("Z");

		for(String value : set1) {
			System.out.print(value + ", " );
		}
		System.out.println();
	}
}

