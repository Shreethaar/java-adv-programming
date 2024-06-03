import java.util.function.BiFunction;

public class Main {
	public static void main(String[] args) {
		BiFunction<String,String,Integer> bf = (i,j) -> i.length()+j.length();
		System.out.println(bf.apply("Hello","World!"));
	}
}

