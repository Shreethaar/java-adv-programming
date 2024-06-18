import java.util.function.Function;

public class PayRollCalculator1 {
    double baseSalary = 1500;

    Function<Double, Double> calcCarBodyCommission = totalCarsSoldAmount -> totalCarsSoldAmount * 0.01;

    Function<Integer, Double> calcIncentiveCommission = numOfCarsSold -> {
        if (numOfCarsSold >= 15) {
            return 600.0;
        } else if (numOfCarsSold >= 10) {
            return 400.0;
        } else if (numOfCarsSold >= 5) {
            return 200.0;
        } else {
            return 0.0;
        }
    };

    Function<Double, Double> calcIncomeTax = income -> {
        if (income <= 416.67) {
            return income * 0.0;
        } else if (income <= 1666.67) {
            return income * 0.01;
        } else if (income <= 2916.67) {
            return income * 0.03;
        } else if (income <= 4166.67) {
            return income * 0.08;
        } else if (income <= 5833.33) {
            return income * 0.13;
        } else if (income <= 8333.33) {
            return income * 0.21;
        } else if (income <= 20833.33) {
            return income * 0.24;
        } else if (income <= 33333.33) {
            return income * 0.245;
        } else if (income <= 50000.00) {
            return income * 0.25;
        } else if (income <= 83333.33) {
            return income * 0.26;
        } else if (income <= 166666.67) {
            return income * 0.28;
        } else {
            return income * 0.30;
        }
    };
   interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }

    TriFunction<Double, Integer, Double, Double> calculateTotalSalary = (totalCarsSoldAmount, numOfCarsSold, baseSalary) -> {
        double commission = calcCarBodyCommission.apply(totalCarsSoldAmount);
        double incentive = calcIncentiveCommission.apply(numOfCarsSold);
        double grossSalary = baseSalary + commission + incentive;
        double incomeTax = calcIncomeTax.apply(grossSalary);
        double providentFund = grossSalary * 0.11; // 11% of gross salary
        double netSalary = grossSalary - incomeTax - providentFund;
        return netSalary;
    };

    public static void main(String[] args) {
        PayRollCalculator1 calculator = new PayRollCalculator1();

        // Example usage:
        double totalCarsSoldAmount = 25000.0; // Example value
        int numOfCarsSold = 12; // Example value

        double netSalary = calculator.calculateTotalSalary.apply(totalCarsSoldAmount, numOfCarsSold, calculator.baseSalary);

        System.out.println("Net Salary: $" + netSalary);
    }
}
