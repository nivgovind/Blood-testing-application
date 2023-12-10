/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class MessageRequest extends WorkRequest{
    
    private String messageBody;
    private boolean read;

    public MessageRequest(UserAccount sender,UserAccount receiver, String messageBody) {
        super(sender, receiver);
        this.messageBody = messageBody;
        read = false;
    }
    
    public Date getSendDate() {
        return super.getRequestDate();
    }
    
    public Date getReadDate() {
        return super.getResolveDate();
    }
    
    public void setAsRead() {
        setRead(true);
        super.setResolveDate(new Date());
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
    
    @Override
    public String toString() {
        return messageBody;
    }
}
