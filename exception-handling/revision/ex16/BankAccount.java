public class BankAccount {
	private String accountNumber;
	private double balance;

	public BankAccount(String accountNumber, double balance) {
		this.accountNumber=accountNumber;
		this.balance=balance;
	}

	public void deposit(double amount) {
		if(amount < 0) { 
			throw new IllegalArgumentException("Amount to deposit must be positive");
		}
		balance+=amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if(amount < 0) {
			throw new IllegalArgumentException("Amount to withdraw must be positive");
		}
		if(amount>balance) {
			throw new InsufficientFundsException("Insufficient funds for withdrawal");
		}
		balance-=amount;
	}

	public double getBalance() {
		return balance;
	}
}

