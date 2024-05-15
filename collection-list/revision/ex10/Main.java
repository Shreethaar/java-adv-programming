/* Question:

You are required to create a Java program that performs the following tasks:

User Input and Exception Handling:

Read a list of student records from the user. Each record contains an id (integer), name (string), and age (integer).
Implement exception handling to manage the following scenarios:
If the user inputs an invalid format for any of the fields, prompt the user to re-enter the entire record.
Create a custom exception called DuplicateStudentException that is thrown if a student with the same id is entered more than once.
If the user enters "done", stop reading input.
Manage Unique Students:

Store the unique Student objects in a set. Use a TreeSet and ensure the natural order is based on the id field (override hashCode() and equals() methods).
Sorting and Display:

After reading the input, sort the students by their name in ascending order using the Comparator interface.
Display the sorted list of students.

*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

class DuplicateStudentException extends Exception {
	public DuplicateStudentException(String message) {
		super(message);
	}
}

class Student implements Comparable<Student> {
	int id;
	String name;
	int age;

	public Student(int id, String name, int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}


	public int hashCode() {
		return Objects.hash(id);
	}

	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null || getClass() != obj.getClass()) return false;
		Student student = (Student) obj;
		return id==student.id;
	}

	public int compareTo(Student other) {
		return Integer.compare(this.id,other.id);
	}

	public String toString() {
		return id+": " +name+", "+age+" years old";
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Student> students = new TreeSet<>();

		while(true) {
			System.out.println("Enter student record (id name age): ");
			String input = sc.nextLine();
			if(input.equalsIgnoreCase("done")) {
				break;
			}
			try {
				String[] parts = input.split(" ");
				if(parts.length!=3) {
					throw new InputMismatchException("Incorrect input format. Please enter the record in 'id name age' format.");
				}
				int id = Integer.parseInt(parts[0]);
				String name = parts[1];
				int age = Integer.parseInt(parts[2]);
				Student student = new Student(id,name,age);
				if(!students.add(student)) {
					throw new DuplicateStudentException("Duplicate student ID found. Please enter a unique student ID.");
				}
			}
			catch(InputMismatchException | NumberFormatException e) {
				System.out.println("Invalid input. " + e.getMessage());
			}
			catch(DuplicateStudentException e) {
				System.out.println(e.getMessage());
			}
		}

		List<Student> sortedStudents = new ArrayList<>(students);
		sortedStudents.sort(Comparator.comparing(student -> student.name));
		System.out.println("Students sorted by name:");
		for(Student student : sortedStudents) {
			System.out.println(student);
		}
	}
}



