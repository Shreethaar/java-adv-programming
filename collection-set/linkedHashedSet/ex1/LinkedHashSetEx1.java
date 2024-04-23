import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetEx1 {
	public static void main(String[] args) {
		Set<String> set1 = new LinkedHashSet<>();
		LinkedHashSet<String> set2 = new LinkedHashSet<>();
			
		set1.add("Re");
		set1.add("Do");
		set1.add("Fa");
		set1.add("Sol");
		set1.add("La");
		set1.add("Ti");
		set1.add("Mi");

		set2.add("Test");
		set2.add("The");
		set2.add("Sorting");
		set2.add("Arrangement");
		set2.add("of");
		set2.add("LinkedHashSet");

		System.out.println(set1+"\n");
		System.out.println(set2);

	}
}

