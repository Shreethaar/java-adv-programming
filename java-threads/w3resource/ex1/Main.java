// write a java program to create a basic Java thread that prints "Hello, World!" when executed


public class Main extends Thread {
    public void run() {
        System.out.print("Hello, world!");
    }
    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
    }
}

