import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

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

  public List<Salesman> sortSalesRepName() {
      List<Salesman> sortList = new ArrayList<>(salesRepInfo.values());
      sortList.sort(new SalesmanComparator());
      return sortList;
  }

  public Salesman searchSalesRepByName(String name) {
        for (Salesman salesman : salesRepInfo.values()) {
            if (salesman.getSalesRepName().equalsIgnoreCase(name)) {
                return salesman;
            }
        }
        return null; // Return null if no salesman with the given name is found
    }

    public String getSalesRepName(String staffID) {
        Salesman salesperson = salesRepInfo.get(staffID);
        if (salesperson != null) {
            return salesperson.getSalesRepName();
        }
        return null; // Return null if salesperson with given staffID is not found
    }

    public List<Salesman> getAllSalesmen() {
        return new ArrayList<>(salesRepInfo.values());
    }
}

