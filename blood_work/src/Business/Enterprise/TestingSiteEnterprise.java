/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role.RoleType;
import java.util.ArrayList;

/**
 *
 * @author nivcodes
 */
class TestingSiteEnterprise extends Enterprise {

    public TestingSiteEnterprise(String name) {
        super(name);
    }

    @Override
    public ArrayList<RoleType> getSupportedRoleList() {
        ArrayList<RoleType> list = new ArrayList<>();
        list.add(RoleType.SampleCollectionPeople);
        list.add(RoleType.NucleicAcidTester);
        list.add(RoleType.TestingSiteDataHandler);
        list.add(RoleType.TestingSiteAdmin);
        return list;
    }
    
}
