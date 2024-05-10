import java.util.Stack;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<>();
		System.out.println(stack1.empty());
		
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);

		System.out.println("Stack print out: ");
		for(int i:stack1) {
			System.out.println(i);
		}
		System.out.println(stack1.empty());

		int peekNum = stack1.peek();
		System.out.println("Peek:"+peekNum);

		
		Iterator<Integer> itr = stack1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println(stack1.pop());
		System.out.println("Search 3: " + stack1.search(3));
		System.out.println("Search 4: " + stack1.search(4));
		System.out.println("Search 1: " + stack1.search(1));


		
	}
}

