package com.loneliness.server.servise;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;
import com.loneliness.server.controller.command_implements.business_command.CalculateRONA;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusinessServiceImpl implements IBusinessService<Index,BigDecimal>{
    // TODO: 22.11.2019 Какое округление?
    // TODO: 22.11.2019 что такое FL?
    @Override
    public BigDecimal calculateProfitability(Index data) throws ServiceException {
        try {
            return (data.getNetProfit().divide(data.getRevenuesFromSales(), 9, RoundingMode.HALF_DOWN)).multiply(new BigDecimal(100)).setScale(1, RoundingMode.FLOOR);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateNetAssetTurnover(Index data) throws ServiceException {
        try {
        return data.getRevenuesFromSales().divide(data.getAssets(),9,RoundingMode.HALF_DOWN).setScale(2, RoundingMode.FLOOR);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateRONA(Index data) throws ServiceException {
        try {
            return calculateProfitability(data).multiply(calculateNetAssetTurnover(data)).setScale(1, RoundingMode.HALF_UP);
        }
        catch (NullPointerException | ServiceException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateFL(Index data) throws ServiceException {
        try {
        return (data.getAttractedCapital().add(data.getEquity())).divide(data.getEquity(),1,RoundingMode.FLOOR);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateROE(Index data) throws ServiceException {
        try {
            return calculateRONA(data).multiply(calculateFL(data)).setScale(1, RoundingMode.HALF_UP);
        } catch (ArithmeticException | NullPointerException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public BigDecimal calculateSG(Index data) {
        return null;
    }

    @Override
    public BigDecimal calculateWACC(Index data) {
        return null;
    }

    public DifferentialIndicators calculateAllDifferentialIndicators(Index data) throws ServiceException {
        DifferentialIndicators indicators=new DifferentialIndicators();
        indicators.setProfitability(calculateProfitability(data));
        indicators.setNetAssetTurnover(calculateNetAssetTurnover(data));
        indicators.setRONA(calculateRONA(data));
        indicators.setFL(calculateFL(data));
        indicators.setROE(calculateROE(data));
        indicators.setSG(calculateSG(data));
        indicators.setWACC(calculateWACC(data));
        return indicators;
    }
}
