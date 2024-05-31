import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question2_v2 {
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
        int secondLargest = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        
        System.out.println("The current size of this array = "+set.size());
        // If the set contains less than 2 elements, no second largest
        if (set.size() < 2) {
            return secondLargest; // Indicate no second largest found
        }
        else
        {
            List<Integer> list = new ArrayList<>(set);
            secondLargest = list.get(list.size()-2);
            return secondLargest;
        }

        // Finding the second largest by removing the largest element
        
    }
}
