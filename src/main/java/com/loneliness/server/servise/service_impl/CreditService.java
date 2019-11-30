package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.Credit;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLCreditDAO;
import com.loneliness.server.servise.DataService;

import java.util.Map;

public class CreditService implements DataService<Credit,String, Map<Integer, Credit>> {
    private CreditService(){}
    private final static CreditService instance=new CreditService();
    private SQLCreditDAO dao= DAOFactory.getInstance().getCreditDAO();
    public static CreditService getInstance() {
        return instance;
    }

    @Override
    public String add(Credit note) {
        return dao.add(note);
    }

    @Override
    public String update(Credit note) {
        return dao.update(note);
    }

    @Override
    public Credit receive(Credit note) {
        return dao.receive(note);
    }

    @Override
    public String delete(Credit note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, Credit> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, Credit> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
