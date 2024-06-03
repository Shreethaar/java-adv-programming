/* Problem Statement:
Create a program that calculates the discount amount for a customer based on their membership type and the total purchase amount. The membership types are as follows:

Gold: 20% discount on purchases above $100.
Silver: 10% discount on purchases above $50.
Bronze: 5% discount on purchases above $20.
You need to implement a BiFunction<String, Double, Double> that takes the membership type and the total purchase amount as input and returns the discount amount.

Requirements:

Prompt the user to input their membership type and total purchase amount.
Use a BiFunction to calculate the discount amount based on the given rules.
Display the discount amount to the user.
*/

import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your membership type (Gold/Silver/Bronze):");
		String membershipType = sc.nextLine();
		System.out.println("Enter your total purchase amount: ");
		double totalAmount = sc.nextDouble();

		BiFunction<String,Double,Double> calculateDiscount = (type, amount) ->{
			switch(type) {
				case "Gold":
					if(amount>100) {
						return amount*0.20;
					}
					break;
				case "Silver":
					if(amount>50) {
						return amount*0.10;
					}
					break;
				case "Bronze":
					if(amount>20) {
						return amount*0.05;
					}
					break;
				default:
					return 0.0;
			}
			return 0.0;
		};

		double discountAmount = calculateDiscount.apply(membershipType, totalAmount);
		System.out.println("Discount Amount: " + discountAmount);
	}
}
