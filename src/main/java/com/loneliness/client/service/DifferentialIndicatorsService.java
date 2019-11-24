package com.loneliness.client.service;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.DifferentialIndicatorsRequest;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.entity.DifferentialIndicators;

import java.util.Map;

public class DifferentialIndicatorsService implements CRUDService<DifferentialIndicators,String, Map<Integer,DifferentialIndicators>>{
    private DifferentialIndicatorsRequest request = FactoryDAO.getInstance().getDifferentialIndicatorsRequest();
    @Override
    public String create(DifferentialIndicators obj) throws ServiceException {
        try {
            return request.add(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public DifferentialIndicators receive(DifferentialIndicators obj) throws ServiceException {
        try {
            return request.receive(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String update(DifferentialIndicators obj) throws ServiceException {
        try {
            return request.update(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String delete(DifferentialIndicators obj) throws ServiceException {
        try {
            return request.delete(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, DifferentialIndicators> receiveAllElem() throws ServiceException {
        try {
            return request.receiveAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, DifferentialIndicators> receiveAllElemInLimit(int left, int right) throws ServiceException {
        try {
            return request.receiveAllInLimit(left, right);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }
}
