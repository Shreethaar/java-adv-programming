/* Write a Java program to iterate through all elements in an array list. */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arrInt = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of elements:");
		int numElements = sc.nextInt();
		for(int i=0;i<numElements;i++) {
			System.out.println("Enter integer as element " + (i+1));
			int n = sc.nextInt();
			arrInt.add(n);
		}

		Iterator<Integer> itr = arrInt.iterator();
		System.out.println("Elements in the ArrayList:");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}

