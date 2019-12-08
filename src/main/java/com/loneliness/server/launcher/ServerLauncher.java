package com.loneliness.server.launcher;




public class ServerLauncher {
    public static void main(String[] args)  {
        Server server;
        if(args[0]!=null){
            try {
                server = new Server(Integer.parseInt(args[0]));
            }
            catch (NumberFormatException e){
                System.out.println("неверно заданный порт. Выбран порт 8000");
                server = new Server(8000);
            }
        }
        else server = new Server(8000);
        while (true){
            if(server.applyConnection()==1)
                break;
        }


    }
}
