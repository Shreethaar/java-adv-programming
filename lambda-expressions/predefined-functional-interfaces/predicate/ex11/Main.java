import java.util.function.Predicate;
import java.util.*;

public class Main {
	String name,role;
	Main(String a, String b) {
		name=a;
		role=b;
	}

	String getRole() {return role;}
	String getName() {return name;}
	public String toString() {
		return "User name: " + name + ",Role: " + role;
	}

	public static void main(String[] args) {
		List<Main> users = new ArrayList<User>();
		users.add(new Main("John", "admin"));
		users.add(new Main("Peter", "member"));
		List admins = process(users, (User u) -> u.getRole().equals("admin"));
		System.out.println(admins);
	}

	public static List<Main> process(List<Main> users, Predicate<Main> predicate){
		List<Main> result = new ArrayList<Main>();
		for(Main user: users) {
			if(predicate.test(user))
				result.add(user);
			return result;
		}
	}
}

