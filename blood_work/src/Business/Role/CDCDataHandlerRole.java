/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CDC.CDCDataHandlerWorkAreaJPanel;

/**
 *
 * @author shubank
 */
public class CDCDataHandlerRole extends Role{
    
    public CDCDataHandlerRole() {
        super(RoleType.CDCDataHandler.getValue());
    }

    @Override
    public JPanel createWorkArea(JPanel mainJFrameContainer, UserAccount account, Platform platform) {
        return new CDCDataHandlerWorkAreaJPanel(mainJFrameContainer, account, platform);
    }
    
}
