class MyThread extends Thread {
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.print(Thread.currentThread().getId()+" Value " + i);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }
}


