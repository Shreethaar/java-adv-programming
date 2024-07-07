//write a java program to check if a file or directory has read and write permissions
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File my_file_dir=new File("/");
        if(my_file_dir.canWrite()) {
            System.out.println(my_file_dir.getAbsolutePath() + " can write.\n");
        }
        else {
            System.out.println(my_file_dir.getAbsolutePath()+" can't write.\n");
        }
        if(my_file_dir.canRead()) {
            System.out.println(my_file_dir.getAbsolutePath()+ " can read.\n");
        }
        else {
            System.out.println(my_file_dir.getAbsolutePath()+ " can't read.\n");
        }
    }

}
