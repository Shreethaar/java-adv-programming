// write a Java program that creates two threads to find and print even and odd numbers from 1 to 20


public class Main {
    private static final int MAX_NUMBER=20;
    private static Object lock = new Object();
    private static boolean isEvenTurn=true;

    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for(int i=2;i<=MAX_NUMBER;i+=2) {
                synchronized(lock) {
                    while(!isEvenTurn) {
                        try {
                            lock.wait();
                        }
                        catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even number from evenThread:"+ i);
                    isEvenTurn=false;
                    lock.notify();
                }
            }
        });

        Thread oddThread = new Thread(() -> {
            for(int i=1;i<=MAX_NUMBER;i+=2) {
                synchronized(lock) {
                    while(isEvenTurn) {
                        try{
                            lock.wait();
                        }
                        catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd number from oddThread:" + i);
                    isEvenTurn=true;
                }
            }
        });
        evenThread.start();
        oddThread.start();
    }
}



