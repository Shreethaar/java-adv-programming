import java.io.File;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		File file = new File("test.txt");
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
		sc.close();
	}
}


