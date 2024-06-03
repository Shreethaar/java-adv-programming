import java.util.TreeMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		TreeMap<String,Integer> treeMap = new TreeMap<>();
		treeMap.put("Apple",10);
		treeMap.put("Banana",20);
		treeMap.put("Orange",30);
		treeMap.put("Mango",40);

		System.out.println("TreeMap: " + treeMap);
		System.out.println("Value for key 'Apple': " + treeMap.get("Apple"));

		treeMap.remove("Banana");
		System.out.println("TreeMap after removing 'Banana': " + treeMap);

		for(Map.Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}

		boolean hasKey = treeMap.containsKey("Mango");
		System.out.println("TreeMap contains 'Mango': " + hasKey);

		boolean hasValue = treeMap.containsValue(30);
		System.out.println("TreeMap contains value 30: " + hasValue);

		System.out.println("First entry: " + treeMap.firstEntry());
		System.out.println("Last entry: " + treeMap.lastEntry());
	}
}

