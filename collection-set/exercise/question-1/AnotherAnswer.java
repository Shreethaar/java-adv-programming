import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class AnotherAnswer {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] arr1=new int[5];
		int[] arr2=new int[5];

		System.out.println("Enter elements for arr1:");
		for(int i=0; i<arr1.length;i++) {
			arr1[i]=sc.nextInt();
		}
		System.out.println("Enter elements for arr1:");
		for(int i=0; i<arr2.length;i++) {
			arr2[i]=sc.nextInt();
		}

		HashSet<Integer> set1 = new HashSet<>();
		for(int num:arr1) {
			set1.add(num);
		}
		
		HashSet<Integer> set2 = new HashSet<>();
		for(int num:arr2) {
			set2.add(num);
		}

		set1.retainAll(set2);
		
		Integer[] common = set1.toArray(new Integer[0]);
		Arrays.sort(common);
		System.out.println("Common elements in ascending order:");
		for(int num:common) {
			System.out.print(num+" ");
		}
	}
}

			
