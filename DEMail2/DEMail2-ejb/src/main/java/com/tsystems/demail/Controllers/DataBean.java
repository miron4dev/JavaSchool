package com.tsystems.demail.Controllers;

import com.tsystems.demail.Beans.MailBean;
import com.tsystems.demail.Beans.MessageBean;
import com.tsystems.demail.Beans.UserBean;
import com.tsystems.demail.Constants.Localization;
import com.tsystems.demail.DAO.DataDAO;
import com.tsystems.demail.Service.DataService;
import com.tsystems.demail.Service.LoginService;
import com.tsystems.demail.Service.RegistrationService;
import com.tsystems.demail.Validation.Validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import org.primefaces.event.NodeSelectEvent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@Named
public class DataBean{

    @Inject
    private UserBean userBean;

    @Inject
    private MailBean mailBean;
    
    @Inject
    private MessageBean messageBean;

    @EJB
    private DataDAO dataDAO;

    @EJB
    private LoginService loginService;

    @EJB
    private RegistrationService registrationService;

    @EJB
    private DataService dataService;
    
    private Logger logger;
    
    @PostConstruct
    public void init(){
        logger =  Logger.getLogger(getClass().getName());
        BasicConfigurator.configure();    
    }

    public String forgotPassword(){
        boolean ans = dataService.passwordReturning(userBean.getMobile_phone());
        String alert = null;
        
        if(ans == false){
            alert = "Phone is not registered or user not have secondary mail.";
            logger.warn("User " + userBean.getMobile_phone() + " unsuccessfully tried to return password.");
        }
        else
        {
           alert = "Password sent to your mail.";
           logger.info("User " + userBean.getMobile_phone() + " was returned password to his secondary mail.");
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(mailBean.getButtonAction().getClientId(context), new FacesMessage(alert));
        return null;
    }
    
    public String createMail(){
        if(!mailBean.getTemp().equals(userBean.getPassword())){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(mailBean.getButtonAction().getClientId(context), new FacesMessage("Password is wrong."));
            logger.warn("Failed attempt to creating new mail for user " + userBean.getMobile_phone() + ": wrong password.");
            return null;
        }

        if(!registrationService.mailChecking(userBean.getUsername(), userBean.getMobile_phone())){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(mailBean.getButtonAction().getClientId(context), new FacesMessage("User with that name is already exist."));
            logger.warn("Failed attempt to creating new mail for user " + userBean.getMobile_phone() + ": mail is already exist.");
            return null;
        }
        else {
            List<String> userList = userBean.getUserList();
            userList.add(userBean.getUsername());
            userBean.setUserList(userList);
            logger.info("User " + userBean.getMobile_phone() + " created new mail with name " + userBean.getUsername());
            return loginProfile();
        }
    }

    public String deleteMail(){
        dataDAO.deleteMail(userBean.getUsername());
        List<String> userList = userBean.getUserList();
        userList.remove(userBean.getUsername());
        userBean.setUserList(userList);
        logger.info("User " + userBean.getMobile_phone() + " deleted his mail with name " + userBean.getUsername());
        return loginProfile();
    }

    public String loginProfile(){
        List data = loginService.loginProfile(userBean.getMobile_phone(), userBean.getPassword());
        if(data.get(0).equals("false"))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(mailBean.getButtonAction().getClientId(context), new FacesMessage("Phone or password is wrong."));
            logger.warn("Failed attempt to login to " + userBean.getMobile_phone());
            return null;
        }
        else
        {
            Object[] profile_info = (Object[])data.get(0);
            userBean.setFirst_name(profile_info[0].toString());
            userBean.setLast_name(profile_info[1].toString());
            userBean.setMobile_phone(profile_info[2].toString());
            userBean.setPassword(profile_info[3].toString());
            List<String> userList = new ArrayList<String>();
            for(int i = 1; i < data.size(); i++)
                userList.add((data.get(i)).toString());
            if(data.size() > 1)
                userBean.setUsername(data.get(1).toString());
            userBean.setUserList(userList);
            userBean.setProfileLoggedIn(true);
            logger.info("User " + userBean.getMobile_phone() + " is logged in");
            return "login.jsf?faces-redirect=true";
        }
    }

    public String loginMail(){
        if(userBean.getUsername() == null){
            return null;
        }
        List folderList = dataDAO.getFolders(userBean.getUsername());
        List userList = new ArrayList();
        for(int i = 5; i < folderList.size(); i++)
            userList.add(folderList.get(i));
        mailBean.setFolderList(userList);
        mailBean.setFullFolderList(folderList);
        mailBean.setMessageList(dataDAO.getMessages(userBean.getUsername(), new Localization().INBOX));
        mailBean.setSelectedMail(null);
        mailBean.setTemp(null);
        mailBean.setSelectedFolderName(new Localization().INBOX);
        userBean.setMailLoggedIn(true);
        logger.info("User " + userBean.getMobile_phone() + "logged in to " + userBean.getUsername());
        return "client.jsf?faces-redirect=true";
    }

    public String logoutProfile(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        userBean.setProfileLoggedIn(false);
        logger.info("User " + userBean.getMobile_phone() + " is logged out");
        return "index.jsf?faces-redirect=true";
    }

    public String logoutMail(){
        userBean.setMailLoggedIn(false);
        logger.info(userBean.getUsername() + " user is logged out");
        return "login.jsf?faces-redirect=true";
    }

    public void folderCreate(){
        String alert = null;
        if(mailBean.getTemp().length() == 0){
            alert = "Folder name cannot be null";
        }
        else if(mailBean.getTemp().equals(new Localization().USERFOLDER)){
            alert = "You cannot use the system folder name.";
        }
        else if(mailBean.getFullFolderList().contains(mailBean.getTemp()) || !dataService.folderCreateChecking(userBean.getUsername(), mailBean.getTemp())){
            alert = "Folder with that name already exist.";
        }
        else {
            alert = "Folder was successfully created.";
            List userList = mailBean.getFolderList();
            List folderList = mailBean.getFullFolderList();
            userList.add(mailBean.getTemp());
            folderList.add(mailBean.getTemp());
            mailBean.setFolderList(userList);
            mailBean.setFullFolderList(folderList);
            logger.info("Folder " + mailBean.getTemp() + " for " + userBean.getUsername() + " was created.");
        }
        mailBean.setTemp(null);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(alert));
        logger.warn("Failed to create new folder " + mailBean.getTemp() + " for " + userBean.getUsername());
    }

    public void folderRename(){
        String alert = null;
        if(mailBean.getTemp().length() == 0){
            alert = "Folder name cannot be null";
        }
        else if(mailBean.getTemp().equals(new Localization().USERFOLDER)){
            alert = "You cannot using system folder name.";
        }
        else if(mailBean.getFullFolderList().contains(mailBean.getTemp()) || !dataService.folderRenameChecking(userBean.getUsername(), mailBean.getCurrentFolder(), mailBean.getTemp())){
            alert = "Folder with that name already exist.";
        }
        else{
            alert = "Folder was successfully renamed.";
            List userList = mailBean.getFolderList();
            List folderList = mailBean.getFullFolderList();
            userList.remove(mailBean.getCurrentFolder());
            userList.add(mailBean.getTemp());
            folderList.remove(mailBean.getCurrentFolder());
            folderList.add(mailBean.getTemp());
            mailBean.setFolderList(userList);
            mailBean.setFullFolderList(folderList);
            logger.info("Folder " + mailBean.getCurrentFolder() + " was renamed to " + mailBean.getTemp() + " for " + userBean.getUsername());
        }
        mailBean.setTemp(null);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(alert));
        logger.warn("Failed to rename folder " + mailBean.getCurrentFolder() + " to " + mailBean.getTemp() + " for " + userBean.getUsername());
    }

    public void folderDelete(){
        if(mailBean.getCurrentFolder().length() == 0){
            return;
        }
        dataDAO.deleteFolder(userBean.getUsername(), mailBean.getCurrentFolder());
        List userList = mailBean.getFolderList();
        List folderList = mailBean.getFullFolderList();
        userList.remove(mailBean.getCurrentFolder());
        folderList.remove(mailBean.getCurrentFolder());
        mailBean.setFullFolderList(folderList);
        mailBean.setFolderList(userList);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Folder was successfully deleted."));
        logger.info("Folder " + mailBean.getCurrentFolder() + " for " + userBean.getUsername() + " was deleted");
    }
    
    public void getMessages(NodeSelectEvent event){
        if(event.getTreeNode().toString().equals(new Localization().USERFOLDER)){
            return;
        }
        mailBean.setMessageList(dataDAO.getMessages(userBean.getUsername(), event.getTreeNode().toString()));
        mailBean.setSelectedMail(null);
        mailBean.setSelectedFolderName(event.getTreeNode().toString());
    }

    public void messageSend(){
        String alert = null;
        if(messageBean.getTo().length() == 0 || messageBean.getBody().length() == 0){
            alert="'To' field and message body cannot be null";
        }
        else if(messageBean.getTo().equals(new Localization().SYSTEM)){
            alert="You cannot reply to this message.";
        }
        else if(!new Validator().userNameChecking(messageBean.getTo())){
            alert="Invalid recipient name.";
        }
        else if(!dataService.messageSending(userBean.getUsername(), messageBean.getTo(), messageBean.getSubject(), messageBean.getBody())){
            alert="Recipient is not registered";
        }
        else{
            alert="Message sent!";
            logger.info(userBean.getUsername() + " sent new message to " + messageBean.getTo());
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(alert));
    }

    public void messageReply(){
        messageBean.setTo(mailBean.getSelectedMail().getFrom());
        messageBean.setSubject("Re: " + mailBean.getSelectedMail().getSubject());
        messageBean.setBody(null);
    }

    public void messageDelete(){
        dataDAO.deleteMessage(mailBean.getSelectedMail().getId());
        messageUpdate();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Message was successfully deleted."));
        logger.info(userBean.getUsername() + " deleted message with id=" + mailBean.getSelectedMail().getId());
    }

    public void messageMove(){
        dataDAO.moveMessage(mailBean.getCurrentFolder(), mailBean.getSelectedMail().getId());
        messageUpdate();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Message was moved to " + mailBean.getCurrentFolder()));
        logger.info(userBean.getUsername() + " moved message with id=" + mailBean.getSelectedMail().getId() + " to " + mailBean.getCurrentFolder() + " folder");
    }

    public void messageUpdate(){
        List<MessageBean> mails = mailBean.getMessages();
        for(int i = 0; i < mails.size(); i++){
            if(mails.get(i).getId().equals(mailBean.getSelectedMail().getId())){
                mails.remove(i);
                break;
            }
        }
        mailBean.setMessages(mails);
    }

    public void dataUpdate(){
        List folderList = dataDAO.getFolders(userBean.getUsername());
        List userList = new ArrayList();
        for(int i = 5; i < folderList.size(); i++)
            userList.add(folderList.get(i));
        mailBean.setFolderList(userList);
        mailBean.setFullFolderList(folderList);
        if(!folderList.contains(mailBean.getSelectedFolderName())){
            mailBean.setSelectedFolderName(new Localization().INBOX);
        }
        mailBean.setMessageList(dataDAO.getMessages(userBean.getUsername(), mailBean.getSelectedFolderName()));
        mailBean.setSelectedMail(null);
        logger.info(userBean.getUsername() + "  was clicked 'Refresh'");
    }
    
}
