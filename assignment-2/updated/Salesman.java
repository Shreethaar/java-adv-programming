public class Salesman {
    private String name;
    private String id;
    private String icNum;
    private String bankAcc;
    private String totalUnitSales;
    private String totalSalesRM;

    public Salesman(String name, String id, String icNum, String bankAcc, String totalUnitSales, String totalSalesRM) {
        this.name = name;
        this.id = id;
        this.icNum = icNum;
        this.bankAcc = bankAcc;
        this.totalUnitSales = totalUnitSales;
        this.totalSalesRM = totalSalesRM;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getIcNum() {
        return icNum;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public String getTotalUnitSales() {
        return totalUnitSales;
    }

    public String getTotalSalesRM() {
        return totalSalesRM;
    }
}

