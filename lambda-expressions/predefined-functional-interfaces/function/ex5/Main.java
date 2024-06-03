import java.util.function.Function;

public class Main {
	public static void main(String[] args) {
		Function<Integer, String> intToString = (Integer i) -> "The number is " + i;
		String result=intToString.apply(5);
		System.out.println(result);
		
		Function<Integer,Integer> square = (Integer x) -> x * x;
		Integer squaredResult = square.apply(4);
		System.out.println(squaredResult);
	}
}

