/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tsystems.demail.client;

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
}
