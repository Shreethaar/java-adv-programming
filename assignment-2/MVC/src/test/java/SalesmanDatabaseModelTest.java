import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.*;

public class SalesmanDatabaseModelTest {

    private static final String DB_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    private SalesmanDatabaseModel databaseModel;

    @BeforeEach
    public void setup() {
        databaseModel = new SalesmanDatabaseModel(DB_URL, DB_USER, DB_PASSWORD);

        // Initialize database schema or perform any necessary setup
        initializeDatabaseSchema();
    }

    @AfterEach
    public void cleanup() {
        // Clean up the database after each test
        resetDatabase();
    }

    @Test
    public void testAddSalesman() {
        SalesmanModel salesman = new SalesmanModel("John Doe", "S001", "1234567890", "123456", 10, 50000.0, null, null, "Bank XYZ");
        
        databaseModel.addSalesman(salesman);

        SalesmanModel retrievedSalesman = databaseModel.searchSalesman("S001");
        assertNotNull(retrievedSalesman);
        assertEquals("John Doe", retrievedSalesman.getSalesmanFullName());
        assertEquals("1234567890", retrievedSalesman.getSalesmanICNum());
        assertEquals("123456", retrievedSalesman.getSalesmanBankAcc());
        assertEquals(10, retrievedSalesman.getSalesmanTotalSalesUnit());
        assertEquals(50000.0, retrievedSalesman.getSalesmanTotalSalesAmount());
        assertEquals("Bank XYZ", retrievedSalesman.getSalesmanBankInfo());
    }

    @Test
    public void testEditSalesman() {
        SalesmanModel salesman = new SalesmanModel("Jane Smith", "S002", "0987654321", "654321", 15, 80000.0, null, null, "Bank ABC");
        databaseModel.addSalesman(salesman);

        SalesmanModel retrievedSalesman = databaseModel.searchSalesman("S002");
        assertNotNull(retrievedSalesman);

        // Update sales information
        retrievedSalesman.setSalesmanFullName("Jane Doe");
        retrievedSalesman.setSalesmanBankAcc("999999");

        databaseModel.editSalesman(retrievedSalesman);

        SalesmanModel updatedSalesman = databaseModel.searchSalesman("S002");
        assertNotNull(updatedSalesman);
        assertEquals("Jane Doe", updatedSalesman.getSalesmanFullName());
        assertEquals("0987654321", updatedSalesman.getSalesmanICNum());
        assertEquals("999999", updatedSalesman.getSalesmanBankAcc());
        assertEquals(15, updatedSalesman.getSalesmanTotalSalesUnit());
        assertEquals(80000.0, updatedSalesman.getSalesmanTotalSalesAmount());
        assertEquals("Bank ABC", updatedSalesman.getSalesmanBankInfo());
    }

    @Test
    public void testDeleteSalesman() {
        SalesmanModel salesman = new SalesmanModel("Jack Black", "S003", "1122334455", "777777", 5, 30000.0, null, null, "Bank PQR");
        databaseModel.addSalesman(salesman);

        SalesmanModel retrievedSalesman = databaseModel.searchSalesman("S003");
        assertNotNull(retrievedSalesman);

        // Delete salesman
        databaseModel.deleteSalesman("S003");

        SalesmanModel deletedSalesman = databaseModel.searchSalesman("S003");
        assertNull(deletedSalesman);
    }

    private void initializeDatabaseSchema() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            String createTableSQL = "CREATE TABLE salesmen (" +
                                    "staffNumber VARCHAR(10) PRIMARY KEY," +
                                    "fullName VARCHAR(255) NOT NULL," +
                                    "icNumber VARCHAR(20) NOT NULL," +
                                    "bankAccountNumber VARCHAR(20) NOT NULL," +
                                    "totalSalesAmount DOUBLE NOT NULL," +
                                    "numberOfCarsSold INT NOT NULL," +
                                    "bankInfo VARCHAR(255) NOT NULL" +
                                    ")";
            stmt.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void resetDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {
            String resetTableSQL = "DROP TABLE IF EXISTS salesmen";
            stmt.executeUpdate(resetTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

