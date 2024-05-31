//using keySet() and values() to iterate

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();

		map.put(123,456);
		map.put(678,910);
		map.put(111,999);
		map.put(222,888);
		map.put(333,777);
		map.put(444,666);
		map.put(555,555);
		map.put(9999,7182);

		Iterator<Integer> key = map.keySet().iterator();

		while(key.hasNext()) {
			Integer aKey = key.next();
			Integer aValue = map.get(aKey);
			System.out.println(aValue); // u will notice the arrangement is "random" but is not random, because of the character of HashMap where the order is not guaranteed, based on the hash codes and the buckets they are placed into
		}
	}
}

