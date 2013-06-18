package com.tsystems.demail;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class LoginService {

    public static List connect(String phone, String password) 
    {
        EntityManager em = Server.emf.createEntityManager();
        em.getTransaction().begin();
        List ans = new ArrayList<String>();
        ans.add("false");
        try 
        {
            String real_password;
        
            real_password = em.createQuery("select password from Accounts where mobile_phone='" + phone + "'").getSingleResult().toString();

            if (password.equals(real_password)) {
                return LoginDAO.connectToProfile(phone);
            }
        } catch (NoResultException ex) {
            return ans;
        } finally {
            em.close();
        }
        return ans;
    }
}
