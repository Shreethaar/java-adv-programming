// example of the sleep() method in Java

public class Main extends Thread {
    public void run() {
        for(int i=1;i<5;i++) {
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Main t1 = new Main();
        Main t2 = new Main();
        t1.start();
        t2.start();
    }
}

