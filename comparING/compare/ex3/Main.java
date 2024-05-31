/* Sorting by length
 * Creates a 'List' of 'String' objects and sort it by the length of the strings using the compare() method. How would you implement the custom comparator to achieve this ?*/

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		words.add("Banana");
		words.add("Apple");
		words.add("Cherry");
		words.add("Mango");
		words.add("Blueberry");
		words.add("Strawberry");

		Collections.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(),s2.length());
			}
		});

		for(String word : words) {
			System.out.println(word);
		}
	}
}

