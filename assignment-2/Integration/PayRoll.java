import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PayRoll {
    private Map<String, Salesman> salesRepInfo;

    public PayRoll() {
        // Initialize salesRepInfo map
        // Example: salesRepInfo = new HashMap<>();
    }

    public void insertSalesRep(Salesman saleRep) {
        salesRepInfo.put(saleRep.getSalesRepStaffID(), saleRep);
        System.out.println("SalesRep " + saleRep.getSalesRepStaffID() + " inserted successfully.");
    }

    public void deleteSalesRep(Salesman saleRep) {
        salesRepInfo.remove(saleRep.getSalesRepStaffID());
        System.out.println("SalesRep " + saleRep.getSalesRepStaffID() + " deleted successfully.");
    }

    public void updateSalesRep(Salesman saleRep) {
        salesRepInfo.replace(saleRep.getSalesRepStaffID(), saleRep);
        System.out.println("SalesRep " + saleRep.getSalesRepStaffID() + " updated successfully.");
    }

    public List<Salesman> getAllSalesmen() {
        return new ArrayList<>(salesRepInfo.values());
    }

    public Salesman searchSalesRep(String staffNum) {
        return salesRepInfo.get(staffNum);
    }

    // Method to search sales rep by name
    public List<Salesman> searchSalesRepByName(String name) {
        List<Salesman> result = new ArrayList<>();
        for (Salesman salesman : salesRepInfo.values()) {
            if (salesman.getSalesRepFullName().equalsIgnoreCase(name)) {
                result.add(salesman);
            }
        }
        return result;
    }

    public void showAllInfoSalesRep() {
        final int[] i = {1};
        salesRepInfo.forEach((id, saleRep) -> {
            System.out.println(i[0] + ": " + id + ", " + saleRep);
            i[0]++;
        });
    }
}
