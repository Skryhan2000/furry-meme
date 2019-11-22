package com.loneliness.server.view;


import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.CommandName;
import com.loneliness.server.controller.CommandProvider;
import com.loneliness.server.launcher.Server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;


public class ClientWorkingThread implements Runnable{
    private ArrayBlockingQueue<ClientWorkingThread> serverList;
    private ObjectOutputStream outObject;
    private ObjectInputStream inObject;
    private Socket userSocket;
    public ClientWorkingThread(Socket userSocket, ArrayBlockingQueue<ClientWorkingThread> serverList) {
        this.userSocket = userSocket;
        try {
            this.serverList=serverList;
            inObject=new ObjectInputStream(userSocket.getInputStream());
            outObject = new ObjectOutputStream(userSocket.getOutputStream());

        } catch (IOException e) {
            Server.getQuantity().decrementAndGet();
        }
    }
    @Override
    public void run() {
        Transmission transmission;
        Object response;
        try {
            while (true) {
                transmission = (Transmission) inObject.readObject();
                if (transmission.getUserData() != null) {
                    response = CommandProvider.getCommandProvider().getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getUserData());
                } else {
                    response = CommandProvider.getCommandProvider().getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission);
                }
                outObject.writeObject(response);
                outObject.reset();
            }



        } catch (ClassNotFoundException | IOException e) {
            killOneClient();
            // e.printStackTrace();
        }
    }

    private void killOneClient() {
        try {
            inObject.close();
            outObject.close();
            userSocket.close();
            System.out.println("Количество людей на сервере "+( Server.getQuantity().decrementAndGet()));
            for (ClientWorkingThread clientsList  : serverList) {
                if (clientsList.equals(this))
                    serverList.remove(this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
