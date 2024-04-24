import java.util.*;

public class Main {
	public static void main(String[] args) {
		Set<StringBuffer> set1 = new TreeSet<>();

		set1.add(new StringBuffer("A"));
		set1.add(new StringBuffer("Z"));
		set1.add(new StringBuffer("L"));
		set1.add(new StringBuffer("B"));
		set1.add(new StringBuffer("O"));
		set1.add(new StringBuffer(1));


		System.out.println(set1);
	}
}

