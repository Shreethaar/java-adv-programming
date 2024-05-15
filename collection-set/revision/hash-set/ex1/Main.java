/* Write a Java program to append the specified element to the end of a hash set */

import java.util.HashSet;
import java.util.Iterator;
public class Main {
	public static void main(String[] args) {
		HashSet<String> h_set = new HashSet<String>();
		h_set.add("Red");
		h_set.add("Yellow");
		h_set.add("Black");
		h_set.add("White");
		h_set.add("Pink");
		h_set.add("Yellow");
		h_set.add("Green");

		System.out.println("The Hash Set: " + h_set+ "\n");
		
		Iterator<String> itr = h_set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().hashCode());
		}

		
		
	}

}

