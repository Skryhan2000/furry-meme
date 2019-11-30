package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.InitialData;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.sql_dao.SQLReportingPeriodDAO;
import com.loneliness.server.servise.DataService;

import java.math.BigDecimal;
import java.util.Map;

public class ReportingPeriodService implements DataService<ReportingPeriod,String, Map<Integer,ReportingPeriod>> {
    private ReportingPeriodService(){}
    private static final ReportingPeriodService instance=new ReportingPeriodService();
    private SQLReportingPeriodDAO dao= DAOFactory.getInstance().getReportingPeriodDAO();
    public static ReportingPeriodService getInstance() {
        return instance;
    }

    @Override
    public String add(ReportingPeriod note) {
        return dao.add(note);
    }

    @Override
    public String update(ReportingPeriod note) {
        return dao.update(note);
    }

    @Override
    public ReportingPeriod receive(ReportingPeriod note) {
        return dao.receive(note);
    }

    public ReportingPeriod receive(int id) {
        return dao.receive(id);
    }

    @Override
    public String delete(ReportingPeriod note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, ReportingPeriod> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, ReportingPeriod> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
    public BigDecimal findPreviousEquity(InitialData initialData){
        return dao.findPreviousEquity(initialData);
    }

    public BigDecimal findFutureEquity(InitialData initialData){
        return dao.findPreviousEquity(initialData);
    }

    public BigDecimal findCreditInPeriod(int id){
        return dao.findCreditInPeriod(id);
    }
}
