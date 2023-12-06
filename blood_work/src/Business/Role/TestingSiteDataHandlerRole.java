/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.TestingSite.TestingSiteDataHandlerWorkAreaJPanel;

/**
 *
 * @author Administrator
 */
public class TestingSiteDataHandlerRole extends Role{
    
    public TestingSiteDataHandlerRole() {
        super(RoleType.TestingSiteDataHandler.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new TestingSiteDataHandlerWorkAreaJPanel(mainJFrameContainer, account, platform);
    }
}
