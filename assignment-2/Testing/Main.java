import java.util.Scanner;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    LoginGUI loginGUI = new LoginGUI();
    LoginController loginController = new LoginController(loginGUI);
    loginGUI.setVisible(true);
    Scanner scanner = new Scanner(System.in);

    // Create instances of SalesPersonDB and PayRollCalculator1 (configure database connection details)
    SalesPersonDB salespersonDB = new SalesPersonDB();
    PayRollCalculator1 calculator = new PayRollCalculator1();

    // Create PayRoll object with dependencies
    PayRoll payroll = new PayRoll(salespersonDB, calculator);

    int choice;

    do {
      System.out.println("\nPayroll System Menu");
      System.out.println("1. Add Salesperson");
      System.out.println("2. Calculate Salary");
      System.out.println("3. View Salesperson Details"); // Optional functionality (refer to SalesPersonDB)
      System.out.println("4. Sort Salesperson By Name");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");

      choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      switch (choice) {
        case 1:
          // Add salesperson details
          String name = getStringValue(scanner, "Enter salesperson name: ");
          String staffID = getStringValue(scanner, "Enter staff number: ");
          String icNum = getStringValue(scanner, "Enter IC number: ");
          String bankAcc = getStringValue(scanner, "Enter bank account number: ");
          int totalSalesUnit = getIntValue(scanner, "Enter total number of cars sold: ");
          double totalSalesAmount = getDoubleValue(scanner, "Enter total sales amount: ");
          double monthlySalary = getDoubleValue(scanner, "Enter monthly salary: ");
          double annualSalary = monthlySalary * 12; // Assuming annual salary is 12x monthly salary
          Salesman newSalesperson = new Salesman(name, staffID, icNum, bankAcc, totalSalesUnit, totalSalesAmount, monthlySalary, annualSalary);
          payroll.insertSalesRep(newSalesperson);
          break;
        case 2:
          // Calculate salary
          String staffIDToCalculate = getStringValue(scanner, "Enter staff number to calculate salary: ");
          payroll.calculateSalary(staffIDToCalculate);
          break;
        case 3:
          // View salesperson details (optional)
          String staffIDToView = getStringValue(scanner, "Enter staff number to view details: ");
          salespersonDB.viewSalesman(staffIDToView); // Modify for PayRoll method if implemented
          break;
        case 4:
          // Sort salespeople by name
          System.out.println("\nSalespeople sorted by name (alphabetical order):");
          List<Salesman> sortedSalesmen = payroll.sortSalesRepName(); // Reusing the method for sorting
          for (Salesman salesman : sortedSalesmen) {
            System.out.println(salesman); // Leverage the toString() method in Salesman
          }
          break;
        case 5:
          System.out.println("Exiting Payroll System.");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    } while (choice != 4);

    scanner.close();
  }

  // Helper methods to get user input with validation
  public static String getStringValue(Scanner scanner, String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public static int getIntValue(Scanner scanner, String prompt) {
    int value;
    do {
      System.out.print(prompt);
      while (!scanner.hasNextInt()) {
        System.out.println("Invalid input. Please enter an integer value.");
        scanner.nextLine(); // Consume invalid input
      }
      value = scanner.nextInt();
      scanner.nextLine(); // Consume newline character
    } while (value <= 0);
    return value;
  }

  public static double getDoubleValue(Scanner scanner, String prompt) {
    double value;
    do {
      System.out.print(prompt);
      while (!scanner.hasNextDouble()) {
        System.out.println("Invalid input. Please enter a double value.");
        scanner.nextLine(); // Consume invalid input
      }
      value = scanner.nextDouble();
      scanner.nextLine(); // Consume newline character
    } while (value <= 0);
    return value;
  }
}
