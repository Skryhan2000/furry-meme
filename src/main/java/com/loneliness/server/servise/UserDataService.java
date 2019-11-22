package com.loneliness.server.servise;

import com.loneliness.entity.UserData;
import com.loneliness.server.dao.DAOFactory;
import com.loneliness.server.dao.SQLUserDAO;

import java.util.Map;

public class UserDataService implements DataService<UserData,String, Map<Integer,UserData>> {
    private final SQLUserDAO userDAO =DAOFactory.getInstance().getUserDAO();
    @Override
    public String add(UserData note) {
        return userDAO.add(note);
    }

    @Override
    public String update(UserData note) {
        return userDAO.update(note);
    }

    @Override
    public UserData receive(UserData note) {
        return userDAO.receive(note);
    }

    @Override
    public String delete(UserData note) {
        return userDAO.delete(note);
    }

    @Override
    public Map<Integer, UserData> receiveAll() {
        return userDAO.receiveAll();
    }

    @Override
    public Map<Integer, UserData> receiveAllInLimit(int left, int right) {
        return userDAO.receiveAllInLimit(left,right);
    }
    public UserData.Type authorise(UserData data){
        if(data.getPassword().equals(receive(data).getPassword()))
        return receive(data).getType();
        else return UserData.Type.NO_TYPE;
    }
}
