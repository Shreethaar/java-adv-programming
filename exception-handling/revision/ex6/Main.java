/* Write a Java program that reads a file and throws an exception if the file is empty*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			checkFileNotEmpty("test1.txt");
			System.out.println("File is not empty.");
		}
		catch(FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		catch(EmptyFileException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static void checkFileNotEmpty(String fileName) throws FileNotFoundException, EmptyFileException {
		File file = new File(fileName);
		Scanner sc = new Scanner(file);

		if(!sc.hasNextLine()) {
			sc.close();
			throw new EmptyFileException("File is empty");
		}
		sc.close();
	}
}

class EmptyFileException extends Exception {
	public EmptyFileException(String message) {
		super(message);
	}
}

