package com.loneliness.server.dao;

public class DAOFactory {
    private static final  DAOFactory instance=new DAOFactory();
    private DAOFactory(){}
    private final SQLUserDAO userDAO=SQLUserDAO.getInstance();

    public static DAOFactory getInstance() {
        return instance;
    }

    public SQLUserDAO getUserDAO() {
        return userDAO;
    }
}
