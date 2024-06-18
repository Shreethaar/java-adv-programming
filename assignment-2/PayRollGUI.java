import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayRollGUI extends JFrame implements ActionListener {

    private PayRoll payRollSys;
    private CardLayout cardLayout;
    private JPanel mainPanel, menuPanel, addPanel, searchPanel;
    private JTextField fullNameField, staffNumField, staffICNumField, staffBankAccNoField,
                     monthlySalaryField, annualSalaryField, totalSalesAmountField, carsSoldField, searchStaffNumField;
    private JButton addSalesmanButton, searchSalesmanButton, resetButton, exitButton, 
                    menuAddButton, menuSearchButton, menuResetButton, menuExitButton;
    private JTextArea outputArea;

    public PayRollGUI(PayRoll payRollSys) {
        super("PayRoll System");
        this.payRollSys = payRollSys;
        initializeComponents();
        createLayout();
        addListeners();
    }

    private void initializeComponents() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Menu panel components
        menuPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        menuAddButton = new JButton("Add Salesman");
        menuSearchButton = new JButton("Search Salesman");
        menuResetButton = new JButton("Reset System");
        menuExitButton = new JButton("Exit");
        menuPanel.add(menuAddButton);
        menuPanel.add(menuSearchButton);
        menuPanel.add(menuResetButton);
        menuPanel.add(menuExitButton);
        
        // Add salesman panel components
        addPanel = new JPanel(new BorderLayout());
        JPanel addInputPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        fullNameField = new JTextField(20);
        staffNumField = new JTextField(20);
        staffICNumField = new JTextField(20);
        staffBankAccNoField = new JTextField(20);
        monthlySalaryField = new JTextField(20);
        annualSalaryField = new JTextField(20);
        totalSalesAmountField = new JTextField(20);
        carsSoldField = new JTextField(20);
        addInputPanel.add(new JLabel("Full Name:"));
        addInputPanel.add(fullNameField);
        addInputPanel.add(new JLabel("Staff Number:"));
        addInputPanel.add(staffNumField);
        addInputPanel.add(new JLabel("Staff IC Number:"));
        addInputPanel.add(staffICNumField);
        addInputPanel.add(new JLabel("Bank Account Number:"));
        addInputPanel.add(staffBankAccNoField);
        addInputPanel.add(new JLabel("Monthly Salary: "));
        addInputPanel.add(monthlySalaryField);
        addInputPanel.add(new JLabel("Annual Salary: "));
        addInputPanel.add(annualSalaryField);
        addInputPanel.add(new JLabel("Total Sales Amount: "));
        addInputPanel.add(totalSalesAmountField);
        addInputPanel.add(new JLabel("Number of Cars Sold:"));
        addInputPanel.add(carsSoldField);
        addSalesmanButton = new JButton("Add Salesman");
        addPanel.add(addInputPanel, BorderLayout.CENTER);
        addPanel.add(addSalesmanButton, BorderLayout.SOUTH);
        
        // Search salesman panel components
        searchPanel = new JPanel(new BorderLayout());
        JPanel searchInputPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        searchStaffNumField = new JTextField(20);
        searchInputPanel.add(new JLabel("Enter Staff Number to search: "));
        searchInputPanel.add(searchStaffNumField);
        searchSalesmanButton = new JButton("Search Salesman");
        searchPanel.add(searchInputPanel, BorderLayout.CENTER);
        searchPanel.add(searchSalesmanButton, BorderLayout.SOUTH);

        // Output area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        // Add panels to main panel
        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(addPanel, "Add");
        mainPanel.add(searchPanel, "Search");

        // Add main panel and output area to frame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(outputScrollPane, BorderLayout.EAST);
    }

    private void createLayout() {
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
    }

    private void addListeners() {
        menuAddButton.addActionListener(this);
        menuSearchButton.addActionListener(this);
        menuResetButton.addActionListener(this);
        menuExitButton.addActionListener(this);

        addSalesmanButton.addActionListener(this);
        searchSalesmanButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuAddButton) {
            cardLayout.show(mainPanel, "Add");
        } else if (e.getSource() == menuSearchButton) {
            cardLayout.show(mainPanel, "Search");
        } else if (e.getSource() == menuResetButton) {
            resetSystem();
        } else if (e.getSource() == menuExitButton) {
            System.exit(0);
        } else if (e.getSource() == addSalesmanButton) {
            addSalesman();
        } else if (e.getSource() == searchSalesmanButton) {
            searchSalesman();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void addSalesman() {
        try {
            // Get values from text fields
            String fullName = fullNameField.getText();
            String staffNum = staffNumField.getText();
            String staffICNum = staffICNumField.getText();
            String staffBankAccNo = staffBankAccNoField.getText();
            double monthlySalary = Double.parseDouble(monthlySalaryField.getText());
            double annualSalary = Double.parseDouble(annualSalaryField.getText());
            double totalSalesAmount = Double.parseDouble(totalSalesAmountField.getText());
            int carsSold = Integer.parseInt(carsSoldField.getText());

            // Create salesman object and add to PayRoll
            Salesman salesman = new Salesman(fullName, staffNum, staffICNum, staffBankAccNo,
                    carsSold, totalSalesAmount, monthlySalary, annualSalary);

            payRollSys.insertSalesRep(salesman);

            // Clear text fields after successful addition
            fullNameField.setText("");
            staffNumField.setText("");
            staffICNumField.setText("");
            staffBankAccNoField.setText("");
            monthlySalaryField.setText("");
            annualSalaryField.setText("");
            totalSalesAmountField.setText("");
            carsSoldField.setText("");

            outputArea.append("Salesman added successfully.\n");
            cardLayout.show(mainPanel, "Menu");

        } catch (NumberFormatException ex) {
            outputArea.append("Invalid input. Please check the data entered.\n");
        }
    }

    private void searchSalesman() {
        String searchStaffNum = searchStaffNumField.getText();

        // Input validation (optional)
        // Check if staff number field is empty

        Salesman searchedStaff = payRollSys.searchSalesRep(searchStaffNum);
        if (searchedStaff != null) {
            outputArea.append("Salesman found:\n" + searchedStaff + "\n");
        } else {
            outputArea.append("Salesman not found.\n");
        }
        cardLayout.show(mainPanel, "Menu");
    }

    private void resetSystem() {
        // Implement reset logic in the PayRoll class
        payRollSys.reset();
        outputArea.append("System reset.\n");
    }
}

