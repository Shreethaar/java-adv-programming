/* Write a Java program that uses a Consumer within a stream to print the squares of a list of integers. */

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		Consumer<Integer> squarePrinter = n -> System.out.println(n*n);
		numbers.stream().forEach(squarePrinter);
	}
}

