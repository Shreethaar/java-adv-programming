import java.io.*;
import java.util.*;

public class MethodsInHashSet {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		//adding elements 
		hs.add("Geek");
		hs.add("For");
		hs.add("Geeks");
		System.out.println("Utilzing add() method");
		System.out.println("HashSet elements: " + hs);
		

		//removing elements
		System.out.println();
		hs.add("A");
		hs.add("B");
		hs.add("Z");
		System.out.println("Initial HashSet " + hs);
		hs.remove("B");
		System.out.println("After removing element " + hs);
		System.out.println("Element AC exists in the set: " + hs.remove("AC"));
			

		//Iterator
		Iterator<String> i = hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}

