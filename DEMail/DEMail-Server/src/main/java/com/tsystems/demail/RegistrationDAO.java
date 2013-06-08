package com.tsystems.demail;

import java.sql.Date;
import javax.persistence.EntityManager;

public class RegistrationDAO {
    
    public static void submit(String user, String password, String firstname, String lastname, String phone, Date birthday) {
        
            EntityManager em = Server.emf.createEntityManager();
            em.getTransaction().begin();
            Accounts acc = new Accounts(user, password, firstname, lastname, phone, birthday);
            em.persist(acc);
            em.getTransaction().commit();
            em.close();
    }
}
