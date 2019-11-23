package com.loneliness.server.servise;


import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.SQLDifferentialIndicatorsDAO;

import java.util.Map;

public class DifferentialIndicatorsDataService implements DataService<DifferentialIndicators,String, Map<Integer, DifferentialIndicators>> {
    SQLDifferentialIndicatorsDAO dao= DAOFactory.getInstance().getDifferentialIndicatorsDAO();
    @Override
    public String add(DifferentialIndicators note) {
        return dao.add(note);
    }

    @Override
    public String update(DifferentialIndicators note) {
        return dao.update(note);
    }

    @Override
    public DifferentialIndicators receive(DifferentialIndicators note) {
        return dao.receive(note);
    }

    @Override
    public String delete(DifferentialIndicators note) {
        return dao.delete(note);
    }

    @Override
    public Map<Integer, DifferentialIndicators> receiveAll() {
        return dao.receiveAll();
    }

    @Override
    public Map<Integer, DifferentialIndicators> receiveAllInLimit(int left, int right) {
        return dao.receiveAllInLimit(left, right);
    }
}
