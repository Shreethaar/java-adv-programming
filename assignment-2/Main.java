import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayRoll payRollSys = new PayRoll();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("PayRoll System Menu:");
            System.out.println("1. Add Salesman");
            System.out.println("2. Search Salesman");
            System.out.println("3. Reset System");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch(choice) {
                case 1: 
                    System.out.println("Full Name: ");
                    String fullName=sc.nextLine();
                    System.out.println("Staff Number: ");
                    String staffNum=sc.nextLine();
                    System.out.println("Monthly Salary: ");
                    double monthlySalary=sc.nextDouble();
                    System.out.println("Annual Salary: ");
                    double annualSalary=sc.nextDouble();
                    System.out.println("Staff IC Number: ");
                    String staffICNum=sc.nextLine();
                    System.out.println("Bank Account Number: ");
                    String staffBankAccNo=sc.nextLine();
                    System.out.println("Total Sales Amount: ");
                    double totalSalesAmount=sc.nextDouble();
                    System.out.println("Number of Cars Sold:");
                    int numberOfCarsSold=sc.nextInt();

                    Salesman salesman = new Salesman(fullName,staffNum,staffICNum,staffBankAccNo,numberOfCarsSold,totalSalesAmount,monthlySalary,annualSalary);
                    payRollSys.insertSalesRep(salesman);
                    break;
                
                case 2:
                    System.out.println("Enter Staff Number to search: ");
                    String searchStaffNum=sc.nextLine();
                    Salesman searchedStaff=payRollSys.searchSalesRep(searchStaffNum);
                    if(searchedStaff!=null) {
                        System.out.println("Salesman found:");
                        System.out.println(searchedStaff);
                    }
                    else {
                        System.out.println("Salesman not found.");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


