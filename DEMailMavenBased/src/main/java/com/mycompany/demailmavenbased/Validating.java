package com.mycompany.demailmavenbased;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validating 
{
    public static boolean regularChecking(String str, String regular)
    {
        Pattern pattern = Pattern.compile(regular); //regular 
        Matcher matcher = pattern.matcher(str); //string
        
        return matcher.matches();
    }

}
