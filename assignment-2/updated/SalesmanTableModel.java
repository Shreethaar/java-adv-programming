import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import javax.sql.*;
import javax.sql.rowset.*;

public class SalesmanTableModel extends AbstractTableModel {
    CachedRowSet salesmanListRowSet;
    ResultSetMetaData metadata;
    Connection connection;
    Statement statement;
    int numcols, numrows;


    public SalesmanTableModel() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/payroll_system","dbuser","password");
        }
        catch(SQLException sqlerr) {
            System.out.println(sqlerr.getMessage());
            System.out.println(sqlerr.getSQLState());
            System.out.println(sqlerr.getErrorCode());
        }

        System.out.println("Connected Successfully");

        try {
            connection.setAutoCommit(false);
            salesmanListRowSet=new CachedRowSetImpl();
            salesmanListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            salesmanListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            salesmanListRowSet.setCommand("SELECT * FROM salesmen");
            salesmanListRowSet.execute(connection);
            metadata=salesmanListRowSet.getMetaData();
            numcols=metadata.getColumnCount();
            numrows=salesmanListRowSet.size();
            salesmanListRowSet.first();
        }
        catch(SQLException exp) {
            exp.printStackTrace();
        }
    }

    public SalesmanTableModel(RowSet rowset, Connection conn) {
        try {
            salesmanListRowSet=(CachedRowSet) rowSet;
            salesmanListRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            salesmanListRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            metadata=salesmanListRowSet.getMetaData();
            numcols=metadata.getColumnCount();
            numrows=salesmanListRowSet.size();
            connection = conn;
        }
        catch(SQLException exp) {
            exp.printStackTrace();
        }
    }
    public int getRowCount(){
        return numrows;
    }

    public int getColumnCount() {
        return numcols;
    }

    public Object getValueAt(int row, int col) {
        try {
            if(row >= salesmanListRowSet.size())
                return null;
            salesmanListRowSet.absolute(row+1);
            Object obj=salesmanListRowSet.getObject(col+1);
            if(obj==null){
                return null;
            }
            else {
                return obj.toString();
            }
        }
        catch(SQLException err) {
            err.printStackTrace();
            return err.toString();
        }
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public String getColumnName(int col) {
        try {
            return metadata.getColumnLable(col+1);
        }
        catch(SQLException err) {
            return err.toString();
        }
    }

    public void setvalueAt(Object avalue, int row, int col) {
        try {
            salesmanListRowSet.moveToInsertRow();
            System.out.println(aValue + " setValueAt " + (row+1) + " " + (col+1));
            salesmanListRowSet.updateObject(col+1,(String) aValue);
        }
        catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }

    public boolean isPrimaryKeyInDB(Object[] array) {
        try {
            if(getRowCount()==0) {
                return false;
            }
            salesmanListRowSet.beforeFirst();
            while(salesmanListRowSet.next()) {
                if(salesmanListRowSet.getString("salesman_id").equals(array[1])) {
                    return true;
                }
                return false;
            }
        }
        catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
            return false;
        }
    }

    public void addRow(Object[] array) {
        try {
            if(!isValidEnrollmentField(array)) {
                return;
            }
            if(!isPrimaryKeyInDB(array)) {
                salesmanListRowSet.last();
                salesmanListRowSet.moveToInsertRow();
                salesmanListRowSet.updateString("salesman_name",(String) array[0]);
                salesmanListRowSet.updateString("salesman_id",(String) array[1]);
                salesmanListRowSet.updateString("salesman_icNum",(String) array[2]);
                salesmanListRowSet.updateString("salesman_bankAcc",(String) array[3]);
                salesmanListRowSet.updateInt("salesman_totalUnitSales",Integer.valueOf((String) array[4]).intValue());
                salesmanListRowSet.updateDouble("salesman_totalSalesRM",Double.valueOf((String) array[5]).doubleValue());
                salesmanList.insertRow();
                salesmanList.moveToCurrentRow();
                salesmanList.acceptChanges(connection);
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Cannot have multiple records with the same primary key (salesman_id).", "Primary Key Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }

    public void deleteRow(Object[] array) {
        try {
            salesmanListRowSet.next();
            while(salesmanListRowSet.next()) {
                if(salesmanListRowSet.getString("salesman_id").equals(array[1])) {
                    salesmanListRowSet.deleteRow();
                    break;
                }
            }
            salesmanListRowSet.acceptChanges(connection);
        }
        catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }
    public void updateRow(Object[] array, JTable jtable) {
        try {
            if(jtable.getSelectedRow()==-1) {
                return;
            }
            if(!isValidEnrollmentField(array)) {
                return;
            }
            salesmanListRowSet.absolute(jtable.getSelectedRow()+1);
            String selectedSalesmanID=salesmanListRowSet.getString("salesman_id");
            String desiredSalesmanID=(String) array[1];

            if (!isPrimaryKeyInDB(array) || desiredCourseNumber.equals(selectedSalesmanID)) {
                salesmanListRowSet.absolute(jtable.getSelectedRow() + 1);
                salesmanListRowSet.updateString("salesman_name", (String) array[0]);
                salesmanListRowSet.updateString("salesman_id",(String) array[1]);
                salesmanListRowSet.updateString("salesman_icNum",(String) array[2]);
                salesmanListRowSet.updateString("salesman_bankAcc",(String) array[3]);
                salesmanListRowSet.updateInt("salesman_totalUnitSales",Integer.valueOf((String) array[4]).intValue());
                salesmanListRowSet.updateDouble("salesman_totalSalesRM",Double.valueOf((String) array[5]).doubleValue());
                salesmanListRowSet.updateRow();
                salesmanListRowSet.first();
                salesmanListRowSet.acceptChanges(connection);
                return;
            }

            JOptionPane.showMessageDialog(null,
                    "Cannot have multiple records with primary key (salesman_id).",
                    "Primary Key Error",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException err) {
            err.getMessage();
            err.printStackTrace();
        }
    }

    public CachedRowSet getRowSet() {
        return salesmanListRowSet;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isTotalUnitSalesField(Object[] array) {
        try {
            Integer.valueOf((String) array[4]).intValue();
            return true;
        }
        catch(NumberFormatException err) {
            JOptionPane.showMessageDialog(null,
                    "Total Sales Unit must be an integer.",
                    "Number Format Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
    public static void main(String[] args) {
        SalesmanGUI salesmanGUI = new SalesmanGUI();
        SalesmanGUI.setVisible(true);
    }
}
