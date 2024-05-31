import jdk.incubator.foreign;
public class Test {
	public static void main(String[] args) {
		String str1="UUM";
		String str2="UUM";
		String str3="UuM";

		System.out.println(str1+" "+str1.hashCode());
		System.out.println(str2+" "+str2.hashCode());
		System.out.println(str3+" "+str3.hashCode());

		System.out.println(str1+" "+str1.address());

	}
}

