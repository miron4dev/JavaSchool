package com.tsystems.demail.Controllers;

import com.tsystems.demail.Beans.UserBean;
import com.tsystems.demail.Service.RegistrationService;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@Named
public class RegistrationBean {

    private UIComponent profileReg;
    private String rtPassword;

    @Inject
    private UserBean userBean;

    @EJB
    private RegistrationService registrationService;

    private Logger logger;
    
    @PostConstruct
    public void init(){
        logger =  Logger.getLogger(getClass().getName());
        BasicConfigurator.configure();    
    }
    
    public String add(){
        java.sql.Date birth_day2 = new java.sql.Date(userBean.getBirth_day().getTime());
        String answer =  registrationService.profileChecking(userBean.getFirst_name(), userBean.getLast_name(), userBean.getMobile_phone(), userBean.getPassword(), birth_day2, userBean.getUsername(), userBean.getSecond_mail());
        if(answer.equals("false"))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(profileReg.getClientId(context), new FacesMessage("User with that name, phone or secondary mail is already exist."));
            logger.warn("Failed to create new user " + userBean.getUsername() + " " + userBean.getMobile_phone() + " " + userBean.getSecond_mail());
            return null;
        }
        else{
            logger.info("New user was created: " + userBean.getMobile_phone());
            return "index.jsf?faces-redirect=true";
        }
    }

    public UIComponent getProfileReg() {
        return profileReg;
    }

    public void setProfileReg(UIComponent profileReg) {
        this.profileReg = profileReg;
    }


    public String getRtPassword() {
        return rtPassword;
    }

    public void setRtPassword(String rtPassword) {
        this.rtPassword = rtPassword;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
