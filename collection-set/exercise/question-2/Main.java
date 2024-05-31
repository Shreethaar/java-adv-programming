/* Write a Java program that takes an array of integers and returns the second largest number in the array. For example, given the array is [1, 5, 2, 4, 3], the program should display 4, since 4 is the second largest number in the array. If the array is [1, 2, 2, 3, 4, 4, 5], the program should still return 4, since 4 is still the second largest number in the array. If the array is [3,3,3,3] the program should display there is no second largest number in the array.
*/

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			TreeSet<Integer> numSet = new TreeSet<>();
			System.out.println("Enter the size of the set:");
			int sizeSet=sc.nextInt();
			for(int i=0;i<sizeSet;i++) {
				System.out.printf("Enter element %d:\n",(i+1));
				int elementSet=sc.nextInt();
				numSet.add(elementSet);
			}
			numSet.remove(numSet.last());
			Integer max=numSet.pollLast();
			if(max!=null) {
				System.out.println("Second largest integer: " + max);
			}
			else {
				System.out.println("No second largestest integer");
			}

		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}


			
