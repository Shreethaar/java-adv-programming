class CustomException extends Exception {
	public CustomException(String message) {
		super(message);
	}
}

class Example {
	public static void main(String[] args) {
		try { 
			validateAge(15);
		}
		catch(CustomException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public static void validateAge(int age) throws CustomException {
		if(age<18) {
			throw new CustomException("You must be at least 18 years old.");
		}
		System.out.println("You are eligible to proceed.");
	}
}

		
