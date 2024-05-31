/* Write a Java program that takes two arrays of integers and displays the common elements between the two arrays in ascending order. For example, if
 Array 1 = {5, 2, 3, 1, 4} and Array 2 = {7, 6, 3, 5, 4} 
Then the output is:      
   3 4 5
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		int n1=0;
		for(int i=0;i<=4;i++) {
			System.out.printf("Enter element %d into arr1:\n",(i+1));
			n1=sc.nextInt();
			arr1.add(n1);
		}
		int n2=0;
		for(int i=0;i<=4;i++) {
			System.out.printf("\nEnter element %d into arr2:\n",(i+1));
			n2=sc.nextInt();
			arr2.add(n2);
		}
		HashSet<Integer> set1 = new HashSet<>();
		set1.addAll(arr1);

		HashSet<Integer> set2 = new HashSet<>();
		set2.addAll(arr2);

		set1.retainAll(set2);
		System.out.println(set1);
	}
}


