import java.util.Scanner;

class IOException_Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner("Hello Greek!");
		System.out.println(""+sc.nextLine());
		System.out.println("Exception Output: " + sc.ioException());
		sc.close();
	}
}

