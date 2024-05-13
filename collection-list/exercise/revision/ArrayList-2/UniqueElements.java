/* 
 * Create a new Java class, let's name it UniqueElements.
Define a method within this class, let's name it findUniqueElements.
This method should take an ArrayList of integers as input and return another ArrayList of integers containing only the unique elements.
Implement the logic to iterate through the input list and add elements to a new list if they are not already present in it.
Finally, return the new list containing unique elements.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueElements {
	public static void main(String[] args) {
		List<Integer> inputList = new ArrayList<>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(3);
		inputList.add(2);
		inputList.add(4);
		inputList.add(1);
		inputList.add(5);

		List<Integer> uniqueElements = findUniqueElements(inputList);

		System.out.println("Unique Elements: ");
		for(Integer i : uniqueElements) {
			System.out.println(i);
		}

	}

	public static List<Integer> findUniqueElements(List<Integer> inputList) {
		Set<Integer> uniqueSet = new HashSet<>();
		for(Integer i : inputList) {
			uniqueSet.add(i);
		}
		List<Integer> uniqueList = new ArrayList<>(uniqueSet);
		return uniqueList;
	}
}
