/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Platform;
import Business.UserAccount.UserAccount;
import userinterface.TestingSite.NucleicAcidTesterWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class NucleicAcidTesterRole extends Role{
    
    public NucleicAcidTesterRole() {
        super(RoleType.NucleicAcidTester.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new NucleicAcidTesterWorkAreaJPanel(mainJFrameContainer, account, platform);
    }
}
