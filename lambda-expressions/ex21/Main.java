import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Supplier<List<Integer>> randomListSupplier = () -> {
			Random random = new Random();
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<10; i++) {
				list.add(random.nextInt(100));
			}
			return list;
		};

		Predicate<Integer> isEven = (num) -> num%2 == 0;
		Function<Integer,Integer> square = (num) -> num * num;
		Consumer<Integer> printNumber = (num) -> System.out.println("Squared number: " + num);
		List<Integer> randomNumbers = randomListSupplier.get();
		System.out.println("Generated numbers: " + randomNumbers);

		List<Integer> evenNumbers = randomNumbers.stream().filter(isEven).collect(Collectors.toList());
		
		List<Integer> squaredNumbers = evenNumbers.stream().map(square).collect(Collectors.toList());

		squaredNumbers.forEach(printNumber);


	}
}

