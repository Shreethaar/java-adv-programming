// using for-loop and for-each loop to iterate

import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		map.put(123,"abc");
		map.put(456,"efg");
		map.put(789,"hij");
		map.put(999,"klm");
		map.put(111,"nop");

		//for-each loop
		
		for(Integer key:map.keySet()) {
			String value = map.get(key);
			System.out.println("Key "+key+":"+value);
		}

		for(String value : map.values()) {
			System.out.println(value);
		}
	}
}

