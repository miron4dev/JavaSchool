package com.tsystems.demail;

import com.tsystems.demail.entity.Folders;
import com.tsystems.demail.entity.Messages;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DataDAO 
{
    public static List getMails(String phone)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        List mails = em.createNativeQuery("select name from Mails where user_id=(select id from Accounts where mobile_phone='" + phone +"\')").getResultList();
        em.close();
   
        return mails;
    }
    
    public static void deleteMail(String name)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("delete from Mails where name='" + name + "'");
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public static List getFolders(String username)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        List folders = em.createNativeQuery("select name from Folders where mail_id=(select id from Mails where name='" + username + "')").getResultList();
        em.close();
        return folders;
    }
    
    public static List getMessages(String username, String foldername)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        int mail_id = Integer.parseInt(em.createNativeQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        List messages = em.createNativeQuery("select subject, from_name, sent_date, to_name, text, id from Messages where mail_id=" + mail_id + " and folder_id=(select id from Folders where name='" + foldername + "' and mail_id=" + mail_id + ")").getResultList();
        em.close();
        
        return messages;
    }
    
    public static void createFolder(String username, String foldername)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        int mail_id = Integer.parseInt(em.createNativeQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        Folders folder = new Folders(mail_id, foldername);
        em.persist(folder);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void deleteFolder(String username, String foldername)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        int mail_id = Integer.parseInt(em.createNativeQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        Query q = em.createQuery("delete from Folders where name='" + foldername + "' and mail_id=" + mail_id);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public static void renameFolder(String username, String foldername, String newfoldername)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        int mail_id = Integer.parseInt(em.createNativeQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
        Query q = em.createQuery("update Folders set name='" + newfoldername + "' where name='" + foldername + "' and mail_id=" + mail_id);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public static void sendMessage(String from, String to, String subject, String text)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        int mail_id_from = Integer.parseInt(em.createNativeQuery("select id from Mails where name='" + from + "'").getSingleResult().toString());
        int mail_id_to = Integer.parseInt(em.createNativeQuery("select id from Mails where name='" + to + "'").getSingleResult().toString());
        int folder_id_from = Integer.parseInt(em.createNativeQuery("select id from Folders where mail_id=" + mail_id_from + " and name='Sent'").getSingleResult().toString());
        int folder_id_to = Integer.parseInt(em.createNativeQuery("select id from Folders where mail_id=" + mail_id_to + " and name='Inbox'").getSingleResult().toString());
        Messages msg_from = new Messages(folder_id_from, mail_id_from, from, to, subject, new java.sql.Date(new java.util.Date().getTime()), text);
        Messages msg_to = new Messages(folder_id_to, mail_id_to, from, to, subject, new java.sql.Date(new java.util.Date().getTime()), text);
        em.persist(msg_from);
        em.persist(msg_to);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void delMessage(String id)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("delete from Messages where id=" + id);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
    public static void moveMessage(String foldername, String id)
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        int mail_id = Integer.parseInt(em.createNativeQuery("select mail_id from Messages where id=" + id).getSingleResult().toString());
        int folder_id = Integer.parseInt(em.createNativeQuery("select id from Folders where name='" + foldername + "' and mail_id=" + mail_id).getSingleResult().toString());
        Query q = em.createQuery("update Messages set folder_id=" + folder_id + "where id=" + id);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
