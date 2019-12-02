package com.loneliness.server.view;


import com.loneliness.entity.Transmission;
import com.loneliness.server.controller.CommandName;
import com.loneliness.server.controller.CommandProvider;
import com.loneliness.server.controller.ControllerException;
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
        CommandProvider provider=CommandProvider.getCommandProvider();
        try {
            while (true) {
                transmission = (Transmission) inObject.readObject();
                if (transmission.getUserData() != null) {
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getUserData());
                } else if(transmission.getBounds()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getBounds());
                }else if(transmission.getCompany()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getCompany());
                }
                else if(transmission.getContactDetail()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getContactDetail());
                }
                else if(transmission.getCredit()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getCredit());
                }
                else if(transmission.getDividend()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getDividend());
                }
                else if(transmission.getInitialData()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getInitialData());
                }
                else if(transmission.getQuarter()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getQuarter());
                }
                else if(transmission.getReportingPeriod()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getReportingPeriod());
                }
                else if(transmission.getRoe()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getRoe());
                }
                else if(transmission.getSg()!=null){
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission.getSg());
                }else {
                    response = provider.getCommand(CommandName.valueOf(transmission.getCommand())).
                            execute(transmission);
                }
                outObject.writeObject(response);
                outObject.reset();
            }


        }catch (ClassCastException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException | IOException | ControllerException e) {
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
