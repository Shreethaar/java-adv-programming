
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Question4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //System.out.print("Enter your input text = ");
        //String text = scan.nextLine();
        String text = "I like to eat. I like to play chess. I like swimming.";
        String[] words = text.split("[\\s.,]+");//My   name is Ali.I live in Jitra,Kedah.
        
        System.out.println("A list of words in the text");
        for (String word :words) {
            System.out.println(word);
        }
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
        System.out.println("\nA list of words and its frequency");
        Set<Map.Entry<String, Integer>> entriesA = wordCount.entrySet();
        for (Map.Entry< String, Integer> entry : entriesA) {
            System.out.println(entry.getKey()+"\t"+entry.getValue());
        }
        
        System.out.println("");
        
        Set<Map.Entry<String, Integer>> entries = wordCount.entrySet();
        //List<Map.Entry<String, Integer>> entries2 = new ArrayList<>();
        List<Map.Entry<String, Integer>> entries2 = new ArrayList<Map.Entry<String, Integer>>();
        
        //ArrayList <Employee> employees = new ArrayList <Employee>();
        // for (Employee emp : employees)
        for (Map.Entry< String, Integer> entry : entries) {
            if (entry.getValue() >= 2) {
                //System.out.println(entry.getKey()+"\t"+entry.getValue());
                entries2.add(entry);

            }
        }
        FrequencyComparator comp = new FrequencyComparator();
        Collections.sort(entries2,comp);
        
        System.out.println("\nA list of words and its frequency at least 2");
        System.out.println("From the most frequent wod to the least frequent word");
        for (Map.Entry<String, Integer> e : entries2) {
            System.out.println(e.getKey()+"\t"+e.getValue());
        }

    }
}

