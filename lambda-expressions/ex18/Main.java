import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Consumer<String> printWithPrefix = (str) -> System.out.println("Prefix: " + str);
		printWithPrefix.accept("Hello");
		printWithPrefix.accept("World");
	}
}


