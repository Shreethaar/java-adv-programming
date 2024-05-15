/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package option3_lambda;

import option2_innerclass.*;
import option1_comparator.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        Comparator<Person> comp = (p1, p2)  -> p1.getName().compareTo(p2.getName());

        Collections.sort(people, comp);
        // Printing sorted list
        for (Person person : people) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        }
    }
    
}
