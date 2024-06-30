class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(int amount) {
        while (amount > balance) {
            System.out.println(Thread.currentThread().getName() + " tries to withdraw $" + amount + " but insufficient balance.");
            try {
                wait(); // Wait until enough balance is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + " withdraws $" + amount + ". Remaining balance: $" + balance);

        notifyAll(); // Notify all waiting threads that balance has been updated
    }

    public synchronized int getBalance() {
        return balance;
    }
}

public class ThreadWithWait_NotifyAll {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread thread1 = new Thread(() -> {
            account.withdraw(500);
        }, "User A");

        Thread thread2 = new Thread(() -> {
            account.withdraw(800);
        }, "User B");

        thread1.start();
        thread2.start();
    }
}
