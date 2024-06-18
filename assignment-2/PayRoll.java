import java.util.HashMap;import java.util.Map;
public class PayRoll {
    private Map<String,Salesman> salesRepInfo;
    private PayRollCalculator1 payRollCalculator;
    private SalesPersonDB salesDB;                      // complete db functions
    public PayRoll() { salesRepInfo=new HashMap<>();  }

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

    public void showAllInfoSalesRep() {
        final int[] i = {1};
        salesRepInfo.forEach((id, saleRep) -> {
            System.out.println(i[0] + ": " + id + ", " + saleRep);
            i[0]++;
        });
    }

    public Salesman searchSalesRep(String staffNum) {
        return salesRepInfo.get(staffNum);
    }
}
