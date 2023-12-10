/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shubank
 */
public abstract class Enterprise {
    private String name;
    private OrganizationDirectory organizationDirectory;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int enterpriseID;
    private static int counter=0;
    
    public enum EnterpriseType{
        TestingPeople("TestingPeopleEnterprise"),
        TestingSite("TestingSiteEnterprise"),
        CDC("CDCEnterprise"),
        PandemicSimulation("PandemicSimulationEnterprise");
        
        private String value;
        private EnterpriseType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Enterprise(String name) {
        this.name = name;
        organizationDirectory = new OrganizationDirectory();
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        enterpriseID = counter;
        ++counter;
    }
    
    public abstract ArrayList<RoleType> getSupportedRoleList();
    
    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public int getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(int enterpriseID) {
        this.enterpriseID = enterpriseID;
    }
    
}
