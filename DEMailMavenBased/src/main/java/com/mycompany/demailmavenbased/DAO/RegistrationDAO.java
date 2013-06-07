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
