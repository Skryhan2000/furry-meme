package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.dao.server_request.ROERequest;
import com.loneliness.client.service.CRUDService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.ROE;

import java.util.Map;

public class ROEService implements CRUDService<ROE,String, Map<Integer,ROE>> {
    private ROEService(){}
    private static final ROEService instance=new ROEService();
    private ROERequest dao= FactoryDAO.getInstance().getRoeRequest();
    public static ROEService getInstance() {
        return instance;
    }

    @Override
    public String update(ROE note)throws ServiceException {
        try {
            return dao.update(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public ROE receive(ROE note)throws ServiceException {
        try {
            return dao.receive(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String delete(ROE note) throws ServiceException{
        try {
            return dao.delete(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String create(ROE obj)throws ServiceException  {
        try {
            return dao.add(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, ROE> receiveAllElem()  throws ServiceException{
        try {
            return dao.receiveAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, ROE> receiveAllElemInLimit(int left, int right) throws ServiceException {
        try {
            return dao.receiveAllInLimit(left, right);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

}
