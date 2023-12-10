/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CDC.CDCInfoDistributorWorkAreaJPanel;

/**
 *
 * @author nivcodes
 */
public class CDCInfoDistributorRole extends Role{
    
    public CDCInfoDistributorRole() {
        super(RoleType.CDCInfoDistributor.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new CDCInfoDistributorWorkAreaJPanel(mainJFrameContainer, account, platform);
    }
}
