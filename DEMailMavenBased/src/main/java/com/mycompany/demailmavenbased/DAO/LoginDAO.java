package com.mycompany.demailmavenbased.DAO;

import com.mycompany.demailmavenbased.App;
import com.mycompany.demailmavenbased.Validator;
import java.awt.Component;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

public class LoginDAO {

    public static boolean connect(String username, String password, Component rootPane) 
    {
        String userAlert = "", passAlert = "";
        String real_password;
        boolean check = true;
        if (Validator.userNameChecking(username) == false) 
        {
            userAlert = "Username is invalid.\n";
            check = false;
        }
        if (password.length() <= 6) 
        {
            passAlert = "Password is too short.\n";
            check = false;
        }
        if (check == false) {
            JOptionPane.showMessageDialog(rootPane, userAlert + passAlert);
            return false;
        }
        EntityManager em = App.emf.createEntityManager();
        em.getTransaction().begin();
        try 
        {
            real_password = em.createNativeQuery("select password from Accounts where user='" + username + "'").getSingleResult().toString();

            if (password.equals(real_password)) {
                return true;
            }
        } catch (NoResultException ex) {
            JOptionPane.showMessageDialog(rootPane, "Wrong username or password");
        } finally {
            em.close();
        }
        return false;
    }
}
