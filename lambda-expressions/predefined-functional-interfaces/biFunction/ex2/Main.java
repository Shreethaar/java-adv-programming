//single or not;

import java.util.function.BiFunction;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String maritialStatus;
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age:");
		age=sc.nextInt();
		System.out.println("Enter your maritial status:");
		maritialStatus=sc.nextLine();
		BiFunction<String,Integer,Boolean> verifyEmployee = (status,empAge) -> {
				if(status.equals("Married")){
					return empAge>30;
				}
				else {
					return false;
				}
		};
		System.out.println(verifyEmployee.apply(maritialStatus,age));
	}
}

