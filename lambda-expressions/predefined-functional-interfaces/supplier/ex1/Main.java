import java.util.function.Supplier;
import java.util.Random;
public class Main {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> new Random().nextInt(10);
		System.out.println(s.get());
	}
}

