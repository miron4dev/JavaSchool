package com.tsystems.demail.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginDAO {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    EntityManager em;

    public String getRealPassword(String phone){
        try{
            String realPass = em.createQuery("select password from Accounts where mobile_phone='" + phone + "'").getSingleResult().toString();
            return realPass;
        } catch (NoResultException ex) {
            return "false";
        }
    }
}
