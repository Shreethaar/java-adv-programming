public class Person {
	private int age;

	public void setAge(int age) throws InvalidAgeException {
		if(age<0||age>150) {
			throw new InvalidAgeException("Invalid Age: " + age);
		}
		this.age=age;
	}
	public int getAge() {
		return age;
	}

	public static void main(String[] args) {
		Person person = new Person();
		try {
			person.setAge(200);
		}
		catch(InvalidAgeException e) {
			System.out.println("Caught exception: " + e.getMessage());
		}
	}
}

