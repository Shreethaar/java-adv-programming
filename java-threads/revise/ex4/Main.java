// Using the thread class: Thread(String name)

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread("my first thread");
        t.start();
        String str=t.getName();
        System.out.println(str);
    }
}
