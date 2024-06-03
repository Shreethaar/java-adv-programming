/*  Write a Java program to associate the specified value with the specified key in a Tree Map. */

import java.util.*;
public class Main {
	public static void main(String[] args) {
		TreeMap<Integer,String> tree_map = new TreeMap<>();
		tree_map.put(1,"red");
		tree_map.put(2,"green");
		tree_map.put(3,"blue");
		tree_map.put(4,"white");
		tree_map.put(5,"black");

		for(Map.Entry<Integer,String> entry:tree_map.entrySet()) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}
	}
}

