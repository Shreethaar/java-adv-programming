import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Main {
	public static void main(String[] args) {
		Comparator<Integer> integerComparator = Comparator.naturalOrder();
		BinaryOperator<Integer> integerIntegerBinaryOperator = BinaryOperator.minBy(integerComparator);
		int arg1=2;
		int arg2=4;
		System.out.printf("minimum(%s,%s) = %s",arg1,arg2, integerIntegerBinaryOperator.apply(arg1,arg2));
	}
}
