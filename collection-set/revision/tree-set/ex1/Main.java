import java.util.Set;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Set<Integer> treeSet1 = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the set");
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Enter element - " + n);
			int insert = sc.nextInt();
			treeSet1.add(insert);
		}
		System.out.println(treeSet1);

	}
}

