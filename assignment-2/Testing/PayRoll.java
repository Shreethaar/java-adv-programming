import java.util.HashMap;

public class PayRoll {
    private HashMap<String, Salesman> salesRepInfo;

    public PayRoll() {
        salesRepInfo = new HashMap<>();
    }

    public void insertSalesRep(Salesman saleRep) {
        salesRepInfo.put(saleRep.getSalesRepStaffID(), saleRep);
        System.out.println("SalesRep " + saleRep.getSalesRepStaffID() + " inserted successfully.");
    }

    
    public void deleteSalesRep(Salesman saleRep) {
        salesRepInfo.remove(saleRep.getSalesRepStaffID());
        System.out.println("SalesRep " + saleRep.getSalesRepStaffID() + " deleted successfully.");
    }

}

