
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionTest {

    public static void main(String[] args) {

        int num = 0, div = 0, result = 0;
        Scanner input = new Scanner(System.in);
        boolean keepGoing = true;
        while (keepGoing) {
            try {
                System.out.print("Enter the numerator> ");
                num = input.nextInt();
                System.out.print("Enter the divisor> ");
                div = input.nextInt();

                result = num / div;
                keepGoing = false;
            } catch (InputMismatchException e) {
                System.out.println("You entered bad data.\nPlease try again. ");
                input.nextLine();

            } catch (ArithmeticException e) {
                System.out.println("You can't divide by 0 ");

            }
        }// while
        System.out.println(num + " / " + div + " = " + result);
    } // main

}
