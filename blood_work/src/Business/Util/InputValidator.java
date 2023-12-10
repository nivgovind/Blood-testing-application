/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Util;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author nivcodes
 */
public class InputValidator {
    
//    Username requirements
//    Username consists of alphanumeric characters (a-zA-Z0-9), lowercase, or uppercase.
//    Username allowed of the dot (.), underscore (_), and hyphen (-).
//    The dot (.), underscore (_), or hyphen (-) must not be the first or last character.
//    The dot (.), underscore (_), or hyphen (-) does not appear consecutively, e.g., java..regex
//    The number of characters must be between 5 to 20.
    public static boolean userNameValidate(String str) {
        String regex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    
    public static void userNameValidate(JLabel label, JTextField textField) {
        String txt = textField.getText();
        String regex = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);
        boolean isValid =  matcher.matches();
        if (isValid) {
            label.setForeground(Color.black);
            textField.setBorder(new LineBorder(Color.green));
        }else {
            label.setForeground(Color.red);
            textField.setBorder(new LineBorder(Color.red));
        }
    }

    public static boolean passwordValidate(String str) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[$*#&@.]).{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    
    public static void passwordValidate(JLabel label, JTextField textField) {
        String txt = textField.getText();
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[$*#&@.]).{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);
        boolean isValid =  matcher.matches();
        if (isValid) {
            label.setForeground(Color.black);
            textField.setBorder(new LineBorder(Color.green));
        }else {
            label.setForeground(Color.red);
            textField.setBorder(new LineBorder(Color.red));
        }
    }
    
    public static boolean emailValidate(String str) {
        String regex = "[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    
    public static void emailValidate(JLabel label, JTextField textField) {
        String txt = textField.getText();
        String regex = "[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);
        boolean isValid =  matcher.matches();
        if (isValid) {
            label.setForeground(Color.black);
            textField.setBorder(new LineBorder(Color.green));
        }else {
            label.setForeground(Color.red);
            textField.setBorder(new LineBorder(Color.red));
        }
    }
    
//    Age requirements
//    validate age between 1-120 include (1 and 120)
//    [1-9] covers numbers between 1 and 9
//    [1-9][0-9] covers numbers between 10 and 99
//    1[01][0-9] covers numbers between 100 and 119
//    and 120 covers the number... 120
    public static boolean ageValidate(String str) {
        String regex = "^(?:[1-9]|[1-9][0-9]|1[01][0-9]|120)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
            return matcher.matches();
    }
    
    public static void ageValidate(JLabel label, JTextField textField) {
        String txt = textField.getText();
        String regex = "^(?:[1-9]|[1-9][0-9]|1[01][0-9]|120)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);
        boolean isValid =  matcher.matches();
        if (isValid) {
            label.setForeground(Color.black);
            textField.setBorder(new LineBorder(Color.green));
        }else {
            label.setForeground(Color.red);
            textField.setBorder(new LineBorder(Color.red));
        }
    }
    
    public static boolean noSpecialCharValidate(String str) {
        String regex = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str); 
        return !matcher.find(); 
    }
    
    public static boolean numbersOnlyValidate(String str) {
        String regex = "[^1234567890]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return !matcher.find();
    }
}
