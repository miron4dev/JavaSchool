package com.tsystems.demail;

import java.math.BigInteger;
import java.sql.Date;
import javax.persistence.EntityManager;

public class RegistrationService 
{
    
    
    public static boolean profileChecking(String username, String password, String firstname, String lastname, String phone, Date birthday)
    {
        if(ValidationService.userChecking(username) && ValidationService.phoneChecking(phone) == true)
        {
            RegistrationDAO.submitProfile(username, password, firstname, lastname, phone, birthday);
            return true;
        }
        else return false;
    }
    
    public static boolean mailChecking(String username, String password, String phone){
        if(ValidationService.userChecking(username) == true){
            RegistrationDAO.submitMail(username, password, phone);
            return true;
        }
        else return false;
    }
}
