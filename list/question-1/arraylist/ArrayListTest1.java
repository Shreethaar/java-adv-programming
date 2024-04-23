import java.util.ArrayList;

public class ArrayListTest1 {
	public static void main(String[] args) {
		ArrayList<String> arrayList1 = new ArrayList<String>();
		ArrayList<String> arrayList2 = new ArrayList<String>();
		ArrayList<String> arrayList3 = new ArrayList<String>();


		//methods for ArrayList
		arrayList1.add("Test 1");
		System.out.println(arrayList1);
		arrayList1.add(1, "Test 2");
		System.out.println(arrayList1);
		arrayList2.add("Test Run 1");
		arrayList1.addAll(arrayList2);
		System.out.println(arrayList1);
		arrayList2.add("Test Run 2");
		System.out.println(arrayList2);
		arrayList1.addAll(0, arrayList2);
		System.out.println(arrayList1);
		arrayList2.clear();
		System.out.println("ArrayList2 clear: " + arrayList2);
		
		arrayList3.add("test");
		arrayList3.add("run");
		arrayList3.add("clone");
		System.out.println(arrayList3);
		System.out.println(arrayList1.clone());


		//basic operation on arraylist: add, access, change and remove elements
		
		ArrayList<String> arrayList4 = new ArrayList<String>();

		//add elements
		arrayList4.add("This");
		arrayList4.add("is");
		arrayList4.add("adding");
		arrayList4.add("elements");
		System.out.println(arrayList4);

		arrayList4.add(2,"removing");
		System.out.println(arrayList4);
		arrayList4.remove("elements");
		System.out.println(arrayList4);
		arrayList4.remove(2);
		System.out.println(arrayList4);
		

		//access elements
		for(String str : arrayList4) {
			System.out.println(str);
		}

		String firstElement = arrayList4.get(0);
		System.out.println(firstElement);

		// change elements
		arrayList4.set(1,"fun");
		arrayList4.set(2,"is it");
		System.out.println(arrayList4);

		// remove elements
		arrayList4.remove(1);
		arrayList4.remove(0);
		System.out.println(arrayList4);

		
		
	}
}

