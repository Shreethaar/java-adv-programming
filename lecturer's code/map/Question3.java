
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Question3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //System.out.print("Enter your input text = ");
        //String text = scan.nextLine();
        String text = "I like to eat and I like to play chess and I like swimming.";
        String[] words = text.split("[\\s.,]+");//My   name is Ali.I live in Jitra,Kedah.
        
        System.out.println("A list of words in the text");
        for (String word :words) {
            System.out.println(word);
        }
        
        System.out.println("");
        Map<String, Integer> wordCount = new TreeMap<>();
        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 1);
            } else {
                int count = wordCount.get(word);
                count++;
                wordCount.replace(word, count);
            }
        }
        Set<Map.Entry<String, Integer>> entries = wordCount.entrySet();
        System.out.println("A list of words and its frequency");
        for (Map.Entry< String, Integer> entry : entries) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }

    }
}
