package com.loneliness.client.dao;

import com.loneliness.client.launcher.Client;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;
import com.loneliness.entity.Transmission;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;




public class CalculateIndexRequest  {
    private Transmission transmission;
    public BigDecimal calculateProfitability(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_PROFITABILITY");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }


    public BigDecimal calculateNetAssetTurnover(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_NET_ASSET_TURNOVER");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }


    public BigDecimal calculateRONA(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_RONA");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    public BigDecimal calculateFL(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_FL");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    public BigDecimal calculateROE(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand(" CALCULATE_ROE");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    public BigDecimal calculateSG(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_SG");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }


    public BigDecimal calculateWACC(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_WACC");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    public DifferentialIndicators calculateAllDifferentialIndicators(Index data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_ALL_DIFFERENTIAL_INDICATORS");
        transmission.setIndex(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (DifferentialIndicators) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }

    }
}
