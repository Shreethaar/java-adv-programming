/* Write a Java program that uses a Consumer to modify a custom object. The Consumer should update the name field of a Person object.
*/

import java.util.function.Consumer;

class Person {
	private String name;

	public Person(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String toString() {
		return "Person{name='"+name+"'}";
	}
}

public class Main {
	public static void main(String[] args) {
		Person person = new Person("John");
		Consumer<Person> nameUpdater = p -> p.setName("Jane");
		nameUpdater.accept(person);
		System.out.println(person);
	}
}

