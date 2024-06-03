import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s);
		c.accept("I only consume data");
	}
}

