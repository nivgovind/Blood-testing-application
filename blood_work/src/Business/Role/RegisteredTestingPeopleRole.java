/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Organization.Organization;
import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.TestingPeople.RegisteredTestingPeopleWorkAreaJPanel;

/**
 *
 * @author shubank
 */
public class RegisteredTestingPeopleRole extends Role{

    public RegisteredTestingPeopleRole() {
        super(RoleType.RegisteredTestingPeople.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new RegisteredTestingPeopleWorkAreaJPanel(mainJFrameContainer, account, platform);
    }
}
