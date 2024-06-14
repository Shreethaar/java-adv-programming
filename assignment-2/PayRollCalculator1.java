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
