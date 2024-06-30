public class TwoThreadJoinYield implements Runnable {

    public void run() {
        for (int x = 1; x <= 3; x++) {
            System.out.println("Run by " + Thread.currentThread().getName() + ", x is " + x);
            // Yield the processor
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new ManyNames();
        Runnable r2 = new ManyNames();

        Thread one = new Thread(r1, "Ali");
        Thread two = new Thread(r2, "Bob");

        one.start();
        two.start();

        // Wait for both threads to finish
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        System.out.println("All threads have finished execution");
    }
}
