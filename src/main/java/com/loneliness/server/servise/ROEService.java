package com.loneliness.server.servise;

import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.entity.ROE;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLROEDAO;

import java.util.Map;

public class ROEService implements DataService<ROE,String, Map<Integer,ROE>>{
    private ROEService(){}
    private static final ROEService instance=new ROEService();
    private SQLROEDAO dao= DAOFactory.getInstance().getRoeDAO();
    public static ROEService getInstance() {
        return instance;
    }

    @Override
    public String add(ROE note) {
        return dao.add(note);
    }

    @Override
    public String update(ROE note) {
        return dao.update(note);
    }

    @Override
    public ROE receive(ROE note) {
        return dao.receive(note);
    }

    @Override
    public String delete(ROE note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, ROE> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, ROE> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
