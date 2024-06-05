// write a Java program to copy all mappings from the specified map to another map

import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		HashMap<Integer,String> hash_map1 = new HashMap<>();
		HashMap<Integer,String> hash_map2 = new HashMap<>();

		hash_map1.put(1,"red");
		hash_map1.put(2,"yellow");
		hash_map1.put(3,"green");
		hash_map1.put(4,"black");
		System.out.println(hash_map1);
		
		hash_map2.put(5,"white");
		hash_map2.put(6,"blue");
		hash_map2.put(7,"orange");
		hash_map2.put(8,"rainbow");
		System.out.println(hash_map2);

		hash_map2.putAll(hash_map1);
		System.out.println(hash_map2);
	}
}
