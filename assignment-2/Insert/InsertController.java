public class InsertController {
    private PayRoll payRollSys;
    private InsertGUI insertGUI;

    public InsertController(PayRoll payRollSys) {
        this.payRollSys = payRollSys;
        this.insertGUI = new InsertGUI(this);
    }

    public void handleInsert(String fullName, String staffNum, String staffICNum, String staffBankAccNo,
                             String monthlySalaryStr, String annualSalaryStr, String totalSalesAmountStr, String carsSoldStr) {
        try {
            // Parse the input values
            double monthlySalary = Double.parseDouble(monthlySalaryStr);
            double annualSalary = Double.parseDouble(annualSalaryStr);
            double totalSalesAmount = Double.parseDouble(totalSalesAmountStr);
            int carsSold = Integer.parseInt(carsSoldStr);

            // Create a new Salesman object
            Salesman salesman = new Salesman(fullName, staffNum, staffICNum, staffBankAccNo, carsSold, totalSalesAmount, monthlySalary, annualSalary);

            // Insert the salesman into the PayRoll system
            payRollSys.insertSalesRep(salesman);

            // Clear the input fields
            insertGUI.clearFields();

            // Show success message
            insertGUI.showOutput("Salesman added successfully.");
        } catch (NumberFormatException ex) {
            // Show error message if input is invalid
            insertGUI.showOutput("Invalid input. Please check the data entered.");
        }
    }
}

