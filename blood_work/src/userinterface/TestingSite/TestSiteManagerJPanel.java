/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.TestingSite;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Platform;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nivcodes
 */
public class TestSiteManagerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TestSiteManagerJPanel
     */
    
    private JPanel rightContainer;
    private Platform platform;
    private UserAccount loginAccount;
    private Enterprise enterprise;
    private Organization organization;
    private Role role;
    public TestSiteManagerJPanel(JPanel rightContainer, Platform platform, UserAccount loginAccount) {
        initComponents();
        this.rightContainer = rightContainer;
        this.platform = platform;
        this.loginAccount = loginAccount;
        setValues();
        populateTable();
    }
    public void setValues() {
        this.role = loginAccount.getRole();
        this.enterprise = platform.getEnterpriseDirectory().getEnterpriseByRole(role);
        this.organization = enterprise.getOrganizationDirectory().getOrganizationByRole(role);
    }
    
    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblTestingPendingResult.getModel();
        dtm.setRowCount(0);
        
        for (UserAccount wr : enterprise.getUserAccountDirectory().getActiveUserAccounts()) {
            Object[] row = new Object[5];
            row[0] = wr; 
            row[1] = wr.getEmployee().getAge();
            row[2] = wr.getEmployee().getEmail();
            row[3] = wr.getRole();
            if (!wr.isDeleted()) {
                row[4] = "Active";
            } else {
                row[4] = "Deleted";
            }
            
            dtm.addRow(row);

        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblTestingPendingResult = new javax.swing.JTable();
        lblWelcome1 = new javax.swing.JLabel();
        btnViewDetail1 = new javax.swing.JButton();
        btnSetEnable = new javax.swing.JButton();

        tblTestingPendingResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User name", "Age", "Email", "Role", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTestingPendingResult);

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome1.setText("Employees");

        btnViewDetail1.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnViewDetail1.setText("Delete this account");
        btnViewDetail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetail1ActionPerformed(evt);
            }
        });

        btnSetEnable.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnSetEnable.setText("Enable this account");
        btnSetEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetEnableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSetEnable, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewDetail1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnViewDetail1)
                .addGap(18, 18, 18)
                .addComponent(btnSetEnable)
                .addContainerGap(275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetail1ActionPerformed
        int selectedRow = tblTestingPendingResult.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a testing request!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        UserAccount wr = (UserAccount)tblTestingPendingResult.getValueAt(selectedRow, 0);
        enterprise.getUserAccountDirectory().searchByUsername(wr.getUsername()).deleteThisAccount();
        populateTable();
    }//GEN-LAST:event_btnViewDetail1ActionPerformed

    private void btnSetEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetEnableActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTestingPendingResult.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a testing request!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        UserAccount wr = (UserAccount)tblTestingPendingResult.getValueAt(selectedRow, 0);
        enterprise.getUserAccountDirectory().searchByUsername(wr.getUsername()).enableThisAccount();
        populateTable();
    }//GEN-LAST:event_btnSetEnableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetEnable;
    private javax.swing.JButton btnViewDetail1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JTable tblTestingPendingResult;
    // End of variables declaration//GEN-END:variables
}
