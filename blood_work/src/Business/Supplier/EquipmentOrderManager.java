/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Supplier;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author nivcodes
 */
public class EquipmentOrderManager {
    private ArrayList<EqOrders> EquipmentOrdersList;
    
    public EquipmentOrderManager() {
        EquipmentOrdersList = new ArrayList<>();
    }

    public ArrayList<EqOrders> getEquipmentOrdersList() {
        return EquipmentOrdersList;
    }

    public void setEquipmentOrdersList(ArrayList<EqOrders> EquipmentOrdersList) {
        this.EquipmentOrdersList = EquipmentOrdersList;
    }

    public EqOrders addEquipmentOrders() {
        EqOrders equipmentOrders = new EqOrders();
        EquipmentOrdersList.add(equipmentOrders);
        return equipmentOrders;
    }
    
    public EqOrders addEquipmentOrders(String type, int q, UserAccount requester) {
        EqOrders equipmentOrders = new EqOrders(type, q, requester);
        EquipmentOrdersList.add(equipmentOrders);
        return equipmentOrders;
    }

    public void removeEquipmentOrders(EqOrders equipmentOrders) {
        EquipmentOrdersList.remove(equipmentOrders);
    }

    public EqOrders searchEquipmentOrders(String type, String status) {
        for (EqOrders equipmentOrders : EquipmentOrdersList) {
            if (equipmentOrders.getType().equals(type) && equipmentOrders.getStatus().equals(status)) {
                return equipmentOrders;
            }
        }
        return null;
    }

    
    
}
