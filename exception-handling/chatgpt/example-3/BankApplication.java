public class BankApplication {
	public static void main(String[] args) {
		Account account = new Account(1000);
	
		try {
			account.withdraw(500);
		}
		catch (InsufficientFundsException e) {
			System.out.println("Insufficient funds. Required: $" + e.getAmount());
			System.out.println("Current balance: $" + account.getBalance());
		}

	}
}

class Account {
	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if(amount <= balance) {
			balance -= amount;
		}
		else {
			double deficit = amount-balance;
			throw new InsufficientFundsException(deficit);
		}
	}
	
	public double getBalance() {
		return balance;
	}
}

class InsufficientFundsException extends Exception {
	private double amount;

	public InsufficientFundsException(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}

