/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Supplier;

import Business.UserAccount.UserAccount;

/**
 *
 * @author nivcodes
 */
public class EqOrders {
    UserAccount supplier;
    UserAccount requester;
    String type;
    String status;
    int quantity;
    public static String[] options = {"Syringe", "Collector", "Test tubes", "Swabs"};
    public static String[] statusOptions = {"Placed", "Shipped", "Delivered"};

    public EqOrders(String type, int quantity, UserAccount requester) {
        this.requester = requester;
        this.type = type;
        this.quantity = quantity;
        status = "Placed";
    }
    
    public EqOrders() {
        status = "Placed";
    }

    public UserAccount getSupplier() {
        return supplier;
    }

    public void setSupplier(UserAccount supplier) {
        this.supplier = supplier;
    }

    public UserAccount getRequester() {
        return requester;
    }

    public void setRequester(UserAccount requester) {
        this.requester = requester;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    @Override
    public String toString() {
        return type;
    }
}
