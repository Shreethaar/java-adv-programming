import java.util.HashSet;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		HashSet<Integer> hset = new HashSet<>();

		hset.add(1);
		hset.add(2);
		hset.add(3);
		hset.add(4);

		Iterator<Integer> itr = hset.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}

