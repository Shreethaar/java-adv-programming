import java.util.*;

public class Main {
	public static void main(String[] args) {
		try {
			List<Integer> numbers = readNumbersFromUser();
			Scanner sc = new Scanner(System.in);
			System.out.print("How many numbers do you want to input?");
		}
		catch (Duplicate_Number_Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static List<Integer> readNumbersFromUser() {
		List<Integer> numbers = new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.print("How many numbers do you want to input? ");
		int count = sc.nextInt();

		System.out.println("Input the integers:");
		for(int i=0;i<count;i++) {
			int num=sc.nextInt();
			numbers.add(num);
		}

		sc.close();
		return numbers;
	}

	public static void checkDuplicates(List<Integer> numbers) throws Duplicate_Number_Exception {
		Set<Integer> uniqueNumbers=new HashSet<>();
		for(int num:numbers) {
			if(uniqueNumbers.contains(num)) {
				throw new Duplicate_Number_Exception("Duplicate numberfound: " + num);
			}
			uniqueNumbers.add(num);
		}
	}
}

class Duplicate_Number_Exception extends Exception {
	public Duplicate_Number_Exception(String message) {
		super(message);
	}
}

