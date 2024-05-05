import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("ankit");
		list1.add("mayank");
		list1.add("irfan");
		list1.add("jai");
		list1.forEach( (n) -> System.out.println(n));
	}
}

