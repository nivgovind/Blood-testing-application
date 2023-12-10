/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.City.City;
import Business.Employee.Employee.SexType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shreya
 */
public class EmployeeDirectory {
    
    private List<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<Employee>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
    
    public Employee createAndAddEmployee(String name, String age, SexType sex, String email, City city){
        Employee employee = new Employee(name, age, sex, email, city);
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
}