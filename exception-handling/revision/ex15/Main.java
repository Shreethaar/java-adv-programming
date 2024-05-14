import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arrNum = new int[4];

        try {
            storeElement(arrNum);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void storeElement(int[] arrNum) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter an integer for index " + i + ":");
            arrNum[i] = sc.nextInt();
        }
        sc.close();
    }
}





