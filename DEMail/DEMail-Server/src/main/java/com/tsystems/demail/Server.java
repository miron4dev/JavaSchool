package com.tsystems.demail;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Server {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("acc");

    public static void main(String[] args) throws ParseException {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server is started!");
            System.out.println("Waiting a client....");

            Socket socket = ss.accept();
            System.out.println("Client is connected. Waiting a commands...");
            Properties data;
            while (true) 
            {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                data = (Properties) in.readObject();
                if(data.getProperty("KEY").equals("REG"))
                {
                    if(RegistrationService.userChecking(data.getProperty("USERNAME")) == true && RegistrationService.phoneChecking(data.getProperty("PHONE")) == true)
                    {
                        RegistrationDAO.submit(data.getProperty("USERNAME"), data.getProperty("PASSWORD"), data.getProperty("FIRSTNAME"), data.getProperty("LASTNAME"), data.getProperty("PHONE"), parseDate(data.getProperty("BIRTHDAY")));
                        out.writeObject("true");
                    }
                    else out.writeObject("false");
                    
                }
                if (data.getProperty("KEY").equals("LOG")) 
                {
                    if (LoginService.connect(data.getProperty("USERNAME"), data.getProperty("PASSWORD")) == true) {
                        out.writeObject("true");
                    } else {
                        out.writeObject("false");
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static Date parseDate(String date) throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = dateFormat.parse(date);
        
        return new java.sql.Date(date1.getTime());
    }
}
