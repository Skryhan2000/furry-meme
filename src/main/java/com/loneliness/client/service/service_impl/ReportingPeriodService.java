package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.dao.server_request.ReportingPeriodRequest;
import com.loneliness.client.service.CRUDService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.InitialData;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLReportingPeriodDAO;
import com.loneliness.server.servise.DataService;

import java.math.BigDecimal;
import java.util.Map;

public class ReportingPeriodService implements CRUDService<ReportingPeriod,String, Map<Integer,ReportingPeriod>> {
    private ReportingPeriodService(){}
    private static final ReportingPeriodService instance=new ReportingPeriodService();
    private ReportingPeriodRequest dao= FactoryDAO.getInstance().getReportingPeriodRequest();
    public static ReportingPeriodService getInstance() {
        return instance;
    }

    @Override
    public String update(ReportingPeriod note)throws ServiceException {
        try {
            return dao.update(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public ReportingPeriod receive(ReportingPeriod note)throws ServiceException {
        try {
            return dao.receive(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }


    @Override
    public String delete(ReportingPeriod note) throws ServiceException{
        try {
            return dao.delete(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String create(ReportingPeriod obj) throws ServiceException {
        try {
            return dao.add(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, ReportingPeriod> receiveAllElem() throws ServiceException {
        try {
            return dao.receiveAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, ReportingPeriod> receiveAllElemInLimit(int left, int right) throws ServiceException {
        try {
            return dao.receiveAllInLimit(left, right);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }


}
