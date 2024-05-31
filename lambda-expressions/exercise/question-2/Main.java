/* Write a Java program that can perform four basic arithmetic operations (add, subtract, multiplication & division) to two integer numbers. User should input the two integers and the operation to be performed. Implements all the operations using lambda expressions
*/
import java.util.Scanner;

interface Operations {
	int operate(int a, int b);

public class Main {
	public static void main(String[] args) {
		int num1,num2;
		char operand;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first numbers:");
		num1=sc.nextInt();
		System.out.println("Enter second numbers:");
		num2=sc.nextInt();
		System.out.println("Enter operation (+,-,*,/):");
		operand=sc.next().charAt(0);

		Operations op = null;

		switch(operation) {
			case '+':
                		arithmeticOperation = (a, b) -> a + b;
                		break;
           	 	case '-':
                		arithmeticOperation = (a, b) -> a - b;
                		break;
           		case '*':
                		arithmeticOperation = (a, b) -> a * b;
                		break;
            		case '/':
                		arithmeticOperation = (a, b) -> {
                    			if (b != 0) {
                        			return a / b;
                    			} 
					else {
                        			System.out.println("Error: Division by zero");
                        		return 0;
                    			}
                		};
                		break;
            		default:
                		System.out.println("Invalid operation");
                		System.exit(1);
		}
        	if (arithmeticOperation != null) {
            	int result = arithmeticOperation.operate(num1, num2);
            	System.out.println("Result: " + result);
		}
	}
}


