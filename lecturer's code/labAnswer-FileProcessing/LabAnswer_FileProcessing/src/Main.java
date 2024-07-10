
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    //private static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        int choice;
        do {
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    main.addEmployee(scanner);
                    break;
                case 2:
                    main.displayAllEmployees();
                    break;
                case 3:
                    System.out.print("Enter the search employee name = ");
                    String target = scanner.next()+scanner.nextLine();
                    main.searchByEmployeeName(target);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    } //main

    public void addEmployee(Scanner scanner) throws IOException {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.next()+ scanner.nextLine();
        System.out.print("Enter Number of Working Days: ");
        int days = scanner.nextInt();
        System.out.print("Enter Hourly Rate: ");
        double rate = scanner.nextDouble();
        double salary = rate * days;
        Employee employee = new Employee(id, name, days, rate, salary);
        
        saveEmployeeToFile(employee);
    }//addEmployee()

    public void saveEmployeeToFile(Employee employee) throws IOException {
        FileWriter fw = new FileWriter("employee.txt", true);
        PrintWriter br = new PrintWriter(fw);
        
        br.println(employee.getEmployeeId()+","+employee.getEmployeeName()+
                   ","+employee.getWorkingDays()+","+employee.getHourlyRate()+
                   ","+employee.getSalary());
        
        br.close();
        fw.close();
    }//saveEmployeeToFile()

    public void displayAllEmployees() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("employee.txt");
        BufferedReader br = new BufferedReader(fr);
        
        System.out.println("A list of employees");
        String data = br.readLine();
        while(data != null)
        {
            String [] tokens = data.split(","); // split up string to tokens using comma
            int empID = Integer.parseInt(tokens[0]);
            String empName = tokens[1];
            int hoursWorked = Integer.parseInt(tokens[2]);
            double rate = Double.parseDouble(tokens[3]);
            double salary = Double.parseDouble(tokens[4]);
            System.out.println(empID+"\t"+empName+"\t"+hoursWorked+"\t"+
                                rate+"\t"+salary);
            data = br.readLine();
        }
        br.close();
        fr.close();
        System.out.println("");
    }
    
    public void searchByEmployeeName(String target) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader("employee.txt");
        BufferedReader br = new BufferedReader(fr);
        Employee emp;
        String data = br.readLine();
        while(data != null)
        {
            String [] tokens = data.split(","); // split up string to tokens using comma
            int empID = Integer.parseInt(tokens[0]);
            String empName = tokens[1];
            int hoursWorked = Integer.parseInt(tokens[2]);
            double rate = Double.parseDouble(tokens[3]);
            double salary = Double.parseDouble(tokens[4]);
            
            if (target.equals(empName))
            {
                System.out.println("The "+target+" is found");
                System.out.println(empID+"\t"+empName+"\t"+hoursWorked+"\t"+
                                rate+"\t"+salary);
            }
            data = br.readLine();
        }//while
        br.close();
        fr.close();
        
        
    }//searchByEmployeeName()

    
}