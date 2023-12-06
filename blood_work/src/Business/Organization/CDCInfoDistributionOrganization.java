/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
class CDCInfoDistributionOrganization extends Organization {

    public CDCInfoDistributionOrganization(String name) {
        super(name);
    }

    @Override
    public ArrayList<Role.RoleType> getSupportedRoleList() {
        ArrayList<Role.RoleType> list = new ArrayList<>();
        list.add(Role.RoleType.CDCInfoDistributor);
        return list;
    }
    
}
