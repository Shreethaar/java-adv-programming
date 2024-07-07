//Write a Java program to get a list of all file/directory names in the given directory

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a directory path:");
        String dir = sc.nextLine();
        File file = new File(dir);
        String[] fileList = file.list();
        for(String name:fileList) {
            System.out.println(name);
        }
    }
}

