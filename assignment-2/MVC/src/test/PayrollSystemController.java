import java.time.Year;
import java.time.YearMonth;

public class PayrollSystemController {
    private SalesmanDatabaseModel model;
    private PayRollSystemGUI view;

    public PayrollSystemController(PayrollSystemGUI view, SalesmanDatabaseModel dbModel) {
        this.view=view;
        this.dbModel=dbModel;
        initView();

    }

    private void initView() {
        view.getAddButton().addActionListener(e -> addSalesman());
        view.getSearchButton().addActionListener(e -> searchSalesman());
        view.getUpdateButton().addActionListener(e -> deleteSalesman());
        view.getResetButton().addActionListener(e -> resetSystem());

    }

    private void addSalesman() {
        String fullName = view.getNameField().getText().trim();
        String staffNumber = view.getNameField().getText().trim();
        String icNumber = view.getIcNumberField().getText().trim();
        String bankAcc = view.getBankAccField().getText().trim();
        String totalSalesAmountStr = view.getTotalSalesField().getText().trim();
        String salesUnitStr = view.getSalesUnitField().getText().trim();
        String salaryMonthStr = view.getSalaryMonthField().getText().trim();
        String salaryYearStr = view.getSalaryYearField().getText().trim();

        try {
            double totalSalesAmount = Double.parseDouble(totalSalesAmountStr);
            int salesUnit = Integer.parseInt(salesUnitStr);
            int salaryMonth = Integer.parseInt(salaryMonthStr);
            int salaryYear = Integer.parseInt(salaryYearStr);

            YearMonth salaryMonthObj = YearMonth.of(salaryYear, salaryMonth);
            Year salaryYearObj = Year.of(salaryYear);

            SalesmanModel newSalesman = new SalesmanModel(fullName, staffNumber, icNumber, bankAcc, salesUnit, totalSalesAmount, salaryMonthObj, salaryYearObj, "");
            dbModel.addSalesman(newSalesman);

            view.displayMessage("Salesman added successfully.");
        } catch (NumberFormatException e) {
            view.displayMessage("Please enter valid numbers for Total Sales Amount, Number of Cars Sold, Salary Month, and Salary Year.");
        }
    }

    private void searchSalesman() {
        String staffNumber = view.getStaffNumberField().getText().trim();
        SalesmanModel foundSalesman = dbModel.searchSalesman(staffNumber);

        if (foundSalesman != null) {
            view.getNameField().setText(foundSalesman.getSalesmanFullName());
            view.getIcNumberField().setText(foundSalesman.getSalesmanICNum());
            view.getBankAccField().setText(foundSalesman.getSalesmanBankAcc());
            view.getTotalSalesField().setText(String.valueOf(foundSalesman.getSalesmanTotalSalesAmount()));
            view.getSalesUnitField().setText(String.valueOf(foundSalesman.getSalesmanTotalSalesUnit()));
            view.getSalaryMonthField().setText(String.valueOf(foundSalesman.getSalaryMonth().getMonthValue()));
            view.getSalaryYearField().setText(String.valueOf(foundSalesman.getSalaryYear().getValue()));
            view.displayMessage("Salesman found.");
        } else {
            view.clearFields();
            view.displayMessage("Salesman not found.");
        }
    }

    private void updateSalesman() {
        String fullName = view.getNameField().getText().trim();
        String staffNumber = view.getStaffNumberField().getText().trim();
        String icNumber = view.getIcNumberField().getText().trim();
        String bankAcc = view.getBankAccField().getText().trim();
        String totalSalesAmountStr = view.getTotalSalesField().getText().trim();
        String salesUnitStr = view.getSalesUnitField().getText().trim();
        String salaryMonthStr = view.getSalaryMonthField().getText().trim();
        String salaryYearStr = view.getSalaryYearField().getText().trim();

        try {
            double totalSalesAmount = Double.parseDouble(totalSalesAmountStr);
            int salesUnit = Integer.parseInt(salesUnitStr);
            int salaryMonth = Integer.parseInt(salaryMonthStr);
            int salaryYear = Integer.parseInt(salaryYearStr);

            YearMonth salaryMonthObj = YearMonth.of(salaryYear, salaryMonth);
            Year salaryYearObj = Year.of(salaryYear);

            SalesmanModel updatedSalesman = new SalesmanModel(fullName, staffNumber, icNumber, bankAcc, salesUnit, totalSalesAmount, salaryMonthObj, salaryYearObj, "");
            dbModel.editSalesman(updatedSalesman);

            view.displayMessage("Salesman updated successfully.");
        } catch (NumberFormatException e) {
            view.displayMessage("Please enter valid numbers for Total Sales Amount, Number of Cars Sold, Salary Month, and Salary Year.");
        }
    }

    private void deleteSalesman() {
        String staffNumber = view.getStaffNumberField().getText().trim();
        dbModel.deleteSalesman(staffNumber);
        view.clearFields();
        view.displayMessage("Salesman deleted successfully.");
    }

    private void resetSystem() {
        dbModel.reset();
        view.clearFields();
        view.displayMessage("System reset successfully.");
    }
}
