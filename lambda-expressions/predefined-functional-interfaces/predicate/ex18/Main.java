//member or non-member

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Predicate<String> verifyMember = (String i) -> (i.equals("member"));
		String member1 = "member";
		String member2 = "non-member";
		System.out.println(verifyMember.test(member1));
		System.out.println(verifyMember.test(member2));
	}
}

