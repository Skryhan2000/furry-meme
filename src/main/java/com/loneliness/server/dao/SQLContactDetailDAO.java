package com.loneliness.server.dao;

import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.UserData;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLContactDetailDAO implements IDAO<ContactDetail,String, Map<Integer,ContactDetail>>{
    private static final SQLContactDetailDAO instance=new SQLContactDetailDAO();
    private SQLContactDetailDAO(){}
    public static SQLContactDetailDAO getInstance() {
        return instance;
    }

    private ContactDetail getDataFromResultSet(ResultSet resultSet) throws SQLException {
        ContactDetail contactDetail= new ContactDetail();
        contactDetail.setContactDetailId(resultSet.getInt("id_контактных_данные"));
        contactDetail.setEmail(resultSet.getString("email"));
        contactDetail.setPhoneNumber(resultSet.getString("номер_телефона"));
        contactDetail.setInfo(resultSet.getString("инфо"));
        contactDetail.setCompanyId(resultSet.getInt("id_компании"));
        return contactDetail;
    }
    @Override
    public String add(ContactDetail note) {
        String sql;
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            sql="INSERT контактные_данные (email , номер_телефона , инфо, id_компании) " +
                    "VALUES ( '"+
                    note.getEmail()+"',' "+
                    note.getPhoneNumber()+"', '"+
                    note.getInfo()+"', '"+
                    note.getCompanyId()+"' "+
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
    public String update(ContactDetail note) {
        String sql;
        sql = "UPDATE контактные_данные SET " +
                "email='" + note.getEmail() + "'," +
                "номер_телефона='" + note.getPhoneNumber() + "'," +
                "инфо='" + note.getInfo() + "'," +
                "id_компании='" +note.getCompanyId() + "' " +
                "WHERE id_контактных_данные=" + note.getContactDetailId() + ";";
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
    public ContactDetail receive(ContactDetail note) {
        ResultSet resultSet;
        String sql;
        sql= "SELECT * FROM контактные_данные WHERE id_контактных_данные = '" + note.getContactDetailId() + "';";

        try {
            Connection connection= DataBaseConnection.getInstance().getConnection();
            resultSet =connection.createStatement().executeQuery(sql);
            if( resultSet.next()){
                return getDataFromResultSet(resultSet);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return note;
    }

    @Override
    public String delete(ContactDetail note) {
        String sql;
        sql="DELETE FROM контактные_данные WHERE id_контактных_данные = '"+note.getContactDetailId()+"';";
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
    public Map<Integer, ContactDetail> receiveAll() {
        ResultSet resultSet;
        ConcurrentHashMap<Integer,ContactDetail> data=new ConcurrentHashMap<>();
        String sql;
        ContactDetail contactDetail;
        sql = "SELECT * FROM контактные_данные ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                 contactDetail=getDataFromResultSet(resultSet);
                data.put(contactDetail.getContactDetailId(),contactDetail);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<Integer, ContactDetail> receiveAllInLimit(int left, int right) {
        ResultSet resultSet;
        ConcurrentHashMap<Integer,ContactDetail> data=new ConcurrentHashMap<>();
        String sql;
        ContactDetail contactDetail;
        sql = "SELECT * FROM контактные_данные  LIMIT "+left+" , "+right+" ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                contactDetail=getDataFromResultSet(resultSet);
                data.put(contactDetail.getContactDetailId(),contactDetail);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }
}
