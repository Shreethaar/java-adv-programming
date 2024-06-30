public class ManyNames implements Runnable{
    public void run()
    {
        for (int x = 1; x <= 3; x++) {
                System.out.println("Run by " + Thread.currentThread().getName() + ", x is " + x);
            }
    }
    public static void main(String[] args)  {
        
        ManyNames r1 = new ManyNames();
        ManyNames r2 = new ManyNames();
        ManyNames r3 = new ManyNames();
        
        Thread one = new Thread(r1,"Ali");
        Thread two = new Thread(r2,"Bob");
        Thread three = new Thread(r3,"Jim");
        one.start();
        two.start();
        three.start();
    }
} 
