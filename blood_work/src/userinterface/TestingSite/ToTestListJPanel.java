/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TestingSite;

import Business.Enterprise.Enterprise;
import Business.Platform;
import Business.UserAccount.UserAccount;
import Business.Util.EmailToolKit;
import Business.WorkQueue.TestRequest;
import Business.WorkQueue.TestSlotRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nivcodes
 */
public class ToTestListJPanel extends javax.swing.JPanel {

    private JPanel rightContainer;
    private Platform platform;
    private UserAccount loginAccount;
    private TestSlotRequest selectedSlot;
    
    public ToTestListJPanel(JPanel rightContainer, Platform platform, UserAccount loginAccount) {
        initComponents();
        this.rightContainer = rightContainer;
        this.platform = platform;
        this.loginAccount = loginAccount;
        populateSlotTable();
    }
    
    private void populateSlotTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblTestableSlots.getModel();
        dtm.setRowCount(0);
        
        Enterprise enterprise = platform.getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.TestingSite);
        if (enterprise != null) {
            WorkQueue orderQueue = enterprise.getWorkQueue();
        }else {
            JOptionPane.showMessageDialog(null, "Error, the TestingSite enterpirse does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (enterprise.getWorkQueue().getWorkRequestList().size() != 0) {
            List<TestSlotRequest> list = new ArrayList<>();
            for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()) {
                if (request instanceof TestSlotRequest) {
                    TestSlotRequest r = (TestSlotRequest) request;
                    if (!r.isCancelled() && r.isSampleCollectionCompleted() && (r.calcBookedRequestsHistorically() - r.calcBookCancelledRequests()) > 0 && !r.isNucleicAcidTestCompleted()) {
                        list.add(r);
                    }
                }
            }
            for (TestSlotRequest tsr : list) {
                Object[] row = new Object[7];
                row[0] = tsr.getScheduledTestingDate().toString(); 
                row[1] = tsr.getCapacity();
                row[2] = tsr;  // toString() return status
                row[3] = tsr.calcBookedRequestsHistorically() - tsr.calcBookCancelledRequests();
                row[4] = tsr.calcBookCancelledRequests(); 
                row[5] = tsr.calcAbsentRequests();
                row[6] = tsr.calcPositiveRequests();
                dtm.addRow(row);
            }
        }
    }
    
    private void populateCollectableTestingRequestTable(TestSlotRequest tsr) {
        DefaultTableModel dtm = (DefaultTableModel) tblTestableTestReqeusts.getModel();
        dtm.setRowCount(0);
        
        for (WorkRequest wr : tsr.getTestRequestList()) {
            TestRequest tr = (TestRequest) wr;
            if (tr.bookedButHasntTest()) {
                Object[] row = new Object[4];
                row[0] = tr; 
                row[1] = tr.getSampleCollector();
                row[2] = tr.getNucleicAcidTester();
                if (tr.getNucleicAcidTestDate() == null) {
                    row[3] = "";
                }else {
                    row[3] = tr.isPositive() == true ? "Positive" : "Negative";
                }
                dtm.addRow(row);
            }
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

        btnStartTesting = new javax.swing.JButton();
        lblWelcome1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTestableTestReqeusts = new javax.swing.JTable();
        btnPositive = new javax.swing.JButton();
        btnCompleteTesting = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTestableSlots = new javax.swing.JTable();
        btnNegative = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        btnStartTesting.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnStartTesting.setText("Start Testing");
        btnStartTesting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTestingActionPerformed(evt);
            }
        });

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome1.setText("Test Requests");

        tblTestableTestReqeusts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Sample Collector", "Nucleic Acid Tester", "Test Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTestableTestReqeusts);

        btnPositive.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnPositive.setText("Positive");
        btnPositive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPositiveActionPerformed(evt);
            }
        });

        btnCompleteTesting.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnCompleteTesting.setText("Completion Testing");
        btnCompleteTesting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteTestingActionPerformed(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("Upcoming slots");

        tblTestableSlots.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Scheduled Testing Date", "Testing Capacity", "Status", "Still Booked Requests", "Book Cancelled Requests", "Absent Requests", "Positive People"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTestableSlots);

        btnNegative.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnNegative.setText("Negative");
        btnNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegativeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNegative)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPositive))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCompleteTesting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStartTesting))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartTesting)
                    .addComponent(btnCompleteTesting))
                .addGap(47, 47, 47)
                .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPositive)
                    .addComponent(btnNegative))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartTestingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTestingActionPerformed
        int selectedRow = tblTestableSlots.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a slot!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        TestSlotRequest tsr = (TestSlotRequest)tblTestableSlots.getValueAt(selectedRow, 2);
        selectedSlot = tsr;
        populateCollectableTestingRequestTable(tsr);
        tsr.markIsNucleicAcidTesting();
    }//GEN-LAST:event_btnStartTestingActionPerformed

    private void btnPositiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPositiveActionPerformed
        int selectedRow = tblTestableTestReqeusts.getSelectedRow();
            
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a testing request!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TestRequest tr = (TestRequest)tblTestableTestReqeusts.getValueAt(selectedRow, 0);

        tr.markPositive(loginAccount);
        platform.getMsgDirectory().addMessageRequest(loginAccount, tr.getTestingPeople(), "You have tested positive for this test. kindly check");
        JOptionPane.showMessageDialog(null, "Test Successfully!!");

        populateSlotTable();
        populateCollectableTestingRequestTable(selectedSlot);
        try {
            EmailToolKit.sendEmailWhenTestResultReleased(platform, tr, "POSITIVE");
        } catch (Exception ex) {
            Logger.getLogger(ToTestListJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPositiveActionPerformed

    private void btnCompleteTestingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteTestingActionPerformed
        if (tblTestableTestReqeusts.getRowCount() != 0) {
            JOptionPane.showMessageDialog(null, "Please finish collecting the remaining testing people!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        selectedSlot.markNucleicAcidTestCompleted();
        JOptionPane.showMessageDialog(null, "Mark Successfully!!");

        populateSlotTable();
        populateCollectableTestingRequestTable(selectedSlot);
    }//GEN-LAST:event_btnCompleteTestingActionPerformed

    private void btnNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegativeActionPerformed
        int selectedRow = tblTestableTestReqeusts.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a testing request!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TestRequest tr = (TestRequest)tblTestableTestReqeusts.getValueAt(selectedRow, 0);

        tr.markNegative(loginAccount);
        JOptionPane.showMessageDialog(null, "Test Successfully!!");
        platform.getMsgDirectory().addMessageRequest(loginAccount, tr.getTestingPeople(), "You have tested negative for this test. kindly check");
        populateSlotTable();
        populateCollectableTestingRequestTable(selectedSlot);
        try {
            EmailToolKit.sendEmailWhenTestResultReleased(platform, tr, "NEGATIVE");
        } catch (Exception ex) {
            Logger.getLogger(ToTestListJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNegativeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompleteTesting;
    private javax.swing.JButton btnNegative;
    private javax.swing.JButton btnPositive;
    private javax.swing.JButton btnStartTesting;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JTable tblTestableSlots;
    private javax.swing.JTable tblTestableTestReqeusts;
    // End of variables declaration//GEN-END:variables
}
