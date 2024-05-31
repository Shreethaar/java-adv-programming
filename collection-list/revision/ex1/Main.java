/* Write a Java program to create an arraylist, add some colors (strings) and print out collection */

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> colors = new ArrayList<>();
		colors.add("Red");
		colors.add("Yellow");
		colors.add("Blue");
		colors.add("Green");

		Iterator<String> itr = colors.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		for(String str:colors) {
			System.out.println(str);
		}
		System.out.println();
		for(int i=0;i<colors.size();i++) {
			System.out.println(colors.get(i));
		}

	}
}

