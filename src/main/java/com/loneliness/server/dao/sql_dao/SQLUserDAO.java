package com.loneliness.server.dao.sql_dao;

import com.loneliness.entity.UserData;
import com.loneliness.server.dao.DataBaseConnection;
import com.loneliness.server.dao.IDAO;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLUserDAO implements IDAO<UserData,String, Map<Integer,UserData>> {
    private static final SQLUserDAO instance=new SQLUserDAO();
    private SQLUserDAO(){}
    public static SQLUserDAO getInstance() {
        return instance;
    }

    private UserData getDataFromResultSet(ResultSet resultSet) throws SQLException {
        UserData userData = new UserData();
        userData.setId(resultSet.getInt("id"));
        userData.setLogin(resultSet.getString("login"));
        userData.setPassword(resultSet.getString("password"));
        userData.setType(resultSet.getString("type"));
        userData.setEmail(resultSet.getString("email"));
        return userData;
    }
    @Override
    public String add(UserData note) {
        String sql;
        try {
            Connection connection= DataBaseConnection.getInstance().getConnection();
            sql="INSERT Users (login , password , type, email) " +
                    "VALUES ( '"+
                    note.getLogin()+"',' "+
                    note.getPassword()+"', '"+
                    note.getType().toString()+"', '"+
                    note.getEmail()+"' "+
                    ");";
           if(connection.prepareStatement(sql).executeUpdate()>=1){
               return "Данные успешно добавлены";
           }
           else {
               return "ERROR Ошибка добавления";
           }
        } catch (SQLException e) {
            e.printStackTrace();
            return "ERROR невозможно добавить такую запись";
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return "ERROR база данных пока не доступна";
        }
    }

    @Override
    public String update(UserData note) {
        String sql;
        sql = "UPDATE users SET " +
                "login='" + note.getLogin() + "'," +
                "password='" + note.getPassword() + "'," +
                "type='" + note.getType().toString() + "'," +
                "email='" +note.getEmail() + "' " +
                "WHERE ID=" + note.getId() + ";";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
           if(connection.createStatement().executeUpdate(sql)==1){
               return "Данные обновлены";
           }
           else {
               return "ERROR данные не могут быть обновлены";
           }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode()+"\n"+e.getSQLState());
            return "ERROR невозможно добавить такую запись";
        } catch (PropertyVetoException e) {
            e.printStackTrace();
            return "ERROR база данных пока не доступна";
        }
    }

    @Override
    public UserData receive(UserData note) {
        ResultSet resultSet;
        String sql;
        if(note.getId()!=0) {
            sql = "SELECT * FROM Users WHERE id = '" + note.getId() + "';";
        }
        else {
            sql= "SELECT * FROM Users WHERE login = '" + note.getLogin() + "';";
        }
        try {
            Connection connection= DataBaseConnection.getInstance().getConnection();
            resultSet =connection.createStatement().executeQuery(sql);
            if( resultSet.next()){
                return getDataFromResultSet(resultSet);
            }
            else note.setType(UserData.Type.NO_TYPE);
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return note;
    }

    @Override
    public String delete(UserData note) {
        String sql;
        sql="DELETE FROM Users WHERE id = '"+note.getId()+"';";
        try {
            Connection connection= DataBaseConnection.getInstance().getConnection();
            if(connection.createStatement().executeUpdate(sql) == 1) {
                return "Данные удалены";
            }
            else {
                return "ERROR Нет данных для удаления";
            }

        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
            return "ERROR Ошибка удаления";
        }
    }

    @Override
    public Map<Integer,UserData> receiveAll() {
        ResultSet resultSet;
        ConcurrentHashMap<Integer,UserData> data=new ConcurrentHashMap<>();
        String sql;
        UserData userData;
        sql = "SELECT * FROM users ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                userData=getDataFromResultSet(resultSet);
                data.put(userData.getId(),userData);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<Integer,UserData> receiveAllInLimit(int left, int right) {
        ResultSet resultSet;
        ConcurrentHashMap<Integer,UserData> data=new ConcurrentHashMap<>();
        String sql;
        UserData userData;
        sql = "SELECT * FROM users Users LIMIT "+left+" , "+right+" ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                userData=getDataFromResultSet(resultSet);
                data.put(userData.getId(),userData);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }
}
