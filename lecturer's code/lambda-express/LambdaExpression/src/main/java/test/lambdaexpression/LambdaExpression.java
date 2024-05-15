/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package test.lambdaexpression;

import java.util.Comparator;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 * @author PC
 */
public class LambdaExpression {

    public boolean checkNumber(int nom)
    {
        boolean status = false;
        if (nom > 10)
           status = true;
        return status;
    }
    public static void main(String[] args) {
               
        Predicate <Integer> p1 = (nom)-> nom > 10;
        System.out.println("Result 1 = "+p1.test(9));
        
        Predicate <String> n = (name)-> name.equals("uum");
        System.out.println("Result 2 = "+n.test("uum"));
        
        LambdaExpression lambda = new LambdaExpression();
        System.out.println("Result 3 = "+lambda.checkNumber(9));
        
        // Integer nom1, Double nom2
        BiPredicate <Integer, Double> p2 = (nom1 ,nom2)-> ((nom1 + nom2)%2 == 0); 
        System.out.println("Result 4 = "+p2.test(4, 6.0));
        
        Function <String, Integer> f1 = (str)-> str.length();
        System.out.println("The length of 1 string = "+f1.apply("Hello world"));
        
        BiFunction <String,String,Integer> f2 = (str1, str2)-> str1.length()+str2.length();
        System.out.println("The length of 2 strings = "+f2.apply("Hello world", "UUM"));
        
        Consumer <String>  c1 = (output) -> System.out.println(output);
        c1.accept("Welcome to UUM");
        
        Random rand = new Random();
        Supplier <Integer> rawak = ()-> rand.nextInt(10); // randomize number from 0-9
        System.out.println("The random number between 0-9 = "+rawak.get());
                
        BiConsumer <Integer, Double> biCon = (val1, val2)-> System.out.println("Inetger value = "+val1+"\n"+"Double value = "+val2);
        biCon.accept(10, 20.5);
        
        //Student stud1, Student stud2
        Student stud1 = new Student("Adi", 111);
        Student stud2 = new Student("Abu", 222);
        Comparator<Student> nameComparator = (stu1, stu2) -> stud1.getName().compareTo(stud2.getName());
        System.out.println("Result comparator = "+nameComparator.compare(stud1, stud2));
    }
}
