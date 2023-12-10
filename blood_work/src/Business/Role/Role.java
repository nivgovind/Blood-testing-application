/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Organization.Organization;
import Business.Platform;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author shreya
 */
public abstract class Role {
    
    private String name;

    public Role(String name) {
        this.name = name;
    }
    
    public enum RoleType{
        RegisteredTestingPeople("TestingPeople"),
        TestingPeopleAdmin("TestingPeopleAdmin"),
        SampleCollectionPeople("SampleCollectionPeople"),
        NucleicAcidTester("NucleicAcidTester"),
        TestingSiteDataHandler("TestingSiteDataHandler"),
        TestingSiteAdmin("TestingSiteAdmin"),
        CDCDataHandler("CDCDataHandler"),
        CDCInfoDistributor("CDCInfoDistributor"),
        CDCAdmin("CDCAdmin"),
        SimulationOperator("SimulationOperator"),
        OverallAdmin("OverallAdmin");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account,  
            Platform platform);

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
    
}