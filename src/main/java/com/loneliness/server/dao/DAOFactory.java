package com.loneliness.server.dao;

import com.loneliness.server.dao.sql_dao.*;

public class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();
    private final SQLUserDAO userDAO = SQLUserDAO.getInstance();
    private final SQLDifferentialIndicatorsDAO differentialIndicatorsDAO = SQLDifferentialIndicatorsDAO.getInstance();
    private final SQLCompanyDAO companyDAO = SQLCompanyDAO.getInstance();
    private final SQLContactDetailDAO contactDetailDAO = SQLContactDetailDAO.getInstance();
    private final SQLCreditDAO creditDAO = SQLCreditDAO.getInstance();
    private final SQLDividendDAO dividendDAO = SQLDividendDAO.getInstance();
    private final SQLInitialDataDAO initialDataDAO = SQLInitialDataDAO.getInstance();
    private final SQLReportingPeriodDAO reportingPeriodDAO = SQLReportingPeriodDAO.getInstance();
    private final SQLROEDAO roeDAO = SQLROEDAO.getInstance();
    private final SQLSGDAO sgDAO = SQLSGDAO.getInstance();

    public static DAOFactory getInstance() {
        return instance;
    }

    private DAOFactory() {
    }

    public SQLUserDAO getUserDAO() {
        return userDAO;
    }

    public SQLDifferentialIndicatorsDAO getDifferentialIndicatorsDAO() {
        return differentialIndicatorsDAO;
    }

    public SQLCompanyDAO getCompanyDAO() {
        return companyDAO;
    }

    public SQLContactDetailDAO getContactDetailDAO() {
        return contactDetailDAO;
    }

    public SQLCreditDAO getCreditDAO() {
        return creditDAO;
    }

    public SQLDividendDAO getDividendDAO() {
        return dividendDAO;
    }

    public SQLInitialDataDAO getInitialDataDAO() {
        return initialDataDAO;
    }

    public SQLReportingPeriodDAO getReportingPeriodDAO() {
        return reportingPeriodDAO;
    }

    public SQLROEDAO getRoeDAO() {
        return roeDAO;
    }

    public SQLSGDAO getSgDAO() {
        return sgDAO;
    }
}
