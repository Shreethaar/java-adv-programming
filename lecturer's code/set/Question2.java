import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question2 {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 2, 4, 3};
        int[] array2 = {1, 2, 2, 3, 4, 4, 5};
        int[] array3 = {3, 3, 3, 3};

        System.out.println("Second largest in array1: " + findSecondLargest(array1));
        System.out.println("Second largest in array2: " + findSecondLargest(array2));
        System.out.println("Second largest in array3: " + findSecondLargest(array3));
    }

    public static int findSecondLargest(int[] arr) {
        // Using HashSet to remove duplicates
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // If the set contains less than 2 elements, no second largest
        if (set.size() < 2) {
            return -1; // Indicate no second largest found
        }

        // Finding the second largest by removing the largest element
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        return secondMax;
    }
}
