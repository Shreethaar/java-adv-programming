import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetEx3 {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();

		set.add("Re");
		set.add("Do");
		set.add("Fa");
		set.add("Sol");
		set.add("La");
		set.add("Ti");
		set.add("Mi");
		System.out.println(set);
		
		set.remove("Fa");
		set.remove("Score");
		System.out.println(set.remove("Score"));
		System.out.println("Print our set with elements removed: " );
		System.out.println(set);
		set.clear();
		System.out.println("Print out after clear command: ");
		System.out.println(set);


	}
}

