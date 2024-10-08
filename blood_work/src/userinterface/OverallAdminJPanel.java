/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface;

import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author shubhank
 */
public class OverallAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OverallAdminJPanel
     */
    public OverallAdminJPanel(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        btnPanel = new javax.swing.JPanel();
        statsBtn = new javax.swing.JButton();
        graphsPanel = new javax.swing.JPanel();

        statsBtn.setText("Tests Statistics");
        statsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statsBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(statsBtn)
                .addContainerGap(391, Short.MAX_VALUE))
        );

        splitPane.setLeftComponent(btnPanel);

        javax.swing.GroupLayout graphsPanelLayout = new javax.swing.GroupLayout(graphsPanel);
        graphsPanel.setLayout(graphsPanelLayout);
        graphsPanelLayout.setHorizontalGroup(
            graphsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 683, Short.MAX_VALUE)
        );
        graphsPanelLayout.setVerticalGroup(
            graphsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        splitPane.setRightComponent(graphsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(splitPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void statsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statsBtnActionPerformed
        // Render a pie chart on the right panel. Get the data from the database
        String applicationTitle = "Tests Statistics";
        String chartTitle = "Tests Statistics";
        String categoryAxisLabel = "Tests";
        String valueAxisLabel = "Number of Tests";
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Test 1", "Test 1");
        dataset.addValue(20, "Test 2", "Test 2");
        dataset.addValue(30, "Test 3", "Test 3");
        dataset.addValue(40, "Test 4", "Test 4");
        dataset.addValue(50, "Test 5", "Test 5");
        JFreeChart barChart = ChartFactory.createBarChart(chartTitle, categoryAxisLabel, valueAxisLabel, dataset);
        CategoryPlot plot = barChart.getCategoryPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        ChartPanel chartPanel = new ChartPanel(barChart);
        graphsPanel.removeAll();
        graphsPanel.add(chartPanel);
        graphsPanel.updateUI();
    }//GEN-LAST:event_statsBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPanel;
    private javax.swing.JPanel graphsPanel;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JButton statsBtn;
    // End of variables declaration//GEN-END:variables
}
