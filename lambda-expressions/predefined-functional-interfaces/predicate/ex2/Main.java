//Checking if a string is empty:

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> isEmpty = String::isEmpty;

		System.out.println(isEmpty.test(""));
		System.out.println(isEmpty.test("Hello"));
	}
}

