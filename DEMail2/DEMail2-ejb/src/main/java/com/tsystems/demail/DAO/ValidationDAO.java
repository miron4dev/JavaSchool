package com.tsystems.demail.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class ValidationDAO {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    EntityManager em;

    public boolean userChecking(String user) {
        if ((Long) em.createQuery("select count(name) from Mails where name='" + user + "'").getSingleResult() == 1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean phoneChecking(String phone) {
        if ((Long) em.createQuery("select count(mobile_phone) from Accounts where mobile_phone='" + phone + "'").getSingleResult() == 1) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean secMailChecking(String mail){
    if ((Long) em.createQuery("select count(second_mail) from Accounts where second_mail='" + mail + "'").getSingleResult() == 1) {
            return false;
        } else {
            return true;
        }    
    }

    public boolean folderChecking(String username, String folderName) {
        try {
            int mail_id = Integer.parseInt(em.createQuery("select id from Mails where name='" + username + "'").getSingleResult().toString());
            String folder = em.createQuery("select name from Folders where mail_id=" + mail_id + " and name='" + folderName + "'").getSingleResult().toString();
            return false;
        } catch (NoResultException ex) {
            return true;
        }

    }

    public List<String> mailExChecking(String phone) {
        List<String> ans = new ArrayList<String>();
        ans.add("false");
        try{
            String second_mail = em.createQuery("select second_mail from Accounts where mobile_phone='" + phone + "'").getSingleResult().toString();
            if(second_mail.length() == 0){
                return ans;
            }    
            else {
                String password = em.createQuery("select password from Accounts where mobile_phone='" + phone + "'").getSingleResult().toString();
                ans.remove("false");
                ans.add(password);
                ans.add(second_mail);
                return ans;
            }
        }
        catch(Exception ex){
            return ans;
        }
    }
}
