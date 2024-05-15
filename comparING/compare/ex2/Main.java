/*
 * Basic Comparison:
 * Write a Java program that creates a 'List' of 'String' objects and sorts the list in alphabetical order using the 'compare()' method. Provide the implementation of the custom opearator
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
	
public class Main {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Random");
		list.add("String");
		list.add("Added");
		list.add("Into");
		list.add("The");
		list.add("ArrayList");
		
		System.out.println("Before sorting:\n" + list);
		
		Collections.sort(list,new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});

		for(String element : list) {
			System.out.println(element);
		}

	}

}

