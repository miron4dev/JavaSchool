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
        String real_password;
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
