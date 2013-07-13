package com.tsystems.demail.Service;

import com.tsystems.demail.DAO.DataDAO;
import com.tsystems.demail.DAO.ValidationDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DataService {

    @EJB
    DataDAO dataDAO;

    @EJB
    ValidationDAO validationDAO;

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
