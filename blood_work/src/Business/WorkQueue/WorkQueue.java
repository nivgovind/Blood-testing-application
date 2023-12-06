/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public void addWorkRequest(WorkRequest workRequest) {
        workRequestList.add(workRequest);
    }
    
    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}