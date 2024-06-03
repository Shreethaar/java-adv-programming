//negate predicate
import java.util.function.Predicate;


public class Main {
	public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
		@Override
		public boolean test(String t) {
			return t.length() > 10;
		}
	};

	public static void predicate_negate() {
		String lengthGTThan10 = "Thunderstruck is 2012 children's " + "film starring Kevin Durrant";
		boolean outcome = hasLengthOf10.negate().test(lengthGTThan10);
		System.out.println(outcome);
	}
	public static void main(String[] args) {
		predicate_negate();
	}
}

