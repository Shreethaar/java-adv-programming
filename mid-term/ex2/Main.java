import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;


public class Main {
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(40);
		System.out.println(arrayList);

		arrayList.remove(1);
		System.out.println(arrayList);

		for(int num:arrayList) {
			System.out.println(num);
		}

		List<Integer> linkedList = new LinkedList<>();
		linkedList.add(40);
		linkedList.add(50);
		linkedList.add(60);
		linkedList.remove(1);
		System.out.println(linkedList.get(1));

		for(int num:linkedList) {
			System.out.println(num);
		}

		Iterator<Integer> itr = arrayList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		Iterator<Integer> itr2 = linkedList.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}
}
