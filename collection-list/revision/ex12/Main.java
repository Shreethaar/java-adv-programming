/* Write a Java program to create a List of integers and add the elements 1, 2, 3, 4, 5 to it. Print the list. */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main (String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);


        Iterator<Integer> itr = numList.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());

        }
    }
}


