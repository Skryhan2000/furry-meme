package com.loneliness.server.servise;

import java.math.BigDecimal;

public interface IBusinessService<D,R> {
    R calculateProfitability(D data) throws ServiceException;
    R calculateNetAssetTurnover(D data) throws ServiceException;
    R calculateRONA(D data);
    R calculateFL(D data);
    R calculateROE(D data);
    R calculateSG(D data);
    R calculateWACC(D data);
}
