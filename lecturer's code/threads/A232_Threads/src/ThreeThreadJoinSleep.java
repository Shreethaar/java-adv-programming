public class ThreeThreadJoinSleep implements Runnable {

    public void run() {
        for (int x = 1; x <= 3; x++) {
            System.out.println("Run by " + Thread.currentThread().getName() + ", x is " + x);
            // Make the thread sleep for a while
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
            }
            // Yield the processor
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new ManyNames();
        Runnable r2 = new ManyNames();
        Runnable r3 = new ManyNames();

        Thread one = new Thread(r1, "Ali");
        Thread two = new Thread(r2, "Bob");
        Thread three = new Thread(r3, "Jim");

        one.start();
        two.start();
        three.start();

        // Wait for all threads to finish
        try {
            one.join();
            two.join();
            three.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        System.out.println("All threads have finished execution");
    }
}
