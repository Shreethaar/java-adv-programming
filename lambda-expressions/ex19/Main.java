import java.util.function.Supplier;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);
		System.out.println(randomNumberSupplier.get());
		System.out.println(randomNumberSupplier.get());
	}
}

