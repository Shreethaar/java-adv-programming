import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Question1 {
    public static void main(String[] args) {
        int[] array1 = {5, 2, 3, 1, 4};
        int[] array2 = {7, 6, 3, 5, 4};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements of array1 to set1
        for (int num : array1) {
            set1.add(num);
        }
        
        // Add elements of array2 to set2
        for (int num : array2) {
            set2.add(num);
        }

        // Find common elements
        set1.retainAll(set2);

        // Sort the common elements
        Set<Integer> sortedSet = new TreeSet<>(set1);

        // Display the common elements
        System.out.println("Common elements in ascending order:");
        for (int num : sortedSet) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
