/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.TestingSite.TestingSiteAdminWorkAreaJPanel;

/**
 *
 * @author Administrator
 */
public class TestingSiteAdminRole extends Role{
    
    public TestingSiteAdminRole() {
        super(RoleType.TestingSiteAdmin.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new TestingSiteAdminWorkAreaJPanel(mainJFrameContainer, account, platform);
    }
}
