public class BankAccount {
	private double balance;

	public BankAccount(double balance) {
		this.balance=balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException{
		if(amount>balance) {
			throw new InsufficientFundsException("Insufficient Funds: " + balance);
		}
	}


	public static void main(String[] args) {
		BankAccount bankAcc = new BankAccount(100);
		try {
			bankAcc.withdraw(200);
		}
		catch(InsufficientFundsException e) {
			System.out.println("Caught exception: " + e.getMessage());
		}
	}
}

