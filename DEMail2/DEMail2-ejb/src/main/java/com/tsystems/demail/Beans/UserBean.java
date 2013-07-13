package com.tsystems.demail.Beans;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class UserBean implements Serializable{

    private String first_name;
    private String last_name;
    private String mobile_phone;
    private String password;
    private String username;
    private String second_mail;
    private Date birth_day;
    private List<String> userList;
    private boolean profileLoggedIn;
    private boolean mailLoggedIn;

    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date birth_day) {
        this.birth_day = birth_day;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public boolean isProfileLoggedIn() {
        return profileLoggedIn;
    }

    public void setProfileLoggedIn(boolean profileLoggedIn) {
        this.profileLoggedIn = profileLoggedIn;
    }

    public boolean isMailLoggedIn() {
        return mailLoggedIn;
    }

    public void setMailLoggedIn(boolean mailLoggedIn) {
        this.mailLoggedIn = mailLoggedIn;
    }

    public String getSecond_mail() {
        return second_mail;
    }

    public void setSecond_mail(String second_mail) {
        this.second_mail = second_mail;
    }
}
