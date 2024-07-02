import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesmanView {

    private static SalesmanDatabaseModel dbModel = new SalesmanDatabaseModel();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Salary Calculator");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Employee Name:");
        nameLabel.setBounds(10, 20, 160, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(180, 20, 165, 25);
        panel.add(nameText);

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(10, 50, 160, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(180, 50, 165, 25);
        panel.add(idText);

        JLabel monthYearLabel = new JLabel("Month Year:");
        monthYearLabel.setBounds(10, 80, 160, 25);
        panel.add(monthYearLabel);

        JTextField monthYearText = new JTextField(20);
        monthYearText.setBounds(180, 80, 165, 25);
        panel.add(monthYearText);

        JLabel icNumberLabel = new JLabel("IC Number:");
        icNumberLabel.setBounds(10, 110, 160, 25);
        panel.add(icNumberLabel);

        JTextField icNumberText = new JTextField(20);
        icNumberText.setBounds(180, 110, 165, 25);
        panel.add(icNumberText);

        JLabel bankAccountNumberLabel = new JLabel("Bank Account Number:");
        bankAccountNumberLabel.setBounds(10, 140, 160, 25);
        panel.add(bankAccountNumberLabel);

        JTextField bankAccountNumberText = new JTextField(20);
        bankAccountNumberText.setBounds(180, 140, 165, 25);
        panel.add(bankAccountNumberText);

        JLabel totalCarSalesLabel = new JLabel("Total Car Sales:");
        totalCarSalesLabel.setBounds(10, 170, 160, 25);
        panel.add(totalCarSalesLabel);

        JTextField totalCarSalesText = new JTextField(20);
        totalCarSalesText.setBounds(180, 170, 165, 25);
        panel.add(totalCarSalesText);

        JLabel numberOfCarsSoldLabel = new JLabel("Number of Cars Sold:");
        numberOfCarsSoldLabel.setBounds(10, 200, 160, 25);
        panel.add(numberOfCarsSoldLabel);

        JTextField numberOfCarsSoldText = new JTextField(20);
        numberOfCarsSoldText.setBounds(180, 200, 165, 25);
        panel.add(numberOfCarsSoldText);

        JButton calculateButton = new JButton("Calculate Salary");
        calculateButton.setBounds(10, 230, 160, 25);
        panel.add(calculateButton);

        // Table to display the results
        String[] columnNames = {"Full Name", "Staff Number", "IC Number", "Bank Account Number", "Gross Salary", "EPF", "Income Tax", "Net Salary"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 270, 760, 150);
        panel.add(scrollPane);

        // Add search and delete components
        JLabel searchLabel = new JLabel("Search (Name/ID):");
        searchLabel.setBounds(10, 430, 160, 25);
        panel.add(searchLabel);

        JTextField searchText = new JTextField(20);
        searchText.setBounds(180, 430, 165, 25);
        panel.add(searchText);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(350, 430, 100, 25);
        panel.add(searchButton);

        JButton deleteButton = new JButton("Delete Selected Row");
        deleteButton.setBounds(460, 430, 160, 25);
        panel.add(deleteButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String empName = nameText.getText();
                String empID = idText.getText();
                String empICNUM = icNumberText.getText();
                String empBankNum = bankAccountNumberText.getText();
                double empCarSales = Double.parseDouble(totalCarSalesText.getText());
                int empCarAmount = Integer.parseInt(numberOfCarsSoldText.getText());

                SalesmanModel employee = new SalesmanModel(empName, empID, empBankNum, empICNUM, empCarSales, empCarAmount);
                employee.calculateGrossSalary();
                employee.calculateEPF();
                employee.calculateIncomeTax();
                employee.calculateNetSalary();

                // Add employee to the database
                dbModel.addSalesman(employee);

                // Update the table with the calculated values
                Object[] row = {empName, empID, empICNUM, empBankNum, String.format("%.2f", employee.getSalesmanGrossSalary()), String.format("%.2f", employee.getSalesmanEPF()), String.format("%.2f", employee.getSalesmanIncomeTax()), String.format("%.2f", employee.getSalesmanNetSalary())};
                model.addRow(row);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTextValue = searchText.getText().toLowerCase();
                for (SalesmanModel salesman : dbModel.getAllSalesmen()) {
                    if (salesman.getSalesmanFullName().toLowerCase().contains(searchTextValue) || salesman.getSalesmanStaffID().toLowerCase().contains(searchTextValue)) {
                        // Select row in the table
                        for (int i = 0; i < table.getRowCount(); i++) {
                            if (table.getValueAt(i, 0).equals(salesman.getSalesmanFullName()) && table.getValueAt(i, 1).equals(salesman.getSalesmanStaffID())) {
                                table.setRowSelectionInterval(i, i);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String staffID = model.getValueAt(selectedRow, 1).toString();
                    // Remove employee from the database
                    dbModel.deleteSalesman(staffID);
                    // Remove row from the table
                    model.removeRow(selectedRow);
                }
            }
        });
    }
}
