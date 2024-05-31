/* Create a new Java class, let's name it CommonElements.
Define a method within this class, let's name it findCommonElements.
This method should take two ArrayLists of integers as input and return another ArrayList of integers containing the common elements.
Implement the logic to iterate through one of the input lists and check if each element is present in the other input list.
If an element is found in both lists, add it to a new list.
Finally, return the new list containing common elements.
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElements {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);

		List<Integer> common = findCommonElements(list1,list2);

		System.out.println("Common Elements: ");
		for(Integer e:common) {
			System.out.println(e);

		}



	}

	public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
		Set<Integer> set1 = new HashSet<>(list1);
		List<Integer> commonElements = new ArrayList<>();

		for(Integer i:list2) {
			if(set1.contains(i)) {
				commonElements.add(i);
			}
		}
		return commonElements;
	}
}


