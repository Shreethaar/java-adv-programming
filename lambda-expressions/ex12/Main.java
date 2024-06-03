import java.util.Function;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public interface Checker {
		boolean test(Person person);
	}

	public static void main(String[] args) {
		List<Person> people=new ArrayList<>();
		people.add(new Person("Ali",25,"Penang"));
		people.add(new Person("Bob",20, "Kedah"));
		people.add(new Person("Lim",30,"Penang"));
		people.add(new Person("Aru",35,"Perlis"));

		
	
		int age=25;
		printBy(people,(p) -> p.getAge()>age);
		printBy(people,p -> p.getOrigin().equals("Kedah"));
	}

	public static void printBy(List<Person> people, Checker checker) {
		for(Person p : people) {
			if(checker.test(p)) {
				System.out.println(p);
			}
		}
	}
}


