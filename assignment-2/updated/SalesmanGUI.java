
import java.awt.*;
import javax.swing.*;

public class SalesmanGUI extends javax.swing.JFrame {
    private JTable jtable1;
    private SalesmanTableController salesmanTableController;

    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel salesmanNameLabel;
    private javax.swing.JLabel salesmanIDLabel;
    private javax.swing.JLabel salesmanICNUMLabel;
    private javax.swing.JLabel salesmanBankACCLabel;
    private javax.swing.JLabel salesmanTotalUnitSalesLabel;
    private javax.swing.JLabel salesmanTotalSalesRMLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField salesmanBankACCTextField;
    private javax.swing.JTextField salesmanICNUMTextField;
    private javax.swing.JTextField salesmanIDTextField;
    private javax.swing.JTextField salesmanNameTextField;
    private javax.swing.JTextField salesmanTotalSalesRMTextField;
    private javax.swing.JTextField salesmanTotalUnitSalesTextField;

    public SalesmanGUI() {
        initComponents();
        salesmanTableController = new SalesmanTableController(this);
        addJTable();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        salesmanNameLabel = new javax.swing.JLabel();
        salesmanIDLabel = new javax.swing.JLabel();
        salesmanICNUMLabel = new javax.swing.JLabel();
        salesmanBankACCLabel = new javax.swing.JLabel();
        salesmanTotalUnitSalesLabel = new javax.swing.JLabel();
        salesmanTotalSalesRMLabel = new javax.swing.JLabel();

        salesmanNameTextField = new javax.swing.JTextField();
        salesmanIDTextField = new javax.swing.JTextField();
        salesmanICNUMTextField = new javax.swing.JTextField();
        salesmanBankACCTextField = new javax.swing.JTextField();
        salesmanTotalUnitSalesTextField = new javax.swing.JTextField();
        salesmanTotalSalesRMTextField = new javax.swing.JTextField();

        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        salesmanNameLabel.setText("Salesman Name");
        salesmanIDLabel.setText("Salesman ID");
        salesmanICNUMLabel.setText("Salesman IC Number");
        salesmanBankACCLabel.setText("Salesman Bank Acc Number");
        salesmanTotalUnitSalesLabel.setText("Salesman Total Unit Sales");
        salesmanTotalSalesRMLabel.setText("Salesman Total Sales RM");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salesmanNameLabel)
                    .addComponent(salesmanIDLabel)
                    .addComponent(salesmanICNUMLabel)
                    .addComponent(salesmanBankACCLabel)
                    .addComponent(salesmanTotalUnitSalesLabel)
                    .addComponent(salesmanTotalSalesRMLabel))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salesmanNameTextField)
                    .addComponent(salesmanIDTextField)
                    .addComponent(salesmanICNUMTextField)
                    .addComponent(salesmanBankACCTextField)
                    .addComponent(salesmanTotalUnitSalesTextField)
                    .addComponent(salesmanTotalSalesRMTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(81, 81, 81)
                .addComponent(deleteButton)
                .addGap(70, 70, 70)
                .addComponent(updateButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesmanNameLabel)
                    .addComponent(salesmanNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesmanIDLabel)
                    .addComponent(salesmanIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesmanICNUMLabel)
                    .addComponent(salesmanICNUMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesmanBankACCLabel)
                    .addComponent(salesmanBankACCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesmanTotalUnitSalesLabel)
                    .addComponent(salesmanTotalUnitSalesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesmanTotalSalesRMLabel)
                    .addComponent(salesmanTotalSalesRMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String name = salesmanNameTextField.getText();
        String id = salesmanIDTextField.getText();
        String icNum = salesmanICNUMTextField.getText();
        String bankAcc = salesmanBankACCTextField.getText();
        String unit = salesmanTotalUnitSalesTextField.getText();
        String totalSales = salesmanTotalSalesRMTextField.getText();

        Object[] array = {name, id, icNum, bankAcc, unit, totalSales};
        salesmanTableController.addRow(array);
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jtable1.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                CachedRowSet rowSet = salesmanTableController.getTableModel().getRowSet();
                rowSet.absolute(selectedRow + 1);
                Object[] array = {rowSet.getString("salesman_name"),
                        rowSet.getString("salesman_id"),
                        rowSet.getString("salesman_icNum"),
                        rowSet.getString("salesman_bankAcc"),
                        rowSet.getString("salesman_totalUnitSales"),
                        rowSet.getString("salesman_totalSalesRM")};
                salesmanTableController.deleteRow(array);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jtable1.getSelectedRow();
        if (selectedRow >= 0) {
            String name = salesmanNameTextField.getText();
            String id = salesmanIDTextField.getText();
            String icNum = salesmanICNUMTextField.getText();
            String bankAcc = salesmanBankACCTextField.getText();
            String unit = salesmanTotalUnitSalesTextField.getText();
            String totalSales = salesmanTotalSalesRMTextField.getText();

            Object[] array = {name, id, icNum, bankAcc, unit, totalSales};
            salesmanTableController.updateRow(array, jtable1);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to update.", "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesmanGUI().setVisible(true);
            }
        });
    }
}
