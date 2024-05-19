/* Write a Java program that allows the user to print a string input using one of the two print method: System.out.println() method or the JOptionPane.showMessageDialog() method. Define a method to print the string and use lambda expression so that the print method to be used can be passed as an argument to the method defined.
*/
import java.util.Scanner;
import java.util.function.Consumer;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = sc.nextLine();
		Consumer<String> returnString = input -> System.out.println(s);
		returnString.accept(s);
		
	}

}

