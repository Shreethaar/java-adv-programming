class MyRunnable implements Runnable {
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getId()+" Value " + i);

        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

    }
}
