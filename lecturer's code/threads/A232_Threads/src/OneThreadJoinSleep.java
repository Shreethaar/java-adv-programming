public class OneThreadJoinSleep implements Runnable {

    public void run() {
        for (int x = 1; x <= 3; x++) {
            System.out.println("Run by " + Thread.currentThread().getName() + ", x is " + x);
            // Make the thread sleep for a while
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
            }
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new ManyNames();
        
        Thread one = new Thread(r1, "Ali");
        
        one.start();

        // Wait for the thread to finish
        try {
            one.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        System.out.println("Thread has finished execution");
    }
}
