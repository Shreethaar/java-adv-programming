/* Write a Java program that uses a 'Consumer' to print each element of a list of strings */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice","Bob","Charlie");
		Consumer<String> printer = name -> System.out.println(name);
		names.forEach(printer);
	}
}

