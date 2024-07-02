import java.util.function.Supplier;

public class SalesmanModel {
    private String salesmanFullName;
    private String salesmanStaffID;
    private String salesmanICNum;
    private String salesmanBankAcc;
    private double salesmanTotalSalesAmount;
    private int salesmanTotalSalesUnit;
    private static final double SALESMAN_BASIC_SALARY=1500;
    private static final double SALESMAN_EPF_RATE=0.11;
    private double salesmanGrossSalary;
    private double salesmanEPF;
    private double salesmanIncomeTax;
    private double salesmanNetSalary;


    public SalesmanModel(String salesmanFullName, String salesmanStaffID, String salesmanBankAcc,String salesmanICNum ,double salesmanTotalSalesAmount, int salesmanTotalSalesUnit) {
        this.salesmanFullName=salesmanFullName;
        this.salesmanStaffID=salesmanStaffID;
        this.salesmanICNum=salesmanICNum;
        this.salesmanBankAcc=salesmanBankAcc;
        this.salesmanTotalSalesAmount=salesmanTotalSalesAmount;
        this.salesmanTotalSalesUnit=salesmanTotalSalesUnit;
    }
    public double calculateCarBodyCommission() {
        return 0.01*salesmanTotalSalesAmount;
    }

    public double calculateIncentiveCommission() {
        if (salesmanTotalSalesUnit>=15) {
            return 600*salesmanTotalSalesUnit;
        }
        else if (salesmanTotalSalesUnit>=10) {
            return 400*salesmanTotalSalesUnit;
        }
        else if (salesmanTotalSalesUnit>=5) {
            return 200*salesmanTotalSalesUnit;
        }
        else {
            return 0;
        }
    }
    public void calculateGrossSalary() {
        salesmanGrossSalary=SALESMAN_BASIC_SALARY+calculateCarBodyCommission()+calculateIncentiveCommission();
    }

    public void calculateEPF() {
        salesmanEPF=salesmanGrossSalary*SALESMAN_EPF_RATE;
    }

    public void calculateIncomeTax() {
        if (salesmanGrossSalary <= 416.67) {
            salesmanIncomeTax=salesmanGrossSalary * 0.0;
        }
        else if (salesmanGrossSalary <= 1666.67) {
            salesmanIncomeTax=salesmanGrossSalary * 0.01;
        }
        else if (salesmanGrossSalary <= 2916.67) {
            salesmanIncomeTax=salesmanGrossSalary * 0.03;
        }
        else if (salesmanGrossSalary <= 4166.67) {
            salesmanIncomeTax=salesmanGrossSalary * 0.08;
        } 
        else if (salesmanGrossSalary <= 5833.33) {
            salesmanIncomeTax=salesmanGrossSalary * 0.13;
        } 
        else if (salesmanGrossSalary <= 8333.33) {
            salesmanIncomeTax=salesmanGrossSalary * 0.21;
        } 
        else if (salesmanGrossSalary <= 20833.33) {
            salesmanIncomeTax=salesmanGrossSalary * 0.24;
        } 
        else if (salesmanGrossSalary <= 33333.33) {
            salesmanIncomeTax=salesmanGrossSalary * 0.245;
        } 
        else if (salesmanGrossSalary <= 50000.00) {
            salesmanIncomeTax=salesmanGrossSalary * 0.25;
        } 
        else if (salesmanGrossSalary <= 83333.33) {
            salesmanIncomeTax=salesmanGrossSalary * 0.26;
        } 
        else if (salesmanGrossSalary <= 166666.67) {
            salesmanIncomeTax=salesmanGrossSalary * 0.28;
        } 
        else {
            salesmanIncomeTax=salesmanGrossSalary * 0.30;
        }
    }

    public void calculateNetSalary() {
        salesmanNetSalary=salesmanGrossSalary-salesmanEPF-salesmanIncomeTax;
    }

    public String getSalesmanFullName() { return salesmanFullName; }
    public String getSalesmanStaffID() { return salesmanStaffID; }
    public String getSalesmanICNum() { return salesmanICNum; }
    public String getSalesmanBankAcc() { return salesmanBankAcc; }
    public int getSalesmanTotalSalesUnit() { return salesmanTotalSalesUnit; }
    public double getSalesmanTotalSalesAmount() { return salesmanTotalSalesAmount; }
    public double getSalesmanGrossSalary() { return salesmanGrossSalary; }
    public double getSalesmanEPF() { return salesmanEPF; }
    public double getSalesmanIncomeTax() { return salesmanIncomeTax; }
    public double getSalesmanNetSalary() { return salesmanNetSalary; }

}




