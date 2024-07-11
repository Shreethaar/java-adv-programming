import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Main {
    private static List<Student> studentList = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Student System Information: ");
            System.out.println("Press 1: Add a new student record");
            System.out.println("Press 2: Search for a student by name");
            System.out.println("Press 3: Save all student records to a text file");
            System.out.println("Press 4: Read student records from a text file");
            System.out.println("Press 5: Exit");
            System.out.println("\nEnter your selection:");
            int selection = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (selection) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    searchStudent(sc);
                    break;
                case 3:
                    // Save to file logic here
                    break;
                case 4:
                    // Read from file logic here
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }
        }
    }

    private static void addStudent(Scanner sc) {
        System.out.println("Enter student name:");
        String name = sc.nextLine();
        System.out.println("Enter student ID:");
        int id = sc.nextInt();
        System.out.println("Enter Number of Courses:");
        int numCourses = sc.nextInt();
        System.out.println("Enter Student GPA:");
        double gpa = sc.nextDouble();

        Student newStudent = new Student(id, name, numCourses, gpa);
        studentList.add(newStudent);
        System.out.println("Student added successfully.");
    }

    private static void searchStudent(Scanner sc) {
        System.out.println("Enter student name to search:");
        String name = sc.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getStudentName().equalsIgnoreCase(name)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with the name: " + name);
        }
    }
}

