package com.tsystems.demail.DAO;

import com.tsystems.demail.Constants.Localization;
import com.tsystems.demail.Entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;

@Stateless
public class RegistrationDAO {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    EntityManager em;

    public void regProfile(String first_name, String last_name, String mobile_phone, String password, Date birth_day, String username, String second_mail){
        Accounts acc = new Accounts(password, first_name, last_name, mobile_phone, birth_day, second_mail);
        em.persist(acc);
        regMail(username, mobile_phone);
    }

    public void regMail(String username, String phone) {
        Localization pp = new Localization();
        int user_id = Integer.parseInt(em.createQuery("select id from Accounts where mobile_phone='" + phone + "'").getSingleResult().toString());
        Mails mails = new Mails(username, new java.sql.Date(new java.util.Date().getTime()), user_id);
        em.persist(mails);
        Folders inbox = new Folders(mails.getId(), pp.INBOX);
        Folders sent = new Folders(mails.getId(), pp.SENT);
        Folders drafts = new Folders(mails.getId(), pp.DRAFTS);
        Folders spam = new Folders(mails.getId(), pp.SPAM);
        Folders trash = new Folders(mails.getId(), pp.TRASH);
        em.persist(inbox);
        em.persist(sent);
        em.persist(drafts);
        em.persist(spam);
        em.persist(trash);
        Messages mess = new Messages(inbox.getId(), mails.getId(), pp.SYSTEM, username, "Welcome to DeMail", mails.getRegistration_date(), "Welcome to DeMail.\nIt is first message.");
        em.persist(mess);
        em.persist(mails);
    }
}
