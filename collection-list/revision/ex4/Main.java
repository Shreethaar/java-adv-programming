/*  Write a Java program to retrieve an element (at a specified index) from a given array list.
 */
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		arr1.add(4);
		arr1.add(5);
		arr1.add(6);

		System.out.println(arr1.get(0));
	}
}

