package com.tsystems.demail;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Server {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    
    public static void main(String[] args)
    {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server is started!");
            System.out.println("Waiting a client....");
            while (true) 
            {
                Socket socket = null;
                while(socket == null){
                    socket = ss.accept();
                }
                new Protocol(socket);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
