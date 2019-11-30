package com.loneliness.client.service.service_impl;

import com.loneliness.client.dao.server_request.CalculateIndexRequest;
import com.loneliness.client.dao.DAOException;
import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.service.ServiceException;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;
import com.loneliness.entity.ROE;
import com.loneliness.entity.SG;


import java.math.BigDecimal;

public class CalculateIndexService {
    private static CalculateIndexRequest request= FactoryDAO.getInstance().getCalculateIndexRequest();
    private CalculateIndexService(){}
    private static CalculateIndexService instance=new CalculateIndexService();

    public static CalculateIndexService getInstance() {
        return instance;
    }

    public BigDecimal calculateProfitability(Index data) throws ServiceException {
        try {
            return request.calculateProfitability(data);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }


    public BigDecimal calculateNetAssetTurnover(Index data) throws ServiceException {
       try {
           return request.calculateNetAssetTurnover(data);
       } catch (DAOException e) {
           throw new ServiceException(e.getCause(),e.getMessage());
       }
    }


    public BigDecimal calculateRONA(Index data) throws ServiceException {
        try {
            return request.calculateRONA(data);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public BigDecimal calculateFL(Index data) throws ServiceException {
        try {
            return request.calculateFL(data);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public BigDecimal calculateROE(Index data) throws ServiceException {
        try {
            return request.calculateROE(data);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public BigDecimal calculateSG(SG data) throws ServiceException {
        try {
            return request.calculateSG(data);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }


    public BigDecimal calculateWACC(Index data) throws ServiceException {
        try {
            return request.calculateWACC(data);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

    public ROE CalculateAllROEData(ROE data) throws ServiceException {
        try {
            return request.CalculateAllROEData(data);
        } catch (DAOException e) {
            throw new ServiceException(e.getCause(),e.getMessage());
        }
    }

}
