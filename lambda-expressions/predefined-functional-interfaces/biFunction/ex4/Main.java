/* Problem Statement:
Create a program that calculates the Body Mass Index (BMI) of a person and categorizes their BMI into various categories. The BMI is calculated using the formula:

BMI
=
weight (kg)
height (m)
2
BMI= 
height (m) 
2
 
weight (kg)
​
 

The BMI categories are as follows:

Underweight: BMI < 18.5
Normal weight: 18.5 ≤ BMI < 24.9
Overweight: 25 ≤ BMI < 29.9
Obesity: BMI ≥ 30
You need to implement a BiFunction<Double, Double, String> that takes the weight (in kilograms) and height (in meters) as input and returns the BMI category as a string.
*/

import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your weight in kilograms:");
		double weight = sc.nextDouble();
		System.out.println("Enter your height in meters:");
		double height = sc.nextDouble();
		BiFunction<Double,Double,String> calculateBMI = (w,h) -> {
			double bmi = w/(h*h);
			if(bmi<18.5) {
				return "Underweight";
			}
			else if (bmi<24.9) {
				return "Normal weight";
			}
			else if (bmi<29.9) {
				return "Over weight";
			}
			else {
				return "Obesity";
			}
		};

		String category = calculateBMI.apply(weight,height);
		double bmi = weight/(height*height);
		System.out.printf("BMI: %2.f\n",bmi);
		System.out.println("Category: " + category);
		sc.close();
	}
}

