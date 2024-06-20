import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.time.Year;
import java.time.YearMonth;

public class TestSalesmanModel {
    
    @Test
    public void testCalculateNetSalary_Scenario1() {
        SalesmanModel salesman = new SalesmanModel("John Doe", "S12345", "987654321", "1234567890", 5, 150000.0, YearMonth.of(2024, 6), Year.of(2024), "Bank Info");
        assertEquals(3900.0, salesman.getGrossSalary(), 0.01); // base salary + car body commission + incentive commission
        assertEquals(31.2, salesman.getMonthlyIncomeTax(), 0.01); // income tax
        assertEquals(429.0, salesman.getEPF(), 0.01); // EPF
        assertEquals(3439.8, salesman.getNetSalary(), 0.01); // net salary
    }

    @Test
    public void testCalculateNetSalary_Scenario2() {
        SalesmanModel salesman = new SalesmanModel("Jane Smith", "S12346", "123456789", "0987654321", 1, 45000.0, YearMonth.of(2024, 6), Year.of(2024), "Bank Info");
        assertEquals(1950.0, salesman.getGrossSalary(), 0.01); // base salary + car body commission + incentive commission
        assertEquals(0.0, salesman.getMonthlyIncomeTax(), 0.01); // income tax
        assertEquals(214.5, salesman.getEPF(), 0.01); // EPF
        assertEquals(1735.5, salesman.getNetSalary(), 0.01); // net salary
    }

    @Test
    public void testCalculateNetSalary_Scenario3() {
        SalesmanModel salesman = new SalesmanModel("Alice Johnson", "S12347", "234567890", "5678901234", 20, 300000.0, YearMonth.of(2024, 6), Year.of(2024), "Bank Info");
        assertEquals(6600.0, salesman.getGrossSalary(), 0.01); // base salary + car body commission + incentive commission
        assertEquals(447.6, salesman.getMonthlyIncomeTax(), 0.01); // income tax
        assertEquals(726.0, salesman.getEPF(), 0.01); // EPF
        assertEquals(5426.4, salesman.getNetSalary(), 0.01); // net salary
    }

    @Test
    public void testCalculateNetSalary_Scenario4() {
        SalesmanModel salesman = new SalesmanModel("Bob Brown", "S12348", "345678901", "6789012345", 0, 0.0, YearMonth.of(2024, 6), Year.of(2024), "Bank Info");
        assertEquals(1500.0, salesman.getGrossSalary(), 0.01); // base salary + car body commission + incentive commission
        assertEquals(0.0, salesman.getMonthlyIncomeTax(), 0.01); // income tax
        assertEquals(165.0, salesman.getEPF(), 0.01); // EPF
        assertEquals(1335.0, salesman.getNetSalary(), 0.01); // net salary
    }

    @Test
    public void testCalculateNetSalary_Scenario5() {
        SalesmanModel salesman = new SalesmanModel("Eve Davis", "S12349", "456789012", "7890123456", 10, 200000.0, YearMonth.of(2024, 6), Year.of(2024), "Bank Info");
        assertEquals(4200.0, salesman.getGrossSalary(), 0.01); // base salary + car body commission + incentive commission
        assertEquals(331.0, salesman.getMonthlyIncomeTax(), 0.01); // income tax
        assertEquals(462.0, salesman.getEPF(), 0.01); // EPF
        assertEquals(3407.0, salesman.getNetSalary(), 0.01); // net salary
    }
}

