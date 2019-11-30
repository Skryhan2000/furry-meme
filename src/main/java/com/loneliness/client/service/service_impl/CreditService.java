package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.dao.server_request.CreditRequest;
import com.loneliness.client.service.CRUDService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Credit;

import java.util.Map;

public class CreditService implements CRUDService<Credit,String, Map<Integer, Credit>> {
    private CreditService(){}
    private final static CreditService instance=new CreditService();
    private CreditRequest dao= FactoryDAO.getInstance().getCreditRequest();
    public static CreditService getInstance() {
        return instance;
    }


    @Override
    public String update(Credit note) throws ServiceException {
        try {
            return dao.update(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Credit receive(Credit note) throws ServiceException{
        try {
            return dao.receive(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String delete(Credit note) throws ServiceException{
        try {
            return dao.delete(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String create(Credit obj) throws ServiceException {
        try {
            return dao.add(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, Credit> receiveAllElem() throws ServiceException {
        try {
            return dao.receiveAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, Credit> receiveAllElemInLimit(int left, int right) throws ServiceException {
        try {
            return dao.receiveAllInLimit(left, right);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }


}
