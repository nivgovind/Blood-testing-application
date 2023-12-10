/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.Role.RoleType;
import java.util.ArrayList;

/**
 *
 * @author shubank
 */
class CDCDataHandlingOrganization extends Organization {

    public CDCDataHandlingOrganization(String name) {
        super(name);
    }

    @Override
    public ArrayList<RoleType> getSupportedRoleList() {
        ArrayList<RoleType> list = new ArrayList<>();
        list.add(RoleType.CDCDataHandler);
        return list;
    }
    
}
