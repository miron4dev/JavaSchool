package com.tsystems.demail;

import java.math.BigInteger;
import javax.persistence.EntityManager;

public class RegistrationService 
{
    public static boolean userChecking(String user)
    {
         EntityManager em = Server.emf.createEntityManager();
         em.getTransaction().begin();
            if ((BigInteger) em.createNativeQuery("select count(user) from Accounts where user='" + user + "'").getSingleResult() == BigInteger.ONE) {
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
         if ((BigInteger) em.createNativeQuery("select count(MobilePhone) from Accounts where MobilePhone='" + phone + "'").getSingleResult() == BigInteger.ONE) {
                em.close();
                return false;
            }
        em.close();
        return true;
    }
}
