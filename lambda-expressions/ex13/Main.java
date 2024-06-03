/* 
You are given a list of integers. Your task is to use lambda expressions to:

Filter out all the odd numbers.
Square each of the remaining numbers.
Collect the results into a new list and print it.
Here's the list of integers you will be working with: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Steps to Complete the Exercise
Create a list of integers.
Use a stream to process the list:
Filter out the odd numbers.
Square each of the remaining numbers.
Collect the results into a new list.
Print the final list. 
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		List<Integer> result = numbers.stream()
			.filter(n -> n % 2 == 0)
			.map(n -> n * n)
			.collect(Collectors.toList());

		System.out.println(result);
	}
}

