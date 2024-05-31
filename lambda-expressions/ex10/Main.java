import java.util.function.*;

public class Main {
	public static void main(String[] args) {
		Predicate <Integer> p1 = (nom) -> nom>10;
		System.out.println(p1.test(10));
		
		Predicate <String> n = (name) -> name.equals("uum");
		System.out.println("Result 2 = " + n.test("uum"));
		
		//LambdaExpression lambda = new LambdaExpression();
		//System.out.println("Result 3 = " + lambda.checkNumber(9));

		BiPredicate <Integer, Double> p3 = (nom1, nom2) -> ((nom1+nom2)%2==0);
		System.out.println(p3.test(10,20.4));
		
		Function <String,Integer> f1 = (str) -> str.length();
		System.out.println("Result 5 = " + f1.apply("Test"));

		BiFunction <String, String, Integer> f2 = (str1, str2) -> str1.length()+str2.length();
		System.out.println("The length of two string = " + f2.apply("Hello World","UUM"));



	}
}

