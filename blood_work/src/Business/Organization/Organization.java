/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author shreya
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;  // The reason having EmployeeDirectory in Organization is making organiztions still have the user information even if the user account is deleted
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum OrgType{
        TestingPeople("TestingPeopleOrganization"),
        TestingPeopleManager("TestingPeopleManagerOrganization"),
        SampleCollection("SampleCollectionOrganization"),
        NucleicAcidTest("NucleicAcidTestOrganization"),
        TestingSiteDataHandling("TestingSiteDataHandlingOrganization"),
        TestingSiteManager("TestingSiteManagerOrganization"),
        CDCDataHandling("CDCDataHandlingOrganization"),
        CDCInfoDistribution("CDCInfoDistributionOrganization"),
        CDCManager("CDCManagerOrganization"),
        Simulation("SimulationOrganization");
        
        
        private String value;
        private OrgType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }
    
    public abstract ArrayList<RoleType> getSupportedRoleList();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
