import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertGUI extends JFrame {
    private JTextField fullNameField;
    private JTextField staffNumField;
    private JTextField staffICNumField;
    private JTextField staffBankAccNoField;
    private JTextField monthlySalaryField;
    private JTextField annualSalaryField;
    private JTextField totalSalesAmountField;
    private JTextField carsSoldField;
    private JTextArea outputArea;
    private JButton insertButton;

    private InsertController insertController;

    public InsertGUI(InsertController insertController) {
        this.insertController = insertController;

        // Setting the title of the JFrame
        setTitle("Insert Salesman Information");

        // Setting the default close operation to exit the application
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Setting the preferred size of the JFrame
        setPreferredSize(new Dimension(400, 600));

        // Creating a panel to hold main content
        JPanel contentPanel = new JPanel(new GridLayout(10, 2, 10, 10));

        // Creating and adding labels and text fields
        contentPanel.add(new JLabel("Full Name:"));
        fullNameField = new JTextField();
        contentPanel.add(fullNameField);

        contentPanel.add(new JLabel("Staff Number:"));
        staffNumField = new JTextField();
        contentPanel.add(staffNumField);

        contentPanel.add(new JLabel("Staff IC Number:"));
        staffICNumField = new JTextField();
        contentPanel.add(staffICNumField);

        contentPanel.add(new JLabel("Staff Bank Account Number:"));
        staffBankAccNoField = new JTextField();
        contentPanel.add(staffBankAccNoField);

        contentPanel.add(new JLabel("Monthly Salary:"));
        monthlySalaryField = new JTextField();
        contentPanel.add(monthlySalaryField);

        contentPanel.add(new JLabel("Annual Salary:"));
        annualSalaryField = new JTextField();
        contentPanel.add(annualSalaryField);

        contentPanel.add(new JLabel("Total Sales Amount:"));
        totalSalesAmountField = new JTextField();
        contentPanel.add(totalSalesAmountField);

        contentPanel.add(new JLabel("Cars Sold:"));
        carsSoldField = new JTextField();
        contentPanel.add(carsSoldField);

        // Creating and adding the output area
        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Creating and adding the insert button
        insertButton = new JButton("Insert");

        // Adding components to the main panel
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
        add(insertButton, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.NORTH);

        // Action listener for the insert button
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertController.handleInsert(
                        fullNameField.getText(),
                        staffNumField.getText(),
                        staffICNumField.getText(),
                        staffBankAccNoField.getText(),
                        monthlySalaryField.getText(),
                        annualSalaryField.getText(),
                        totalSalesAmountField.getText(),
                        carsSoldField.getText()
                );
            }
        });

        // Setting the frame to be visible
        pack();
        setVisible(true);

        // Setting the frame location to the center of the screen
        setLocationRelativeTo(null);
    }

    public void showOutput(String message) {
        outputArea.append(message + "\n");
    }

    public void clearFields() {
        fullNameField.setText("");
        staffNumField.setText("");
        staffICNumField.setText("");
        staffBankAccNoField.setText("");
        monthlySalaryField.setText("");
        annualSalaryField.setText("");
        totalSalesAmountField.setText("");
        carsSoldField.setText("");
    }
}
