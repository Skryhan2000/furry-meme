package com.loneliness.server.dao.sql_dao;

import com.loneliness.entity.Company;
import com.loneliness.server.dao.DataBaseConnection;
import com.loneliness.server.dao.IDAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SQLCompanyDAO implements IDAO<Company,String, Map<Integer,Company>> {
    private static final SQLCompanyDAO instance=new SQLCompanyDAO();
    private SQLCompanyDAO(){}

    public static SQLCompanyDAO getInstance() {
        return instance;
    }

    private Company getDataFromResultSet(ResultSet resultSet) throws SQLException {
        Company company = new Company();
        company.setCompanyId(resultSet.getInt("id_компании"));
        company.setCompanyName(resultSet.getString("имя_компании"));
        return company;
    }

    @Override
    public String add(Company note) {
        String sql;
        try ( Connection connection= DataBaseConnection.getInstance().getConnection()){
            sql="INSERT компании (имя_компании) " +
                    "VALUES ( '"+
                    note.getCompanyName()+
                    "');";
            if(connection.prepareStatement(sql).executeUpdate()>=1){
                return "Данные успешно добавлены";
            }
            else {
                return "ERROR Ошибка добавления";
            }
        } catch (SQLException e) {
            logger.catching(e);
            return "ERROR невозможно добавить такую запись";
        } catch (PropertyVetoException e) {
            logger.catching(e);
            return "ERROR база данных пока не доступна";
        }
    }

    @Override
    public String update(Company note) {
        String sql;
        sql = "UPDATE компании SET " +
                "имя_компании='" + note.getCompanyName() + "' " +
                "WHERE id_компании=" + note.getCompanyId() + ";";
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            if(connection.createStatement().executeUpdate(sql)==1){
                return "Данные обновлены";
            }
            else {
                return "ERROR данные не могут быть обновлены";
            }
        } catch (SQLException e) {
            logger.catching(e);
            return "ERROR невозможно добавить такую запись";
        } catch (PropertyVetoException e) {
            logger.catching(e);
            return "ERROR база данных пока не доступна";
        }
    }


    @Override
    public Company receive(Company note) {
        ResultSet resultSet;
        String sql;
        sql = "SELECT * FROM компании WHERE id_компании = '" + note.getCompanyId() + "';";

        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {
                return getDataFromResultSet(resultSet);
            }
        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
        }
        return note;
    }

    @Override
    public String delete(Company note) {
        String sql;
        sql="DELETE FROM компании WHERE id_компании = '"+note.getCompanyId()+"';";
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            if(connection.createStatement().executeUpdate(sql) == 1) {
                return "Данные удалены";
            }
            else {
                return "ERROR Нет данных для удаления";
            }

        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
            return "ERROR Ошибка удаления";
        }
    }

    @Override
    public Map<Integer, Company> receiveAll() {
        ResultSet resultSet;
        ConcurrentHashMap<Integer,Company> data=new ConcurrentHashMap<>();
        String sql;
        Company company;
        sql = "SELECT * FROM компании ;";
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                company=getDataFromResultSet(resultSet);
                data.put(company.getCompanyId(),company);
            }
        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
        }
        return data;
    }

    @Override
    public Map<Integer, Company> receiveAllInLimit(int left, int right) {
        ResultSet resultSet;
        ConcurrentHashMap<Integer,Company> data=new ConcurrentHashMap<>();
        String sql;
        Company company;
        sql = "SELECT * FROM компании LIMIT "+left+" , "+right+" ;";
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                company=getDataFromResultSet(resultSet);
                data.put(company.getCompanyId(),company);
            }
        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
        }
        return data;

    }
}
