/* Write a Java program to iterate through all elements in a linked list. */

import java.util.LinkedList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> listInt = new LinkedList<>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		listInt.add(4);
		System.out.println(listInt);
		listInt.addFirst(5);
		System.out.println(listInt);
		listInt.addLast(6);
		System.out.println(listInt);

		System.out.println();
		Iterator itr = listInt.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		for(int i:listInt) {
			System.out.println(i);
		}

		System.out.println();
		for(int i=0;i<listInt.size();i++) {
			System.out.println(listInt.get(i));
		}

	}
}

