/* Question 2: Set and Comparator
Question:

You are required to create a Java program that adds unique objects of a user-defined class Student to a set. The Student class has three fields: id, name, and age. Assume the uniqueness of the Student objects is based solely on the id field (without overriding hashCode() and equals() methods).

Additionally, sort the set of Student objects based on their name in ascending order using the Comparator interface.

*/

import java.util.Comparator;
import java.util.TreeSet;
import java.util.Set;

class Student {
	int id;
	String name;
	int age;

	public Student(int id, String name, int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}

	public String toString(){
		return id + ": " + name + ", " + age + " years old";
	}
}

public class Main {
	public static void main(String[] args) {
		Set<Student> students = new TreeSet<>(new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.name.compareTo(s2.name);
			}
		});
		students.add(new Student(1,"Alice",20));
		students.add(new Student(2,"Charlie",21));
		students.add(new Student(3,"Bob",22));

		System.out.println("Student sorted by names:");
		for(Student student : students) {
			System.out.println(student);
		}
	}
}

