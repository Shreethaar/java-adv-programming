import java.time.YearMonth;
import java.util.List;

public class SalesmanController {

    private SalesmanModel salesmanModel;
    private SalesmanDatabaseModel salesmanDatabaseModel;
    private SalesmanView salesmanView;

    public SalesmanController(SalesmanModel salesmanModel, SalesmanDatabaseModel salesmanDatabaseModel, SalesmanView salesmanView) {
        this.salesmanModel = salesmanModel;
        this.salesmanDatabaseModel = salesmanDatabaseModel;
        this.salesmanView = salesmanView;
        salesmanView.addSaveButtonListener(e -> saveSalesman());
        salesmanView.addSearchButtonListener(e -> searchSalesman());
        salesmanView.addEditButtonListener(e -> editSalesman());
        salesmanView.addDeleteButtonListener(e -> deleteSalesman());
        salesmanView.addClearButtonListener(e -> clearForm());
    }

    public void saveSalesman() {
        String staffNumber = salesmanView.getStaffNumber();
        String fullName = salesmanView.getFullName();
        String icNumber = salesmanView.getICNumber();
        String bankAccountNumber = salesmanView.getBankAccountNumber();
        int totalSalesUnit = salesmanView.getTotalSalesUnit();
        double totalSalesAmount = salesmanView.getTotalSalesAmount();
        YearMonth salaryMonth = salesmanView.getSalaryMonth();
        int salaryYear = salesmanView.getSalaryYear();
        double grossSalary = salesmanModel.getGrossSalary();
        double incomeTax = salesmanModel.getMonthlyIncomeTax();
        double epf = salesmanModel.getEPF();
        double netSalary = salesmanModel.getNetSalary();

        // Create a SalesmanModel object
        SalesmanModel salesman = new SalesmanModel(staffNum,fullName, icNumber, bankAccountNumber, totalSalesUnit, totalSalesAmount, salaryMonth, salaryYear, "");
salesman.setGrossSalary(grossSalary);
salesman.setMonthlyIncomeTax(incomeTax);
salesman.setEPF(epf);
salesman.setNetSalary(netSalary);

        // Save to database
        SalesmanModel salesman = new SalesmanModel(staffNumber, fullName, icNumber, bankAccountNumber, totalSalesUnit, totalSalesAmount, salaryMonth, salaryYear, grossSalary, incomeTax, epf, netSalary);
        // Add to table
        Object[] rowData = {
            staffNumber,
            fullName,
            icNumber,
            bankAccountNumber,
            totalSalesUnit,
            totalSalesAmount,
            salaryMonth,
            salaryYear,
            grossSalary,
            incomeTax,
            epf,
            netSalary
        };
        salesmanView.addRowToTable(rowData);
        salesmanView.showMessage("Salesman data saved successfully!");
        updateSalesmanTable();
    }

    public void searchSalesman() {
        String staffID = salesmanView.getStaffNumber();
        SalesmanModel salesman = salesmanDatabaseModel.searchSalesman(staffID);

        if (salesman != null) {
            salesmanView.setStaffNumber(salesman.getSalesmanStaffID());
            salesmanView.setFullName(salesman.getSalesmanFullName());
            salesmanView.setICNumber(salesman.getSalesmanICNum());
            salesmanView.setBankAccountNumber(salesman.getSalesmanBankAcc());
            salesmanView.setTotalSalesUnit(salesman.getSalesmanTotalSalesUnit());
            salesmanView.setTotalSalesAmount(salesman.getSalesmanTotalSalesAmount());
            salesmanView.setSalaryMonth(salesman.getSalaryMonth());
            salesmanView.setSalaryYear(salesman.getSalaryYear());
            salesmanView.setGrossSalary(salesman.getGrossSalary());
            salesmanView.setMonthlyIncomeTax(salesman.getMonthlyIncomeTax());
            salesmanView.setEPF(salesman.getEPF());
            salesmanView.setNetSalary(salesman.getNetSalary());

            // Clear the table and add the found salesman data
            salesmanView.clearTable();
            Object[] rowData = {
                salesman.getSalesmanFullName(),
                salesman.getSalesmanStaffID(),
                salesman.getSalesmanICNum(),
                salesman.getSalesmanBankAcc(),
                salesman.getSalesmanTotalSalesUnit(),
                salesman.getSalesmanTotalSalesAmount(),
                salesman.getSalaryMonth(),
                salesman.getSalaryYear(),
                salesman.getGrossSalary(),
                salesman.getMonthlyIncomeTax(),
                salesman.getEPF(),
                salesman.getNetSalary()
            };
            salesmanView.addRowToTable(rowData);
            salesmanView.showMessage("Salesman data found and displayed!");
        } else {
            salesmanView.showMessage("Salesman not found!");
        }
        updateSalesmanTable();
    }

    public void editSalesman() {
        // Get data from the view
        String staffNumber = salesmanView.getStaffNumber();
        String fullName = salesmanView.getFullName();
        String icNumber = salesmanView.getICNumber();
        String bankAccountNumber = salesmanView.getBankAccountNumber();
        int totalSalesUnit = salesmanView.getTotalSalesUnit();
        double totalSalesAmount = salesmanView.getTotalSalesAmount();
        YearMonth salaryMonth = salesmanView.getSalaryMonth();
        int salaryYear = salesmanView.getSalaryYear();
        double grossSalary = salesmanModel.getGrossSalary();
        double incomeTax = salesmanModel.getMonthlyIncomeTax();
        double epf = salesmanModel.getEPF();
        double netSalary = salesmanModel.getNetSalary();



        // Create a SalesmanModel object
        SalesmanModel salesman = new SalesmanModel(staffNumber, fullName, icNumber, bankAccountNumber, totalSalesUnit, totalSalesAmount, salaryMonth, salaryYear, grossSalary, incomeTax, epf, netSalary);

        // Update in database
        salesmanDatabaseModel.editSalesman(salesman);

        // Clear the table and add the updated salesman data
        salesmanView.clearTable();
        Object[] rowData = {
            staffNumber,
            fullName,
            icNumber,
            bankAccountNumber,
            totalSalesUnit,
            totalSalesAmount,
            salaryMonth,
            salaryYear,
            grossSalary,
            incomeTax,
            epf,
            netSalary
        };
        salesmanView.addRowToTable(rowData);
        salesmanView.showMessage("Salesman information updated successfully!");
        updateSalesmanTable();

    }

    public void deleteSalesman() {
        String staffID = salesmanView.getStaffNumber();
        salesmanDatabaseModel.deleteSalesman(staffID);
        clearForm();
        salesmanView.showMessage("Salesman information deleted!");

        // Clear the table
        salesmanView.clearTable();
        updateSalesmanTable();

    }

    public void clearForm() {
        salesmanView.setStaffNumber("");
        salesmanView.setFullName("");
        salesmanView.setICNumber("");
        salesmanView.setBankAccountNumber("");
        salesmanView.setTotalSalesUnit(0);
        salesmanView.setTotalSalesAmount(0.0);
        salesmanView.setSalaryMonth(YearMonth.now()); // Set current month and year
        salesmanView.setSalaryYear(YearMonth.now().getYear());
        salesmanView.setGrossSalary(0.0);
        salesmanView.setMonthlyIncomeTax(0.0);
        salesmanView.setEPF(0.0);
        salesmanView.setNetSalary(0.0);
        salesmanView.showMessage("Form cleared!");
    }
    public void populateModelFromView() {
        salesmanModel.setSalesmanFullName(salesmanView.getFullName());
        salesmanModel.setSalesmanStaffID(salesmanView.getStaffNumber());
        salesmanModel.setSalesmanICNum(salesmanView.getICNumber());
        salesmanModel.setSalesmanBankAcc(salesmanView.getBankAccountNumber());
        salesmanModel.setSalesmanTotalSalesUnit(salesmanView.getTotalSalesUnit());
        salesmanModel.setSalesmanTotalSalesAmount(salesmanView.getTotalSalesAmount());
        salesmanModel.setSalesmanSalaryMonth(salesmanView.getSalaryMonth());
        salesmanModel.setSalesmanSalaryYear(salesmanView.getSalaryYear());
        salesmanModel.calculateAll();
    }

    private void updateSalesmanTable() {
        List<SalesmanModel> salesmen = salesmanDatabaseModel.getAllSalesmen();
        for(SalesmanModel salesman : salesmen) {
            Object[] rowData = {
            salesman.getSalesmanStaffID(),
            salesman.getSalesmanFullName(),
            salesman.getSalesmanICNum(),
            salesman.getSalesmanBankAcc(),
            salesman.getSalesmanTotalSalesUnit(),
            salesman.getSalesmanTotalSalesAmount(),
            salesman.getSalaryMonth().toString(),
            salesman.getSalaryYear().toString(),
            salesman.getGrossSalary(),
            salesman.getMonthlyIncomeTax(),
            salesman.getEPF(),
            salesman.getNetSalary()
        };
            salesmanView.addRowToTable(rowData);
        }
    }
}
