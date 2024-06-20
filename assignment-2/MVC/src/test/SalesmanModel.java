import java.time.Year;
import java.time.YearMonth;
import java.util.function.Function;

public class SalesmanModel {
    private String salesmanFullName;
    private String salesmanStaffID;
    private String salesmanICNum;
    private String salesmanBankAcc;
    private int salesmanTotalSalesUnit;
    private double salesmanTotalSalesAmount;
    private YearMonth salaryMonth;
    private Year salaryYear;
    private String salesmanBankInfo;
    private double salesmanBaseSalary = 1500;
    private double carBodyCommission;
    private double incentiveCommission;
    private double monthlyIncomeTax;
    private double epf;
    private double grossSalary;
    private double netSalary;

    public SalesmanModel(String salesmanFullName, String salesmanStaffID, String salesmanICNum, String salesmanBankAcc, int salesmanTotalSalesUnit, double salesmanTotalSalesAmount, YearMonth salaryMonth, Year salaryYear, String salesmanBankInfo) {
        this.salesmanFullName = salesmanFullName;
        this.salesmanStaffID = salesmanStaffID;
        this.salesmanICNum = salesmanICNum;
        this.salesmanBankAcc = salesmanBankAcc;
        this.salesmanTotalSalesUnit = salesmanTotalSalesUnit;
        this.salesmanTotalSalesAmount = salesmanTotalSalesAmount;
        this.salaryMonth = salaryMonth;
        this.salaryYear = salaryYear;
        this.salesmanBankInfo = salesmanBankInfo;
        calculateAll();
    }

    public String getSalesmanFullName() { return salesmanFullName; }
    public String getSalesmanStaffID() { return salesmanStaffID; }
    public String getSalesmanICNum() { return salesmanICNum; }
    public String getSalesmanBankAcc() { return salesmanBankAcc; }
    public int getSalesmanTotalSalesUnit() { return salesmanTotalSalesUnit; }
    public double getSalesmanTotalSalesAmount() { return salesmanTotalSalesAmount; }
    public YearMonth getSalaryMonth() { return salaryMonth; }
    public Year getSalaryYear() { return salaryYear; }
    public String getSalesmanBankInfo() { return salesmanBankInfo; }
    public double getGrossSalary() { return grossSalary; }
    public double getMonthlyIncomeTax() { return monthlyIncomeTax; }
    public double getEPF() { return epf; }
    public double getNetSalary() { return netSalary; }
    
    
    public void setSalesmanFullName(String salesmanFullName) {
        this.salesmanFullName = salesmanFullName;
    }

    public void setSalesmanStaffID(String salesmanStaffID) {
        this.salesmanStaffID = salesmanStaffID;
    }

    public void setSalesmanICNum(String salesmanICNum) {
        this.salesmanICNum = salesmanICNum;
    }

    public void setSalesmanBankAcc(String salesmanBankAcc) {
        this.salesmanBankAcc = salesmanBankAcc;
    }

    public void setSalesmanTotalSalesUnit(int salesmanTotalSalesUnit) {
        this.salesmanTotalSalesUnit = salesmanTotalSalesUnit;
    }

    public void setSalesmanTotalSalesAmount(double salesmanTotalSalesAmount) {
        this.salesmanTotalSalesAmount = salesmanTotalSalesAmount;
    }

    public void setSalaryMonth(YearMonth salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public void setSalaryYear(Year salaryYear) {
        this.salaryYear = salaryYear;
    }

    public void setSalesmanBankInfo(String salesmanBankInfo) {
        this.salesmanBankInfo = salesmanBankInfo;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setMonthlyIncomeTax(double monthlyIncomeTax) {
        this.monthlyIncomeTax = monthlyIncomeTax;
    }

    public void setEPF(double epf) {
        this.epf = epf;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }


    public void calculateAll() {
        carBodyCommission = calcCarBodyCommission.apply(salesmanTotalSalesAmount);
        incentiveCommission = calcIncentiveCommission.apply(salesmanTotalSalesUnit);
        grossSalary = salesmanBaseSalary + carBodyCommission + incentiveCommission;
        monthlyIncomeTax = calcIncomeTax.apply(grossSalary);
        epf = grossSalary * 0.11;
        netSalary = grossSalary - monthlyIncomeTax - epf;
    }

    Function<Double, Double> calcCarBodyCommission = salesAmount -> salesAmount * 0.01;

    Function<Integer, Double> calcIncentiveCommission = totalSalesUnit -> {
        if (totalSalesUnit >= 15) {
            return 600.0;
        } else if (totalSalesUnit >= 10) {
            return 400.0;
        } else if (totalSalesUnit >= 5) {
            return 200.0;
        } else {
            return 0.0;
        }
    };

    Function<Double, Double> calcIncomeTax = grossSalary -> {
        if (grossSalary <= 416.67) {
            return grossSalary * 0.0;
        } else if (grossSalary <= 1666.67) {
            return grossSalary * 0.01;
        } else if (grossSalary <= 2916.67) {
            return grossSalary * 0.03;
        } else if (grossSalary <= 4166.67) {
            return grossSalary * 0.08;
        } else if (grossSalary <= 5833.33) {
            return grossSalary * 0.13;
        } else if (grossSalary <= 8333.33) {
            return grossSalary * 0.21;
        } else if (grossSalary <= 20833.33) {
            return grossSalary * 0.24;
        } else if (grossSalary <= 33333.33) {
            return grossSalary * 0.245;
        } else if (grossSalary <= 50000.00) {
            return grossSalary * 0.25;
        } else if (grossSalary <= 83333.33) {
            return grossSalary * 0.26;
        } else if (grossSalary <= 166666.67) {
            return grossSalary * 0.28;
        } else {
            return grossSalary * 0.30;
        }
    };

    @Override
    public String toString() {
        return "Salesman{" +
                "fullName='" + salesmanFullName + '\'' +
                ", staffNumber='" + salesmanStaffID + '\'' +
                ", icNumber='" + salesmanICNum + '\'' +
                ", bankAccountNumber='" + salesmanBankAcc + '\'' +
                ", totalSalesAmount=" + salesmanTotalSalesAmount +
                ", numberOfCarsSold=" + salesmanTotalSalesUnit +
                ", salaryMonth=" + salaryMonth +
                ", salaryYear=" + salaryYear +
                '}';
    }
}
