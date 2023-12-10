package Business.Enterprise;

 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import java.util.ArrayList;

/**
 *
 * @author shreya
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;
    
    public Enterprise getEnterprise(EnterpriseType type) {
        for (Enterprise enterprise : enterpriseList) {
            if (type.getValue().equals(enterprise.getName())) {
                return enterprise;
            }
        }
        return null;
    }
    
    public Enterprise getEnterpriseByRole(Role role) {
        for (Enterprise enterprise : enterpriseList) {
            ArrayList<RoleType> roleList = enterprise.getSupportedRoleList();
            for (RoleType type : roleList) {
                if (type.getValue().equals(role.getName())) {
                    return enterprise;
                }
            }
        }
        return null;
    }

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(EnterpriseType type){
        Enterprise enterprise = null;
        if (type.getValue().equals(EnterpriseType.TestingPeople.getValue())){
            enterprise = new TestingPeopleEnterprise(EnterpriseType.TestingPeople.getValue());
            enterpriseList.add(enterprise);
        }
        else if (type.getValue().equals(EnterpriseType.TestingSite.getValue())){
            enterprise = new TestingSiteEnterprise(EnterpriseType.TestingSite.getValue());
            enterpriseList.add(enterprise);
        }
        else if (type.getValue().equals(EnterpriseType.CDC.getValue())){
            enterprise = new CDCEnterprise(EnterpriseType.CDC.getValue());
            enterpriseList.add(enterprise);
        }
        else if (type.getValue().equals(EnterpriseType.PandemicSimulation.getValue())){
            enterprise = new PandemicSimulationEnterprise(EnterpriseType.PandemicSimulation.getValue());
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }
}