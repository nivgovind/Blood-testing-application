/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.Objects;

/**
 *
 * @author shreya
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    boolean deleted  = false;
    String iconPath;

    public UserAccount(String username, String password, Employee employee, Role role) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        this.role = role;
        this.workQueue = new WorkQueue();
        String rootDir = System.getProperty("user.dir");
        iconPath = rootDir + "\\src\\Resources\\DefaultUserIcon.png";
//        iconPath = "src/Resources/DefaultUserIcon.png";
    }
    
    public void deleteThisAccount() {
        setDeleted(true);
    }
    
    public void enableThisAccount() {
        setDeleted(false);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserAccount other = (UserAccount) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.role, other.role)) {
            return false;
        }
        return true;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public boolean isDeleted() {
        return deleted;
    }

    private void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
    
    
    
    @Override
    public String toString() {
        if (this.isDeleted()) {
            return "</deleted>" + username;
        }
        return username;
    }
    
    
    
}