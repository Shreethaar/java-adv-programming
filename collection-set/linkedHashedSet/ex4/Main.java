/* Write a Java method to remove all duplicates from a LinkedHashSet. */

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter as much of numbers you like, enter 0 to stop:");
		Set<Integer> numSet = new LinkedHashSet<>();

		while(true) {
			int num=sc.nextInt();
			if(num==0) {
				break;
			}
			else {
				numSet.add(num);
				System.out.println(numSet);
			}
			
		}

	}
}
