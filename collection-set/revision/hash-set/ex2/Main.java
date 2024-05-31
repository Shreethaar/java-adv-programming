/* Write a Java program to iterate through all elements in a hash set */

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		HashSet<String> h_set = new HashSet<>();
		h_set.add("Red");
		h_set.add("Yellow");
		h_set.add("Black");
		h_set.add("White");
		h_set.add("Pink");
		h_set.add("Yellow");
		h_set.add("Green");

		Iterator<String> itr = h_set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println();
		for(String element : h_set) {
			System.out.println(element);
		}
	}
}

