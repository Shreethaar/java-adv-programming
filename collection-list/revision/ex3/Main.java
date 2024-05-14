/* Write a Java program to insert an element into the array list at the first position. */
import java.util.ArrayList;
public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>(4);
		System.out.println(arr1);
		arr1.add(0,10);
		arr1.add(1,20);
		System.out.println(arr1);
		arr1.add(30);
		arr1.add(0,20);
		System.out.println(arr1);
	}
}



