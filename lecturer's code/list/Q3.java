
import java.util.ArrayList;
import java.util.List;


public class Q3 
{
    public static void main(String[] args) 
    {
        List <String> list1 = new ArrayList<String>();
        list1.add("red");
        list1.add("yellow");
        list1.add("green");
        
        System.out.println("List1");
        for (int i=0; i<list1.size(); i++)
            System.out.println(i+"\t"+list1.get(i));
        
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("red");
        list2.add("yellow");
        list2.add("blue");
        
        System.out.println("\nList2");
        for (int i=0; i<list2.size(); i++)
            System.out.println(i+"\t"+list2.get(i));
        
        list1.addAll(list2);
        System.out.println("\nlist1.addAll(list2)");
        for (int i=0; i<list1.size(); i++)
            System.out.println(i+"\t"+list1.get(i));
        
        System.out.println("\nList2-2");
        for (int i=0; i<list2.size(); i++)
            System.out.println(i+"\t"+list2.get(i));
        
        list1.removeAll(list2);
        System.out.println("\nlist1.removeAll(list2)");
        for (int i=0; i<list1.size(); i++)
            System.out.println(i+"\t"+list1.get(i));
        
        System.out.println("\nList2-3");
        for (int i=0; i<list2.size(); i++)
            System.out.println(i+"\t"+list2.get(i));
        
        
        list1.retainAll(list2);
        System.out.println("\nlist1.retainAll(list2)");
        for (int i=0; i<list1.size(); i++)
            System.out.println(i+"\t"+list1.get(i));
        
        System.out.println("\nList2-4");
        for (int i=0; i<list2.size(); i++)
            System.out.println(i+"\t"+list2.get(i));
        
        list1.clear();
        System.out.println("\nlist1.clear())");
        for (int i=0; i<list1.size(); i++)
            System.out.println(i+"\t"+list1.get(i));
    }
}
