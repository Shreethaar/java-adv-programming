/* the get() method returns the element at the given index, whereas the set() method changes or replaces the element
 */

import java.util.*;
public class ListExample2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Mango");
		list.add("Apple");
		list.add("Banana");
		list.add("Grapes");

		System.out.println("Returning element: " +list.get(1));

		list.set(1,"Dates");

		for(String fruit:list) {
			System.out.println(fruit);
		}
	}
}

