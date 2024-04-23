import java.util.List;
import java.util.ArrayList;

public class StringList {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2= new ArrayList<>();
		list1.add("red");
		list1.add("yellow");
		list1.add("green");
		list2.add("red");
		list2.add("yellow");
		list2.add("blue");
		System.out.println("List1: "+list1);
		System.out.println("List2: "+list2);


		//Question a: What are list1 and list2 after executing list1.addAll(list2)
		/*
		list1.addAll(list2);
		System.out.println("List1: "+list1);
		System.out.println("List2: "+list2);

		
		//Question b: What are list1 and list2 after executing list1.removeAll(list2);

		list1.removeAll(list2);
		System.out.println("List1: "+list1);
		System.out.println("List2: "+list2);
		*/
		//Question c: What are list1 and list2 after executing list1.retainAll(list2);
		list1.retainAll(list2);
		System.out.println("List1: "+list1);
		System.out.println("List2: "+list2);

		//Question d: What are list1 after executing list1.clear();
		list1.clear();
		System.out.println("List1: " +list1);

		
	}
}



