package com.loneliness.client.dao;

public class FactoryDAO {
    private static final FactoryDAO instance=new FactoryDAO();
    private final UserRequest userRequest=new UserRequest();
    public static FactoryDAO getInstance() {
        return instance;
    }
    private FactoryDAO(){}

    public UserRequest getUserRequest() {
        return userRequest;
    }
}
