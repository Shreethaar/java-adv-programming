/* Write a Java program to update an array element by the given element */

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> numArr = new ArrayList<>();
		numArr.add(3);
		numArr.add(4);
		numArr.add(5);
		numArr.add(6);
		numArr.set(0,5);
		System.out.println(numArr);
		numArr.set(2,10);
		numArr.set(1,15);

		System.out.println(numArr);
	}
}

