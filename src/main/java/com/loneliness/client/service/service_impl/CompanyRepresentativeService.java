package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.dao.server_request.CompanyRepresentativeRequest;
import com.loneliness.client.service.CRUDService;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.CompanyRepresentatives;

import java.util.Map;

public class CompanyRepresentativeService implements CRUDService<CompanyRepresentatives,String, Map<Integer,CompanyRepresentatives>> {

    private CompanyRepresentativeService(){}
    private CompanyRepresentativeRequest dao= FactoryDAO.getInstance().getCompanyRepresentativeRequest();
    private static final CompanyRepresentativeService instance=new CompanyRepresentativeService();

    public static CompanyRepresentativeService getInstance() {
        return instance;
    }

    @Override
    public String create(CompanyRepresentatives obj) throws ServiceException {
        try {
            return dao.add(obj);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, CompanyRepresentatives> receiveAllElem() throws ServiceException {
        try {
            return dao.receiveAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public Map<Integer, CompanyRepresentatives> receiveAllElemInLimit(int left, int right) throws ServiceException {
        try {
            return dao.receiveAllInLimit(left, right);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }



    @Override
    public String update(CompanyRepresentatives note) throws ServiceException {
        try {
            return dao.update(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public CompanyRepresentatives receive(CompanyRepresentatives note) throws ServiceException {
        try {
            return dao.receive(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    @Override
    public String delete(CompanyRepresentatives note) throws ServiceException {
        try {
            return dao.delete(note);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }


}
