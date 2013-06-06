package com.mycompany.demailmavenbased;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.tree.DefaultMutableTreeNode;

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
        return regularChecking(phone, "\\+{1}[7]{1}9[0-9]{9}");
    }
    
    public static boolean folderExistenceChecking(DefaultMutableTreeNode folder, String name) 
    {
        for(int i = 0; i < folder.getChildCount(); i++)
        {
            if((folder.getChildAt(i).toString()).equals(name)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean permitActionChecking(String nodeName)
    {
        if(nodeName.equals("Inbox") || nodeName.equals("Sent") || nodeName.equals("Drafts") || 
           nodeName.equals("Spam") || nodeName.equals("Trash") || nodeName.equals("Priority"))
        {
            return false;
        }
        return true;
    }
    
    public static boolean systemFolderChecking(String nodeName)
    {
        if(nodeName.equals("UserMail") || nodeName.equals("DE-Mail") || nodeName.equals("Folders"))
        {
            return true;
        }
        return false;
    }

}
