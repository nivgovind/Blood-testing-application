/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import Business.City.City;
import Business.Employee.Employee;
import Business.Employee.Employee.SexType;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Platform;
import Business.Role.CDCAdminRole;
import Business.Role.CDCDataHandlerRole;
import Business.Role.CDCInfoDistributorRole;
import Business.Role.NucleicAcidTesterRole;
import Business.Role.RegisteredTestingPeopleRole;
import Business.Role.Role;
import Business.Role.SampleCollectionPeopleRole;
import Business.Role.SimulationOperatorRole;
import Business.Role.TestingPeopleAdminRole;
import Business.Role.TestingSiteAdminRole;
import Business.Role.TestingSiteDataHandlerRole;
import Business.UserAccount.UserAccount;
import Business.Util.EmailToolKit;
import Business.Util.InputValidator;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;

/**
 *
 * @author shreya
 */
public class RegisterJPanel extends javax.swing.JPanel {

    private JPanel mainJFrameContainer;
    private Platform platform;
    
    public RegisterJPanel(JPanel mainJFrameContainer, Platform platform) {
        initComponents();
        this.mainJFrameContainer = mainJFrameContainer;
        this.platform = platform;
        addInputTextFieldListeners();
        populateRoleCbx();
        populateCityCbx();
        initSexButtonGroup();
    }
    
    private void initSexButtonGroup() {
        bgSex = new ButtonGroup();

        bgSex.add(rbtnMale);
        bgSex.add(rbtnFemale);
    }
    
    private void populateRoleCbx() {
        DefaultComboBoxModel<Object> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement(new RegisteredTestingPeopleRole());
        dcbm.addElement(new TestingPeopleAdminRole());
        dcbm.addElement(new SampleCollectionPeopleRole());
        dcbm.addElement(new NucleicAcidTesterRole());
        dcbm.addElement(new TestingSiteDataHandlerRole());
        dcbm.addElement(new TestingSiteAdminRole());
        dcbm.addElement(new CDCAdminRole());
        dcbm.addElement(new CDCDataHandlerRole());
        dcbm.addElement(new CDCInfoDistributorRole());
        dcbm.addElement(new SimulationOperatorRole());
        cbxRegisteredRole.setModel(dcbm);
//        cbxRegisteredRole.setEnabled(false);
    }
    
    private void populateCityCbx() {
        DefaultComboBoxModel<Object> dcbm = new DefaultComboBoxModel<>();
        for (City city : platform.getCityDirectory().getCityList()) {
            dcbm.addElement(city);
        }
        cbxCity.setModel(dcbm);
        cbxCity.setSelectedIndex(-1);
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
        
        Document docName = txtName.getDocument();
        docName.addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InputValidator.userNameValidate(lblName, txtName);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InputValidator.userNameValidate(lblName, txtName);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
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

        btnBack = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        rbtnFemale = new javax.swing.JRadioButton();
        lblEmail = new javax.swing.JLabel();
        rbtnMale = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxRegisteredRole = new javax.swing.JComboBox<>();
        cbxCity = new javax.swing.JComboBox<>();
        lblUserName = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBack.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnBack.setText("<< Back to Login");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        lblPassword.setText("Password");

        jLabel7.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jLabel7.setText("Sex");

        btnRegister.setBackground(new java.awt.Color(255, 153, 0));
        btnRegister.setFont(new java.awt.Font("微软雅黑", 1, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        lblName.setText("Name");

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        lblAge.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        lblAge.setText("Age");

        rbtnFemale.setFont(new java.awt.Font("微软雅黑", 2, 12)); // NOI18N
        rbtnFemale.setText("Female");
        rbtnFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFemaleActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        lblEmail.setText("Email");

        rbtnMale.setFont(new java.awt.Font("微软雅黑", 2, 12)); // NOI18N
        rbtnMale.setText("Male");
        rbtnMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMaleActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jLabel10.setText("City");

        jLabel6.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        jLabel6.setText("Register Role");

        cbxRegisteredRole.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        cbxRegisteredRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxCity.setFont(new java.awt.Font("微软雅黑", 0, 14)); // NOI18N
        cbxCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblUserName.setFont(new java.awt.Font("微软雅黑", 1, 18)); // NOI18N
        lblUserName.setText("User Name");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUserName)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxRegisteredRole, 0, 221, Short.MAX_VALUE)
                    .addComponent(txtPassword)
                    .addComponent(txtEmail))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rbtnMale, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCity, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName)
                                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAge))))
                    .addComponent(btnRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUserName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(lblAge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnMale)
                            .addComponent(rbtnFemale))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRegisteredRole, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mainJFrameContainer.remove(this);
        CardLayout layout = (CardLayout) mainJFrameContainer.getLayout();
        layout.previous(mainJFrameContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String username = txtUserName.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();
        String name = txtName.getText();
        String age = txtAge.getText();
        SexType sexType = rbtnMale.isSelected() ? SexType.Male : SexType.Female;
        City city = (City) cbxCity.getSelectedItem();
        Role role = (Role) cbxRegisteredRole.getSelectedItem();
        
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
        if(name.isEmpty() || name.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter name!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(age.isEmpty() || age.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter age!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!rbtnFemale.isSelected() && !rbtnMale.isSelected()){
            JOptionPane.showMessageDialog(null, "Please select sex!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(cbxCity.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Please select city!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (!InputValidator.userNameValidate(username)) {
            JOptionPane.showMessageDialog(null, "Invalid input!\nUsername consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.\n" +
                "Username allowed of the dot (.), underscore (_), and hyphen (-).\n" +
                "The dot (.), underscore (_), or hyphen (-) must not be the first or last character.\n" +
                "The dot (.), underscore (_), or hyphen (-) does not appear consecutively, e.g., java..regex\n" +
                "The number of characters must be between 5 to 20.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!InputValidator.userNameValidate(name)) {
            JOptionPane.showMessageDialog(null, "Invalid input!\nName consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.\n" +
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
        
        if (!platform.checkIfUserAccountIsUnique(username)) {
            JOptionPane.showMessageDialog(null, "Duplicate username, please enter another one!!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Employee e = new Employee(name, age, sexType, email, city);
        platform.getEmployeeDirectory().createAndAddEmployee(name, age, sexType, email, city);
        UserAccount ua = platform.getUserAccountDirectory().createAndAddUserAccount(username, password, e, role);
        
        // get enterprise and organization that the newly registered user belongs to
        Enterprise enterprise = platform.getEnterpriseDirectory().getEnterpriseByRole(role);
        Organization organization = enterprise.getOrganizationDirectory().getOrganizationByRole(role);
        
        // add employee and useraccount to the specific enterprise and organization
        enterprise.getEmployeeDirectory().addEmployee(e);
        enterprise.getUserAccountDirectory().addUserAccount(ua);
        organization.getEmployeeDirectory().addEmployee(e);
        organization.getUserAccountDirectory().addUserAccount(ua);
        
        JOptionPane.showMessageDialog(null, "Register successfully!!!");
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
        txtEmail.setEnabled(false);
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        rbtnFemale.setEnabled(false);
        rbtnMale.setEnabled(false);
        cbxRegisteredRole.setEnabled(false);
        cbxCity.setEnabled(false);
        
        mainJFrameContainer.remove(this);
        CardLayout layout = (CardLayout) mainJFrameContainer.getLayout();
        layout.previous(mainJFrameContainer);
        
        try {
            EmailToolKit.sendEmailWhenSuccessfullyRegistered(e.getEmail(), ua);
            
            //        for (Enterprise en : platform.getEnterpriseDirectory().getEnterpriseList()) {
//            System.out.println(en.getName());
//            for (Organization or : en.getOrganizationDirectory().getOrganizationList()) {
//                System.out.println(or.getName());
//                or.getUserAccountDirectory().getUserAccountList().forEach((useraccount)->System.out.println(useraccount.getUsername()));
//            }
//            en.getUserAccountDirectory().getUserAccountList().forEach((useraccount)->System.out.println(useraccount.getUsername()));
//        }
        } catch (Exception ex) {
            Logger.getLogger(RegisterJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void rbtnFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnFemaleActionPerformed

    private void rbtnMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMaleActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<Object> cbxCity;
    private javax.swing.JComboBox<Object> cbxRegisteredRole;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
    private javax.swing.ButtonGroup bgSex; 
}
