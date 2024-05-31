import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetEx2 {
	public static void main(String[] args) {
		// adding duplicates
		Set<String> set = new LinkedHashSet<>();

		set.add("Re");
		set.add("Do");
		set.add("Fa");
		set.add("Sol");
		set.add("La");
		set.add("Ti");
		set.add("Mi");
		set.add("Sol");

		System.out.println(set);
	}
}

