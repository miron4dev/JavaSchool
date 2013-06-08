package com.tsystems.demail;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class LoginService {

    public static boolean connect(String username, String password) 
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        try 
        {
            String real_password;
        
            real_password = em.createNativeQuery("select password from Accounts where user='" + username + "'").getSingleResult().toString();

            if (password.equals(real_password)) {
                return true;
            }
        } catch (NoResultException ex) {
            return false;
        } finally {
            em.close();
        }
        return false;
    }
}
