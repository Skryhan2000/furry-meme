package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.dao.server_request.InitialDataRequest;
import com.loneliness.client.service.CRUDService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.InitialData;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLInitialDataDAO;
import com.loneliness.server.servise.DataService;

import java.math.BigDecimal;
import java.util.Map;

public class InitialDataService implements CRUDService<InitialData,String, Map<Integer,InitialData>> {
    private InitialDataService(){}
    private static final InitialDataService instance=new InitialDataService();
    private InitialDataRequest dao= FactoryDAO.getInstance().getInitialDataRequest();
    public static InitialDataService getInstance() {
        return instance;
    }



    @Override
    public String update(InitialData note) throws ServiceException{
        try {
            return dao.update(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public InitialData receive(InitialData note)throws ServiceException {
        try {
            return dao.receive(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String delete(InitialData note) throws ServiceException{
        try {
            return dao.delete(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String create(InitialData obj) throws ServiceException {
        try {
            return dao.add(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, InitialData> receiveAllElem() throws ServiceException {
        try {
            return dao.receiveAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, InitialData> receiveAllElemInLimit(int left, int right) throws ServiceException {
        try {
            return dao.receiveAllInLimit(left, right);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public BigDecimal findPreviousEquity(InitialData initialData) throws ServiceException{
        try {
            return dao.findFutureEquity(initialData);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public BigDecimal findFutureEquity(InitialData initialData) throws ServiceException{
        try {
            return dao.findPreviousEquity(initialData);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public BigDecimal findCreditInPeriod(int id) throws ServiceException{
        try {
            return dao.findCreditInPeriod(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }
}
