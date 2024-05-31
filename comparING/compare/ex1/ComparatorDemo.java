import java.util.*;

class Student {
	String name;
	int age,roll;
	
	Student(String name, int age, int roll){
		this.name=name;
		this.age=age;
		this.roll=roll;
	}

}

class AgeComparator implements Comparator {
   @Override
   public int compare(Object o1, Object o2) {
      return ((Student) o1).age - ((Student) o2).age;
   }
}
class RollComparator implements Comparator {
   @Override
   public int compare(Object o1, Object o2) {
      return ((Student) o1).roll - ((Student) o2).roll;
   }
}

public class ComparatorDemo {
   public static void main(String[] args) {
      List list = new ArrayList<>();
      list.add(new Student("Ramesh", 30, 20));
      list.add(new Student("Adithya", 7, 10));
      list.add(new Student("Krishna", 25, 5));
      list.add(new Student("Vineet", 24, 15));
      System.out.println("BEFORE SORTING");
      for (Student e : list) {
         System.out.println("[ STU : name = " + e.name + " age = " + e.age + " roll = " + e.roll + "]");
      }
      Collections.sort(list,new AgeComparator());
      System.out.println("AFTER SORTING WITH AGE");
      for (Student e : list) {
         System.out.println("[ STU : name = " + e.name + " age = " + e.age + " ]");
      }
      Collections.sort(list,new RollComparator());
      System.out.println("AFTER SORTING WITH ROLL");
      for (Student e : list) {
         System.out.println("[ STU : name = " + e.name + " roll = " + e.roll + " ]");
      }
   }
}
