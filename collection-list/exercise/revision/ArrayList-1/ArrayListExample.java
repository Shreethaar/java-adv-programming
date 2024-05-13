import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> myFriendsList = new ArrayList();
		System.out.println("The size of the myList before init = " + myFriendsList.size());
		myFriendsList.add("Alex");
		myFriendsList.add("Tanya");
		myFriendsList.add("Veloxy");
		myFriendsList.add("Alex");
		myFriendsList.add("Andrew");
		System.out.println(myFriendsList);
		System.out.println("The size of myList after init = " + myFriendsList.size());
		myFriendsList.add("Thor");
		System.out.println(myFriendsList);
		System.out.println("The size of myList = " + myFriendsList.size());

		System.out.println(myFriendsList.indexOf("Alex"));
		
		myFriendsList.remove(3);
		System.out.println(myFriendsList.get(3));
		System.out.println("After removing one of Alex's there is only Alex: " + myFriendsList);
		System.out.println(myFriendsList.get(1));

		myFriendsList.clear();
		System.out.println("The size of the list after clear method = " + myFriendsList.size());

	
	}

}
