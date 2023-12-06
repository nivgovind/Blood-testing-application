/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.City.CityDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Platform {
    private static Platform platform;
    private String version;
    private EnterpriseDirectory enterpriseDirectory;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private CityDirectory cityDirectory;
    private WorkQueue allActivitiesWorkQueue;
    private Logger platformLogger;

    public Platform() {
        version = "v. 1.0.0";
        enterpriseDirectory = new EnterpriseDirectory();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        cityDirectory = new CityDirectory();
        allActivitiesWorkQueue = new WorkQueue();
//        platformLogger = Logger.getLogger("Covid-19 Testing and Alert Platform");//this line will called storeSystem() error
    }
    
    public static Platform getInstance(){
        if(platform == null){
            // System.out.println("EcoSystem is null");
            platform = new Platform();
        }
        return platform;
    }
    
    public boolean checkIfUserAccountIsUnique(String userName){
       if (this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)) {
           return true;
       }
       return false;
    }

    public static Platform getPlatform() {
        return platform;
    }

    public static void setPlatform(Platform platform) {
        Platform.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public CityDirectory getCityDirectory() {
        return cityDirectory;
    }
    
    public WorkQueue getAllActivitiesWorkQueue() {
        return allActivitiesWorkQueue;
    }

    public Logger getPlatformLogger() {
        return platformLogger;
    }
    
}
