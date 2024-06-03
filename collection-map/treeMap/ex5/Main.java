// write a java program to search for a value in a tree map
import java.util.*;

public class Main {
	public static void main(String[] args) {
		TreeMap<String,String> tree_map1 = new TreeMap<>();
		tree_map1.put("C1","Red");	
		tree_map1.put("C2","Green");
		tree_map1.put("C3","Black");
		tree_map1.put("C4","White");

		if(tree_map1.containsValue("Green")) {
			System.out.println("The treemap contains value Green");
		}
		else {
			System.out.println("The treemap does not contain value Green");
		}
		if(tree_map1.containsValue("Pink")){
			System.out.println("The treemap contains value Pink");
		}
		else {
			System.out.println("The treemap does not contains value Pink");
		}
	}
}

