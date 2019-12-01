package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.ROE;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLROEDAO;
import com.loneliness.server.servise.DataService;
import com.loneliness.server.servise.ServiceException;
import com.loneliness.server.servise.ServiceFactory;

import java.util.Map;

public class ROEService implements DataService<ROE,String, Map<Integer,ROE>> {
    private ROEService(){}
    private static final ROEService instance=new ROEService();
    private SQLROEDAO dao= DAOFactory.getInstance().getRoeDAO();
    public static ROEService getInstance() {
        return instance;
    }
    private BusinessServiceImpl calculator= ServiceFactory.getInstance().getBusinessService();

    @Override
    public String add(ROE note) throws ServiceException {
        note=calculator.calculateAllROEData(note);
        return dao.add(note);
    }

    @Override
    public String update(ROE note) throws ServiceException {
        note=calculator.calculateAllROEData(note);
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

    public ROE findRoeByReportingPeriodID(int id){
        return dao.findRoeByReportingPeriodID(id);
    }
}
