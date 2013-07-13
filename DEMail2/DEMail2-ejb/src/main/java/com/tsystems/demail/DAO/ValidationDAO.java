package com.tsystems.demail.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class ValidationDAO {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    EntityManager em;

    public boolean userChecking(String user)
    {
        if((Long)em.createQuery("select count(name) from Mails where name='" + user + "'").getSingleResult() == 1) {
            return false;
        }
        else return true;
    }

    public boolean phoneChecking(String phone)
    {
        if((Long)em.createQuery("select count(mobile_phone) from Accounts where mobile_phone='" + phone + "'").getSingleResult() == 1) {
            return false;
        }
        else return true;
    }

    public boolean folderChecking(String username, String folderName)
    {
        try{
            int mail_id = Integer.parseInt(em.createQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
            String folder = em.createQuery("select name from Folders where mail_id=" + mail_id + " and name='" + folderName + "'").getSingleResult().toString();
            return false;
        } catch (NoResultException ex) {
            return true;
        }

    }
}
