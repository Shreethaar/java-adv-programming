//Demonstration of storing lamba expression in a variable

interface StringModifier {
	String modify(String str);
}

public class Main {
	public static void main(String[] args) {
		StringModifier upperCaseConverter = str -> str.toUpperCase();
		String message = "Hello, world!";
		String upperCasedMessage = upperCaseConverter.modify(message);
		System.out.println(upperCasedMessage);

	}

}

