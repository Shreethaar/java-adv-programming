interface Sayable {
	public String say(String name);
}

public class Main {
	public static void main(String[] args) {
		Sayable s1 = (name) -> {
			return "Hello, " + name;
		};
		System.out.println(s1.say("Sonoo"));

		Sayable s2 = name -> {
			return "Hello, " + name;
		};
		System.out.println(s2.say("Sonno"));
	}
}

