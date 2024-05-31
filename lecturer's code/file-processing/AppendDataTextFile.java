
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AppendDataTextFile 
{
    public static void main(String[] args) throws IOException 
    {
        String textToAppend = "Happy Learning 2";
     
        File fileName = new File("tambahFail.txt");
        FileWriter fileWriter = new FileWriter(fileName, true); //Set true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(textToAppend);  //New line
        printWriter.close();

   
    }
    
}
