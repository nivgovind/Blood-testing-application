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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author shubhank
 */
public class EmailToolKit {

    public static void sendMail(String from, String to, String subject, String msg) throws Exception {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 587);
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        String username = "saxena.shubhank.19@gmail.com";
        String password = "wgxp ncld xbrv utxm";

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
    
    public static void sendEmailWhenNewSlotReleased(Platform platform, TestSlotRequest newSlot) throws Exception {
        Enterprise testingPeopleEnterprise = platform.getEnterpriseDirectory().getEnterprise(Enterprise.EnterpriseType.TestingPeople);
        for (UserAccount ua : testingPeopleEnterprise.getUserAccountDirectory().getActiveUserAccounts()) {
            // Todo - Replace lorem ipsem with the to email address
            sendMail(ua.getEmployee().getEmail(), "Lorem Ipsem","New Slot Released", "The new slot is scheduled on " + newSlot.getScheduledTestingDate() + ".");
        }
    }


    public static void sendEmailWhenSlotCancelled(Platform platform, TestSlotRequest tsr) throws Exception {
        for (TestRequest tr : tsr.getTestRequestList()) {
            if (tr.isBooked()) {
                // Todo - Replace lorem ipsem with the to email address
                sendMail(tr.getTestingPeople().getEmployee().getEmail(), "Lorem Ipsem ","Slot Cancelled", "We are so sorry to tell you that the slot which is scheduled on " + tr.getTestSlotRequest().getScheduledTestingDate() + " was cancelled due to some technical problems. Thanks for your cooperation.");
            }
        }
    }
    
    public static void sendEmailWhenTestResultReleased(Platform platform, TestRequest tr, String result) throws Exception {
        // Todo - Replace lorem ipsem with the to email address
        sendMail(tr.getTestingPeople().getEmployee().getEmail(), "Lorem Ipsem", "Result Released", "Your COVID-19 nucleic acid test result is " + result + ". Thanks for your cooperation.");
    }

    public static void sendEmailWhenSuccessfullyRegistered() throws Exception {
        // Todo - Replace lorem ipsem with the from and to email address. Replace username with the username of the user who registered
        sendMail("Lorem Ipsem", "Lorem Ipsem", "Registration completed", "Hi, " + "Username"  + "!\n\nCongratulations, you are registered successfully to our blood testing platrom.");
    }
}

// Google App password for application
// wgxp ncld xbrv utxm

