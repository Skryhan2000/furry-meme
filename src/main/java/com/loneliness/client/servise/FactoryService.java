package com.loneliness.client.servise;

public class FactoryService {
    private static final FactoryService instance=new FactoryService();
    public final UserService userService=new UserService();
    private FactoryService(){}

    public static FactoryService getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }
}
