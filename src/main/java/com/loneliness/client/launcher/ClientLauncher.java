package com.loneliness.client.launcher;

public class ClientLauncher {
    public static void main(String[] args) {
        String ipAddress = args[0];
        int port = 8000;
        Client client = new Client(ipAddress,port);
        client.start();


    }
}
