import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || getClass()!=o.getClass()) return false;
		Person person = (Person) o;
		return age==person.age&&Object.equals(name,person.name);
	}
	public int hashCode() {
		return Objects.hash(name,age);
	}

	public String toString() {
		return "Person{name='"+name+"',age="+age+"}";
	}
}

public class Main {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>(); 
		Person person1 = new Person("John", 25);
        	Person person2 = new Person("Jane", 30);
        	Person person3 = new Person("John", 25);
		
		people.add(person1);
		people.add(person2);
		people.add(person3);

		System.out.println("List contains person1: " + people.contains(person1)); // true
        	System.out.println("List contains person3: " + people.contains(person3)); // true

        // Display the list
        	for (Person person : people) {
            		System.out.println(person);
        	}
    	}
}
