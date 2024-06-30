class SharedObject {
    synchronized void waitForNotify() {
        try {
            wait(); // Wait until notified
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Thread notified.");
    }

    synchronized void notifyThread() {
        notify(); // Notify waiting thread
    }
}

public class ThreadWithWait_Notify {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();

        Thread threadA = new Thread(() -> {
            System.out.println("Thread A waiting...");
            sharedObject.waitForNotify();
            System.out.println("Thread A resumed.");
        });

        Thread threadB = new Thread(() -> {
            System.out.println("Thread B notifying...");
            sharedObject.notifyThread();
        });

        threadA.start();
        threadB.start();
    }
}
