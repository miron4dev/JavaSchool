package com.mycompany.demailmavenbased;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator 
{
    private static boolean regularChecking(String str, String regular)
    {
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(str); 
        
        return matcher.matches();
    }
    
    public static boolean userNameChecking(String user)
    {
        return  user.length() >= 6 && user.length() <= 30 && regularChecking(user, "[a-zA-Z]{1}\\w*");
    }
    
    public static boolean nameChecking(String name)
    {
        return regularChecking(name, "[a-zA-Z]+");
    }
    
    public static boolean phoneChecking(String phone)
    {
        return regularChecking(phone, "9[0-9]{9}");
    }

}
