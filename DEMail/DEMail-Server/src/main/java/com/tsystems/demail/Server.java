package com.tsystems.demail;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Server {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");

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
                if(data.getProperty("KEY").equals("REG_PROFILE"))
                {
                    if(RegistrationService.userChecking(data.getProperty("USERNAME")) == true && RegistrationService.phoneChecking(data.getProperty("PHONE")) == true)
                    {
                        RegistrationDAO.submitProfile(data.getProperty("USERNAME"), data.getProperty("PASSWORD"), data.getProperty("FIRSTNAME"), data.getProperty("LASTNAME"), data.getProperty("PHONE"), parseDate(data.getProperty("BIRTHDAY")));
                        out.writeObject("true");
                    }
                    else out.writeObject("false");
                    
                }
                else if (data.getProperty("KEY").equals("LOG_PROFILE")) 
                {
                    if (LoginService.connect(data.getProperty("PHONE"), data.getProperty("PASSWORD")) == true) {
                        out.writeObject(LoginDAO.connectToProfile(data.getProperty("PHONE")));
                    } else {
                        out.writeObject(Arrays.asList("false"));
                    }
                }
                else if(data.getProperty("KEY").equals("REG_MAIL"))
                {
                    if(RegistrationService.userChecking(data.getProperty("USERNAME")) == true){
                        RegistrationDAO.submitMail(data.getProperty("USERNAME"), data.getProperty("PASSWORD"), data.getProperty("PHONE"));
                        out.writeObject("true");
                    }
                    else out.writeObject("false");
                }
                else if(data.getProperty("KEY").equals("GET_MAILS"))
                {
                    out.writeObject(DataDAO.getMails(data.getProperty("PHONE")));
                }
                else if(data.getProperty("KEY").equals("DELETE_MAIL"))
                {
                    DataDAO.deleteMail(data.getProperty("USERNAME"));
                }
                else if(data.getProperty("KEY").equals("GET_FOLDERS"))
                {
                    out.writeObject(DataDAO.getFolders(data.getProperty("USERNAME")));
                }
                else if(data.getProperty("KEY").equals("GET_MESSAGES"))
                {
                    out.writeObject(DataDAO.getMessages(data.getProperty("USERNAME")));
                }
                else if(data.getProperty("KEY").equals("NEW_FOLDER")){
                    DataDAO.createFolder(data.getProperty("USERNAME"), data.getProperty("FOLDERNAME"));
                }
                else if(data.getProperty("KEY").equals("DEL_FOLDER")){
                    DataDAO.deleteFolder(data.getProperty("USERNAME"), data.getProperty("FOLDERNAME"));
                }
                else if(data.getProperty("KEY").equals("REN_FOLDER")){
                    DataDAO.renameFolder(data.getProperty("USERNAME"), data.getProperty("FOLDERNAME"), data.getProperty("NEWFOLDERNAME"));
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
