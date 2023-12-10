/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author nivcodes
 */
public class MessageDirectory {
    ArrayList<MessageRequest> msgList;

    public MessageDirectory() {
        msgList = new ArrayList();
    }

    public ArrayList<MessageRequest> getMsgList() {
        return msgList;
    }

    public void setMsgList(ArrayList<MessageRequest> msgList) {
        this.msgList = msgList;
    }
    
    public MessageRequest addMessageRequest(UserAccount sender,UserAccount receiver, String messageBody){
        MessageRequest msg = new MessageRequest(sender, receiver, messageBody);
        msgList.add(msg);
        return msg;
    }

    public ArrayList<MessageRequest> searchMessageRequestbyreciever(UserAccount userAccount) {
        ArrayList<MessageRequest> result = new ArrayList<>();
        for (MessageRequest msg : msgList) {
            if (msg.getReceiver().equals(userAccount)) {
                result.add(msg);
            }
        }
        return result;
    }
    
}
