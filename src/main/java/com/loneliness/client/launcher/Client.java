package com.loneliness.client.launcher;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client extends Thread {
    private static Socket socket;
    private static String ipAddress;
    private static int port ;
    private static ObjectOutputStream outObject;
    private static ObjectInputStream inObject;
    Client(String ipAdr, int portToConnect) {
        ipAddress = ipAdr;
        port = portToConnect;
        try {
            socket = new Socket(ipAdr, port);
        } catch (UnknownHostException e) {
          //  e.printStackTrace();
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }


    public static ObjectOutputStream getOutObject() {
        return outObject;
    }

    public static void setOutObject(ObjectOutputStream outObject) {
        Client.outObject = outObject;
    }

    public static ObjectInputStream getInObject() {
        return inObject;
    }

    public static void setInObject(ObjectInputStream inObject) {
        Client.inObject = inObject;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void run(){
        Window window=new Window();
        window.begin();
    }



    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                inObject.close();
                outObject.close();
            }
        } catch (IOException ignored) {}
    }
    public static boolean connect()  {
        try {
            socket = new Socket(ipAddress, port);
            outObject = new ObjectOutputStream(socket.getOutputStream());
            inObject=new ObjectInputStream(socket.getInputStream());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public static boolean connect( String ipAddress,int port)  {
        try {
            socket = new Socket(ipAddress, port);
            outObject = new ObjectOutputStream(socket.getOutputStream());
            inObject=new ObjectInputStream(socket.getInputStream());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}