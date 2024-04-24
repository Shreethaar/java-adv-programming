/* Write a program that counts the occurrences of words in a text input by the user and displays the words and their occurrences in alphabetical order of the words.

*/

// text into array -> LinkedHashSet -> counts

import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("PLS ENTER TXT:");
		String input=sc.nextLine();
		String[] text=input.split("\\s+");
		
		Set<String> hashedText = new LinkedHashSet<>();
		hashedText.addAll(Arrays.asList(text));
		
		for(String word:hashedText) {
			int count=0;
			for(String w:text) {
				if(word.equals(w)) {
					count++;
				}
			}
			System.out.println(word+": "+count);
		}
	}
}

