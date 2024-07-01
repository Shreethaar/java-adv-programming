import java.time.YearMonth;

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
        // ... (existing code for saving salesman data)
    }

    public void searchSalesman() {
        // ... (existing code for searching salesman data)
    }

    public void editSalesman() {
        // Similar to saveSalesman, but update the database using editSalesman method
        String staffID = salesmanView.getStaffNumber();
        // ... (get other data from view)
        salesmanDatabaseModel.editSalesman(salesmanModel);
        salesmanView.showMessage("Salesman information updated successfully!");
    }

    public void deleteSalesman() {
        String staffID = salesmanView.getStaffNumber();
        salesmanDatabaseModel.deleteSalesman(staffID);
        clearForm();
        salesmanView.showMessage("Salesman information deleted!");
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
}
