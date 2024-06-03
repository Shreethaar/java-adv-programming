public class Main {
	int instanceVariable = 5;
	static int staticVariable = 7;

	public void doSomething() {
		int localVar = 10;
		Runnable operation = () -> {
			instanceVariable++;
			staticVariable++;
			//final localVar++;
			System.out.println("Modified instance variable: " + instanceVariable);
			System.out.println("Modified static variable: " + staticVariable);
			//System.out.println("Local variable: " + localVar);
		};
		operation.run();
	}
	public static void main(String[] args) {
		Main test = new Main();
		test.doSomething();
	}
}

