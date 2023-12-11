package Business;

import Business.City.City;
import Business.Employee.Employee;
import Business.Employee.Employee.SexType;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.Organization;
import Business.Organization.Organization.OrgType;
import Business.Role.CDCAdminRole;
import Business.Role.CDCDataHandlerRole;
import Business.Role.CDCInfoDistributorRole;
import Business.Role.NucleicAcidTesterRole;
import Business.Role.RegisteredTestingPeopleRole;
import Business.Role.Role;
import Business.Role.SampleCollectionPeopleRole;
import Business.Role.SimulationOperatorRole;
import Business.Role.TestingPeopleAdminRole;
import Business.Role.TestingSiteAdminRole;
import Business.Role.TestingSiteDataHandlerRole;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestRequest;
import Business.WorkQueue.TestSlotRequest;
import java.util.Calendar;
import java.util.Date;



/**
 *
 * @author nivcodes
 */
public class ConfigureAPlatform {
    public static Faker fn = new Faker();
    
    public ConfigureAPlatform() {
        
    }
    public Platform configure(){
        
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
        
        // Employee e = platform.getEmployeeDirectory().createAndAddEmployee("Liu Lou", "23", SexType.Male, "liu.lou@northeastern.edu", platform.getCityDirectory().getCityList().get(0));
        // testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e);
        // testingPeopleOrganization.getEmployeeDirectory().addEmployee(e);
        
        // UserAccount ua = platform.getUserAccountDirectory().createAndAddUserAccount("coulson", "Lou123@", e, new RegisteredTestingPeopleRole());
        // testingPeopleEnterprise.getUserAccountDirectory().addUserAccount(ua);
        // testingPeopleOrganization.getUserAccountDirectory().addUserAccount(ua);
        
        
        // Employee e2 = platform.getEmployeeDirectory().createAndAddEmployee("Amy", "23", SexType.Female, "coulson0104@icloud.com", platform.getCityDirectory().getCityList().get(1));
        // testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e2);
        // testingPeopleOrganization.getEmployeeDirectory().addEmployee(e2);
        
        // UserAccount ua2 = platform.getUserAccountDirectory().createAndAddUserAccount("11111", "Lou123@", e2, new TestingSiteAdminRole());
        // testingSiteEnterprise.getUserAccountDirectory().addUserAccount(ua2);
        // TestingSiteManager.getUserAccountDirectory().addUserAccount(ua2);
        
        
        // Employee e3 = platform.getEmployeeDirectory().createAndAddEmployee("Mike", "23", SexType.Male, "coulson0104@icloud.com", platform.getCityDirectory().getCityList().get(1));
        // testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e3);
        // testingPeopleOrganization.getEmployeeDirectory().addEmployee(e3);
        
        // UserAccount ua3 = platform.getUserAccountDirectory().createAndAddUserAccount("22222", "Lou123@", e3, new SampleCollectionPeopleRole());
        // testingSiteEnterprise.getUserAccountDirectory().addUserAccount(ua3);
        // TestingSiteManager.getUserAccountDirectory().addUserAccount(ua3);
        
        // Employee e4 = platform.getEmployeeDirectory().createAndAddEmployee("John", "23", SexType.Male, "coulson0104@icloud.com", platform.getCityDirectory().getCityList().get(1));
        // testingPeopleEnterprise.getEmployeeDirectory().addEmployee(e4);
        // testingPeopleOrganization.getEmployeeDirectory().addEmployee(e4);
        
        // UserAccount ua4 = platform.getUserAccountDirectory().createAndAddUserAccount("33333", "Lou123@", e4, new NucleicAcidTesterRole());
        // testingSiteEnterprise.getUserAccountDirectory().addUserAccount(ua4);
        // TestingSiteManager.getUserAccountDirectory().addUserAccount(ua4);

        configure_app(platform);
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
    
    public UserAccount create_account(Platform platform, String username, String password, String email, String name, String age, Employee.SexType sexType, City city, Role role) {
        // SexType sexType = rbtnMale.isSelected() ? SexType.Male : SexType.Female;
        // City city = (City) cbxCity.getSelectedItem();
        // Role role = (Role) cbxRegisteredRole.getSelectedItem();
        
        
        Employee e = new Employee(name, age, sexType, email, city);
        platform.getEmployeeDirectory().createAndAddEmployee(name, age, sexType, email, city);
        UserAccount ua = platform.getUserAccountDirectory().createAndAddUserAccount(username, password, e, role);
        
        // get enterprise and organization that the newly registered user belongs to
        Enterprise enterprise = platform.getEnterpriseDirectory().getEnterpriseByRole(role);
        Organization organization = enterprise.getOrganizationDirectory().getOrganizationByRole(role);
        
        // add employee and useraccount to the specific enterprise and organization
        enterprise.getEmployeeDirectory().addEmployee(e);
        enterprise.getUserAccountDirectory().addUserAccount(ua);
        organization.getEmployeeDirectory().addEmployee(e);
        organization.getUserAccountDirectory().addUserAccount(ua);
        
        return ua;
    }
    
    public void setup_test_users(Platform platform) {
//        RegisteredTestingPeopleRole
        create_account(platform, "Qwerty1", "Qwerty@123", "govindaraj.n@northeastern.edu", "Qwerty1", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new RegisteredTestingPeopleRole());
        create_account(platform, "Tpeople2", "Qwerty@123", "gupta.shreya@northeastern.edu", "Qwerty1", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new RegisteredTestingPeopleRole());
        create_account(platform, "Tpeople3", "Qwerty@123", "saxena.shubh@northeastern.edu", "Qwerty1", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new RegisteredTestingPeopleRole());
        
        
        create_account(platform, "Qwerty2", "Qwerty@123", "b@n.edu", "Qwerty2", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new TestingPeopleAdminRole());
        create_account(platform, "Qwerty3", "Qwerty@123", "c@n.edu", "Qwerty3", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new SampleCollectionPeopleRole());
        create_account(platform, "Qwerty4", "Qwerty@123", "d@n.edu", "Qwerty4", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new NucleicAcidTesterRole());
        create_account(platform, "Qwerty5", "Qwerty@123", "e@n.edu", "Qwerty5", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new TestingSiteDataHandlerRole());
        create_account(platform, "Qwerty6", "Qwerty@123", "f@n.edu", "Qwerty6", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new TestingSiteAdminRole());
        create_account(platform, "Qwerty7", "Qwerty@123", "g@n.edu", "Qwerty7", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new CDCAdminRole());
        create_account(platform, "Qwerty8", "Qwerty@123", "h@n.edu", "Qwerty8", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new CDCDataHandlerRole());
        create_account(platform, "Qwerty9", "Qwerty@123", "i@n.edu", "Qwerty9", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new CDCInfoDistributorRole());
        create_account(platform, "Qwerty10", "Qwerty@123", "j@n.edu", "Qwerty10", "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new SimulationOperatorRole());
    }
    
    
    
    public TestSlotRequest setup_slot(Platform platform, String username, String pwd, int capacity, int year, int month, int day) {
//        TestingSiteAdminRole() only releases slots
        UserAccount userAccount = platform.getUserAccountDirectory().authenticateUser(username, pwd);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        Date scheduleTestingDate = calendar.getTime();
//        long scheduleTestingDateMills = calendar.getTimeInMillis();
        
        Enterprise enterprise = platform.getEnterpriseDirectory().getEnterpriseByRole(userAccount.getRole());
        
//        WorkQueue requestQueue = enterprise.getWorkQueue();
        TestSlotRequest newSlot = new TestSlotRequest(userAccount, scheduleTestingDate, capacity);
        enterprise.getWorkQueue().addWorkRequest(newSlot);
        platform.getAllActivitiesWorkQueue().addWorkRequest(newSlot);
        newSlot.release();
        
//        Book some slots for dummy user
        book_test(platform, "Tpeople2", "Qwerty@123", newSlot);
        book_test(platform, "Tpeople3", "Qwerty@123", newSlot);
        
//        EmailToolKit.sendEmailWhenNewSlotReleased(platform, newSlot);

        return newSlot;
    }
    
    public void book_test(Platform platform, String username, String pwd, TestSlotRequest tsr){
        UserAccount userAccount = platform.getUserAccountDirectory().authenticateUser(username, pwd);
        Enterprise testingPeopleEnterprise = platform.getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.TestingPeople);
        Enterprise testingSiteEnterprise = platform.getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.TestingSite);
        
        TestRequest newBookedTr = tsr.bookOneTest(userAccount);
        testingPeopleEnterprise.getWorkQueue().addWorkRequest(newBookedTr);
        testingSiteEnterprise.getWorkQueue().addWorkRequest(newBookedTr);
        platform.getAllActivitiesWorkQueue().addWorkRequest(newBookedTr);
    }
    
//    collect samples + mark completed
    public TestSlotRequest bulk_book_tests(Platform platform, TestSlotRequest tsr) {
        String username;
        tsr.getCapacity();
        UserAccount ua;
        UserAccount sampler = platform.getUserAccountDirectory().authenticateUser("Qwerty3", "Qwerty@123");
        for (int i = 1; i <= tsr.getCapacity(); i++) {
            username = fn.getName();
            ua = create_account(platform, username, "Qwerty@123", (username+"@neu.edu"), username, "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new RegisteredTestingPeopleRole());
            book_test(platform, ua.getUsername(), ua.getPassword(), tsr);
        }
        tsr.collectAllSamples(sampler);
        tsr.markSampleCollectionCompleted();
        return tsr;
    }
    
    public TestSlotRequest bulk_nat_tests(Platform platform, TestSlotRequest tsr) {
        tsr.getCapacity();
        String username;
        UserAccount ua;
        UserAccount sampler = platform.getUserAccountDirectory().authenticateUser("Qwerty3", "Qwerty@123");
        UserAccount natc = platform.getUserAccountDirectory().authenticateUser("Qwerty4", "Qwerty@123");
        for (int i = 1; i <= tsr.getCapacity(); i++) {
            username = fn.getName();
            ua = create_account(platform, username, "Qwerty@123", (username+"@n.edu"), username, "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new RegisteredTestingPeopleRole());
            book_test(platform, ua.getUsername(), ua.getPassword(), tsr);
        }
        tsr.collectAllSamples(sampler);
        tsr.markSampleCollectionCompleted();
        tsr.TestAllSamples(natc);
        tsr.markNucleicAcidTestCompleted();
        return tsr;
    }
    
//    public TestSlotRequest bulk_cdc_tests(Platform platform, TestSlotRequest tsr) {
//        tsr.getCapacity();
//        String username;
//        UserAccount ua;
//        UserAccount sampler = platform.getUserAccountDirectory().authenticateUser("Qwerty3", "Qwerty@123");
//        UserAccount natc = platform.getUserAccountDirectory().authenticateUser("Qwerty4", "Qwerty@123");
//        for (int i = 1; i <= tsr.getCapacity(); i++) {
//            username = fn.getName();
//            ua = create_account(platform, username, "Qwerty@123", (username+"@n.edu"), username, "20", Employee.SexType.Female, platform.getCityDirectory().getCityList().get(1), new RegisteredTestingPeopleRole());
//            book_test(platform, ua.getUsername(), ua.getPassword(), tsr);
//        }
//        tsr.collectAllSamples(sampler);
//        tsr.markSampleCollectionCompleted();
//        tsr.TestAllSamples(natc);
//        tsr.markSampleCollectionCompleted();
//        return tsr;
//    }
    
    
    
    public void configure_app(Platform platform) {
        setup_test_users(platform);
        setup_slot(platform, "Qwerty6", "Qwerty@123", 5, 2023, 12, 4);
        setup_slot(platform, "Qwerty6", "Qwerty@123", 5, 2023, 12, 5);
        setup_slot(platform, "Qwerty6", "Qwerty@123", 5, 2023, 12, 6);
        
//        Collected samples
        TestSlotRequest tsr1 = setup_slot(platform, "Qwerty6", "Qwerty@123", 15, 2023, 12, 4);
        bulk_book_tests(platform, tsr1);
        
//        tested samples
        TestSlotRequest tsr2 = setup_slot(platform, "Qwerty6", "Qwerty@123", 20, 2023, 12, 6);
        bulk_nat_tests(platform, tsr2);

        TestSlotRequest tsr3 = setup_slot(platform, "Qwerty6", "Qwerty@123", 5, 2023, 12, 6);
        bulk_book_tests(platform, tsr3);
//        certified tests
//        TestSlotRequest tsr3 = setup_slot(platform, "Qwerty6", "Qwerty@123", 4, 2023, 12, 7);
//        bulk_nat_tests(platform, tsr3);
    }
}
