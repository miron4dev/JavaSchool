package com.tsystems.demail.Service;

import com.tsystems.demail.DAO.RegistrationDAO;
import com.tsystems.demail.DAO.ValidationDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Date;

@Stateless
public class RegistrationService {

    @EJB
    private ValidationDAO validationDAO;

    @EJB
    private RegistrationDAO registrationDAO;

    public String profileChecking(String first_name, String last_name, String mobile_phone, String password, Date birth_day, String username, String second_mail)
    {
        if(validationDAO.userChecking(username) && validationDAO.phoneChecking(mobile_phone) && validationDAO.secMailChecking(second_mail) == true)
        {
            registrationDAO.regProfile(first_name, last_name, mobile_phone, password, birth_day, username, second_mail);
            return "true";
        }
        else return "false";
    }

    public boolean mailChecking(String username, String phone){
        if(validationDAO.userChecking(username) == true){
            registrationDAO.regMail(username, phone);
            return true;
        }
        else return false;
    }

}
