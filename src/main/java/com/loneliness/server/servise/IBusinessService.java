package com.loneliness.server.servise;

import java.math.BigDecimal;

public interface IBusinessService<D,R> {
    R calculateProfitability(D data) throws ServiceException;
    R calculateNetAssetTurnover(D data) throws ServiceException;
    R calculateRONA(D data) throws ServiceException;
    R calculateFL(D data) throws ServiceException;
    R calculateROE(D data) throws ServiceException;
    R calculateSG(D data) throws ServiceException;
    R calculateWACC(D data) throws ServiceException;
}
