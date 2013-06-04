package com.mycompany.demailmavenbased;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConf {

    private static final String url = "jdbc:mysql://localhost/demail";
    private static final String name = "root";
    private static final String password = "root";
    private static Connection connection = null;
    static Statement statement = null;
    
    public static void openCon() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
        } 
        catch (SQLException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public static void closeCon()
    {
        try{
            connection.close();
            System.exit(0);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

