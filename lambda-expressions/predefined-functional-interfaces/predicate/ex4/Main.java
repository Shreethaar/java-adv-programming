//Combining predicates
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<Integer> isEven = number -> number%2==0;
		Predicate<Integer> isGreaterThan10 = number -> number > 10;

		Predicate<Integer> isEvenAndGreaterThan10 = isEven.and(isGreaterThan10);
		Predicate<Integer> isOddOrLessThan10 = isEven.negate().or(isGreaterThan10.negate());
		System.out.println(isEvenAndGreaterThan10.test(12));
		System.out.println(isOddOrLessThan10.test(9));
	}
}

