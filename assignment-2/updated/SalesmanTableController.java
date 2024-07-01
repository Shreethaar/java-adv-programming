
import javax.sql.rowset.CachedRowSet;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SalesmanTableController implements ListSelectionListener {
    private SalesmanGUI salesmanGUI;
    private SalesmanTableModel salesmanTableModel;
    private Connection connection;

    public SalesmanTableController(SalesmanGUI salesmanGUI) {
        this.salesmanGUI = salesmanGUI;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/payroll_system", "dbuser", "password");
            salesmanTableModel = new SalesmanTableModel(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SalesmanTableModel getTableModel() {
        return salesmanTableModel;
    }

    public void addRow(Object[] array) {
        salesmanTableModel.addRow(array);
        salesmanGUI.updateTable();
    }

    public void deleteRow(Object[] array) {
        salesmanTableModel.deleteRow(array);
        salesmanGUI.updateTable();
    }

    public void updateRow(Object[] array, JTable jtable) {
        salesmanTableModel.updateRow(array, jtable);
        salesmanGUI.updateTable();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = salesmanGUI.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                try {
                    CachedRowSet rowSet = salesmanTableModel.getRowSet();
                    rowSet.absolute(selectedRow + 1);
                    salesmanGUI.setSalesmanNameTextField(rowSet.getString("salesman_name"));
                    salesmanGUI.setSalesmanIDTextField(rowSet.getString("salesman_id"));
                    salesmanGUI.setSalesmanICNUMTextField(rowSet.getString("salesman_icNum"));
                    salesmanGUI.setSalesmanBankACCTextField(rowSet.getString("salesman_bankAcc"));
                    salesmanGUI.setSalesmanTotalUnitSalesTextField(rowSet.getString("salesman_totalUnitSales"));
                    salesmanGUI.setSalesmanTotalSalesRMTextField(rowSet.getString("salesman_totalSalesRM"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
