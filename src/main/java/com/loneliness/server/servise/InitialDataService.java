package com.loneliness.server.servise;

import com.loneliness.entity.InitialData;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLInitialDataDAO;

import java.util.Map;

public class InitialDataService implements DataService<InitialData,String, Map<Integer,InitialData>>{
    private InitialDataService(){}
    private static final InitialDataService instance=new InitialDataService();
    private SQLInitialDataDAO dao= DAOFactory.getInstance().getInitialDataDAO();
    public static InitialDataService getInstance() {
        return instance;
    }

    @Override
    public String add(InitialData note) {
        return dao.add(note);
    }

    @Override
    public String update(InitialData note) {
        return dao.update(note);
    }

    @Override
    public InitialData receive(InitialData note) {
        return dao.receive(note);
    }

    @Override
    public String delete(InitialData note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, InitialData> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, InitialData> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
