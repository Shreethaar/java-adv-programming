// Write a Java program to search for a key in a treemap

import java.util.*;

public class Main {
	public static void main(String[] args) {
		TreeMap<String,String> tree_map1 = new TreeMap<>();
		tree_map1.put("C1","Red");
		tree_map1.put("C2","Green");
		tree_map1.put("C3","Black");
		tree_map1.put("C4","White");

		System.out.println(tree_map1);

		if(tree_map1.containsKey("C1")) {
			System.out.println("The tree map contains key C1");
		}
		else {
			System.out.println("The tree map does not contains key C1");
		}
		if(tree_map1.containsKey("C5")) {
			System.out.println("The tree map contains key C5");
		}
		else {
			System.out.println("The tree map does not contain key C5");
		}

	}
}

