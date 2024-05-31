/* Write a Java program to create a method that reads a file and throws an Exception if the file is not found */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			readFile("test1.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}


	public static void readFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
		sc.close();
	}
}

	
