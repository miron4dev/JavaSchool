package com.tsystems.demail.client;

import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client
{
    public static Socket socket;
    
    public static void main(String[] args) throws UnknownHostException, IOException
    {
        Client.socket = new Socket("localhost", 1234);
        App.main(args);
    }
    
    public static boolean getAnswer(Properties data) throws IOException, ClassNotFoundException
    {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        out.writeObject(data);
        out.flush();
        if(in.readObject().toString().equals("true"))
            return true;
        else return false;
    }
    
    public static List getList(Properties data) throws IOException, ClassNotFoundException
    {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        out.writeObject(data);
        out.flush();
        return (List) in.readObject();
    }
    
    public static void sendAction(Properties data)
    {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            out.writeObject(data);
            out.flush();
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }
}
