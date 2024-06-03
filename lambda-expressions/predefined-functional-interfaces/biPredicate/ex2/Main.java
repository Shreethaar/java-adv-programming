import java.util.function.BiPredicate;

public class Main {
	public static void main(String[] args) {
		BiPredicate<Integer,Integer> isSumGreaterThan10 = (a,b) -> a+b>10;
		System.out.println(isSumGreaterThan10.test(5,6));
		System.out.println(isSumGreaterThan10.test(3,4));

		BiPredicate<Integer,Integer> isProductEven = (a,b) -> (a*b) % 2 == 0;
		BiPredicate<Integer,Integer> combinedPredicate = isSumGreaterThan10.and(isProductEven);


		System.out.println(combinedPredicate.test(5,6));
		System.out.println(combinedPredicate.test(3,4));




	}
}


