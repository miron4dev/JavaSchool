package com.tsystems.demail;

import java.util.List;
import javax.persistence.EntityManager;

public class LoginDAO 
{
    public static List connectToProfile(String phone)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        List mails = em.createQuery("select mobile_phone, password, first_name, last_name from Accounts where mobile_phone='" + phone + "'").getResultList();
        em.close();
   
        return mails;
    }

}
