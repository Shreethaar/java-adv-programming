//write a java program to get specific files with extensins from a specified folder


import java.io.File;
import java.io.FilenameFilter;

public class Main {
    public static void main(String[] args) {
        File file = new File("/home/trevorphilips/Desktop/Coding/python");
        String[] list = file.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".py")) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
        for(String f:list) {
            System.out.println(f);
        }
    }
}

