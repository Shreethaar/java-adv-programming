//Reading from a file

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReadingExample {
    public static void main(String[] args) {
        String filename = "example.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line=br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

