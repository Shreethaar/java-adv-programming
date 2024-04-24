import java.util.*;

public class Main {
	public static void main(String[] args) {
		Set<String> set1 = new TreeSet<>();
		set1.add("A");
		set1.add("B");
		set1.add("C");
		set1.add("C"); //duplicates doesnt add into it
		
		System.out.println(set1);
	}
}

