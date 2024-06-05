import java.util.function.BiConsumer;

public class Main {
	public static void main(String[] args) {
		BiConsumer<Integer,Integer> addAndPrint = (a,b) -> {
			int result = a+b;
			System.out.println("Result " + result);

		};
		addAndPrint.accept(5,10);
		addAndPrint.accept(10,15);


	}
}

