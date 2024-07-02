import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class SalesmanDatabaseModel {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/payroll_system";
    private static final String DB_USER = "dbuser";
    private static final String DB_PASSWORD = "password";

    private TreeSet<SalesmanModel> salesmenSet;
    public SalesmanDatabaseModel() {
        salesmenSet = new TreeSet<>(new SalesmanNameComparator());
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void addSalesman(SalesmanModel salesman) {
        salesmenSet.add(salesman);

        String query = "INSERT INTO salesmen (salesmanFullName, salesmanStaffID, salesmanICNum, salesmanBankAcc, salesmanTotalSalesAmount, salesmanTotalSalesUnit) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, salesman.getSalesmanFullName());
            ps.setString(2, salesman.getSalesmanStaffID());
            ps.setString(3, salesman.getSalesmanICNum());
            ps.setString(4, salesman.getSalesmanBankAcc());
            ps.setDouble(5, salesman.getSalesmanTotalSalesAmount());
            ps.setInt(6, salesman.getSalesmanTotalSalesUnit());
            ps.executeUpdate();
            System.out.println("Salesman information saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to save salesman information.");
        }
    }

    public SalesmanModel searchSalesman(String staffID) {
       String query = "SELECT * FROM salesmen WHERE salesmanStaffID = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, staffID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new SalesmanModel(
                        rs.getString("salesmanFullName"),
                        rs.getString("salesmanStaffID"),
                        rs.getString("salesmanICNum"),
                        rs.getString("salesmanBankAcc"),
                        rs.getDouble("salesmanTotalSalesAmount"),
                        rs.getInt("salesmanTotalSalesUnit")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to search for salesman.");
        }
        return null;
    }
    public void editSalesman(SalesmanModel salesman) {
        String query = "UPDATE salesmen SET salesmanFullName = ?, salesmanICNum = ?, salesmanBankAcc = ?, salesmanTotalSalesAmount = ?, salesmanTotalSalesUnit = ? WHERE salesmanStaffID = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, salesman.getSalesmanFullName());
            ps.setString(2, salesman.getSalesmanICNum());
            ps.setString(3, salesman.getSalesmanBankAcc());
            ps.setDouble(4, salesman.getSalesmanTotalSalesAmount());
            ps.setInt(5, salesman.getSalesmanTotalSalesUnit());
            ps.setString(6, salesman.getSalesmanStaffID());
            ps.executeUpdate();
            System.out.println("Salesman information updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to update salesman information.");
        }
    }
    public void deleteSalesman(String staffID) {
        salesmenSet.removeIf(s -> s.getSalesmanStaffID().equals(staffID));

        String query = "DELETE FROM salesmen WHERE salesmanStaffID = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, staffID);
            ps.executeUpdate();
            System.out.println("Salesman deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete salesman.");
        }
    }

    public void reset() {
        salesmenSet.clear();

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

    public TreeSet<SalesmanModel> getAllSalesmen() {
        salesmenSet.clear();
        String query = "SELECT * FROM salesmen";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                SalesmanModel salesman = new SalesmanModel(
                        rs.getString("salesmanFullName"),
                        rs.getString("salesmanStaffID"),
                        rs.getString("salesmanICNum"),
                        rs.getString("salesmanBankAcc"),
                        rs.getDouble("salesmanTotalSalesAmount"),
                        rs.getInt("salesmanTotalSalesUnit")
                );
                salesmenSet.add(salesman);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to retrieve salesmen.");
        }
        return salesmenSet;
    }
}
