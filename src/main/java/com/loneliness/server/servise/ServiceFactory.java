package com.loneliness.server.servise;

public class ServiceFactory {
    private static final ServiceFactory instance=new ServiceFactory();
    private final UserDataService userService=new UserDataService();
    private final BusinessServiceImpl businessService=new BusinessServiceImpl();
    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserDataService getUserService() {
        return userService;
    }

    public BusinessServiceImpl getBusinessService() {
        return businessService;
    }
}
