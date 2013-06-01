package com.mycompany.demailmavenbased;

public enum MainMenuOption 
{
    SIGN_IN(1),
    SIGN_UP(2),
    EXIT(3);
    
    private final int value;
    
    MainMenuOption(int valueOption)
    {
        value = valueOption;
    }
}
