package com.tsystems.demail.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private boolean regularChecking(String str, String regular)
    {
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }

    public boolean userNameChecking(String user)
    {
        return  user.length() >= 17 && user.length() <= 44 && regularChecking(user, "[a-zA-Z]{1}\\w*@demail.com");
    }

    public boolean nameChecking(String name)
    {
        return regularChecking(name, "[a-zA-Z]+");
    }

    public boolean phoneChecking(String phone)
    {
        return regularChecking(phone, "\\+{1}[7]{1}9[0-9]{9}");
    }

    public boolean passChecking(String password) {
        return password.length() > 6;
    }
    
    public boolean gmailChecking(String mail){
        return mail.length() >=15 && mail.length() <= 39 && regularChecking(mail, "[a-zA-Z]{1}\\w*@gmail.com");
    }
}
