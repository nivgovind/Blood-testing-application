/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.City.City;

/**
 *
 * @author raunak
 */
public class Employee {
    
    private String name;  
    private String age;
    private SexType sex; // 0-female, 1-male
    private String email;
    private City city;
    private int id;
    private static int count = 1;
    
    public enum SexType{
        Female("Female"),
        Male("Male");
        
        private String value;
        private SexType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Employee(String name, String age, SexType sex, String email, City city) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        this.city = city;
        
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
