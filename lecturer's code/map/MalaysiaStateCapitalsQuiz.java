import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MalaysiaStateCapitalsQuiz {
    public static void main(String[] args) {
        // Create a map to store the states and their capitals
        Map<String, String> stateCapitals = new HashMap<>();
        stateCapitals.put("Johor", "Johor Bahru");
        stateCapitals.put("Selangor", "Shah Alam");
        stateCapitals.put("Penang", "George Town");
        stateCapitals.put("Perak", "Ipoh");
        stateCapitals.put("Kedah", "Alor Setar");
        // Add more states and capitals as needed

        // Get a random state from the map
        Object[] states = stateCapitals.keySet().toArray();
        Random random = new Random();
        String randomState = (String) states[random.nextInt(states.length)];

        // Prompt the user to enter the capital for the random state
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the capital of " + randomState + "?");
        String userAnswer = scanner.nextLine();

        // Check if the user's answer is correct
        if (userAnswer.equalsIgnoreCase(stateCapitals.get(randomState))) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct capital is: " + stateCapitals.get(randomState));
        }
    }
}