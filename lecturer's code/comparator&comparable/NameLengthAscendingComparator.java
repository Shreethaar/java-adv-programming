/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

// Comparator for sorting by name length from smallest to largest

import java.util.Comparator;

class NameLengthAscendingComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getName().length(), p2.getName().length());
    }
}