import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
public class SalesmanView {

    private static SalesmanDatabaseModel dbModel = new SalesmanDatabaseModel();
    private static JTable table;
    private static final int[] EDITABLE_COLUMNS = {0, 1, 2, 3, 4, 5}; // Columns that are editable
    private static final int[] NON_EDITABLE_COLUMNS = {6, 7, 8, 9}; // Columns that are non-editable

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maju Auto Sales Sdn.Bhd Salesman Payroll System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);

        // Load previously stored data
        loadStoredData();
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        addTitle(panel);
        addForm(panel);
        addButtons(panel);
        addTable(panel);
        addSearch(panel);
        addReportButtons(panel);
    }

    private static void addTitle(JPanel panel) {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Salesman PayRoll System");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        panel.add(titlePanel);
    }

    private static void addForm(JPanel panel) {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 2, 10, 10));

        formPanel.add(new JLabel("Salesman Name:", JLabel.CENTER));
        JTextField nameText = new JTextField(20);
        formPanel.add(nameText);

        formPanel.add(new JLabel("Salesman ID:", JLabel.CENTER));
        JTextField idText = new JTextField(20);
        formPanel.add(idText);

        formPanel.add(new JLabel("Month Year:", JLabel.CENTER));
        JTextField monthYearText = new JTextField(20);
        formPanel.add(monthYearText);

        formPanel.add(new JLabel("IC Number:", JLabel.CENTER));
        JTextField icNumberText = new JTextField(20);
        formPanel.add(icNumberText);

        formPanel.add(new JLabel("Bank Account Number:", JLabel.CENTER));
        JTextField bankAccountNumberText = new JTextField(20);
        formPanel.add(bankAccountNumberText);

        formPanel.add(new JLabel("Total Car Sales:", JLabel.CENTER));
        JTextField totalCarSalesText = new JTextField(20);
        formPanel.add(totalCarSalesText);

        formPanel.add(new JLabel("Number of Cars Sold:", JLabel.CENTER));
        JTextField numberOfCarsSoldText = new JTextField(20);
        formPanel.add(numberOfCarsSoldText);

        panel.add(formPanel);

        addCalculateButton(panel, nameText, idText, icNumberText, bankAccountNumberText, totalCarSalesText, numberOfCarsSoldText);
    }

    private static void addCalculateButton(JPanel panel, JTextField nameText, JTextField idText, JTextField icNumberText, JTextField bankAccountNumberText, JTextField totalCarSalesText, JTextField numberOfCarsSoldText) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton calculateButton = new JButton("Calculate Salary");
        buttonPanel.add(calculateButton);
        panel.add(buttonPanel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSalary(nameText, idText, icNumberText, bankAccountNumberText, totalCarSalesText, numberOfCarsSoldText);
            }
        });
    }

    private static void calculateSalary(JTextField nameText, JTextField idText, JTextField icNumberText, JTextField bankAccountNumberText, JTextField totalCarSalesText, JTextField numberOfCarsSoldText) {
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

            // Update the table with the calculated values
            addRowToTable(employee);

            JOptionPane.showMessageDialog(null, "Salesman information saved successfully.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers for car sales and number of cars sold.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void addButtons(JPanel panel) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

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

        JButton editCellsButton = new JButton("Edit Cells");
        buttonPanel.add(editCellsButton);

        panel.add(buttonPanel);

        resetButton.addActionListener(e -> resetForm(panel));

        exitButton.addActionListener(e -> System.exit(0));

        sortNameButton.addActionListener(e -> sortTableByName());

        sortIDButton.addActionListener(e -> sortTableByID());

        saveChangesButton.addActionListener(e -> saveChanges(panel));

        editCellsButton.addActionListener(e -> verifyCellEdit());
    }

    private static void addTable(JPanel panel) {
        String[] columnNames = {"Full Name", "Staff Number", "IC Number", "Bank Account Number", "Total Car Sales", "Number of Cars Sold", "Gross Salary", "EPF", "Income Tax", "Net Salary"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
    }

    private static void addSearch(JPanel panel) {
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

        searchButton.addActionListener(e -> searchSalesman(searchText.getText()));

        deleteButton.addActionListener(e -> deleteSelectedRow());
    }

    private static void addReportButtons(JPanel panel) {
        JPanel reportPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton genReport1 = new JButton("Generate Report Low to High");
        reportPanel.add(genReport1);

        JButton genReport2 = new JButton("Generate Report High to Low");
        reportPanel.add(genReport2);

        panel.add(reportPanel);

        genReport1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateReport("salesman_report_low_to_high.txt", true);
            }
        });

        genReport2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateReport("salesman_report_high_to_low.txt", false);
            }
        });
    }

    private static void generateReport(String fileName, boolean ascending) {
        List<SalesmanModel> salesmenSortedByCarsSold = new ArrayList<>(dbModel.getAllSalesmen());
        if (ascending) {
            salesmenSortedByCarsSold.sort(Comparator.comparingInt(SalesmanModel::getSalesmanTotalSalesUnit));
        } else {
            salesmenSortedByCarsSold.sort(Comparator.comparingInt(SalesmanModel::getSalesmanTotalSalesUnit).reversed());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Salesman Report Sorted by Number of Cars Sold (" + (ascending ? "Lowest to Highest" : "Highest to Lowest") + ")\n");
            writer.write("---------------------------------------------------------------\n");
            for (SalesmanModel salesman : salesmenSortedByCarsSold) {
                salesman.calculateGrossSalary();
                salesman.calculateEPF();
                salesman.calculateIncomeTax();
                salesman.calculateNetSalary();
                writer.write(String.format("Name: %s, Staff ID: %s, IC Number: %s, Bank Account: %s, Total Sales Amount: %.2f, Total Sales Units: %d, Gross Salary: %.2f, EPF: %.2f, Income Tax: %.2f, Net Salary: %.2f\n",
                        salesman.getSalesmanFullName(),
                        salesman.getSalesmanStaffID(),
                        salesman.getSalesmanICNum(),
                        salesman.getSalesmanBankAcc(),
                        salesman.getSalesmanTotalSalesAmount(),
                        salesman.getSalesmanTotalSalesUnit(),
                        salesman.getSalesmanGrossSalary(),
                        salesman.getSalesmanEPF(),
                        salesman.getSalesmanIncomeTax(),
                        salesman.getSalesmanNetSalary()
                ));
            }
            JOptionPane.showMessageDialog(null, "Report generated successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to generate report.");
        }
    }

    private static void loadStoredData() {
        List<SalesmanModel> allSalesmen = new ArrayList<>(dbModel.getAllSalesmen());
        for (SalesmanModel salesman : allSalesmen) {
            // Recalculate the salary attributes
            salesman.calculateGrossSalary();
            salesman.calculateEPF();
            salesman.calculateIncomeTax();
            salesman.calculateNetSalary();
            addRowToTable(salesman);
        }
    }

    private static void addRowToTable(SalesmanModel employee) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
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

    private static void resetForm(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            }
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    private static void sortTableByName() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        TreeSet<SalesmanModel> sortedByName = dbModel.getSortedSalesmenNames();
        for (SalesmanModel employee : sortedByName) {
            employee.calculateGrossSalary();
            employee.calculateEPF();
            employee.calculateIncomeTax();
            employee.calculateNetSalary();
            addRowToTable(employee);
        }
    }

    private static void sortTableByID() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows

        TreeSet<SalesmanModel> sortedByID = dbModel.getSortedSalesmenStaffID();
        for (SalesmanModel employee : sortedByID) {
            employee.calculateGrossSalary();
            employee.calculateEPF();
            employee.calculateIncomeTax();
            employee.calculateNetSalary();
            addRowToTable(employee);
        }
    }

    private static void saveChanges(JPanel panel) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            for (int col : NON_EDITABLE_COLUMNS) {
                if (!model.getValueAt(i, col).toString().equals(getOriginalValue(i, col))) {
                    JOptionPane.showMessageDialog(panel, "Changes to non-editable columns are not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            String empName = model.getValueAt(i, 0).toString();
            String empID = model.getValueAt(i, 1).toString();
            String empICNUM = model.getValueAt(i, 2).toString();
            String empBankNum = model.getValueAt(i, 3).toString();
            double empCarSales = Double.parseDouble(model.getValueAt(i, 4).toString());
            int empCarAmount = Integer.parseInt(model.getValueAt(i, 5).toString());

            SalesmanModel employee = new SalesmanModel(empName, empID, empBankNum, empICNUM, empCarSales, empCarAmount);
            employee.calculateGrossSalary();
            employee.calculateEPF();
            employee.calculateIncomeTax();
            employee.calculateNetSalary();

            dbModel.editSalesman(employee);
        }
        JOptionPane.showMessageDialog(panel, "Changes saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getOriginalValue(int row, int col) {
        // Implement this method to retrieve the original value from the database or a stored copy.
        // For simplicity, let's assume we have a way to get the original value.
        // This is just a placeholder implementation.
        return table.getModel().getValueAt(row, col).toString();
    }

    private static void searchSalesman(String searchTextValue) {
        boolean found = false;  // Flag to check if the salesman is found
        
        for (SalesmanModel salesman : dbModel.getAllSalesmen()) {
            if (salesman.getSalesmanFullName().toLowerCase().contains(searchTextValue.toLowerCase()) || salesman.getSalesmanStaffID().toLowerCase().contains(searchTextValue.toLowerCase())) {
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

    private static void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String staffID = table.getValueAt(selectedRow, 1).toString();
            dbModel.deleteSalesman(staffID);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.removeRow(selectedRow);
        }
    }

    private static void verifyCellEdit() {
        int selectedRow = table.getSelectedRow();
        int selectedColumn = table.getSelectedColumn();

        if (selectedRow == -1 || selectedColumn == -1) {
            JOptionPane.showMessageDialog(null, "Please select a cell to edit.");
            return;
        }

        boolean isEditable = false;
        for (int col : EDITABLE_COLUMNS) {
            if (selectedColumn == col) {
                isEditable = true;
                break;
            }
        }

        if (isEditable) {
            JOptionPane.showMessageDialog(null, "Cell is editable.");
        } else {
            JOptionPane.showMessageDialog(null, "Cell is not editable.");
        }
    }
}

