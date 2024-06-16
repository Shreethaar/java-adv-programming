import java.util.HashMap;import java.util.Map;
public class PayRoll {
    private Map<String,Salesman> salesRepInfo;
    private PayRollCalculator1 payRollCalculator;
    public PayRoll() { salesRepInfo=new HashMap<>();  }

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
import java.util.function.Function;
import java.util.function.BiFunction;

public class PayRollCalculator1 {
    private double baseSalary = 1500;

    Function<Double,Double> calcCarBodyCommission=totalCarsSoldAmount -> totalCarsSoldAmount * 0.01;
    Function<Integer,Double> calcIncentiveCommission=numOfCarsSold -> {
        if(numOfCarsSold>=15) {
            return 600.0;
        }
        else if(numOfCarsSold>=10) {
            return 400.0;
        }
        else if(numOfCarsSold>=5) {
            return 200.0;
        }
        else {
            return 0.0;
        }
    };

    interface TriFunction<A,B,C,R> {
        R apply(A a, B b, C c);
    }

    TriFunction<Double,Integer,Double,Double> calculateTotalSalary=(totalCarsSoldAmount,numOfCarsSold, baseSalary) -> {
        double commission=calcCarBodyCommission.apply(totalCarsSoldAmount);
        double incentive=calcIncentiveCommission.apply(numOfCarsSold);
        return baseSalary+commission+incentive;
    };
}


   

