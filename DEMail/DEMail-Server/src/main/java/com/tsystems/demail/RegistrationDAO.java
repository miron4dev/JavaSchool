package com.tsystems.demail;

import com.tsystems.demail.entity.Accounts;
import com.tsystems.demail.entity.Folders;
import com.tsystems.demail.entity.Mails;
import com.tsystems.demail.entity.Messages;
import java.sql.Date;
import javax.persistence.EntityManager;

public class RegistrationDAO {

    public static void submitProfile(String username, String password, String firstname, String lastname, String phone, Date birthday) {

        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        Accounts acc = new Accounts(password, firstname, lastname, phone, birthday);
        em.persist(acc);
        em.getTransaction().commit();
        submitMail(username, password, phone);
        em.close();
    }

    public static void submitMail(String username, String password, String phone) {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        int user_id = Integer.parseInt(em.createNativeQuery("select id from Accounts where mobile_phone='" + phone + "'").getSingleResult().toString());
        Mails mails = new Mails(username, new java.sql.Date(new java.util.Date().getTime()), user_id);
        em.persist(mails);
        Folders inbox = new Folders(mails.getId(), "Inbox");
        Folders sent = new Folders(mails.getId(), "Sent");
        Folders drafts = new Folders(mails.getId(), "Drafts");
        Folders spam = new Folders(mails.getId(), "Spam");
        Folders trash = new Folders(mails.getId(), "Trash");
        Folders priority = new Folders(mails.getId(), "Priority");
        em.persist(inbox);
        em.persist(sent);
        em.persist(drafts);
        em.persist(spam);
        em.persist(trash);
        em.persist(priority);
        Messages mess = new Messages(inbox.getId(), mails.getId(), "admin@demail.com", username, "Welcome to DEMail", mails.getRegistration_date(), "Welcome to DEMail.\nIt is first message.");
        em.persist(mess);
        em.persist(mails);
        em.getTransaction().commit();
        em.close();
    }
}
