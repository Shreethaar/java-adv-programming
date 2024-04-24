import java.util.*;

class CollectionList1 {
	public static void main(String[] args) {
		List<String> arrayList1 = new ArrayList<>();
		List<Integer> linkedList1 = new LinkedList<>();
		List<String> vector1 = new Vector<>();
		Stack<Double> stack1 = new Stack<>();

		arrayList1.add("Ajay");
		arrayList1.add("Ajay");
		arrayList1.add("Sanjay");
		arrayList1.add("Vijay");

		linkedList1.add(1);
		linkedList1.add(2);
		linkedList1.add(3);
		linkedList1.add(3);

		vector1.add("Ayush");
		vector1.add("Piyush");
		vector1.add("Rajesh");
		vector1.add("Mukesh");

		stack1.push(1.2);
		stack1.push(1.2);
		stack1.push(1.4);

		Iterator itr1 = arrayList1.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}

		Iterator itr2 = linkedList1.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		Iterator itr3 = vector1.iterator();
		while(itr3.hasNext()) {
			System.out.println(itr3.next());
		}

		Iterator itr4 = stack1.iterator();
		while(itr4.hasNext()) {
			System.out.println(itr4.next());
		}


	}
}

