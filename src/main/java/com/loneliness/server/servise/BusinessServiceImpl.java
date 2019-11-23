package com.loneliness.server.servise;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;
import com.loneliness.server.controller.command_implements.business_command.CalculateRONA;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusinessServiceImpl implements IBusinessService<Index,BigDecimal>{

    // TODO: 22.11.2019 что такое FL?
    private RoundingMode roundingMode=RoundingMode.HALF_UP;
    private int scale=4;

    @Override
    public BigDecimal calculateProfitability(Index data) throws ServiceException {
        try {
            return (data.getNetProfit().divide(data.getRevenuesFromSales(), scale, roundingMode)).multiply(new BigDecimal(100)).setScale(scale, roundingMode);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateNetAssetTurnover(Index data) throws ServiceException {
        try {
        return data.getRevenuesFromSales().divide(data.getAssets(),scale,RoundingMode.HALF_DOWN).setScale(scale, roundingMode);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateRONA(Index data) throws ServiceException {
        try {
            return calculateProfitability(data).multiply(calculateNetAssetTurnover(data)).setScale(scale, roundingMode);
        }
        catch (NullPointerException | ServiceException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateFL(Index data) throws ServiceException {
        try {
        return (data.getAttractedCapital().add(data.getEquity())).divide(data.getEquity(),scale,roundingMode);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateROE(Index data) throws ServiceException {
        try {
            return calculateRONA(data).multiply(calculateFL(data)).setScale(scale, roundingMode);
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
