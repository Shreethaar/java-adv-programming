/* Coding Question
Title: Summing Adjacent Elements in a List Using BinaryOperator

Problem Statement:

You are given a list of integers. Your task is to create a BinaryOperator<Integer> that sums two integers. Then, write a method sumAdjacentElements that takes a list of integers and applies the BinaryOperator to each pair of adjacent elements in the list, storing the results in a new list. The method should return this new list of summed adjacent elements.

Requirements:

Create a BinaryOperator<Integer> that sums two integers.
Write a method sumAdjacentElements that takes a list of integers and applies the BinaryOperator to each pair of adjacent elements.
The method should return a new list containing the sums of each pair of adjacent elements.
*/

import java.util.function.BinaryOperator;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		BinaryOperator<Integer,Integer> sumTwoInt = (i,j) -> a+b;
		List<Integer> result = sumAdjacent(numbers,sumTwoInt);
		System.out.println(result);
	}

	public static List<Integer> sumAdjacentElements(List<Integer> numbers, BinaryOperator<Integer> operator) {
		for(int i=0;i<numbers.size()-1;i++) {
			int sum = operator.apply(numbers.get(i),numbers.get(i+1));
			result.add(sum);
		}
		return result;
	}

}




