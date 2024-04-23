class Main {
	public int doSomething(int value) {
		if(value<=0) {
			throw new IllegalArgumentException("Value must be a positive integer.");
		}
		else {
			return value;
		}
	}

	public static void main(String[] args) {
		Main example = new Main();
		example.doSomething(10);
		example.doSomething(-1);
	}
}


