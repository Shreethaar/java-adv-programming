public class Main implements Runnable {
    public void run() {
        System.out.println("Thread is running");

    }


    public static void main(String[] args) {
        Runnable r = () -> {
            for(int x=1;x<=3;x++) {
                System.out.println("Run by " + Thread.currentThread.getName() + ",x is " + x);
            }
        };
        Thread one = new Thread(r,"Ali");
        Thread two = new Thread(r,"Bob");
        Thread three = new Thread(r,"Jim");
        one.start();
        two.start();
        three.start();
    }

}

