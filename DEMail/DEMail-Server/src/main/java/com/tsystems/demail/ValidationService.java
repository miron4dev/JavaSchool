/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tsystems.demail;

import java.math.BigInteger;
import javax.persistence.EntityManager;

public class ValidationService 
{
    public static boolean userChecking(String user)
    {
         EntityManager em = Server.emf.createEntityManager();
         em.getTransaction().begin();
            if((Long)em.createQuery("select count(name) from Mails where name='" + user + "'").getSingleResult() == 1) {
                em.close();
                return false;
            }
            em.close();
            return true;
    }
    
    public static boolean phoneChecking(String phone)
    { 
         EntityManager em = Server.emf.createEntityManager();
         em.getTransaction().begin();
         if((Long)em.createQuery("select count(mobile_phone) from Accounts where mobile_phone='" + phone + "'").getSingleResult() == 1) {
                em.close();
                return false;
            }
        em.close();
        return true;
    }
}
