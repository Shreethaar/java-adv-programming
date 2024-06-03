//write a java program to delete all elements from a treemap

import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) {
		TreeMap<String,String> tree_map1 = new TreeMap<String,String>();
		tree_map1.put("C1","Red");
		tree_map1.put("C2","Green");
		tree_map1.put("C3","Black");
		tree_map1.put("C4","White");

		System.out.println("Original TreeMap content: " + tree_map1);
		tree_map1.clear();
		System.out.println("The new map: " + tree_map1);
	}
}

