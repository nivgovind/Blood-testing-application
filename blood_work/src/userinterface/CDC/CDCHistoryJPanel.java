/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.CDC;

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
 * @author shubhank
 */
public class CDCHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CDCHistoryJPanel
     */
    private JPanel rightContainer;
    private Platform platform;
    private UserAccount loginAccount;
    private TestSlotRequest selectedSlot;
    public CDCHistoryJPanel(JPanel rightContainer, Platform platform, UserAccount loginAccount) {
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
                    if (r.isNucleicAcidTestCompleted()) {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTestableSlots = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTestableTestReqeusts = new javax.swing.JTable();
        btnStartTesting = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 204, 255));

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

        btnStartTesting.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnStartTesting.setText("View details");
        btnStartTesting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTestingActionPerformed(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(473, 473, 473)
                                .addComponent(btnStartTesting)))
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStartTesting)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>                        

    private void populateCollectableTestingRequestTable(TestSlotRequest tsr) {
        DefaultTableModel dtm = (DefaultTableModel) tblTestableTestReqeusts.getModel();
        dtm.setRowCount(0);
        
        for (WorkRequest wr : tsr.getTestRequestList()) {
            TestRequest tr = (TestRequest) wr;
            Object[] row = new Object[4];
                row[0] = tr; 
                row[1] = tr.getSampleCollector();
                row[2] = tr.getNucleicAcidTester();
                if (tr.getNucleicAcidTestDate() == null) {
                    row[3] = "-";
                }else {
                    row[3] = tr.isPositive() == true ? "Positive" : "Negative";
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

        lblWelcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTestableSlots = new javax.swing.JTable();
        btnStartTesting = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTestableTestReqeusts = new javax.swing.JTable();

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("History");

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

        btnStartTesting.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnStartTesting.setText("View details");
        btnStartTesting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartTestingActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(473, 473, 473)
                            .addComponent(btnStartTesting))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStartTesting)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
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
    }//GEN-LAST:event_btnStartTestingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartTesting;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblTestableSlots;
    private javax.swing.JTable tblTestableTestReqeusts;
    // End of variables declaration//GEN-END:variables
}
