public class Salesman {
    private String salesRepFullName;
    private String salesRepStaffID;
    private String salesRepICNum;
    private String salesRepBankAcc;
    private int salesRepTotalSalesUnit;         //total amount of cars sold (units)
    private double salesRepTotalSalesAmount;    //total price of cars sold (sales)
    private double salesRepMonthlySalary;
    private double salesRepAnnualSalary;
    public Salesman(String salesRepFullName, String salesRepStaffID, String salesRepICNum, String salesRepBankAcc, int salesRepTotalSalesUnit, double salesRepTotalSalesAmount, double salesRepMonthlySalary, double salesRepAnnualSalary) {this.setSalesRepFullName(salesRepFullName);this.setSalesRepStaffID(salesRepStaffID);this.setSalesRepICNum(salesRepICNum);this.setSalesRepBankAcc(salesRepBankAcc);this.setSalesRepTotalSalesUnit(salesRepTotalSalesUnit);this.setSalesRepTotalSalesAmount(salesRepTotalSalesAmount);this.setSalesRepMonthlySalary(salesRepMonthlySalary);this.setSalesRepAnnualSalary(salesRepAnnualSalary);
    }
    public String getSalesRepFullName() {return salesRepFullName;}
    public String getSalesRepStaffID() {return salesRepStaffID;}
    public String getSalesRepICNum() {return salesRepICNum;}
    public String getSalesRepBankAcc() {return salesRepBankAcc;}
    public int getSalesRepTotalSalesUnit() {return salesRepTotalSalesUnit;}
    public double getSalesRepTotalSalesAmount() {return salesRepTotalSalesAmount;}
    public double getSalesRepMonthlySalary() {return salesRepMonthlySalary;}
    public double getSalesRepAnnualSalary() {return salesRepAnnualSalary;}
    public void setSalesRepFullName(String salesRepFullName) {this.salesRepFullName=salesRepFullName;}
    public void setSalesRepStaffID(String salesRepStaffID) {this.salesRepStaffID=salesRepStaffID;}
    public void setSalesRepICNum(String salesRepICNum) {this.salesRepICNum=salesRepICNum;}
    public void setSalesRepBankAcc(String salesRepBankAcc) {this.salesRepBankAcc=salesRepBankAcc;}
    public void setSalesRepTotalSalesUnit(int salesRepTotalSalesUnit) {this.salesRepTotalSalesUnit=salesRepTotalSalesUnit;}
    public void setSalesRepTotalSalesAmount(double salesRepTotalSalesAmount) {this.salesRepTotalSalesAmount=salesRepTotalSalesAmount;}
    public void setSalesRepMonthlySalary(double salesRepMonthlySalary) { this.salesRepMonthlySalary=salesRepMonthlySalary;}
    public void setSalesRepAnnualSalary(double salesRepAnnualSalary) {this.salesRepAnnualSalary=salesRepAnnualSalary;}
    public String toString() {
        return "Salesman{" +
                "fullName='" + salesRepFullName+ '\'' +
                ", staffNumber='" + salesRepStaffID + '\'' +
                ", month='" + salesRepMonthlySalary + '\'' +
                ", year=" + salesRepAnnualSalary +
                ", icNumber='" + salesRepICNum + '\'' +
                ", bankAccountNumber='" + salesRepBankAcc + '\'' +
                ", totalSalesAmount=" + salesRepTotalSalesAmount +
                ", numberOfCarsSold=" + salesRepTotalSalesUnit +
                '}';
    }
}


