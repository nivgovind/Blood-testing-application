/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.OverallAdminJPanel;
import userinterface.TestingPeople.RegisteredTestingPeopleWorkAreaJPanel;

// Add the missing import statement for the Role class
/**
 *
 * @author shubhank
 */
public class OverallAdmin extends Role {
    
    public OverallAdmin() {
        super(Role.RoleType.OverallAdmin.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new OverallAdminJPanel(mainJFrameContainer, account, platform);
    }
}
