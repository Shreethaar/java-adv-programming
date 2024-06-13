public class Salesman {
    private String salesRepFullName;
    private String salesRepStaffID;
    private String salesRepICNum;
    private String salesRepBankAcc;
    private int salesRepTotalSalesUnit;         //total amount of cars sold (units)
    private double salesRepTotalSalesAmount;    //total price of cars sold (sales)
    private double salesRepMonthlySales;
    private double salesRepAnnualSales;

    public Salesman(String salesRepFullName, String salesRepStaffID, String salesRepICNum, String salesRepBankAcc, int salesRepTotalSalesUnit, double salesRepTotalSalesAmount, double salesRepMonthlySales, double salesRepAnnualSales) {
        this.setSalesRepFullName(salesRepFullName);
        this.setSalesRepStaffID(salesRepStaffID);
        this.setSalesRepICNum(salesRepICNum);
        this.setSalesRepBankAcc(salesRepBankAcc);
        this.setSalesRepTotalSalesUnit(salesRepTotalSalesUnit);
        this.setSalesRepTotalSalesAmount(salesRepTotalSalesAmount);
        this.setSalesRepMonthlySales(salesRepMonthlySales);
        this.setSalesRepAnnualSales(salesRepAnnualSales);
    }

    private String getSalesRepFullName() {
        return salesRepFullName;
    }

    private String getSalesRepStaffID() {
        return salesRepStaffID;
    }
    
    private String getSalesRepICNum() {
        return salesRepICNum;
    }

    private String getSalesRepBankAcc() {
        return salesRepBankAcc;
    }
    
    private int getSalesRepTotalSalesUnit() {
        return salesRepTotalSalesUnit;
    }

    private double getSalesRepTotalSalesAmount() {
        return salesRepTotalSalesAmount;
    }

    private double getSalesRepMonthlySales() { 
        return salesRepMonthlySales;
    }

    private double getSalesRepAnnualSales() {
        return salesRepAnnualSales;
    }

    private void setSalesRepFullName(String salesRepFullName) {
        this.salesRepFullName=salesRepFullName;
    }

    private void setSalesRepStaffID(String salesRepStaffID) {
        this.salesRepStaffID=salesRepStaffID;
    }
    
    private void setSalesRepICNum(String salesRepICNum) {
        this.salesRepICNum=salesRepICNum;
    }

    private void setSalesRepBankAcc(String salesRepBankAcc) {
        this.salesRepBankAcc=salesRepBankAcc;
    }
    
    private void setSalesRepTotalSalesUnit(int salesRepTotalSalesUnit) {
        this.salesRepTotalSalesUnit=salesRepTotalSalesUnit;
    }

    private void setSalesRepTotalSalesAmount(double salesRepTotalSalesAmount) {
        this.salesRepTotalSalesAmount=salesRepTotalSalesAmount;
    }

    private void setSalesRepMonthlySales(double salesRepMonthlySales) { 
        this.salesRepMonthlySales=salesRepMonthlySales;
    }

    private void setSalesRepAnnualSales(double salesRepAnnualSales) {
        this.salesRepAnnualSales=salesRepAnnualSales;
    }
}
