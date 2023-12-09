/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.Simulation;

import Business.Platform;
import Business.Supplier.EqOrders;
import Business.UserAccount.UserAccount;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nivcodes
 */
public class MngOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MngOrdersJPanel
     */
    
    private JPanel rightContainer;
    private Platform platform;
    private UserAccount loginAccount;
    
    public MngOrdersJPanel(JPanel rightContainer, Platform platform, UserAccount loginAccount) {
        initComponents();
        this.rightContainer = rightContainer;
        this.platform = platform;
        this.loginAccount = loginAccount;
        populateOrdersTable();
        populateEquipmentCbx();
    }
    
    public void populateOrdersTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblOrderHistory.getModel();
        dtm.setRowCount(0);
        
        for (EqOrders tr : platform.geteOrderManager().getEquipmentOrdersList()) {
            Object[] row = new Object[4];
            row[0] = tr; 
            row[1] = tr.getQuantity();
            row[2] = tr.getStatus();
            row[3] = tr.getRequester();
            dtm.addRow(row);
        }
    }
    
    private void populateEquipmentCbx() {
        DefaultComboBoxModel<Object> dcbm = new DefaultComboBoxModel<>();
        for (String ct : EqOrders.statusOptions) {
            dcbm.addElement(ct);
        }
        cbxDisease.setModel(dcbm);
        cbxDisease.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxDisease = new javax.swing.JComboBox<>();
        lblWelcome1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderHistory = new javax.swing.JTable();
        btnUpdateOrder = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        cbxDisease.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        cbxDisease.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDisease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDiseaseActionPerformed(evt);
            }
        });

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome1.setText("Order List");

        tblOrderHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Qty", "Status", "Employee"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblOrderHistory);

        btnUpdateOrder.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnUpdateOrder.setText("Update");
        btnUpdateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(cbxDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateOrder)
                    .addComponent(cbxDisease, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(196, 196, 196))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxDiseaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDiseaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDiseaseActionPerformed

    private void btnUpdateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrderActionPerformed
        int selectedRow = tblOrderHistory.getSelectedRow();
        EqOrders eoq = new EqOrders();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a testing request!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        eoq = (EqOrders) tblOrderHistory.getValueAt(selectedRow, 0);
        String dpt = (String) cbxDisease.getSelectedItem();
        eoq.setStatus(dpt);
        JOptionPane.showMessageDialog(null, "Updated Successfully!!");
        populateOrdersTable();
    }//GEN-LAST:event_btnUpdateOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateOrder;
    private javax.swing.JComboBox<Object> cbxDisease;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JTable tblOrderHistory;
    // End of variables declaration//GEN-END:variables
}
