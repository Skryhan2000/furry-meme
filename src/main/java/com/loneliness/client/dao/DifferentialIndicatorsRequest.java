package com.loneliness.client.dao;

import com.loneliness.client.launcher.Client;
import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Transmission;
import com.loneliness.entity.UserData;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DifferentialIndicatorsRequest implements IDAO<DifferentialIndicators,String, Map<Integer,DifferentialIndicators>>{
    private Transmission transmission;
    @Override
    public String add(DifferentialIndicators note) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand(" CREATE_DIFFERENTIAL_INDICATORS");
        transmission.setDifferentialIndicators(note);
        try {
            Client.getOutObject().writeObject(transmission);
            return (String) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    @Override
    public String update(DifferentialIndicators note) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("UPDATE_DIFFERENTIAL_INDICATORS");
        transmission.setDifferentialIndicators(note);
        try {
            Client.getOutObject().writeObject(transmission);
            return (String) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    @Override
    public DifferentialIndicators receive(DifferentialIndicators note) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("RECEIVE_DIFFERENTIAL_INDICATORS");
        transmission.setDifferentialIndicators(note);
        try {
            Client.getOutObject().writeObject(transmission);
            return (DifferentialIndicators) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    @Override
    public String delete(DifferentialIndicators note) throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("DELETE_DIFFERENTIAL_INDICATORS");
        transmission.setDifferentialIndicators(note);
        try {
            Client.getOutObject().writeObject(transmission);
            return (String) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    @Override
    public Map<Integer, DifferentialIndicators> receiveAll() throws DAOException {
        transmission = new Transmission();
        transmission.setCommand("RECEIVE_ALL_DIFFERENTIAL_INDICATORS");
        try {
            Client.getOutObject().writeObject(transmission);
            return (ConcurrentHashMap<Integer, DifferentialIndicators>) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    @Override
    public Map<Integer, DifferentialIndicators> receiveAllInLimit(int left, int right) throws DAOException {
            transmission = new Transmission();
            transmission.setBounds(new int[]{left, right});
            transmission.setCommand("RECEIVE_ALL_DIFFERENTIAL_INDICATORS_IN_LIMIT");
            try {
            Client.getOutObject().writeObject(transmission);
            return (Map<Integer, DifferentialIndicators>) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }
}
