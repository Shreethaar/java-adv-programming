public class Main {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("12234533",1000.00);

		try {
			System.out.println("Creating account with initial balance $1000.00");
			account.deposit(500.0);
			System.out.println("Depositing $500.0");
			System.out.println("New balance after deposit: $" + account.getBalance());
			System.out.println("Attempting to withdraw $2000.00");
			account.withdraw(2000.0);
		}
		catch (InsufficientFundsException e) {
			System.out.println("InsufficientFundsException: " + e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
		}

		finally {
			System.out.println("Final balance: $" + account.getBalance());
		}

		try {
			System.out.println("Attempting to withdraw -$100.0");
			account.withdraw(-100.0);
		}
		catch (InsufficientFundsException e) {
			System.out.println("InsufficientFundsException: " + e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + e.getMessage());
		}
		finally {
			System.out.println("Final balance: $" + account.getBalance());
		}
	}
}

