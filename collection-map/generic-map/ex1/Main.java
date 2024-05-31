import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		//adding key 123 (int)
		//correspoding value abc (string)
		map.put(123,"abc");
		map.put(456,"efg");
	
		System.out.println(map.get(123));
		//prints out "abc"
		System.out.println(map.get(456));
		//prints out "efg"
		
		map.put(789,"hij");
		System.out.println(map.get(788));
		//prints out "null", if map.get(789) --> "hij"

	}
}

