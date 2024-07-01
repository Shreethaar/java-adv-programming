import javax.swing.*;
import java.awt.event.ActionListener;
import java.time.YearMonth;

public class SalesmanView extends JFrame {

    private JLabel staffNumberLabel;
    private JTextField staffNumberField;
    private JLabel fullNameLabel;
    private JTextField fullNameField;
    private JLabel icNumberLabel;
    private JTextField icNumberField;
    private JLabel bankAccountLabel;
    private JTextField bankAccountField;
    private JLabel totalSalesUnitLabel;
    private JTextField totalSalesUnitField;
    private JLabel totalSalesAmountLabel;
    private JTextField totalSalesAmountField;
    private JLabel salaryMonthLabel;
    private JComboBox<YearMonth> salaryMonthComboBox;
    private JLabel salaryYearLabel;
    private JTextField salaryYearField;

    private JLabel grossSalaryLabel;
    private JTextField grossSalaryField;
    private JLabel incomeTaxLabel;
    private JTextField incomeTaxField;
    private JLabel epfLabel;
    private JTextField epfField;
    private JLabel netSalaryLabel;
    private JTextField netSalaryField;

    private JButton saveButton;
    private JButton searchButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JTextArea messageArea;

    public SalesmanView() {
        super("Salesman Salary System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);

        initComponents();
        initLayout();
    }

    private void initComponents() {
        staffNumberLabel = new JLabel("Staff Number:");
        staffNumberField = new JTextField(20);
        fullNameLabel = new JLabel("Full Name:");
        fullNameField = new JTextField(20);
        icNumberLabel = new JLabel("IC Number:");
        icNumberField = new JTextField(20);
        bankAccountLabel = new JLabel("Bank Account Number:");
        bankAccountField = new JTextField(20);
        totalSalesUnitLabel = new JLabel("Total Sales Unit:");
        totalSalesUnitField = new JTextField(20);
        totalSalesAmountLabel = new JLabel("Total Sales Amount:");
        totalSalesAmountField = new JTextField(20);
        salaryMonthLabel = new JLabel("Salary Month:");
        YearMonth[] months = {YearMonth.of(2023, 1), YearMonth.of(2024, 7)};

salaryMonthComboBox = new JComboBox<>(months);
        salaryYearLabel = new JLabel("Salary Year:");
        salaryYearField = new JTextField(20);

        grossSalaryLabel = new JLabel("Gross Salary:");
        grossSalaryField = new JTextField(20);
        grossSalaryField.setEditable(false);
        incomeTaxLabel = new JLabel("Monthly Income Tax:");
        incomeTaxField = new JTextField(20);
        incomeTaxField.setEditable(false);
        epfLabel = new JLabel("EPF:");
        epfField = new JTextField(20);
        epfField.setEditable(false);
        netSalaryLabel = new JLabel("Net Salary:");
        netSalaryField = new JTextField(20);
        netSalaryField.setEditable(false);

        saveButton = new JButton("Save");
        searchButton = new JButton("Search");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        messageArea = new JTextArea(5, 40);
        messageArea.setEditable(false);
    }

    private void initLayout() {
        int labelWidth = 100;
        int fieldWidth = 200;
        int labelHeight = 25;
        int fieldHeight = 25;
        int spacing = 10;

        int x = 50;
        int y = 20;

        staffNumberLabel.setBounds(x, y, labelWidth, labelHeight);
        add(staffNumberLabel);
        staffNumberField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(staffNumberField);

        y += labelHeight + spacing;

        fullNameLabel.setBounds(x, y, labelWidth, labelHeight);
        add(fullNameLabel);
        fullNameField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(fullNameField);

        y += labelHeight + spacing;

        icNumberLabel.setBounds(x, y, labelWidth, labelHeight);
        add(icNumberLabel);
        icNumberField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(icNumberField);

        y += labelHeight + spacing;

        bankAccountLabel.setBounds(x, y, labelWidth, labelHeight);
        add(bankAccountLabel);
        bankAccountField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(bankAccountField);

        y += labelHeight + spacing;

        totalSalesUnitLabel.setBounds(x, y, labelWidth, labelHeight);
        add(totalSalesUnitLabel);
        totalSalesUnitField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(totalSalesUnitField);

        y += labelHeight + spacing;

        totalSalesAmountLabel.setBounds(x, y, labelWidth, labelHeight);
        add(totalSalesAmountLabel);
        totalSalesAmountField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(totalSalesAmountField);

        y += labelHeight + spacing;

        salaryMonthLabel.setBounds(x, y, labelWidth, labelHeight);
        add(salaryMonthLabel);
        salaryMonthComboBox.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(salaryMonthComboBox);

        y += labelHeight + spacing;

        salaryYearLabel.setBounds(x, y, labelWidth, labelHeight);
        add(salaryYearLabel);
        salaryYearField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(salaryYearField);

        // Layout for calculated fields
        x = 450;
        y = 20;

        grossSalaryLabel.setBounds(x, y, labelWidth, labelHeight);
        add(grossSalaryLabel);
        grossSalaryField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(grossSalaryField);

        y += labelHeight + spacing;

        incomeTaxLabel.setBounds(x, y, labelWidth, labelHeight);
        add(incomeTaxLabel);
        incomeTaxField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(incomeTaxField);

        y += labelHeight + spacing;

        epfLabel.setBounds(x, y, labelWidth, labelHeight);
        add(epfLabel);
        epfField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(epfField);

        y += labelHeight + spacing;

        netSalaryLabel.setBounds(x, y, labelWidth, labelHeight);
        add(netSalaryLabel);
        netSalaryField.setBounds(x + labelWidth + spacing, y, fieldWidth, fieldHeight);
        add(netSalaryField);

        // Layout for buttons and message area
        x = 50;
        y = 400;

        saveButton.setBounds(x, y, fieldWidth, fieldHeight);
        add(saveButton);

        x += fieldWidth + spacing;

        searchButton.setBounds(x, y, fieldWidth, fieldHeight);
        add(searchButton);

        x += fieldWidth + spacing;

        editButton.setBounds(x, y, fieldWidth, fieldHeight);
        add(editButton);

        x += fieldWidth + spacing;

        deleteButton.setBounds(x, y, fieldWidth, fieldHeight);
        add(deleteButton);

        x += fieldWidth + spacing;

        clearButton.setBounds(x, y, fieldWidth, fieldHeight);
        add(clearButton);

        y += fieldHeight + spacing * 2;

        messageArea.setBounds(x, y, fieldWidth * 4, fieldHeight * 2);
        add(messageArea);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addSearchButtonListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }

    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public String getStaffNumber() {
        return staffNumberField.getText();
    }

    public void setStaffNumber(String staffNumber) {
        staffNumberField.setText(staffNumber);
    }

    public String getFullName() {
        return fullNameField.getText();
    }

    public void setFullName(String fullName) {
        fullNameField.setText(fullName);
    }

    public String getICNumber() {
        return icNumberField.getText();
    }

    public void setICNumber(String icNumber) {
        icNumberField.setText(icNumber);
    }

    public String getBankAccountNumber() {
        return bankAccountField.getText();
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        bankAccountField.setText(bankAccountNumber);
    }

    public int getTotalSalesUnit() {
        try {
            return Integer.parseInt(totalSalesUnitField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setTotalSalesUnit(int totalSalesUnit) {
        totalSalesUnitField.setText(String.valueOf(totalSalesUnit));
    }

    public double getTotalSalesAmount() {
        try {
            return Double.parseDouble(totalSalesAmountField.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public void setTotalSalesAmount(double totalSalesAmount) {
        totalSalesAmountField.setText(String.valueOf(totalSalesAmount));
    }

    public YearMonth getSalaryMonth() {
        return (YearMonth) salaryMonthComboBox.getSelectedItem();
    }

    public void setSalaryMonth(YearMonth salaryMonth) {
        salaryMonthComboBox.setSelectedItem(salaryMonth);
    }

    public int getSalaryYear() {
        try {
            return Integer.parseInt(salaryYearField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setSalaryYear(int salaryYear) {
        salaryYearField.setText(String.valueOf(salaryYear));
    }

    public void setGrossSalary(double grossSalary) {
        grossSalaryField.setText(String.valueOf(grossSalary));
    }

    public void setMonthlyIncomeTax(double monthlyIncomeTax) {
        incomeTaxField.setText(String.valueOf(monthlyIncomeTax));
    }

    public void setEPF(double epf) {
        epfField.setText(String.valueOf(epf));
    }

    public void setNetSalary(double netSalary) {
        netSalaryField.setText(String.valueOf(netSalary));
    }

    public void showMessage(String message) {
        messageArea.setText(message);
        messageArea.append("\n"); // Add newline after each message
    }
}
