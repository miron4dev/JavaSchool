package com.mycompany.demailmavenbased;

import java.util.Scanner;

public class App 
{
    private static MainMenuOption answer;
    private final static MainMenuOption[] choice = {MainMenuOption.SIGN_IN, MainMenuOption.SIGN_UP, 
        MainMenuOption.EXIT};
    
    public static void main( String[] args )
    {
        answer = getRequest();
        
        DBConf.openCon();
        while(answer != MainMenuOption.EXIT)
        {
            switch(answer)
            {
                case SIGN_IN:
                    Registration.reg();
                    break;
                case SIGN_UP:
                    break;
            }
            
            answer = getRequest();
        }
        DBConf.closeCon();
    }
    
    private static MainMenuOption getRequest()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("*********************");
        System.out.println("Welcome to DeMail.");
        System.out.println("What are you want to do?\n1. Registration.\n2. Sign in.\n3. Exit.");
        System.out.print("Your choice: ");
        try{
            return choice[input.nextInt()-1];
        }catch(Exception ex){
            System.out.println("Wrong input.");
        }
        return null;
        
    }
}
