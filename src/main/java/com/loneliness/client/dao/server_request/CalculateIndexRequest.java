package com.loneliness.client.dao.server_request;

import com.loneliness.client.dao.DAOException;
import com.loneliness.client.launcher.Client;
import com.loneliness.entity.Index;
import com.loneliness.entity.ROE;
import com.loneliness.entity.SG;
import com.loneliness.entity.Transmission;

import java.io.IOException;
import java.math.BigDecimal;




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
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
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
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
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
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
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
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
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
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
        }
    }

    public BigDecimal calculateSG(SG data) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_SG");
        transmission.setSg(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (BigDecimal) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
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
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
        }
    }
    public ROE CalculateAllROEData(ROE data) throws  DAOException {
        transmission = new Transmission();
        transmission.setCommand("CALCULATE_ALL_ROE_DATA");
        transmission.setRoe(data);
        try {
            Client.getOutObject().writeObject(transmission);
            return (ROE) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }catch (ClassCastException e){
            throw new DAOException( e.getCause(),"Не валидные данные отправлены");
        }
    }

}
