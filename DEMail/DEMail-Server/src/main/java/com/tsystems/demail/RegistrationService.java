package com.tsystems.demail;

import java.math.BigInteger;
import javax.persistence.EntityManager;

public class RegistrationService 
{
    public static boolean userChecking(String user)
    {
         EntityManager em = Server.emf.createEntityManager();
         em.getTransaction().begin();
            if ((BigInteger) em.createNativeQuery("select count(name) from Mails where name='" + user + "'").getSingleResult() == BigInteger.ONE) {
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
         if ((BigInteger) em.createNativeQuery("select count(mobile_phone) from Accounts where mobile_phone='" + phone + "'").getSingleResult() == BigInteger.ONE) {
                em.close();
                return false;
            }
        em.close();
        return true;
    }
}
