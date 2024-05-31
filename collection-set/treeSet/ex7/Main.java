import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Set<Soldier> soldiers = new TreeSet<>();
		soldiers.add(new Soldier("Ivanov",170));
		soldiers.add(new Soldier("Petrov",180));
		soldiers.add(new Soldier("Sidorov",175));

		for(Soldier s: soldiers) {
			System.out.println(s.name);
		}
	}

	public static class Soldier implements Comparable<Soldier> {
		private String name;
		private int height;

		public Soldier(String name, int height) {
			this.name=name;
			this.height=height;
		}

		public int compareTo(Soldier o) {
			return o.height-this.height;
		}
	}
}


