/* Question 1: Exception Handling and List
Question:

You are required to create a Java program that reads integers from the user and adds them to a list. Implement exception handling to manage the following scenarios:

Input Mismatch Exception: If the user inputs a non-integer value, catch this exception and prompt the user to enter the integer again.
Custom Exception: Create a custom exception called NegativeNumberException which should be thrown if the user enters a negative number. Catch this exception and display an appropriate message to the user.
Display List: Once the user decides to stop entering numbers (by entering a specific keyword, e.g., "done"), display the list of entered integers.
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        while (true) {
            System.out.print("Enter an integer: ");
            try {
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                int number = Integer.parseInt(input);
                if (number < 0) {
                    throw new NegativeNumberException("Negative numbers are not allowed. Please enter a positive integer.");
                }
                numbers.add(number);
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("The list of entered integers is: " + numbers);
    }
}

