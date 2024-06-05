public class Person {
	public String name;
	public Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Name: " +name+", Age: " + age;
	}
}

