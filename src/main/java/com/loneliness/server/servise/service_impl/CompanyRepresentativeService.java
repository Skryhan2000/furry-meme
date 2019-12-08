package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.CompanyRepresentatives;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLCompanyRepresentative;
import com.loneliness.server.servise.DataService;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class CompanyRepresentativeService implements DataService<CompanyRepresentatives,String, Map<Integer,CompanyRepresentatives>> {

    private CompanyRepresentativeService(){}
    private SQLCompanyRepresentative dao= DAOFactory.getInstance().getCompanyRepresentative();
    private static final CompanyRepresentativeService instance=new CompanyRepresentativeService();
    private BusinessServiceImpl calculator= ServiceFactory.getInstance().getBusinessService();

    public static CompanyRepresentativeService getInstance() {
        return instance;
    }

    @Override
    public String add(CompanyRepresentatives note) throws ServiceException {
        return dao.add(note);
    }

    @Override
    public String update(CompanyRepresentatives note) throws ServiceException {
        return dao.update(note);
    }

    @Override
    public CompanyRepresentatives receive(CompanyRepresentatives note) {
        return dao.receive(note);
    }

    @Override
    public String delete(CompanyRepresentatives note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, CompanyRepresentatives> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, CompanyRepresentatives> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
