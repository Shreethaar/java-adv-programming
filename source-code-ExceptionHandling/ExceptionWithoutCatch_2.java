package ex01;


import java.util.Scanner;

public class ExceptionWithoutCatch_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        System.out.print("Enter an integer > ");
        num = scan.nextInt();  // InputMismatchException - invalid input
        System.out.println("The number you entered is " +num);

    }
    
}
