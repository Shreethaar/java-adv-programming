//append to a file

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppendExample {
    public static void main(String[] args) {
        String fileName = "example.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write("This line will be appended to the file");
            bw.newLine();
        }
        catch(IOException e) {
            e.printStackTrace();

        }
    }
}

