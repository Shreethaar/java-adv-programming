// Checking if a number is even
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<Integer> isEven = number -> number%2 == 0;
		System.out.println(isEven.test(10));
		System.out.println(isEven.test(11));
	}
}

