import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		Function<String,Integer> stringLength = (str) -> str.length();
		System.out.println(stringLength.apply("Hello"));
		System.out.println(stringLength.apply("Test"));
	}
}
