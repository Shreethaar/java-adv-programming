// write a program to associate the specified value with the specified key in HashMap.

import java.util.HashMap;
public class Main {
	public static void main(String[] args) {
		HashMap<String, Integer> hash_map = new HashMap<>();

		hash_map.put("Key001",2345);
		hash_map.put("Key002",4243);
		hash_map.put("Key003",4230);
		hash_map.put("Key004",9879);
		hash_map.put("Key005",6565);
		
		for(HashMap.Entry x:hash_map.entrySet()) {
			System.out.println(x.getKey() + " " + x.getValue());
		}

	}
}
