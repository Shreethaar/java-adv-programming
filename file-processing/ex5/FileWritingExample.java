//Writing to a file

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Hello, World!");
            bw.newLine();
            bw.write("This is another line");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
