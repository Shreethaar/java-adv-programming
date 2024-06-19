import java.sql.*;

public class SalesPersonDB {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/payroll_system";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void addSalesman(Salesman salesman) {
        String query = "INSERT INTO salesmen (staffNumber, fullName, monthlySalary, annualSalary, icNumber, bankAccountNumber, totalSalesAmount, numberOfCarsSold) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, salesman.getSalesRepStaffID());
            ps.setString(2, salesman.getSalesRepFullName());
            ps.setDouble(3, salesman.getSalesRepMonthlySalary());
            ps.setDouble(4, salesman.getSalesRepAnnualSalary());
            ps.setString(5, salesman.getSalesRepICNum());
            ps.setString(6, salesman.getSalesRepBankAcc());
            ps.setDouble(7, salesman.getSalesRepTotalSalesAmount());
            ps.setInt(8, salesman.getSalesRepTotalSalesUnit());
            ps.executeUpdate();
            System.out.println("Salesman information saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to save salesman information.");
        }
    }

    public Salesman searchSalesman(String staffNumber) {
        String query = "SELECT * FROM salesmen WHERE staffNumber = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, staffNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Salesman(
                        rs.getString("fullName"),
                        rs.getString("staffNumber"),
                        rs.getString("icNumber"),
                        rs.getString("bankAccountNumber"),
                        rs.getInt("numberOfCarsSold"),
                        rs.getDouble("totalSalesAmount"),
                        rs.getDouble("monthlySalary"),
                        rs.getDouble("annualSalary")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to search for salesman.");
        }
        return null;
    }

    public void viewSalesman(String staffNumber) {
        Salesman salesman = searchSalesman(staffNumber);
        if (salesman != null) {
            System.out.println(salesman);
        } else {
            System.out.println("Salesman not found.");
        }
    }

    public void editSalesman(Salesman salesman) {
        String query = "UPDATE salesmen SET fullName = ?, monthlySalary = ?, annualSalary = ?, icNumber = ?, bankAccountNumber = ?, totalSalesAmount = ?, numberOfCarsSold = ? WHERE staffNumber = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, salesman.getSalesRepFullName());
            ps.setDouble(2, salesman.getSalesRepMonthlySalary());
            ps.setDouble(3, salesman.getSalesRepAnnualSalary());
            ps.setString(4, salesman.getSalesRepICNum());
            ps.setString(5, salesman.getSalesRepBankAcc());
            ps.setDouble(6, salesman.getSalesRepTotalSalesAmount());
            ps.setInt(7, salesman.getSalesRepTotalSalesUnit());
            ps.setString(8, salesman.getSalesRepStaffID());
            ps.executeUpdate();
            System.out.println("Salesman information updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update salesman information.");
        }
    }

    public void deleteSalesman(String staffNumber) {
        String query = "DELETE FROM salesmen WHERE staffNumber = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, staffNumber);
            ps.executeUpdate();
            System.out.println("Salesman deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete salesman.");
        }
    }

    public void reset() {
        String query = "DELETE FROM salesmen";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            System.out.println("System reset successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to reset system.");
        }
    }
}

// Example Salesman class
class Salesman {
    private String fullName;
    private String staffNum;
    private String staffICNum;
    private String staffBankAccNo;
    private int carsSold;
    private double totalSalesAmount;
    private double monthlySalary;
    private double annualSalary;

    public Salesman(String fullName, String staffNum, String staffICNum, String staffBankAccNo,
                    int carsSold, double totalSalesAmount, double monthlySalary, double annualSalary) {
        this.fullName = fullName;
        this.staffNum = staffNum;
        this.staffICNum = staffICNum;
        this.staffBankAccNo = staffBankAccNo;
        this.carsSold = carsSold;
        this.totalSalesAmount = totalSalesAmount;
        this.monthlySalary = monthlySalary;
        this.annualSalary = annualSalary;
    }

    public String getSalesRepFullName() {
        return fullName;
    }

    public String getSalesRepStaffID() {
        return staffNum;
    }

    public String getSalesRepICNum() {
        return staffICNum;
    }

    public String getSalesRepBankAcc() {
        return staffBankAccNo;
    }

    public int getSalesRepTotalSalesUnit() {
        return carsSold;
    }

    public double getSalesRepTotalSalesAmount() {
        return totalSalesAmount;
    }

    public double getSalesRepMonthlySalary() {
        return monthlySalary;
    }

    public double getSalesRepAnnualSalary() {
        return annualSalary;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "fullName='" + fullName + '\'' +
                ", staffNum='" + staffNum + '\'' +
                ", staffICNum='" + staffICNum + '\'' +
                ", staffBankAccNo='" + staffBankAccNo + '\'' +
                ", carsSold=" + carsSold +
                ", totalSalesAmount=" + totalSalesAmount +
                ", monthlySalary=" + monthlySalary +
                ", annualSalary=" + annualSalary +
                '}';
    }
}
