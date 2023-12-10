/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shreya
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }
    
    public List<UserAccount> getActiveUserAccounts() {
        List<UserAccount> list = new ArrayList<>();
        for (UserAccount ua : userAccountList) {
            if(!ua.isDeleted()) {
                list.add(ua);
            }
        }
        return list;
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public void addUserAccount(UserAccount ua) {
        userAccountList.add(ua);
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createAndAddUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount(username, password, employee, role);
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }

    

    public UserAccount searchByUsername(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                return ua;
            }
        }
        return null;
    }

}