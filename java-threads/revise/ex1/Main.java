public class Main implements Runnable {
    public void run() {
        System.out.println("thread is running");
    }
    public static void main(String[] args) {
        Thread t = new Thread(new Main());
        t.start();

    }
}

