package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.dao.server_request.CompanyRequest;
import com.loneliness.client.service.CRUDService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.Company;

import java.util.Map;

public class CompanyService implements CRUDService<Company,String, Map<Integer,Company>> {
    private CompanyService(){}
    private static final CompanyService instance =new CompanyService();
    public static CompanyService getInstance() {
        return instance;
    }
    private CompanyRequest dao= FactoryDAO.getInstance().getCompanyRequest();

    @Override
    public String create(Company obj) throws ServiceException {
        try {
            return dao.add(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }
    @Override
    public String update(Company note) throws ServiceException {
        try {
            return dao.update(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Company receive(Company note) throws ServiceException {
        try {
            return dao.receive(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String delete(Company note) throws ServiceException {
        try {
            return dao.delete(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }
    @Override
    public Map<Integer, Company> receiveAllElem() throws ServiceException {
        try {
            return dao.receiveAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, Company> receiveAllElemInLimit(int left, int right) throws ServiceException {
        try {
            return dao.receiveAllInLimit(left, right);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }



}
