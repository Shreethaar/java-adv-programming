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

    Function<Double, Double> calcIncomeTax = income -> {
        if (income <= 416.67) {
            return income * 0.0;
        } else if (income <= 1,666.67) {
            return income * 0.01;
        } else if (income <= 2,916.67) {
            return income * 0.03;
        } else if (income <= 4,166.67) {
            return income * 0.08;
        } else if (income <= 5,833.33) {
            return income * 0.13;
        } else if (income <= 8,333.33) {
            return income * 0.21;
        } else if (income <= 20,833.33) {
            return income * 0.24;
        } else if (income <= 33,333.33) {
            return income * 0.245;
        } else if (income <= 50,000.00) {
            return income * 0.25;
        } else if (income <= 83,333.33) {
            return income * 0.26;
        } else if (income <= 166,666.67) {
            return income * 0.28;
        } else {
            return income * 0.30;
        }
    };
}
