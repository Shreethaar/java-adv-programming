import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PayrollSystemGUI extends JFrame {
    // GUI components declaration
    private JLabel nameLabel, staffNumberLabel, icNumberLabel, bankAccLabel, totalSalesLabel, salesUnitLabel, salaryMonthLabel, salaryYearLabel, messageLabel;
    private JTextField nameField, staffNumberField, icNumberField, bankAccField, totalSalesField, salesUnitField, salaryMonthField, salaryYearField;
    private JButton addButton, searchButton, updateButton, deleteButton, resetButton, generateReportButton, exitSystemButton;
    private JTable salesmanTable;
    private DefaultTableModel tableModel;

    public PayrollSystemGUI() {
        // GUI setup
        setTitle("Payroll System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Initialize GUI components
        nameLabel = new JLabel("Full Name:");
        nameField = new JTextField(20);

        staffNumberLabel = new JLabel("Staff Number:");
        staffNumberField = new JTextField(20);

        icNumberLabel = new JLabel("IC Number:");
        icNumberField = new JTextField(20);

        bankAccLabel = new JLabel("Bank Account Number:");
        bankAccField = new JTextField(20);

        totalSalesLabel = new JLabel("Total Sales Amount:");
        totalSalesField = new JTextField(20);

        salesUnitLabel = new JLabel("Number of Cars Sold:");
        salesUnitField = new JTextField(20);

        salaryMonthLabel = new JLabel("Salary Month:");
        salaryMonthField = new JTextField(20);

        salaryYearLabel = new JLabel("Salary Year:");
        salaryYearField = new JTextField(20);

        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        resetButton = new JButton("Reset");
        generateReportButton = new JButton("Generate Report");
        exitSystemButton = new JButton("Exit");

        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);

        // JTable setup
        String[] columnNames = {"Full Name", "Staff Number", "IC Number", "Bank Account", "Total Sales", "Cars Sold", "Salary Month", "Salary Year"};
        tableModel = new DefaultTableModel(columnNames, 0);
        salesmanTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(salesmanTable);

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(staffNumberLabel, gbc);
        gbc.gridx = 1;
        add(staffNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(icNumberLabel, gbc);
        gbc.gridx = 1;
        add(icNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(bankAccLabel, gbc);
        gbc.gridx = 1;
        add(bankAccField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(totalSalesLabel, gbc);
        gbc.gridx = 1;
        add(totalSalesField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(salesUnitLabel, gbc);
        gbc.gridx = 1;
        add(salesUnitField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(salaryMonthLabel, gbc);
        gbc.gridx = 1;
        add(salaryMonthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(salaryYearLabel, gbc);
        gbc.gridx = 1;
        add(salaryYearField, gbc);

        // Adding buttons in separate rows
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        add(addButton, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        add(updateButton, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(deleteButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        add(resetButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(messageLabel, gbc);

        // Add the table at the bottom
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(tableScrollPane, gbc);

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

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JButton getExitButton() {
        return exitSystemButton;
    }

    public JButton getGenerateReportButton() {
        return getGenerateReportButton;
    }

    public void clearFields() {
        nameField.setText("");
        staffNumberField.setText("");
        icNumberField.setText("");
        bankAccField.setText("");
        totalSalesField.setText("");
        salesUnitField.setText("");
        salaryMonthField.setText("");
        salaryYearField.setText("");
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

