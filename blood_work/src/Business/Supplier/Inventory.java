
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Supplier;
import java.util.HashMap;


/**
 *
 * @author nivcodes
 */
public class Inventory {
    public static String[] options = {"Syringe", "Sterile cotton", "Vials", "Swabs"};
    public static String[] inventoryStatus = {"Out of stock", "In stock"};
    
    public HashMap<String, Integer> inventoryMap = new HashMap<>();

    public Inventory() {
        inventoryMap.put("Syringe", 100);
        inventoryMap.put("Sterile cotton", 200);
        inventoryMap.put("Vials", 200);
        inventoryMap.put("Swabs", 200);
    }

    public HashMap<String, Integer> getInventoryMap() {
        return inventoryMap;
    }
    
    public String getStockStatus(String key) {
        if (inventoryMap.get(key) > 0) {
            return inventoryStatus[1];
        }
            
        return inventoryStatus[0];
    }
    
    public void updateStatus(String key, Integer value) {
        inventoryMap.put(key, inventoryMap.get(key) - value);
    }

    public void updateInventory(String key, Integer value) {
        inventoryMap.put(key, inventoryMap.get(key) + value);
    }
    
}

