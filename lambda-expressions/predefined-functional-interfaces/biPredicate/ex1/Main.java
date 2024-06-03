import java.util.function.BiPredicate;

public class Main {
	public static void main(String[] args) {
		BiPredicate<Integer,Integer> bp = (i,j) -> (i+j) % 2 == 0;
		System.out.println(bp.test(5,6));
	}
}

