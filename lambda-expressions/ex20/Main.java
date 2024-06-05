import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Predicate<Integer> isGreaterThan50 = (num) -> num>50;
		Function<Integer,Integer> square = (num) -> num*num;
		Consumer<Integer> printNumber = (num) -> System.out.println("Number: "+ num);
		Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
		Integer number = randomNumberSupplier.get();
		if(isGreaterThan50.test(number)) {
			Integer squaredNumber = square.apply(number);
			printNumber.accept(squaredNumber);
		}
		else {
			System.out.println("Number " + number + " is not greater than 50.");
		}
	}
}

