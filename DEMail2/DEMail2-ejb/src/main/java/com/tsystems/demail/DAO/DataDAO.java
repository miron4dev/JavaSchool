package com.tsystems.demail.DAO;

import com.tsystems.demail.Constants.Localization;
import com.tsystems.demail.Entity.Mails;
import com.tsystems.demail.Entity.Folders;
import com.tsystems.demail.Entity.Messages;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DataDAO {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    EntityManager em;
    
    public List getProfileData(String phone){;
        List data = em.createQuery("select first_name, last_name, mobile_phone, password from Accounts where mobile_phone='" + phone + "'").getResultList();
        List mails = em.createQuery("select name from Mails where user_id=(select id from Accounts where mobile_phone='" + phone +"')").getResultList();
        data.addAll(mails);
        return data;
    }

    public void deleteMail(String name){
        em.remove(em.find(Mails.class, em.createQuery("select id from Mails where name='" + name +"'").getSingleResult()));
    }

    public List getFolders(String username)
    {
        List folders = em.createQuery("select name from Folders where mail_id=(select id from Mails where name='" + username + "')").getResultList();
        return folders;
    }

    public List getMessages(String username, String folderName)
    {
        int mail_id = Integer.parseInt(em.createQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        List messages = em.createQuery("select from_name, to_name, subject, text, sent_date, id from Messages where mail_id=" + mail_id + " and folder_id=(select id from Folders where name='" + folderName + "' and mail_id=" + mail_id + ")").getResultList();
        return messages;
    }

    public void createFolder(String username, String folderName)
    {
        int mail_id = Integer.parseInt(em.createQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        Folders folder = new Folders(mail_id, folderName);
        em.persist(folder);
    }

    public void renameFolder(String username, String folderName, String newFolderName)
    {
        int mail_id = Integer.parseInt(em.createQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        int folder_id = Integer.parseInt(em.createQuery("select id from Folders where name='" + folderName + "' and mail_id=" + mail_id).getSingleResult().toString());
        em.find(Folders.class, folder_id).setName(newFolderName);
    }

    public void deleteFolder(String username, String folderName){
        int mail_id = Integer.parseInt(em.createQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        int folder_id = Integer.parseInt(em.createQuery("select id from Folders where name='" + folderName + "' and mail_id=" + mail_id).getSingleResult().toString());
        em.remove(em.find(Folders.class, folder_id));
    }

    public void sendMessage(String from, String to, String subject, String text){
        int mail_id_from = Integer.parseInt(em.createQuery("select id from Mails where name='" + from + "'").getSingleResult().toString());
        int mail_id_to = Integer.parseInt(em.createQuery("select id from Mails where name='" + to + "'").getSingleResult().toString());
        int folder_id_from = Integer.parseInt(em.createQuery("select id from Folders where mail_id=" + mail_id_from + " and name='" + new Localization().SENT + "'").getSingleResult().toString());
        int folder_id_to = Integer.parseInt(em.createQuery("select id from Folders where mail_id=" + mail_id_to + " and name='" + new Localization().INBOX +"'").getSingleResult().toString());
        Messages msg_from = new Messages(folder_id_from, mail_id_from, from, to, subject, new java.sql.Date(new java.util.Date().getTime()), text);
        Messages msg_to = new Messages(folder_id_to, mail_id_to, from, to, subject, new java.sql.Date(new java.util.Date().getTime()), text);
        em.persist(msg_from);
        em.persist(msg_to);
    }

    public void deleteMessage(String id){
        em.remove(em.find(Messages.class, Integer.parseInt(id)));
    }

    public void moveMessage(String folderName, String id){
        int mail_id = Integer.parseInt(em.createQuery("select mail_id from Messages where id=" + id).getSingleResult().toString());
        int folder_id = Integer.parseInt(em.createQuery("select id from Folders where name='" + folderName + "' and mail_id=" + mail_id).getSingleResult().toString());
        em.find(Messages.class, Integer.parseInt(id)).setFolder_id(folder_id);
    }

}
