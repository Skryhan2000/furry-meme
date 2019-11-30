package com.loneliness.client.service;

public class FactoryService {
    private static final FactoryService instance=new FactoryService();
    private final UserService userService=new UserService();
    private final CalculateIndexService calculateIndexRequest = CalculateIndexService.getInstance();
    private FactoryService(){}

    public static FactoryService getInstance() {
        return instance;
    }



    public CalculateIndexService getCalculateIndexRequest() {
        return calculateIndexRequest;
    }

    public UserService getUserService() {
        return userService;
    }
}
