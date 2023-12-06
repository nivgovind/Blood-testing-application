/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Organization.Organization;
import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.TestingPeople.TestingPeopleAdminWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class TestingPeopleAdminRole extends Role{

    
    public TestingPeopleAdminRole() {
        super(RoleType.TestingPeopleAdmin.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new TestingPeopleAdminWorkAreaJPanel(mainJFrameContainer, account, platform);
    }
}
