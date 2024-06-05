import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}

	public int compareTo(Person other) {
		return this.name.compareTo(other.name);
	}

	public String toString() {
		return "Person{name='"+name"', age="+age+'}';
	}

}

public class Main {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Alice",30));
		people.add(new Person("BoB", 25));
		people.add(new Person("Charlie",35));

		Collections.sort(people);
		System.out.println("Sorted by name: ");
		for(Person person: people) {
			System.out.println(person);
		}

		people.sort(new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return Integer.compare(p1.age,p2.age);
			}
		});

		System.out.println("Sorted by age:");
		for(Person person : people) {
			System.out.println(person);
		}
	}
}

