/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author DELL
 */
public class PersonUI {
    public static void main(String[] args) {
        // Creating list of persons
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 20));

        // Sort by name in ascending order
        Collections.sort(people, new NameAscendingComparator());

        // Sort by name in descending order
        //Collections.sort(people, new NameDescendingComparator());

        // Sort by age in ascending order
        //Collections.sort(people, new AgeAscendingComparator());

        // Sort by age in descending order
        //Collections.sort(people, new AgeDescendingComparator());

        // Sort by name length from smallest to largest
        //Collections.sort(people, new NameLengthAscendingComparator());

        // Sort by name length from largest to smallest
        //Collections.sort(people, new NameLengthDescendingComparator());

        // Printing sorted list
        for (Person person : people) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
    
}
