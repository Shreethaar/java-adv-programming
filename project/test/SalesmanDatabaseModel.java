import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class SalesmanDatabaseModel {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/salesmen";
    private static final String DB_USER = "trevorphilips";
    private static final String DB_PASSWORD = "password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void addSalesman(SalesmanModel salesman) {
        salesman.calculateGrossSalary();
        salesman.calculateEPF();
        salesman.calculateIncomeTax();
        salesman.calculateNetSalary();

        String query = "INSERT INTO salesmen (salesmanFullName, salesmanStaffID, salesmanICNum, salesmanBankAcc, salesmanTotalSalesAmount, salesmanTotalSalesUnit, grossSalary, epf, incomeTax, netSalary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, salesman.getSalesmanFullName());
            ps.setString(2, salesman.getSalesmanStaffID());
            ps.setString(3, salesman.getSalesmanICNum());
            ps.setString(4, salesman.getSalesmanBankAcc());
            ps.setDouble(5, salesman.getSalesmanTotalSalesAmount());
            ps.setInt(6, salesman.getSalesmanTotalSalesUnit());
            ps.setDouble(7, salesman.getSalesmanGrossSalary());
            ps.setDouble(8, salesman.getSalesmanEPF());
            ps.setDouble(9, salesman.getSalesmanIncomeTax());
            ps.setDouble(10, salesman.getSalesmanNetSalary());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salesman information saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to save salesman information. Error: " + e.getMessage());
        }
    }

    public SalesmanModel searchSalesman(String staffID) {
        String query = "SELECT * FROM salesmen WHERE salesmanStaffID = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            ps.setString(1, staffID);
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
            JOptionPane.showMessageDialog(null, "Failed to search for salesman. Error: " + e.getMessage());
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
            JOptionPane.showMessageDialog(null, "Salesman information updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to update salesman information. Error: " + e.getMessage());
        }
    }

    public void deleteSalesman(String staffID) {
        String query = "DELETE FROM salesmen WHERE salesmanStaffID = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, staffID);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salesman deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete salesman. Error: " + e.getMessage());
        }
    }

    public void reset() {
        String query = "DELETE FROM salesmen";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "System reset successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to reset system. Error: " + e.getMessage());
        }
    }

    public TreeSet<SalesmanModel> getAllSalesmen() {
        TreeSet<SalesmanModel> salesmenSet = new TreeSet<>(new SalesmanIDComparator());
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
            JOptionPane.showMessageDialog(null, "Failed to retrieve salesmen. Error: " + e.getMessage());
        }
        return salesmenSet;
    }

    public TreeSet<SalesmanModel> getSortedSalesmenNames() {
        TreeSet<SalesmanModel> sortedSalesmen = new TreeSet<>(new SalesmanNameComparator());
        sortedSalesmen.addAll(getAllSalesmen());
        return sortedSalesmen;
    }

    public TreeSet<SalesmanModel> getSortedSalesmenStaffID() {
        TreeSet<SalesmanModel> sortedSalesmen = new TreeSet<>(new SalesmanIDComparator());
        sortedSalesmen.addAll(getAllSalesmen());
        return sortedSalesmen;
    }
}

