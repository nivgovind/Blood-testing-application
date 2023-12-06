package Business.Organization;

 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.OrgType;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }
    
    public Organization getOrganizationByRole(Role role) {
        for (Organization org : organizationList) {
            ArrayList<RoleType> roleList = org.getSupportedRoleList();
            for (RoleType type : roleList) {
                if (type.getValue().equals(role.getName())) {
                    return org;
                }
            }
        }
        return null;
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization getTestingPeopleOrg() {
        for (Organization o : organizationList) {
            if (o.getName().equals(OrgType.TestingPeople.getValue())) {
                return o;
            }
        }
        return null;
    }
    
    public Organization createAndAddOrganization(OrgType type){
        Organization organization = null;
        if (type.getValue().equals(OrgType.TestingPeople.getValue())){
            organization = new TestingPeopleOrganization(OrgType.TestingPeople.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.TestingPeopleManager.getValue())){
            organization = new TestingPeopleManagerOrganization(OrgType.TestingPeopleManager.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.SampleCollection.getValue())){
            organization = new SampleCollectionOrganization(OrgType.SampleCollection.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.NucleicAcidTest.getValue())){
            organization = new NucleicAcidTestOrganization(OrgType.NucleicAcidTest.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.TestingSiteDataHandling.getValue())){
            organization = new TestingSiteDataHandlingOrganization(OrgType.TestingSiteDataHandling.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.TestingSiteManager.getValue())){
            organization = new TestingSiteManagerOrganization(OrgType.TestingSiteManager.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.CDCDataHandling.getValue())){
            organization = new CDCDataHandlingOrganization(OrgType.CDCDataHandling.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.CDCInfoDistribution.getValue())){
            organization = new CDCInfoDistributionOrganization(OrgType.CDCInfoDistribution.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.CDCManager.getValue())){
            organization = new CDCManagerOrganization(OrgType.CDCManager.getValue());
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrgType.Simulation.getValue())){
            organization = new SimulationOrganization(OrgType.Simulation.getValue());
            organizationList.add(organization);
        }
        
        return organization;
    }
}