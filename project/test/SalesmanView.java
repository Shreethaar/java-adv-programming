import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class SalesmanView {

    private static SalesmanDatabaseModel dbModel = new SalesmanDatabaseModel();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maju Auto Sales Sdn.Bhd Salesman Payroll System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Salesman PayRoll System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        panel.add(titlePanel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel nameLabel = new JLabel("Salesman Name:", JLabel.CENTER);
        formPanel.add(nameLabel);
        JTextField nameText = new JTextField(20);
        formPanel.add(nameText);

        JLabel idLabel = new JLabel("Salesman ID:", JLabel.CENTER);
        formPanel.add(idLabel);
        JTextField idText = new JTextField(20);
        formPanel.add(idText);

        JLabel monthYearLabel = new JLabel("Month Year:", JLabel.CENTER);
        formPanel.add(monthYearLabel);
        JTextField monthYearText = new JTextField(20);
        formPanel.add(monthYearText);

        JLabel icNumberLabel = new JLabel("IC Number:", JLabel.CENTER);
        formPanel.add(icNumberLabel);
        JTextField icNumberText = new JTextField(20);
        formPanel.add(icNumberText);

        JLabel bankAccountNumberLabel = new JLabel("Bank Account Number:", JLabel.CENTER);
        formPanel.add(bankAccountNumberLabel);
        JTextField bankAccountNumberText = new JTextField(20);
        formPanel.add(bankAccountNumberText);

        JLabel totalCarSalesLabel = new JLabel("Total Car Sales:", JLabel.CENTER);
        formPanel.add(totalCarSalesLabel);
        JTextField totalCarSalesText = new JTextField(20);
        formPanel.add(totalCarSalesText);

        JLabel numberOfCarsSoldLabel = new JLabel("Number of Cars Sold:", JLabel.CENTER);
        formPanel.add(numberOfCarsSoldLabel);
        JTextField numberOfCarsSoldText = new JTextField(20);
        formPanel.add(numberOfCarsSoldText);

        panel.add(formPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton calculateButton = new JButton("Calculate Salary");
        buttonPanel.add(calculateButton);

        JButton resetButton = new JButton("Reset");
        buttonPanel.add(resetButton);

        JButton exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);

        JButton sortNameButton = new JButton("Sort By Name");
        buttonPanel.add(sortNameButton);

        JButton sortIDButton = new JButton("Sort By ID");
        buttonPanel.add(sortIDButton);

        JButton saveChangesButton = new JButton("Save Changes");
        buttonPanel.add(saveChangesButton);

        panel.add(buttonPanel);

        TreeSet<SalesmanModel> salesmanNameSortSet = new TreeSet<>(new SalesmanNameComparator());
        TreeSet<SalesmanModel> salesmanIDSortSet = new TreeSet<>(new SalesmanIDComparator());

        // Table to display the results
        String[] columnNames = {"Full Name", "Staff Number", "IC Number", "Bank Account Number", "Total Car Sales", "Number of Cars Sold", "Gross Salary", "EPF", "Income Tax", "Net Salary"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        // Add search and delete components
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel searchLabel = new JLabel("Search (Name/ID):");
        searchPanel.add(searchLabel);
        JTextField searchText = new JTextField(20);
        searchPanel.add(searchText);

        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        JButton deleteButton = new JButton("Delete Selected Row");
        searchPanel.add(deleteButton);

        panel.add(searchPanel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String empName = nameText.getText();
                    String empID = idText.getText();
                    String empICNUM = icNumberText.getText();
                    String empBankNum = bankAccountNumberText.getText();
                    double empCarSales = Double.parseDouble(totalCarSalesText.getText());
                    int empCarAmount = Integer.parseInt(numberOfCarsSoldText.getText());

                    if (empCarSales < 0 || empCarAmount < 0) {
                        throw new IllegalArgumentException("Sales amounts cannot be negative.");
                    }

                    SalesmanModel employee = new SalesmanModel(empName, empID, empBankNum, empICNUM, empCarSales, empCarAmount);
                    employee.calculateGrossSalary();
                    employee.calculateEPF();
                    employee.calculateIncomeTax();
                    employee.calculateNetSalary();

                    // Add employee to the database
                    dbModel.addSalesman(employee);
                    salesmanNameSortSet.add(employee);

                    // Update the table with the calculated values
                    Object[] row = {
                        empName, empID, empICNUM, empBankNum,
                        String.format("%.2f", empCarSales), empCarAmount,
                        String.format("%.2f", employee.getSalesmanGrossSalary()),
                        String.format("%.2f", employee.getSalesmanEPF()),
                        String.format("%.2f", employee.getSalesmanIncomeTax()),
                        String.format("%.2f", employee.getSalesmanNetSalary())
                    };
                    model.addRow(row);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please enter valid numbers for car sales and number of cars sold.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTextValue = searchText.getText().toLowerCase();
                boolean found = false;  // Flag to check if the salesman is found
                
                for (SalesmanModel salesman : dbModel.getAllSalesmen()) {
                    if (salesman.getSalesmanFullName().toLowerCase().contains(searchTextValue) || salesman.getSalesmanStaffID().toLowerCase().contains(searchTextValue)) {
                        for (int i = 0; i < table.getRowCount(); i++) {
                            if (table.getValueAt(i, 0).equals(salesman.getSalesmanFullName()) && table.getValueAt(i, 1).equals(salesman.getSalesmanStaffID())) {
                                table.setRowSelectionInterval(i, i);
                                found = true;
                                break;
                            }
                        }
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Failed to search for salesman.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String staffID = model.getValueAt(selectedRow, 1).toString();
                    dbModel.deleteSalesman(staffID);
                    model.removeRow(selectedRow);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameText.setText("");
                idText.setText("");
                monthYearText.setText("");
                icNumberText.setText("");
                bankAccountNumberText.setText("");
                totalCarSalesText.setText("");
                numberOfCarsSoldText.setText("");
                searchText.setText("");
                model.setRowCount(0);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        sortNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); // Clear existing rows

                TreeSet<SalesmanModel> sortedByName = dbModel.getSortedSalesmenNames();
                for (SalesmanModel employee : sortedByName) {
                    // Recalculate salary attributes
                    employee.calculateGrossSalary();
                    employee.calculateEPF();
                    employee.calculateIncomeTax();
                    employee.calculateNetSalary();

                    Object[] row = {
                        employee.getSalesmanFullName(),
                        employee.getSalesmanStaffID(),
                        employee.getSalesmanICNum(),
                        employee.getSalesmanBankAcc(),
                        String.format("%.2f", employee.getSalesmanTotalSalesAmount()),
                        employee.getSalesmanTotalSalesUnit(),
                        String.format("%.2f", employee.getSalesmanGrossSalary()),
                        String.format("%.2f", employee.getSalesmanEPF()),
                        String.format("%.2f", employee.getSalesmanIncomeTax()),
                        String.format("%.2f", employee.getSalesmanNetSalary())
                    };
                    model.addRow(row);
                }
            }
        });

        sortIDButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0); // Clear existing rows

                TreeSet<SalesmanModel> sortedByID = dbModel.getSortedSalesmenStaffID();
                for (SalesmanModel employee : sortedByID) {
                    // Recalculate salary attributes
                    employee.calculateGrossSalary();
                    employee.calculateEPF();
                    employee.calculateIncomeTax();
                    employee.calculateNetSalary();

                    Object[] row = {
                        employee.getSalesmanFullName(),
                        employee.getSalesmanStaffID(),
                        employee.getSalesmanICNum(),
                        employee.getSalesmanBankAcc(),
                        String.format("%.2f", employee.getSalesmanTotalSalesAmount()),
                        employee.getSalesmanTotalSalesUnit(),
                        String.format("%.2f", employee.getSalesmanGrossSalary()),
                        String.format("%.2f", employee.getSalesmanEPF()),
                        String.format("%.2f", employee.getSalesmanIncomeTax()),
                        String.format("%.2f", employee.getSalesmanNetSalary())
                    };
                    model.addRow(row);
                }
            }
        });

        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = table.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String empName = table.getValueAt(i, 0).toString();
                    String empID = table.getValueAt(i, 1).toString();
                    String empICNUM = table.getValueAt(i, 2).toString();
                    String empBankNum = table.getValueAt(i, 3).toString();
                    double empCarSales = Double.parseDouble(table.getValueAt(i, 4).toString());
                    int empCarAmount = Integer.parseInt(table.getValueAt(i, 5).toString());

                    SalesmanModel employee = new SalesmanModel(empName, empID, empBankNum, empICNUM, empCarSales, empCarAmount);
                    employee.calculateGrossSalary();
                    employee.calculateEPF();
                    employee.calculateIncomeTax();
                    employee.calculateNetSalary();

                    dbModel.editSalesman(employee);
                }
                JOptionPane.showMessageDialog(panel, "Changes saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
