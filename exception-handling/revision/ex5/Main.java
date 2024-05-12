/* Write a Java program that reads a list of numbers from a file and throws an exception if any of the numbers are positive
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		try {
			readFile("test1.txt");
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void readFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner sc = new Scanner(file);

		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.print(line);

		}
		sc.close();
	}
}
