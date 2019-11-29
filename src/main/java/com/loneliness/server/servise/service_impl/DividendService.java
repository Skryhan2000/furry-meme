package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.Dividend;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLDividendDAO;
import com.loneliness.server.servise.DataService;

import java.util.Map;

public class DividendService implements DataService<Dividend,String, Map<Integer, Dividend>> {
    private DividendService(){}
    private final static DividendService instance=new DividendService();
    private SQLDividendDAO dao=DAOFactory.getInstance().getDividendDAO();
    public static DividendService getInstance() {
        return instance;
    }

    @Override
    public String add(Dividend note) {
        return dao.add(note);
    }

    @Override
    public String update(Dividend note) {
        return dao.update(note);
    }

    @Override
    public Dividend receive(Dividend note) {
        return dao.receive(note);
    }

    @Override
    public String delete(Dividend note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, Dividend> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, Dividend> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
