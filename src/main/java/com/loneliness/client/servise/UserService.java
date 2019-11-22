package com.loneliness.client.servise;

import com.loneliness.client.dao.FactoryDAO;
import com.loneliness.client.dao.UserRequest;
import com.loneliness.entity.UserData;

import java.util.Map;

public class UserService implements CRUDService<UserData,String, Map<Integer,UserData>>{
    private UserRequest request= FactoryDAO.getInstance().getUserRequest();
    @Override
    public String create(UserData obj) throws ServiceException {
        return request.add(obj);
    }

    @Override
    public UserData receive(UserData obj) throws ServiceException {
        return request.receive(obj);
    }

    @Override
    public String update(UserData obj) throws ServiceException {
        return request.update(obj);
    }

    @Override
    public String delete(UserData obj) throws ServiceException {
        return request.delete(obj);
    }

    @Override
    public Map<Integer, UserData> receiveAllElem() throws ServiceException {
        return request.receiveAll();
    }

    @Override
    public Map<Integer, UserData> receiveAllElemInLimit(int left, int right) throws ServiceException {
        return request.receiveAllInLimit(left, right);
    }
    public UserData.Type authorise(UserData obj){
        return request.authorise(obj);
    }
}
