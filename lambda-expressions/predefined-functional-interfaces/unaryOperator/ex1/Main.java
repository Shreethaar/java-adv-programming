import java.util.function.UnaryOperator;

public class Main {
	public static void main(String[] args) {
		UnaryOperator<String> extensionAdder = (String text) -> {return text + ".txt";};
		String newText = extensionAdder.apply("example-function");

		System.out.println(newText);
	}
}

