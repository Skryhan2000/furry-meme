package com.loneliness.client.dao;

import com.loneliness.client.dao.server_request.CalculateIndexRequest;
import com.loneliness.client.dao.server_request.UserRequest;

public class FactoryDAO {
    private static final FactoryDAO instance=new FactoryDAO();
    private final UserRequest userRequest=new UserRequest();

    private final CalculateIndexRequest calculateIndexRequest=new CalculateIndexRequest();

    public static FactoryDAO getInstance() {
        return instance;
    }
    private FactoryDAO(){}


    public UserRequest getUserRequest() {
        return userRequest;
    }

    public CalculateIndexRequest getCalculateIndexRequest() {
        return calculateIndexRequest;
    }
}
