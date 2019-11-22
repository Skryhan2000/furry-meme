package com.loneliness.server.launcher;




public class ServerLauncher {
    public static void main(String[] args)  {
        Server server = new Server(8000);
        while (true){
            if(server.applyConnection()==1)
                break;
        }


    }
}
