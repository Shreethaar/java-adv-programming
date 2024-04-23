class NumberFormat_Demo {
	public static void main(String[] args) {
		try {
			int num=Integer.parseInt("Akki");
			System.out.println(num);
		}
		catch(NumberFormatException e) {
			System.out.println("Number format exception");
		}
	}
}

