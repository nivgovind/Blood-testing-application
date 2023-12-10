/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TestingSite;

import Business.DB4OUtil.DB4OUtil;
import Business.Platform;
import Business.UserAccount.UserAccount;
import Business.Util.StretchIcon;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import userinterface.MessageJPanel;
import userinterface.SettingsJPanel;

/**
 *
 * @author shubank
 */
public class TestingSiteDataHandlerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel mainJFrameContainer;
    private UserAccount loginAccount;
    private Platform platform;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public TestingSiteDataHandlerWorkAreaJPanel(JPanel mainJFrameContainer, UserAccount loginAccount, Platform platform) {
        initComponents();
        this.mainJFrameContainer = mainJFrameContainer;
        this.loginAccount = loginAccount;
        this.platform = platform;
        initLeftUserBar();
    }
    
    public void initLeftUserBar() {
        String imagePath = loginAccount.getIconPath();
        ImageIcon imageIcon = new StretchIcon(imagePath);
        userIcon.setIcon(imageIcon);
        lblUserName.setText(loginAccount.getUsername());
        lblVersion.setText(platform.getVersion());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        leftBar = new javax.swing.JPanel();
        userIcon = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        btnToSendList = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnMessages = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblVersion = new javax.swing.JLabel();
        rightContainer = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        leftBar.setBackground(new java.awt.Color(255, 204, 204));

        userIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblUserName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUserName.setText("UserName");

        btnToSendList.setBackground(new java.awt.Color(255, 209, 111));
        btnToSendList.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnToSendList.setText("Manage Employees");
        btnToSendList.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnToSendList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToSendListActionPerformed(evt);
            }
        });

        btnSettings.setBackground(new java.awt.Color(255, 209, 111));
        btnSettings.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSettings.setText("Settings");
        btnSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnMessages.setBackground(new java.awt.Color(255, 209, 111));
        btnMessages.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnMessages.setText("Messages");
        btnMessages.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessagesActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(215, 58, 73));
        btnLogout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Log Out");
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblVersion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblVersion.setText("v. 1.x.x");

        javax.swing.GroupLayout leftBarLayout = new javax.swing.GroupLayout(leftBar);
        leftBar.setLayout(leftBarLayout);
        leftBarLayout.setHorizontalGroup(
            leftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftBarLayout.createSequentialGroup()
                .addGroup(leftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftBarLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(leftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnToSendList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(leftBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVersion)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        leftBarLayout.setVerticalGroup(
            leftBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftBarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(userIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUserName)
                .addGap(37, 37, 37)
                .addComponent(btnToSendList)
                .addGap(91, 91, 91)
                .addComponent(btnMessages)
                .addGap(36, 36, 36)
                .addComponent(btnSettings)
                .addGap(36, 36, 36)
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lblVersion)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(leftBar);

        rightContainer.setBackground(new java.awt.Color(255, 255, 255));
        rightContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(rightContainer);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnToSendListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToSendListActionPerformed
        // TODO add your handling code here:
        TestSiteManagerJPanel bjp = new TestSiteManagerJPanel(rightContainer, platform, loginAccount);
        CardLayout layout = (CardLayout)rightContainer.getLayout();
        rightContainer.add("TestSiteManagerJPanel",bjp);
        layout.next(rightContainer);
    }//GEN-LAST:event_btnToSendListActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        mainJFrameContainer.remove(this);
        CardLayout layout = (CardLayout) mainJFrameContainer.getLayout();
        layout.previous(mainJFrameContainer);
        dB4OUtil.storeSystem(platform);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        SettingsJPanel sjp = new SettingsJPanel(this, rightContainer,platform, loginAccount);
        CardLayout layout = (CardLayout)rightContainer.getLayout();
        rightContainer.add("SettingsJPanel",sjp);
        layout.next(rightContainer);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessagesActionPerformed
        MessageJPanel mjp = new MessageJPanel(rightContainer, platform, loginAccount);
        CardLayout layout = (CardLayout)rightContainer.getLayout();
        rightContainer.add("MessageJPanel",mjp);
        layout.next(rightContainer);
    }//GEN-LAST:event_btnMessagesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMessages;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnToSendList;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel leftBar;
    private javax.swing.JPanel rightContainer;
    private javax.swing.JLabel userIcon;
    // End of variables declaration//GEN-END:variables
}
