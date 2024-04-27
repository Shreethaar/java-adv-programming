/* Demonstrating the usage of TreeSet along with the methods */

import java.util.TreeSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public class Main {
	public static void main(String[] args) {
		TreeSet<Integer> tree1 = new TreeSet<>();

		tree1.add(5);
		tree1.add(10);
		tree1.add(3);
		tree1.add(8);

		System.out.println(tree1);
		
		System.out.println("Contains 8: " + tree1.contains(8));
		System.out.println("Contains 7: " + tree1.contains(7));

		tree1.remove(3);
		System.out.println("After removing 3: " + tree1);

		System.out.println("Is treeSet empty: " + tree1.isEmpty());
		System.out.println("Size of treeSet: " + tree1.size());
		
		tree1.clear();
		System.out.println("After clearing, TreeSet " + tree1);
		System.out.println("Is treeSet empty now? " + tree1.isEmpty());

		tree1.add(1);
		tree1.add(2);
		tree1.add(3);
		tree1.add(4);
		tree1.add(5);
		tree1.add(6);
		tree1.add(7);
		tree1.add(8);
		tree1.add(9);
		tree1.add(10);

		NavigableSet<Integer> navigableSet = new TreeSet<>(tree1);
		System.out.println("Ceiling of 5: " + navigableSet.ceiling(5));
		System.out.println("Floor of 5: " + navigableSet.floor(5));
		System.out.println("Higher than 5: " + navigableSet.higher(5));
		System.out.println("Lower than 5: " + navigableSet.lower(5));
		
		SortedSet<Integer> headSet = navigableSet.headSet(5,true);
		System.out.println("HeadSet before 5: " + headSet);

		SortedSet<Integer> headSet1 = navigableSet.headSet(5,false);
		System.out.println("HeadSet before 5 (not including 5) : " + headSet1);

		SortedSet<Integer> tailSet = navigableSet.tailSet(5,true);
		System.out.println("TailSet after 5: " + tailSet);

		SortedSet<Integer> tailSet1 = navigableSet.tailSet(5,false);
		System.out.println("TailSet after 5 (not including 5): " + tailSet1);


		
	}
}

