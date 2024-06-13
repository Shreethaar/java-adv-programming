public class SalaryCalculator {

    public static double calculateCarBodyCommission(double totalCarsSoldAmount) {
        return totalCarsSoldAmount * 0.01;
    }

    public static double calculateIncentiveCommission(int numberOfCarsSold) {
        if (numberOfCarsSold >= 15) {
            return 600;
        } else if (numberOfCarsSold >= 10) {
            return 400;
        } else if (numberOfCarsSold >= 5) {
            return 200;
        } else {
            return 0;
        }
    }

    public static double calculateGrossSalary(double baseSalary, double carBodyCommission, double incentiveCommission) {
        return baseSalary + carBodyCommission + incentiveCommission;
    }

    public static double calculateEPF(double grossSalary) {
        return grossSalary * 0.11;
    }

    public static double calculateIncomeTax(double grossSalary) {
        // Replace with your actual income tax calculation logic based on Malaysia's tax brackets
        return grossSalary * 0.05; // Placeholder for income tax calculation
    }

    public static double calculateNetSalary(double grossSalary, double epf, double incomeTax) {
        return grossSalary - epf - incomeTax;
    }
}

// change all of it
