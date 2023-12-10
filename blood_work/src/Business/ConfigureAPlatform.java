package Business;

import Business.City.City;
import Business.Employee.Employee;
import Business.Employee.Employee.SexType;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.Organization;
import Business.Organization.Organization.OrgType;
import Business.Role.NucleicAcidTesterRole;
import Business.Role.RegisteredTestingPeopleRole;
import Business.Role.Role;
import Business.Role.SampleCollectionPeopleRole;
import Business.Role.TestingSiteAdminRole;
import Business.UserAccount.UserAccount;



/**
 *
 * @author nivcodes
 */
public class ConfigureAPlatform {
    
    public static Platform configure(){
        
        Platform platform = Platform.getInstance();
        
        Enterprise testingPeopleEnterprise = platform.getEnterpriseDirectory().createAndAddEnterprise(EnterpriseType.TestingPeople);
        Enterprise testingSiteEnterprise = platform.getEnterpriseDirectory().createAndAddEnterprise(EnterpriseType.TestingSite);
        Enterprise cdcEnterprise = platform.getEnterpriseDirectory().createAndAddEnterprise(EnterpriseType.CDC);
        Enterprise simulationEnterprise = platform.getEnterpriseDirectory().createAndAddEnterprise(EnterpriseType.PandemicSimulation);
        
        Organization testingPeopleOrganization = testingPeopleEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.TestingPeople);
        Organization testingPeopleManagerOrganization = testingPeopleEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.TestingPeopleManager);
        
        Organization sampleCollectionOrganization  = testingSiteEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.SampleCollection);
        Organization NucleicAcidTestOrganization = testingSiteEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.NucleicAcidTest);
        Organization TestingSiteDataHandlingOrganization = testingSiteEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.TestingSiteDataHandling);
        Organization TestingSiteManager = testingSiteEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.TestingSiteManager);
        
        Organization cdcInfoDistributionOrganization = cdcEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.CDCInfoDistribution);
        Organization cdcDataHandlingOrganization = cdcEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.CDCDataHandling);
        Organization cdcManagerOrganization = cdcEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.CDCManager);
        
        Organization simulatonOrganization = simulationEnterprise.getOrganizationDirectory().createAndAddOrganization(OrgType.Simulation);
        
        platform.getCityDirectory().createAndAddCity("New York");
        platform.getCityDirectory().createAndAddCity("Los Angeles");
        platform.getCityDirectory().createAndAddCity("Boston");
        
        Employee e = platform.getEmployeeDirectory().createAndAddEmployee("Liu Lou", "23", SexType.Male, "liu.lou@northeastern.edu", platform.getCityDirectory().getCityList().get(0));
        testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e);
        testingPeopleOrganization.getEmployeeDirectory().addEmployee(e);
        
        UserAccount ua = platform.getUserAccountDirectory().createAndAddUserAccount("coulson", "Lou123@", e, new RegisteredTestingPeopleRole());
        testingPeopleEnterprise.getUserAccountDirectory().addUserAccount(ua);
        testingPeopleOrganization.getUserAccountDirectory().addUserAccount(ua);
        
        
        Employee e2 = platform.getEmployeeDirectory().createAndAddEmployee("Amy", "23", SexType.Female, "coulson0104@icloud.com", platform.getCityDirectory().getCityList().get(1));
        testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e2);
        testingPeopleOrganization.getEmployeeDirectory().addEmployee(e2);
        
        UserAccount ua2 = platform.getUserAccountDirectory().createAndAddUserAccount("11111", "Lou123@", e2, new TestingSiteAdminRole());
        testingSiteEnterprise.getUserAccountDirectory().addUserAccount(ua2);
        TestingSiteManager.getUserAccountDirectory().addUserAccount(ua2);
        
        
        Employee e3 = platform.getEmployeeDirectory().createAndAddEmployee("Mike", "23", SexType.Male, "coulson0104@icloud.com", platform.getCityDirectory().getCityList().get(1));
        testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e3);
        testingPeopleOrganization.getEmployeeDirectory().addEmployee(e3);
        
        UserAccount ua3 = platform.getUserAccountDirectory().createAndAddUserAccount("22222", "Lou123@", e3, new SampleCollectionPeopleRole());
        testingSiteEnterprise.getUserAccountDirectory().addUserAccount(ua3);
        TestingSiteManager.getUserAccountDirectory().addUserAccount(ua3);
        
        Employee e4 = platform.getEmployeeDirectory().createAndAddEmployee("John", "23", SexType.Male, "coulson0104@icloud.com", platform.getCityDirectory().getCityList().get(1));
        testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e4);
        testingPeopleOrganization.getEmployeeDirectory().addEmployee(e4);
        
        UserAccount ua4 = platform.getUserAccountDirectory().createAndAddUserAccount("33333", "Lou123@", e4, new NucleicAcidTesterRole());
        testingSiteEnterprise.getUserAccountDirectory().addUserAccount(ua4);
        TestingSiteManager.getUserAccountDirectory().addUserAccount(ua4);

//        
//        Employee e1 = new RestaurantManager("Restaurant Manager1", r1);
//        UserAccount ua1 = r1.getOrganizationDirectory().getRestaurantManagerOrg().getUserAccountDirectory().createAndAddUserAccount("rm1", "rm1", e1, new AdminRole());
//        
//        Employee e2 = new RestaurantManager("Restaurant Manager2", r2);
//        UserAccount ua2 = r2.getOrganizationDirectory().getRestaurantManagerOrg().getUserAccountDirectory().createAndAddUserAccount("rm2", "rm2", e2, new AdminRole());
//        
//        Employee e3 = new Customer("Customer1");
//        UserAccount ua3 = platform.addCustomer("c1", "c1", e3, new CustomerRole());
//        OrderRequest orderRequest1 = platform.createAddOrderRequest(ua3, r1, r1.getMenuList().get(0), 1);
//        
//        Employee e4 = new DeliveryMan("DeliveryMan1");
//        platform.addDeliveryMan("dm1", "dm1", e4, new DeliveryManRole());
//        
//        Employee e5 = new DeliveryMan("DeliveryMan2");
//        platform.addDeliveryMan("dm2", "dm2", e5, new DeliveryManRole());
        
        return platform;
    }
}
