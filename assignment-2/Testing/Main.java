public class Main {

    public static void main(String[] args) {
        // Create a PayRoll object to manage salesperson information
        PayRoll payroll = new PayRoll();

        // Create a Salesman object with sample details
        String name = "John Doe";
        String staffID = "S1234";
        String icNum = "123456-78-9012";
        String bankAcc = "1234567890";
        int totalSalesUnit = 10; // Units sold
        double totalSalesAmount = 100000.00; // Total sales amount
        double monthlySalary = 5000.00;
        double annualSalary = monthlySalary * 12; // Assuming annual salary is 12x monthly salary

        Salesman newSalesperson = new Salesman(name, staffID, icNum, bankAcc, totalSalesUnit, totalSalesAmount, monthlySalary, annualSalary);

        // Insert the salesperson details into the PayRoll
        payroll.insertSalesRep(newSalesperson);
        System.out.println(newSalesperson);

        

    }
}

