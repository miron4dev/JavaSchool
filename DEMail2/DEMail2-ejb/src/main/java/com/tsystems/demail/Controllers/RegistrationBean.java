package com.tsystems.demail.Controllers;

import com.tsystems.demail.Beans.UserBean;
import com.tsystems.demail.Service.RegistrationService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegistrationBean {

    private UIComponent profileReg;
    private String rtPassword;

    @Inject
    private UserBean userBean;

    @EJB
    private RegistrationService registrationService;

    public String add(){
        System.out.println(userBean.getBirth_day());
        System.out.println(userBean.getBirth_day().getTime());
        java.sql.Date birth_day2 = new java.sql.Date(userBean.getBirth_day().getTime());
        String answer =  registrationService.profileChecking(userBean.getFirst_name(), userBean.getLast_name(), userBean.getMobile_phone(), userBean.getPassword(), birth_day2, userBean.getUsername());
        if(answer.equals("false"))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(profileReg.getClientId(context), new FacesMessage("User with that name or phone is already exist."));
            return null;
        }
        else{
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
