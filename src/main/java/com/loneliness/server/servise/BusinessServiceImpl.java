package com.loneliness.server.servise;

import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusinessServiceImpl implements IBusinessService<Index,BigDecimal>{

    private RoundingMode roundingMode=RoundingMode.HALF_UP;
    private int scale=4;
    private final BigDecimal T=new BigDecimal(0.35);

    @Override
    public BigDecimal calculateProfitability(Index data) throws ServiceException {
        try {
            return (data.getPBIT().divide(data.getSales(), scale, roundingMode)).multiply(new BigDecimal(100)).setScale(scale, roundingMode);
        }catch (ArithmeticException | NullPointerException e){
            throw new ServiceException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public BigDecimal calculateNetAssetTurnover(Index data) throws ServiceException {
        try {
        return data.getSales().divide(data.getAssets(),scale,RoundingMode.HALF_DOWN).setScale(scale, roundingMode);
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
        return (data.getCredit().add(data.getEquity())).divide(data.getEquity(),scale,roundingMode);
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
    public BigDecimal calculateSG(Index data) throws ServiceException {
        try {
            return ((calculateRONA(data).multiply(calculateFL(data))).multiply(T).multiply(data.getPBIT().
                    divide(data.getEBIT(),scale,roundingMode))).multiply(data.getE2().divide(data.
                    getE1(),scale,roundingMode));
        } catch (ServiceException e) {
            throw new ServiceException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public BigDecimal calculateWACC(Index data) {
        // TODO: 23.11.2019 уточнить формулу
//        BigDecimal f=data.getR().multiply(new BigDecimal(1).min(T));
//        BigDecimal s=data.getL().divide(data.getL(),scale,roundingMode).add(data.getE());
//        BigDecimal t=data.getE().divide(data.)
        return null;
    }

    public DifferentialIndicators calculateAllDifferentialIndicators(Index data) throws ServiceException {
        DifferentialIndicators indicators=new DifferentialIndicators();
        indicators.setProfR(calculateProfitability(data));
        indicators.setNetA(calculateNetAssetTurnover(data));
        indicators.setRONA(calculateRONA(data));
        indicators.setFL(calculateFL(data));
        indicators.setROE(calculateROE(data));
        indicators.setSG(calculateSG(data));
        indicators.setWACC(calculateWACC(data));
        return indicators;
    }
}
