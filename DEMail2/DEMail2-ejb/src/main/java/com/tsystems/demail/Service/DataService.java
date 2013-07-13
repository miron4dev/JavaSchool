package com.tsystems.demail.Service;

import com.tsystems.demail.Constants.JMailData;
import com.tsystems.demail.Constants.Parameters;
import com.tsystems.demail.DAO.DataDAO;
import com.tsystems.demail.DAO.LoginDAO;
import com.tsystems.demail.DAO.ValidationDAO;
import com.tsystems.demail.JavaMail.ForgotPassword;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DataService {

    @EJB
    DataDAO dataDAO;
    
    @EJB
    LoginDAO loginDAO;

    @EJB
    ValidationDAO validationDAO;
   
    @EJB
    ForgotPassword forgotPassword;

    public boolean passwordReturning(String phone){
        List<String> answer = validationDAO.mailExChecking(phone);
        if(answer.get(0).equals("false")){
            return false;
        }
        else{
            if ((forgotPassword.sendPass(phone, answer.get(0), answer.get(1))).equals("Done"))
                return true;
            else return false;
        }
    }
    
    public boolean folderCreateChecking(String username, String folderName){
        if(validationDAO.folderChecking(username, folderName) == true){
            dataDAO.createFolder(username, folderName);
            return true;
        }
        else return false;
    }

    public boolean folderRenameChecking(String username, String folderName, String newFolderName){
        if(validationDAO.folderChecking(username, newFolderName) == true){
            dataDAO.renameFolder(username, folderName, newFolderName);
            return true;
        }
        else return false;
    }

    public boolean messageSending(String from, String to, String subject, String text){
        if(validationDAO.userChecking(to) == false){
            dataDAO.sendMessage(from, to, subject, text);
            return true;
        }
        else return false;
    }
}
