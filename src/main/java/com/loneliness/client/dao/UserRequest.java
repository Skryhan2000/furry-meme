package com.loneliness.client.dao;

import com.loneliness.client.launcher.Client;
import com.loneliness.entity.Transmission;
import com.loneliness.entity.UserData;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRequest implements IDAO<UserData,String, Map<Integer,UserData>> {
    private Transmission transmission;

    @Override
    public String add(UserData note) {
        transmission = new Transmission();
        transmission.setCommand("CREATE_USER");
        transmission.setUserData(note);
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
    public String update(UserData note) {
        transmission = new Transmission();
        transmission.setCommand("UPDATE_USER");
        transmission.setUserData(note);
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
    public UserData receive(UserData note) {
        transmission = new Transmission();
        transmission.setCommand("RECEIVE_USER");
        transmission.setUserData(note);
        try {
            Client.getOutObject().writeObject(transmission);
            return (UserData) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    @Override
    public String delete(UserData note) {
        transmission = new Transmission();
        transmission.setCommand("DELETE_USER");
        transmission.setUserData(note);
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
    public Map<Integer, UserData> receiveAll() {
        Transmission transmission = new Transmission();
        transmission.setCommand("RECEIVE_ALL_USERS");
        try {
            Client.getOutObject().writeObject(transmission);
            return (ConcurrentHashMap<Integer, UserData>) Client.getInObject().readObject();
        } catch (IOException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Ошибка соединения с сервером");
        } catch (ClassNotFoundException e) {
            throw new DAOException(e.getMessage(), e.getCause(), "Не верный ответ с сервера");
        }
    }

    @Override
    public Map<Integer, UserData> receiveAllInLimit(int left, int right) {
        try {
            transmission = new Transmission();
            transmission.setBounds(new int[]{left, right});
            transmission.setCommand("RECEIVE_ALL_USERS_IN_LIMIT");
            Client.getOutObject().writeObject(transmission);
            return (Map<Integer, UserData>) Client.getInObject().readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DAOException("Ошибка получения данных", "ServerUserRequest " + e.getMessage());
        }
    }

    public UserData.Type authorise(UserData note) {
        transmission = new Transmission();
        transmission.setCommand("AUTHORISE_USER");
        transmission.setUserData(note);
        try {
            Client.getOutObject().writeObject(transmission);
            return (UserData.Type) Client.getInObject().readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new DAOException("Ошибка получения данных", "ServerUserRequest " + e.getMessage());
        }
    }
}
