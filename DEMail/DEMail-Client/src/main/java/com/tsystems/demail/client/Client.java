package com.tsystems.demail.client;

import com.tsystems.demail.common.ProtocolParameters;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class Client
{
    public static Socket socket;
    
    public static void main(String[] args) throws UnknownHostException, IOException
    {
            Client.socket = new Socket(ProtocolParameters.ADDRESS, ProtocolParameters.PORT);
            App.main(args);
    }
    
    public static boolean getAnswer(Properties data)
    {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            out.writeObject(data);
            out.flush();
            if(in.readObject().toString().equals("true"))
                return true;
            else return false;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static List getList(Properties data)
    {
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try 
        {
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
                out.writeObject(data);
                out.flush();
                return (List) in.readObject();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
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
