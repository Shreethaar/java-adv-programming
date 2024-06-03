/* Write a Java program that uses a Consumer with a method reference to print each element of a list of integers. */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers  = Arrays.asList(1,2,3,4,5);
		Consumer<Integer> printer = System.out::println;
		numbers.forEach(printer);
	}
}

