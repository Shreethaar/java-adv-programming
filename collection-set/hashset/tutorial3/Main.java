import java.util.*;

public class Main {
	public static void main(String[] args) {
		HashSet<String> h = new HashSet<String>();
		// add() method
		h.add("India");
		h.add("Australia");
		h.add("South Africa");
		// adding duplicate
		h.add("India");
	
		System.out.println(h);
		System.out.println("List contains India or not: "+h.contains("India"));
		// contains() method 
		
		h.remove("Australia");
		// remove() method
		System.out.println("List after removing Australia:"+h);
		

		System.out.println("Iterating over list:");
		Iterator<String> i = h.iterator();
		// iterating using iterator()

		while(i.hasNext()) { // holds true till there is single element remaining
			System.out.println(i.next());
		}
		
		System.out.println("\nChecking the list :"+h);
	
	}
}

