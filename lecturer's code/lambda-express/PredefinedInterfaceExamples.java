/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predefined_interfaces;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author DELL
 */
public class PredefinedInterfaceExamples {
    
    public static void main(String[] args) {
        
        //Integer nom=2;
        //int nom1 = new Integer(2);
                               //Integer nom
        Predicate<Integer> p = (nom) -> (nom > -10) && (nom < 10); 
        System.out.println("9 = "+p.test(9)); 
        System.out.println("-12 = "+p.test(-12));
        
        Predicate<String> q = (name) -> name.equalsIgnoreCase("ali");
        System.out.println("Ali = "+q.test("Ali"));
        System.out.println("Abu = "+q.test("Abu"));
        
        Function<String, Integer> f = text -> text.length(); 
        System.out.println(f.apply("Hello!")); 
        
        Function<Double, Double> squareVolume = volume -> volume * volume * volume;
        System.out.println("The volume of square = "+squareVolume.apply(3.0));


    }
    
}
