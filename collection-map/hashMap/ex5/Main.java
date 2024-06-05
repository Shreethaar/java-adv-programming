// Write a Java program to count the number of key-value (size) mappings in a map

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<Integer,String> hash_map = new HashMap<>();
		hash_map.put(1,"test1");
		hash_map.put(2,"test2");
		hash_map.put(3,"test3");
		hash_map.put(4,"test4");

		System.out.println("Size of hash map: " + hash_map.size());

	}
}

