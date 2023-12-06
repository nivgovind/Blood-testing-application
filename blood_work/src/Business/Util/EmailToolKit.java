/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Util;

import Business.Enterprise.Enterprise;
import Business.Platform;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestRequest;
import Business.WorkQueue.TestSlotRequest;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Administrator
 */
public class EmailToolKit {
    
    private static void basicSend(String receiveEmial, String subject, String callingOfReceiver, String messageBody) {
        final String username = "coulson0104@outlook.com";  // like yourname@outlook.com
        final String nickname = "QuaranTeam"; // people see this rather than the whole email address of the sender
        final String password = "liulou19970104";   // password here

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");//smtp.office365.com
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        session.setDebug(false);

        try {

            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(username, nickname));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(EmailToolKit.class.getName()).log(Level.SEVERE, null, ex);
            }
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiveEmial));   // like inzi769@gmail.com
            message.setSubject(subject);
            message.setText("Hi, " + callingOfReceiver  + "!\n\n" + messageBody + "\n\nSincerely,\nQuaranTeam");

            Transport.send(message);

            System.out.println("Sent email successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void sendEmailWhenNewSlotReleased(Platform platform, TestSlotRequest newSlot) {
        Enterprise testingPeopleEnterprise = platform.getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.TestingPeople);
        for (UserAccount ua : testingPeopleEnterprise.getUserAccountDirectory().getActiveUserAccounts()) {
            basicSend(ua.getEmployee().getEmail(), "New Slot Released", ua.getUsername(), "The new slot is scheduled on " + newSlot.getScheduledTestingDate() + ".");
        }
    }
    
    
    public static void sendEmailWhenSlotCancelled(Platform platform, TestSlotRequest tsr) {
        for (TestRequest tr : tsr.getTestRequestList()) {
            if (tr.isBooked()) {
                basicSend(tr.getTestingPeople().getEmployee().getEmail(), "Slot Cancelled", tr.getTestingPeople().getUsername(), "We are so sorry to tell you that the slot which is scheduled on " + tr.getTestSlotRequest().getScheduledTestingDate() + " was cancelled due to some technical problems. Thanks for your cooperation.");
            }
        }
    }
    
    public static void sendEmailWhenTestResultReleased(Platform platform, TestRequest tr, String result) {
        basicSend(tr.getTestingPeople().getEmployee().getEmail(), "Result Released", tr.getTestingPeople().getUsername(), "Your COVID-19 nucleic acid test result is " + result + ". Thanks for your cooperation.");
    }
    
    public static void sendEmailWhenSuccessfullyRegistered(String receiverEmail, UserAccount ua) {
        
        final String username = "coulson0104@outlook.com";  // like yourname@outlook.com
        final String nickname = "QuaranTeam"; // people see this rather than the whole email address of the sender
        final String password = "liulou19970104";   // password here

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");//smtp.office365.com
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        session.setDebug(false);

        try {

            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(username, nickname));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(EmailToolKit.class.getName()).log(Level.SEVERE, null, ex);
            }
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));   // like inzi769@gmail.com
            message.setSubject("Registration completed");
            message.setText("Hi, " + ua.getUsername()  + "!\n\nCongratulations, you are registered successfully to our COVID-19 TESTING "
                    + "AND WARNING PLATFORM. Wish you all the best through this pandemic.\n\nSincerely,\nQuaranTeam");

            Transport.send(message);

            System.out.println("Sent email successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
//        // 收件人电子邮箱
//      String to = email;
// 
//      // 发件人电子邮箱
//      String from = "liu.lou@northeastern.edu";
// 
//      // 指定发送邮件的主机为 localhost
//      String host = "smtp.office365.com";
// 
//      // 获取系统属性
//      Properties properties = System.getProperties();
// 
//      // 设置邮件服务器
//      properties.setProperty("mail.smtp.host", host);
// 
//      // 获取默认session对象
//      Session session = Session.getDefaultInstance(properties);
// 
//      try{
//         // 创建默认的 MimeMessage 对象
//         MimeMessage message = new MimeMessage(session);
// 
//         // Set From: 头部头字段
//         message.setFrom(new InternetAddress(from));
// 
//         // Set To: 头部头字段
//         message.addRecipient(Message.RecipientType.TO,
//                                  new InternetAddress(to));
// 
//         // Set Subject: 头部头字段
//         message.setSubject("QuaranTeam");
// 
//         // 设置消息体
//         message.setText("Congratulations! You are registered successfully!!!");
// 
//         // 发送消息
//         Transport.send(message);
//         System.out.println("Sent email successfully....");
//      }catch (MessagingException mex) {
//         mex.printStackTrace();
//      }
    }
    
}
