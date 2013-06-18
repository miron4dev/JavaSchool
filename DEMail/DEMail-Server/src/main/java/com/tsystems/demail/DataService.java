/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tsystems.demail;

public class DataService 
{
    public static boolean userSubmiting(String from, String to, String subject, String text){
        if(ValidationService.userChecking(to) == false){
            DataDAO.sendMessage(from, to, subject, text);
            return true;
        }
        else return false;
    }
}
