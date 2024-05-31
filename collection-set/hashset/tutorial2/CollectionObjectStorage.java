import java.io.*;
import java.util.*;

public class CollectionObjectStorage {
	public static void main(String[] args) {
		// Instantiate an object of HashSet
		HashSet<ArrayList> set = new HashSet<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		// create ArrayList list1
		ArrayList<Integer> list2 = new ArrayList<>();
		// create ArrayList list2

		list1.add(1);
		list1.add(2);
		list2.add(1);
		list2.add(2);
		set.add(list1);
		set.add(list2);
		System.out.println(set.size());
	}
}

