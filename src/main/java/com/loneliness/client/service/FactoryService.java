package com.loneliness.client.service;

import com.loneliness.entity.DifferentialIndicators;

public class FactoryService {
    private static final FactoryService instance=new FactoryService();
    private final UserService userService=new UserService();
    private final DifferentialIndicatorsService differentialIndicatorsService=new DifferentialIndicatorsService();
    private FactoryService(){}

    public static FactoryService getInstance() {
        return instance;
    }

    public DifferentialIndicatorsService getDifferentialIndicatorsService() {
        return differentialIndicatorsService;
    }

    public UserService getUserService() {
        return userService;
    }
}
