package com.mycompany.demailmavenbased.DAO;

import com.mycompany.demailmavenbased.App;
import com.mycompany.demailmavenbased.Validator;
import com.mycompany.demailmavenbased.entity.Accounts;
import java.awt.Component;
import java.math.BigInteger;
import java.sql.Date;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class RegistrationDAO {
    
    public static boolean submit(String user, String password, String rtpassword, String firstname, String lastname, String phone, Date birthday, boolean clickBox, Component rootPane) {
        boolean nameCheck = false, userCheck = false, passCheck = false, rtpassCheck = false,
                phoneCheck = false;
        String nameAlert = "";
        String userAlert = "";
        String passAlert = "";
        String rtpasswordAlert = "";
        String phoneAlert = "";
        String agreementAlert = "";
        nameCheck = Validator.nameChecking(firstname) && Validator.nameChecking(lastname);
        userCheck = Validator.userNameChecking(user);
        phoneCheck = Validator.phoneChecking(phone);
        if (password.length() > 6) {
            passCheck = true;
        }
        if (password.equals(rtpassword)) {
            rtpassCheck = true;
        }
        if ((nameCheck && userCheck && passCheck && rtpassCheck && phoneCheck && clickBox) == false) {
            if (nameCheck == false) {
                nameAlert = "Firstname and lastname must contain only characters and can not be null.\n";
            }
            if (userCheck == false) {
                userAlert = "Username must be between 6 and 30 characters and contain only letters (a-z) and numbers.\n";
            }
            if (passCheck == false) {
                passAlert = "Password must be at least 6 characters.\n";
            }
            if (rtpassCheck == false) {
                rtpasswordAlert = "Passwords don't match.\n";
            }
            if (phoneCheck == false) {
                phoneAlert = "Phone number format is not recognized.\n";
            }
            if (clickBox == false) {
                agreementAlert = "You are not agree with the registration agreement.\n";
            }
            JOptionPane.showMessageDialog(rootPane, nameAlert + userAlert + passAlert
                    + rtpasswordAlert + phoneAlert + agreementAlert);
            
            return false;
        } else {
            EntityManager em = App.emf.createEntityManager();
            em.getTransaction().begin();
            if ((BigInteger) em.createNativeQuery("select count(user) from Accounts where user='" + user + "'").getSingleResult() == BigInteger.ONE) {
                JOptionPane.showMessageDialog(rootPane, "User with that name is already registered.");
                return false;
            }
            if ((BigInteger) em.createNativeQuery("select count(MobilePhone) from Accounts where MobilePhone='" + phone + "'").getSingleResult() == BigInteger.ONE) {
                JOptionPane.showMessageDialog(rootPane, "User with that phone is already registered.");
                return false;
            }
            Accounts acc = new Accounts(user, password, firstname, lastname, phone, birthday);
            em.persist(acc);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(rootPane, "Registration was successful. \nYour new e-mail is " + user + "@demail.com");
            
            return true;
        }
    }
}
