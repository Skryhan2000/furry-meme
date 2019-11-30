package com.loneliness.server.servise.service_impl;

import com.loneliness.entity.*;
import com.loneliness.server.dao.sql_dao.SQLReportingPeriodDAO;
import com.loneliness.server.servise.ServiceException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusinessServiceImpl {
    private final static RoundingMode roundingMode=RoundingMode.HALF_UP;
    private final static int scale=4;
    private final static BigDecimal T=new BigDecimal(0.35);


    public BigDecimal calculateProfitability(ROE data) throws ServiceException {//рентабельность продаж
        try {
            return (data.getInitialData().getPBIT().divide(data.getInitialData().getSales(), scale, roundingMode)).
                    multiply(new BigDecimal(100)).setScale(scale, roundingMode);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }


    public BigDecimal calculateNetAssetTurnover(ROE data) throws ServiceException { //оборачиваемость чистых активов
        try {
        return data.getInitialData().getSales().divide(data.getInitialData().getAssets(),
                scale,RoundingMode.HALF_DOWN).setScale(scale, roundingMode);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }


    public BigDecimal calculateRONA(ROE data) throws ServiceException {
        try {
            return calculateProfitability(data).multiply(calculateNetAssetTurnover(data)).setScale(scale, roundingMode);
        }
        catch (NullPointerException | ServiceException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }


    public BigDecimal calculateFL(ROE data) throws ServiceException {
        try {
        return (data.getInitialData().getCredit().add(data.getInitialData().getEquity())).divide(data.getInitialData().getEquity(),scale,roundingMode);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    public BigDecimal calculateROE(ROE data) throws ServiceException {
        try {
            return calculateRONA(data).multiply(calculateFL(data)).setScale(scale, roundingMode);
        } catch (ArithmeticException | NullPointerException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }


    public BigDecimal calculateSG(SG data) throws ServiceException {
        try {

            return ((calculateRONA(data.getRoe()).multiply(calculateFL(data.getRoe()))).multiply(T).multiply(data.getRoe().getInitialData().getPBIT().
                    divide(data.getRoe().getEBIT(),scale,roundingMode))).multiply(SQLReportingPeriodDAO.getInstance().findFutureEquity(data.getInitialDataId()).
                    divide(SQLReportingPeriodDAO.getInstance().findFutureEquity(data.getInitialDataId()),scale,roundingMode));
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }

    public BigDecimal calculateWACC(InitialData initialData) throws ServiceException {
        try {
            return SQLReportingPeriodDAO.getInstance().findCreditInPeriod(initialData.getReportingDateId()).multiply(new BigDecimal(1).min(T)).multiply( initialData.getCredit().divide( initialData.getCredit(),
                    scale,roundingMode).add(initialData.getEquity())).add( initialData.getCredit().divide(( initialData.getCredit().add(initialData.getEquity())),
                    scale,roundingMode)).add((new BigDecimal(0.07).multiply(initialData.getPBIT())).multiply(initialData.getEquity().divide((initialData.getCredit().add(initialData.getEquity())),scale,roundingMode)));
        }catch (ArithmeticException e){
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }
    public ROE calculateAllROEData(ROE note) throws ServiceException {
        calculateProfitability(note);
        calculateNetAssetTurnover(note);
        calculateRONA(note);
        calculateROE(note);
        calculateFL(note);
        return note;
    }


}
