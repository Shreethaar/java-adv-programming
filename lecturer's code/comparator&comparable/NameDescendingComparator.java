/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import java.util.Comparator;

/**
 *
 * @author DELL
 */
// Comparator for sorting by name in descending order
class NameDescendingComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p2.getName().compareTo(p1.getName());
    }
}
