/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TestingSite;

import Business.Enterprise.Enterprise;
import Business.Platform;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestRequest;
import Business.WorkQueue.TestSlotRequest;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shreya
 */
public class ToCollectListJPanel extends javax.swing.JPanel {

    private JPanel rightContainer;
    private Platform platform;
    private UserAccount loginAccount;
    private TestSlotRequest selectedSlot;
    
    public ToCollectListJPanel(JPanel rightContainer, Platform platform, UserAccount loginAccount) {
        initComponents();
        this.rightContainer = rightContainer;
        this.platform = platform;
        this.loginAccount = loginAccount;
        populateSlotTable();
    }
    
    private void populateSlotTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblCollectableSlots.getModel();
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
                    if (!r.isCancelled() && !r.isSampleCollectionCompleted() && (r.calcBookedRequestsHistorically() - r.calcBookCancelledRequests()) > 0) {
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
        DefaultTableModel dtm = (DefaultTableModel) tblCollectableTestReqeusts.getModel();
        dtm.setRowCount(0);
        
        for (WorkRequest wr : tsr.getTestRequestList()) {
            TestRequest tr = (TestRequest) wr;
            if (tr.bookedButHasntCollect()) {
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

        lblWelcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCollectableSlots = new javax.swing.JTable();
        btnStartCollection = new javax.swing.JButton();
        lblWelcome1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCollectableTestReqeusts = new javax.swing.JTable();
        btnCollected = new javax.swing.JButton();
        btnCompleteColllection = new javax.swing.JButton();
        btnAbsent = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("Collectable Slots");

        tblCollectableSlots.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCollectableSlots);

        btnStartCollection.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnStartCollection.setText("Start Collection");
        btnStartCollection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartCollectionActionPerformed(evt);
            }
        });

        lblWelcome1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome1.setText("Collectable Test Requests");

        tblCollectableTestReqeusts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblCollectableTestReqeusts);

        btnCollected.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnCollected.setText("Collected");
        btnCollected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectedActionPerformed(evt);
            }
        });

        btnCompleteColllection.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnCompleteColllection.setText("Completion Collection");
        btnCompleteColllection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteColllectionActionPerformed(evt);
            }
        });

        btnAbsent.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnAbsent.setText("Absent");
        btnAbsent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbsentActionPerformed(evt);
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
                        .addComponent(btnAbsent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCollected))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCompleteColllection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStartCollection))
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
                    .addComponent(btnStartCollection)
                    .addComponent(btnCompleteColllection))
                .addGap(47, 47, 47)
                .addComponent(lblWelcome1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCollected)
                    .addComponent(btnAbsent))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartCollectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartCollectionActionPerformed
        int selectedRow = tblCollectableSlots.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a slot!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        TestSlotRequest tsr = (TestSlotRequest)tblCollectableSlots.getValueAt(selectedRow, 2);
        selectedSlot = tsr;
        populateCollectableTestingRequestTable(tsr);
        tsr.markIsSampleCollecting();
    }//GEN-LAST:event_btnStartCollectionActionPerformed

    private void btnCollectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectedActionPerformed
        int selectedRow = tblCollectableTestReqeusts.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a testing request!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        TestRequest tr = (TestRequest)tblCollectableTestReqeusts.getValueAt(selectedRow, 0);

        tr.collect(loginAccount);
        JOptionPane.showMessageDialog(null, "Collect Successfully!!");
        platform.getMsgDirectory().addMessageRequest(loginAccount, tr.getTestingPeople(), "Your sample has been collected. kindly check");
        populateSlotTable();
        populateCollectableTestingRequestTable(selectedSlot);
    }//GEN-LAST:event_btnCollectedActionPerformed

    private void btnCompleteColllectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteColllectionActionPerformed
        if (tblCollectableTestReqeusts.getRowCount() != 0) {
            JOptionPane.showMessageDialog(null, "Please finish collecting the remaining testing people!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        selectedSlot.markSampleCollectionCompleted();
        JOptionPane.showMessageDialog(null, "Mark Successfully!!");

        populateSlotTable();
        populateCollectableTestingRequestTable(selectedSlot);
    }//GEN-LAST:event_btnCompleteColllectionActionPerformed

    private void btnAbsentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbsentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbsentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbsent;
    private javax.swing.JButton btnCollected;
    private javax.swing.JButton btnCompleteColllection;
    private javax.swing.JButton btnStartCollection;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcome1;
    private javax.swing.JTable tblCollectableSlots;
    private javax.swing.JTable tblCollectableTestReqeusts;
    // End of variables declaration//GEN-END:variables
}
