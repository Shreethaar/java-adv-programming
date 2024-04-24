import java.util.Stack;
import java.util.Iterator;

public class StackinList{
	public static void main(String[] args) {
		Stack<String> stack1 = new Stack<>();
		stack1.add("Name");
		stack1.add("Name");
		stack1.add("Name2");

		stack1.push("Push Name");
		stack1.push("Push Name");
		stack1.push("Push Name2");

		Iterator<String> itr = stack1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
			itr.remove();
			System.out.println("!");

		}
	}	
}

