import javax.swing.*;
import java.awt.*;

public class PayrollSystemGUI extends JFrame {
    // GUI components declaration
    private JLabel nameLabel, staffNumberLabel, icNumberLabel, bankAccLabel, totalSalesLabel, salesUnitLabel, salaryMonthLabel, salaryYearLabel, messageLabel;
    private JTextField nameField, staffNumberField, icNumberField, bankAccField, totalSalesField, salesUnitField, salaryMonthField, salaryYearField;
    private JButton addButton, searchButton, updateButton, deleteButton, resetButton;

    public PayrollSystemGUI() {
        // GUI setup
        setTitle("Payroll System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2, 10, 10));

        // Initialize GUI components
        nameLabel = new JLabel("Full Name:");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        staffNumberLabel = new JLabel("Staff Number:");
        add(staffNumberLabel);
        staffNumberField = new JTextField();
        add(staffNumberField);

        icNumberLabel = new JLabel("IC Number:");
        add(icNumberLabel);
        icNumberField = new JTextField();
        add(icNumberField);

        bankAccLabel = new JLabel("Bank Account Number:");
        add(bankAccLabel);
        bankAccField = new JTextField();
        add(bankAccField);

        totalSalesLabel = new JLabel("Total Sales Amount:");
        add(totalSalesLabel);
        totalSalesField = new JTextField();
        add(totalSalesField);

        salesUnitLabel = new JLabel("Number of Cars Sold:");
        add(salesUnitLabel);
        salesUnitField = new JTextField();
        add(salesUnitField);

        salaryMonthLabel = new JLabel("Salary Month:");
        add(salaryMonthLabel);
        salaryMonthField = new JTextField();
        add(salaryMonthField);

        salaryYearLabel = new JLabel("Salary Year:");
        add(salaryYearLabel);
        salaryYearField = new JTextField();
        add(salaryYearField);

        addButton = new JButton("Add");
        add(addButton);

        searchButton = new JButton("Search");
        add(searchButton);

        updateButton = new JButton("Update");
        add(updateButton);

        deleteButton = new JButton("Delete");
        add(deleteButton);

        resetButton = new JButton("Reset");
        add(resetButton);

        messageLabel = new JLabel("");
        add(messageLabel);

        setVisible(true);
    }

    // Getter methods for GUI components
    public JTextField getNameField() {
        return nameField;
    }

    public JTextField getStaffNumberField() {
        return staffNumberField;
    }

    public JTextField getIcNumberField() {
        return icNumberField;
    }

    public JTextField getBankAccField() {
        return bankAccField;
    }

    public JTextField getTotalSalesField() {
        return totalSalesField;
    }

    public JTextField getSalesUnitField() {
        return salesUnitField;
    }

    public JTextField getSalaryMonthField() {
        return salaryMonthField;
    }

    public JTextField getSalaryYearField() {
        return salaryYearField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void clearFields() {
        nameField.setText("");
        staffNumberField.setText("");
        icNumberField.setText("");
        bankAccField.setText("");
        totalSalesField.setText("");
    }

    public void displayMessage(String message) {
        messageLabel.setText(message);
    }

    public static void main(String[] args) {
        PayrollSystemGUI view = new PayrollSystemGUI();
        SalesmanDatabaseModel dbModel = new SalesmanDatabaseModel();
        new PayrollSystemController(view, dbModel);
    }
}
