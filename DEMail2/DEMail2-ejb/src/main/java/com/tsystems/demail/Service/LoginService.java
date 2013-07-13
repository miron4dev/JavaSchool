package com.tsystems.demail.Service;

import com.tsystems.demail.DAO.DataDAO;
import com.tsystems.demail.DAO.LoginDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LoginService {

    @EJB
    private LoginDAO loginDAO;

    @EJB
    private DataDAO dataDAO;

    public List loginProfile(String phone, String password){
        List data = new ArrayList();
        data.add("false");
        String real_password = loginDAO.getRealPassword(phone);
        if(real_password.equals("false") == false && password.equals(real_password)){
            return dataDAO.getProfileData(phone);
        }
        else return data;
    }
}
