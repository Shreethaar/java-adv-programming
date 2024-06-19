import java.util.HashMap;
import java.util.Map;

public class PayRoll {
    private Map<String, Salesman> salesRepInfo;

    public PayRoll() {
        salesRepInfo = new HashMap<>();
    }

    public void insertSalesRep(Salesman salesRep) {
        salesRepInfo.put(salesRep.getSalesRepStaffID(), salesRep);
        System.out.println("Salesman " + salesRep.getSalesRepStaffID() + " inserted successfully.");
    }

    public void deleteSalesRep(String staffNum) {
        Salesman removedSalesman = salesRepInfo.remove(staffNum);
        if (removedSalesman != null) {
            System.out.println("Salesman " + staffNum + " deleted successfully.");
        } else {
            System.out.println("Salesman " + staffNum + " not found.");
        }
    }

    public void updateSalesRep(Salesman salesRep) {
        if (salesRepInfo.containsKey(salesRep.getSalesRepStaffID())) {
            salesRepInfo.put(salesRep.getSalesRepStaffID(), salesRep);
            System.out.println("Salesman " + salesRep.getSalesRepStaffID() + " updated successfully.");
        } else {
            System.out.println("Salesman " + salesRep.getSalesRepStaffID() + " not found, cannot update.");
        }
    }

    public void showAllInfoSalesRep() {
        System.out.println("All Salesmen Information:");
        salesRepInfo.forEach((staffNum, salesman) -> {
            System.out.println(staffNum + ": " + salesman);
        });
    }

    public Salesman searchSalesRep(String staffNum) {
        return salesRepInfo.get(staffNum);
    }

    // Getters and setters can be added as needed

    public Map<String, Salesman> getSalesRepInfo() {
        return salesRepInfo;
    }

    public void setSalesRepInfo(Map<String, Salesman> salesRepInfo) {
        this.salesRepInfo = salesRepInfo;
    }
}
