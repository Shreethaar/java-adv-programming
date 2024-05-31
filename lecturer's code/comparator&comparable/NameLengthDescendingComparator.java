/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

// Comparator for sorting by name length from largest to smallest

import java.util.Comparator;

class NameLengthDescendingComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p2.getName().length(), p1.getName().length());
    }
}
