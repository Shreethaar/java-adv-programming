import java.util.HashMap;
import java.util.Map;

public class PayRoll {
    private Map<String, Salesman> salesRepInfo;
    private SalesPersonDB salespersonDB;
    private PayRollCalculator1 calculator;

    public PayRoll(SalesPersonDB salespersonDB, PayRollCalculator1 calculator) {
        this.salesRepInfo = new HashMap<>();
        this.salespersonDB = salespersonDB;
        this.calculator = calculator;
    }
    
    public void insertSalesRep(Salesman salesRep) {
        salespersonDB.addSalesman(salesRep);
        salesRepInfo.put(salesRep.getSalesRepStaffID(), salesRep);
        System.out.println("Salesman " + salesRep.getSalesRepStaffID() + " inserted successfully.");
    }

    public void printSalesRepDetails() {
        for (Salesman salesperson : salesRepInfo.values()) {
            System.out.println(salesperson);
        }
    }

    public void calculateSalary(String staffID) {
        Salesman salesperson = salespersonDB.searchSalesman(staffID);
        if (salesperson != null) {
            double netSalary = calculator.calculateTotalSalary.apply(
            salesperson.getSalesRepTotalSalesAmount(),
            salesperson.getSalesRepTotalSalesUnit(),
            calculator.baseSalary);
      System.out.println("Staff Number: " + staffID);
      System.out.println("Net Salary: $" + netSalary);
    } 
    else {
      System.out.println("Salesperson with staff ID " + staffID + " not found.");
    }
  }
    
}

