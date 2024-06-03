// Student or non-student

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> verifyStudent = (String i) -> (i.equals("Student"));
		String student1 = "Student";
		String student2 = "Non-student";
		System.out.println(verifyStudent.test(student1));
		System.out.println(verifyStudent.test(student2));
	}
}


