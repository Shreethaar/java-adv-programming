import java.lang.Thread;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            for(int j=0;j<5;j++) {
                Thread.sleep(-100);
                System.out.println(j);
            }
        }
        catch(Exception expn) {
            System.out.println(expn);
        }
    }
}
