/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.Platform;
import Business.Role.CDCDataHandlerRole;
import Business.Role.CDCInfoDistributorRole;
import Business.Role.TestingSiteAdminRole;
import Business.UserAccount.UserAccount;
import Business.Util.InputValidator;
import Business.Util.StretchIcon;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import userinterface.CDC.CDCAdminWorkAreaJPanel;
import userinterface.CDC.CDCDataHandlerWorkAreaJPanel;
import userinterface.CDC.CDCInfoDistributorWorkAreaJPanel;
import userinterface.Simulation.SimulationOperatorWorkAreaJPanel;
import userinterface.TestingPeople.RegisteredTestingPeopleWorkAreaJPanel;
import userinterface.TestingSite.NucleicAcidTesterWorkAreaJPanel;
import userinterface.TestingSite.SampleCollectionPeopleWorkAreaJPanel;
import userinterface.TestingSite.TestingSiteAdminWorkAreaJPanel;
import userinterface.TestingSite.TestingSiteDataHandlerWorkAreaJPanel;

/**
 *
 * @author Administrator
 */
public class SettingsJPanel extends javax.swing.JPanel {

    private JPanel workAreaJPanel;
    private JPanel rightContainer;
    private Platform platform;
    private UserAccount loginAccount;
    private boolean imageHasChosen = false;
    private boolean inputValid = false;
    private File imageFile;
    
    /**
     * Creates new form SettinsJPanel
     */
    public SettingsJPanel(JPanel workAreaJPanel, JPanel rightContainer, Platform platform, UserAccount loginAccount) {
        initComponents();
        this.workAreaJPanel = workAreaJPanel;
        this.rightContainer = rightContainer;
        this.platform = platform;
        this.loginAccount = loginAccount;
        populateJPanel();
        addInputTextFieldListeners();
    }
    
    private void populateJPanel() {
        String imagePath = loginAccount.getIconPath();
        ImageIcon imageIcon = new StretchIcon(imagePath);
        lblIcon.setIcon(imageIcon);
        
        txtUserName.setText(loginAccount.getUsername());
        txtPassword.setText(loginAccount.getPassword());
        txtAge.setText(loginAccount.getEmployee().getAge());
        txtEmail.setText(loginAccount.getEmployee().getEmail());
        lblUploadFileName.setText("");
    }
    
    private void addInputTextFieldListeners() {
        Document docUser = txtUserName.getDocument();
        docUser.addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InputValidator.userNameValidate(lblUserName, txtUserName);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InputValidator.userNameValidate(lblUserName, txtUserName);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Document docPass = txtPassword.getDocument();
        docPass.addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InputValidator.passwordValidate(lblPassword, txtPassword);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InputValidator.passwordValidate(lblPassword, txtPassword);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Document docEmail = txtEmail.getDocument();
        docEmail.addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InputValidator.emailValidate(lblEmail, txtEmail);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InputValidator.emailValidate(lblEmail, txtEmail);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
//        Document docName = txtName.getDocument();
//        docName.addDocumentListener(new javax.swing.event.DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                InputValidator.userNameValidate(lblName, txtName);
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                InputValidator.userNameValidate(lblName, txtName);
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
        
        Document docAge = txtAge.getDocument();
        docAge.addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InputValidator.ageValidate(lblAge, txtAge);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InputValidator.ageValidate(lblAge, txtAge);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        btnImageChoose = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblUploadFileName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jLabel1.setText("Profile");

        lblIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnImageChoose.setFont(new java.awt.Font("微软雅黑", 1, 12)); // NOI18N
        btnImageChoose.setText("Choose File");
        btnImageChoose.setEnabled(false);
        btnImageChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImageChooseActionPerformed(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        lblUserName.setText("User Name");

        txtUserName.setEnabled(false);

        txtAge.setEnabled(false);

        lblAge.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        lblAge.setText("Age");

        txtEmail.setEnabled(false);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        lblEmail.setText("Email");

        lblPassword.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        lblPassword.setText("Password");

        txtPassword.setEnabled(false);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblUploadFileName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImageChoose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserName)
                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAge)
                            .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUploadFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImageChoose))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserName)
                            .addComponent(lblAge))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(lblPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImageChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImageChooseActionPerformed
        // TODO add your handling code here:
        // create a file chooser
        JFileChooser chooser = new JFileChooser();
        // only one file could be selected
        chooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
        chooser.setFileFilter(filter);

        int approveOrNot = chooser.showOpenDialog(btnImageChoose);
        if (approveOrNot == JFileChooser.APPROVE_OPTION) {
            imageFile = chooser.getSelectedFile();
            String fileName = imageFile.getName();
            int index = fileName.lastIndexOf(".");
            String suffix = fileName.substring(index+1);
            // filter non-image file
            if (!(suffix.equals("jpg")||suffix.equals("png"))) {
                JOptionPane.showMessageDialog(null, "Please choose .jpg or .png format file");
                return;
            }
            imageHasChosen = true;
            lblUploadFileName.setText(fileName);
        }
    }//GEN-LAST:event_btnImageChooseActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String age = txtAge.getText();
        String email = txtEmail.getText();
        
        if(username.isEmpty() || username.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter username!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(password.isEmpty() || password.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter password!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(email.isEmpty() || email.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter email!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
//        if(name.isEmpty() || name.trim().isEmpty()){
//            JOptionPane.showMessageDialog(null, "Please enter name!!", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
        if(age.isEmpty() || age.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter age!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
//        if(!rbtnFemale.isSelected() && !rbtnMale.isSelected()){
//            JOptionPane.showMessageDialog(null, "Please select sex!!", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if(cbxCity.getSelectedIndex() == -1){
//            JOptionPane.showMessageDialog(null, "Please select city!!", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
        
        
        if (!InputValidator.userNameValidate(username)) {
            JOptionPane.showMessageDialog(null, "Invalid input!\nUsername consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.\n" +
                "Username allowed of the dot (.), underscore (_), and hyphen (-).\n" +
                "The dot (.), underscore (_), or hyphen (-) must not be the first or last character.\n" +
                "The dot (.), underscore (_), or hyphen (-) does not appear consecutively, e.g., java..regex\n" +
                "The number of characters must be between 5 to 20.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!InputValidator.passwordValidate(password)) {
            JOptionPane.showMessageDialog(null, "Invalid input!\nPassword consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.\n"
                    + "At least one character of [$*#&@.].\n"
                    + "At least six characters long.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!InputValidator.ageValidate(age)) {
            JOptionPane.showMessageDialog(null, "Invalid input!\nOnly age between 1-120 was allowed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!InputValidator.emailValidate(email)) {
            JOptionPane.showMessageDialog(null, "Invalid input!\nWrong email format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!username.equals(loginAccount.getUsername()) && !platform.checkIfUserAccountIsUnique(username)) {
            JOptionPane.showMessageDialog(null, "Duplicate username, please enter another one!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        loginAccount.setUsername(username);
        loginAccount.setPassword(password);
        loginAccount.getEmployee().setAge(age);
        loginAccount.getEmployee().setEmail(email);
        if (imageHasChosen) {
            String rootDir = System.getProperty("user.dir");
            String savePath = rootDir + "\\src\\Resources\\" + imageFile.getName();
//            String savePath = "src/Resources/" + imageFile.getName();
            loginAccount.setIconPath(savePath);
            
            FileInputStream input = null;
            FileOutputStream output = null;
            try {
                input = new FileInputStream(imageFile);
                File saveFile = new File(savePath);
                output = new FileOutputStream(saveFile);
                byte[] buffer = new byte[1024];
                int len = 0;

                while((len = input.read(buffer)) != -1) {
                    output.write(buffer, 0, len);
                }
                output.flush();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Image upload failed!", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                try {
                    output.close();
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Save Successfully!!");
        populateJPanel();
        
        if (workAreaJPanel instanceof CDCAdminWorkAreaJPanel) {
            CDCAdminWorkAreaJPanel jPanel = (CDCAdminWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof CDCDataHandlerWorkAreaJPanel) {
            CDCDataHandlerWorkAreaJPanel jPanel = (CDCDataHandlerWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof CDCInfoDistributorWorkAreaJPanel) {
            CDCInfoDistributorWorkAreaJPanel jPanel = (CDCInfoDistributorWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof SimulationOperatorWorkAreaJPanel) {
            SimulationOperatorWorkAreaJPanel jPanel = (SimulationOperatorWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof RegisteredTestingPeopleWorkAreaJPanel) {
            RegisteredTestingPeopleWorkAreaJPanel jPanel = (RegisteredTestingPeopleWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof RegisteredTestingPeopleWorkAreaJPanel) {
            RegisteredTestingPeopleWorkAreaJPanel jPanel = (RegisteredTestingPeopleWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof SampleCollectionPeopleWorkAreaJPanel) {
            SampleCollectionPeopleWorkAreaJPanel jPanel = (SampleCollectionPeopleWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof NucleicAcidTesterWorkAreaJPanel) {
            NucleicAcidTesterWorkAreaJPanel jPanel = (NucleicAcidTesterWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof TestingSiteDataHandlerWorkAreaJPanel) {
            TestingSiteDataHandlerWorkAreaJPanel jPanel = (TestingSiteDataHandlerWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }else if (workAreaJPanel instanceof TestingSiteAdminWorkAreaJPanel) {
            TestingSiteAdminWorkAreaJPanel jPanel = (TestingSiteAdminWorkAreaJPanel) workAreaJPanel;
            jPanel.initLeftUserBar();
        }

        txtUserName.setEnabled(false);
        txtAge.setEnabled(false);
        txtEmail.setEnabled(false);
        txtPassword.setEnabled(false);
        btnImageChoose.setEnabled(false);

        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        txtUserName.setEnabled(true);
        txtAge.setEnabled(true);
        txtEmail.setEnabled(true);
        txtPassword.setEnabled(true);
        btnImageChoose.setEnabled(true);

        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImageChoose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUploadFileName;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
