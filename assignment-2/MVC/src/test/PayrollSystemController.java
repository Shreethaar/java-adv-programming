import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PayrollSystemController {
    private PayrollSystemGUI view;
    private SalesmanDatabaseModel model;

    public PayrollSystemController(PayrollSystemGUI view, SalesmanDatabaseModel model) {
        this.view = view;
        this.model = model;
    }
    
    public void addButtonActionPerformed(ActionEvent e) {
        SalesmanModel salesman = new SalesmanModel(
            view.getNameField(),
            view.getStaffNumberField(),
            view.getIcNumberField(),
            view.getBankAccField(),
            Double.parseDouble(view.getTotalSalesField()),
            Integer.parseInt(view.getSalesUnitField()),
            Integer.parseInt(view.getSalaryMonthField()),
            Integer.parseInt(view.getSalaryYearField())
        );
        model.addSalesman(salesman);
        view.updateTable();
        view.displayMessage("Salesman added successfully.");
        view.clearFields();
    }

    public void updateButtonActionPerformed(ActionEvent e) {
        SalesmanModel salesman = model.searchSalesmanByName(view.getNameField());
        if (salesman != null) {
            salesman.setStaffNumber(view.getStaffNumberField());
            salesman.setIcNumber(view.getIcNumberField());
            salesman.setBankAcc(view.getBankAccField());
            salesman.setTotalSales(Double.parseDouble(view.getTotalSalesField()));
            salesman.setCarsSold(Integer.parseInt(view.getSalesUnitField()));
            salesman.setSalaryMonth(Integer.parseInt(view.getSalaryMonthField()));
            salesman.setSalaryYear(Integer.parseInt(view.getSalaryYearField()));
            
            model.updateSalesman(salesman);
            view.updateTable();
            view.displayMessage("Salesman data updated successfully.");
            view.clearFields();
        } else {
            view.displayMessage("Salesman not found.");
        }
    }

    public void deleteButtonActionPerformed(ActionEvent e) {
        if (model.deleteSalesman(view.getNameField())) {
            view.updateTable();
            view.displayMessage("Salesman deleted successfully.");
            view.clearFields();
        } else {
            view.displayMessage("Salesman not found.");
        }
    }

    public void resetButtonActionPerformed(ActionEvent e) {
        view.clearFields();
    }

    public DefaultTableModel getTableModel() {
        String[] columnNames = {"Name", "Staff Number", "IC Number", "Bank Account", "Total Sales", "Cars Sold", "Salary Month", "Salary Year"};
        List<SalesmanModel> salesmen = model.getAllSalesmen();
        Object[][] data = new Object[salesmen.size()][8];
        for (int i = 0; i < salesmen.size(); i++) {
            SalesmanModel salesman = salesmen.get(i);
            data[i][0] = salesman.getName();
            data[i][1] = salesman.getStaffNumber();
            data[i][2] = salesman.getIcNumber();
            data[i][3] = salesman.getBankAcc();
            data[i][4] = salesman.getTotalSales();
            data[i][5] = salesman.getCarsSold();
            data[i][6] = salesman.getSalaryMonth();
            data[i][7] = salesman.getSalaryYear();
        }
        return new DefaultTableModel(data, columnNames);
    }
}
