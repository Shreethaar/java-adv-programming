/*We can convert the Array to List by traversing the array and adding the element in list one by one using list.add() method. Let's see a simple example to convert array elements into List.
 */

import java.util.*;

public class ArrayToListExample {
	public static void main(String[] args) {
		//Creating array
		String[] array = {"Java","Python","PHP","C++"};
		System.out.println("Printing array:" + Arrays.toString(array));
		List<String> list = new ArrayList<String>();
		for(String lang:array) {
			list.add(lang);
		}
		System.out.println("Printing List:" + list);
	}
}
