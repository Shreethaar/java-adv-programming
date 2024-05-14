import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		try {
			doWork(num);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		

	}
	public static void doWork(int num) throws Exception {
		if(num!=0) {
			throw new Exception("Null value");
		}
		else {
			System.out.println(num);
		}

	}
}


