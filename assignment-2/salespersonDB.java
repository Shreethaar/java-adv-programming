import java.sql.*;

public class salespersonDB {
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/payroll_system";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }

    public void addSalesman(Salesman salesman) {
        String query = "INSERT INTO salesman (staffNumber, fullName, month, year, icNumber, bankAccountNumber, totalSalesAmount, numberOfCarsSold) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
                        rs.getString("month"),
                        rs.getString("year"),
                        rs.getInt("icNumber"),
                        rs.getDouble("bankAccountNumber"),
                        rs.getDouble("totalSalesAmount"),
                        rs.getInt("numberOfCarsSold")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to search for salesman.");
        }
        return null;
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


