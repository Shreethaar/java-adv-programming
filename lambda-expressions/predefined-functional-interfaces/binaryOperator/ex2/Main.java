import java.util.function.BinaryOperator;

public class Main {
	public static void main(String[] args) {
		BinaryOperator<Person> getMax = BinaryOperator.maxBy((Person p1, Person p2) -> p1.age-p2.age);
		Person person1 = new Person("Adithya",23);
		Person person2 = new Person("Jai",29);
		Person maxPerson = getMax.apply(person1,person2);
		System.out.println("Person with higher age: " + maxPerson);

		BinaryOperator<Person> getMin = BinaryOperator.minBy((Person p1, Person p2) -> p1.age-p2.age);
		Person minPerson = getMin.apply(person1,person2);
		System.out.println("Person with lower age: " + minPerson);
	
	}

}
