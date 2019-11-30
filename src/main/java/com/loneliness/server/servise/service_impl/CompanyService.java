package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.Company;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLCompanyDAO;
import com.loneliness.server.servise.DataService;

import java.util.Map;

public class CompanyService implements DataService<Company,String, Map<Integer,Company>> {
    private CompanyService(){}
    private static final CompanyService instance =new CompanyService();
    public static CompanyService getInstance() {
        return instance;
    }
    private SQLCompanyDAO dao= DAOFactory.getInstance().getCompanyDAO();
    @Override
    public String add(Company note) {
        return dao.add(note);
    }

    @Override
    public String update(Company note) {
        return dao.update(note);
    }

    @Override
    public Company receive(Company note) {
        return dao.receive(note);
    }

    @Override
    public String delete(Company note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, Company> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, Company> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
