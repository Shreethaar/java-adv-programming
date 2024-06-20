import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.time.YearMonth;

public class PayrollSystemGUI extends JFrame {

    private JLabel nameLabel, staffNumberLabel, icNumberLabel, bankAccLabel, totalSalesLabel, salesUnitLabel, salaryMonthLabel, salaryYearLabel, messageLabel;
    private JTextField nameField, staffNumberField, icNumberField, bankAccField, totalSalesField, salesUnitField, salaryMonthField, salaryYearField;
    private JButton addButton, searchButton, updateButton, deleteButton, resetButton;

    private SalesmanDatabaseModel dbModel;

    public PayrollSystemGUI() {
        setTitle("Payroll System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2, 10, 10));

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
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSalesman();
            }
        });
        add(addButton);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchSalesman();
            }
        });
        add(searchButton);

        updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSalesman();
            }
        });
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSalesman();
            }
        });
        add(deleteButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetSystem();
            }
        });
        add(resetButton);

        messageLabel = new JLabel("");
        add(messageLabel);

        dbModel = new SalesmanDatabaseModel();

        setVisible(true);
    }

    private void addSalesman() {
        String fullName = nameField.getText().trim();
        String staffNumber = staffNumberField.getText().trim();
        String icNumber = icNumberField.getText().trim();
        String bankAcc = bankAccField.getText().trim();
        String totalSalesAmountStr = totalSalesField.getText().trim();
        String salesUnitStr = salesUnitField.getText().trim();
        String salaryMonthStr = salaryMonthField.getText().trim();
        String salaryYearStr = salaryYearField.getText().trim();

        try {
            double totalSalesAmount = Double.parseDouble(totalSalesAmountStr);
            int salesUnit = Integer.parseInt(salesUnitStr);
            int salaryMonth = Integer.parseInt(salaryMonthStr);
            int salaryYear = Integer.parseInt(salaryYearStr);

            YearMonth salaryMonthObj = YearMonth.of(salaryYear, salaryMonth);
            Year salaryYearObj = Year.of(salaryYear);

            SalesmanModel newSalesman = new SalesmanModel(fullName, staffNumber, icNumber, bankAcc, salesUnit, totalSalesAmount, salaryMonthObj, salaryYearObj, "");
            dbModel.addSalesman(newSalesman);

            displayMessage("Salesman added successfully.");
        } catch (NumberFormatException e) {
            displayMessage("Please enter valid numbers for Total Sales Amount, Number of Cars Sold, Salary Month, and Salary Year.");
        }
    }

    private void searchSalesman() {
        String staffNumber = staffNumberField.getText().trim();
        SalesmanModel foundSalesman = dbModel.searchSalesman(staffNumber);

        if (foundSalesman != null) {
            nameField.setText(foundSalesman.getSalesmanFullName());
            icNumberField.setText(foundSalesman.getSalesmanICNum());
            bankAccField.setText(foundSalesman.getSalesmanBankAcc());
            totalSalesField.setText(String.valueOf(foundSalesman.getSalesmanTotalSalesAmount()));
            salesUnitField.setText(String.valueOf(foundSalesman.getSalesmanTotalSalesUnit()));
            salaryMonthField.setText(String.valueOf(foundSalesman.getSalaryMonth().getMonthValue()));
            salaryYearField.setText(String.valueOf(foundSalesman.getSalaryYear().getValue()));
            displayMessage("Salesman found.");
        } else {
            clearFields();
            displayMessage("Salesman not found.");
        }
    }

    private void updateSalesman() {
        String fullName = nameField.getText().trim();
        String staffNumber = staffNumberField.getText().trim();
        String icNumber = icNumberField.getText().trim();
        String bankAcc = bankAccField.getText().trim();
        String totalSalesAmountStr = totalSalesField.getText().trim();
        String salesUnitStr = salesUnitField.getText().trim();
        String salaryMonthStr = salaryMonthField.getText().trim();
        String salaryYearStr = salaryYearField.getText().trim();

        try {
            double totalSalesAmount = Double.parseDouble(totalSalesAmountStr);
            int salesUnit = Integer.parseInt(salesUnitStr);
            int salaryMonth = Integer.parseInt(salaryMonthStr);
            int salaryYear = Integer.parseInt(salaryYearStr);

            YearMonth salaryMonthObj = YearMonth.of(salaryYear, salaryMonth);
            Year salaryYearObj = Year.of(salaryYear);

            SalesmanModel updatedSalesman = new SalesmanModel(fullName, staffNumber, icNumber, bankAcc, salesUnit, totalSalesAmount, salaryMonthObj, salaryYearObj, "");
            dbModel.editSalesman(updatedSalesman);

            displayMessage("Salesman updated successfully.");
        } catch (NumberFormatException e) {
            displayMessage("Please enter valid numbers for Total Sales Amount, Number of Cars Sold, Salary Month, and Salary Year.");
        }
    }

    private void deleteSalesman() {
        String staffNumber = staffNumberField.getText().trim();
        dbModel.deleteSalesman(staffNumber);
        clearFields();
        displayMessage("Salesman deleted successfully.");
    }

    private void resetSystem() {
        dbModel.reset();
        clearFields();
        displayMessage("System reset successfully.");
    }

    private void clearFields() {
        nameField.setText("");
        staffNumberField.setText("");
        icNumberField.setText("");
        bankAccField.setText("");
        totalSalesField.setText("");
        salesUnitField.setText("");
        salaryMonthField.setText("");
        salaryYearField.setText("");
    }

    private void displayMessage(String message) {
        messageLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PayrollSystemGUI();
            }
        });
    }
}

