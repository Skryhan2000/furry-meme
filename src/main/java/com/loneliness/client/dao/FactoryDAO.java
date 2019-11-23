package com.loneliness.client.dao;

public class FactoryDAO {
    private static final FactoryDAO instance=new FactoryDAO();
    private final UserRequest userRequest=new UserRequest();
    private final DifferentialIndicatorsRequest differentialIndicatorsRequest=new DifferentialIndicatorsRequest();
    public static FactoryDAO getInstance() {
        return instance;
    }
    private FactoryDAO(){}

    public DifferentialIndicatorsRequest getDifferentialIndicatorsRequest() {
        return differentialIndicatorsRequest;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }
}
