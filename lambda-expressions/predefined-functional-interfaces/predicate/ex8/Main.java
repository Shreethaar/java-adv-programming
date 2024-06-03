import java.util.function.Predicate;

public class Main {
	public static Predicate<String> hasLengthOf10 = new Predicate<String>() {
		@Override
		public boolean test(String t){
			return t.length() > 10;
		}
	};

	public static void predicate_or() {
		Predicate<String> containsLetterA = p -> p.contains("A");
		String containsA = "And";
		boolean outcome = hasLengthOf10.or(containsLetterA).test(containsA);
		System.out.println(outcome);
	}
	public static void main(String[] args) {
		predicate_or();
	}
}

