import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class CustomerForm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cont = "no";
        do {
            Customer cust = new Customer();
            System.out.println("UUM Sport Center\n"+"Badminton Court Booking System");
            System.out.println("Enter customer name:");
            String name = sc.nextLine();
            cust.setName(name);
            System.out.println("Enter customer status (public/staff):");
            String status=sc.nextLine();
            cust.setStatus(status);
            System.out.println("Enter number of hours:");
            int hours=sc.nextInt();
            cust.setHours(hours);
            double charge= calculateCharge(status,hours);
            cust.setCharge(charge);
            System.out.println("Do you want to continue (Yes/No):");
            cont=sc.nextLine();

        }

        while(cont.equalsIgnoreCase("yes"));
    }

    public static douuble calculateCharge(String status, int hours) {
        if(status.equalsIgnoreCase("public")) {
            return 4*hours;
        }
        else {
            return 2*hours;
        }
    }

    public void saveDataIntoTextFile(Customer cust) throws IOException {
        String filename = "customer.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));
        bw.write(cust.getName());
        bw.write(cust.getStatus());
        bw.write(cust.getHours());
        double charge=cust.getCharge();
        bw.write(charge);

    }

    public void displayAllCustomers() throws IOException, FileNotFoundException {
        String filename = "customer.txt";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while((line=br.readLine())!=null) {
            System.out.println(line);
        }

    }

}






