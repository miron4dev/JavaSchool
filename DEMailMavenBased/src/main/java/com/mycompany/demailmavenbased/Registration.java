package com.mycompany.demailmavenbased;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Registration {
    
    public static void reg()
    {
        Scanner input = new Scanner(System.in);
        String user, password, name, surname;
        String query;
        System.out.print("Name: ");
        name = input.nextLine();
        System.out.print("Surname: ");
        surname = input.nextLine();
        System.out.print("Desired username: ");
        user = input.nextLine();
        System.out.print("Password: ");
        password = input.nextLine();
        if(name.length() < 5 || surname.length() < 5 || user.length() < 5 || password.length() < 5)
        {
            System.out.println("Input length is too low.");
            System.out.println("Logout...");
            System.out.println();
            return;
        }
        try
        {
            int count = -1;
            query = "select count(user) from Accounts where user='" + user +'\'';
            ResultSet rs = DBConf.statement.executeQuery(query);
            while(rs.next())
            {
                count = rs.getInt("count(user)");
            }
            if(count == 1)
            {
                System.out.println("User with that name is already registered. Please "
                        + "try again.");
                return;
            }
            query = "insert into Accounts (user, password, name, surname) values('" + user + "', '" 
                + password + "', '" + name + "', '" + surname + "')";
            DBConf.statement.executeUpdate(query);
            System.out.println("Registration was successful. Your new e-mail is " + user + "@demail.com");
            System.out.println();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
