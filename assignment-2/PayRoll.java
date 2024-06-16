import java.util.HashMap;import java.util.Map;
public class PayRoll {
    private Map<String,Salesman> salesRepInfo;
    public PayRoll() { salesRepInfo=new HashMap<>(); }

    public void insertSalesRep(Salesman saleRep) {
        salesRepInfo.put(saleRep.getSalesRepStaffID(), saleRep);
        // return success output message (SOP)
    }

    public void deleteSalesRep(Salesman saleRep) {
        salesRepInfo.remove(saleRep.getSalesRepStaffID());
        // return success output message (SOP)
    }

    public void updateSalesRep(Salesman saleRep) {
        salesRepInfo.replace(saleRep.getSalesRepStaffID(), saleRep);
        // return success output message (SOP)
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


   

