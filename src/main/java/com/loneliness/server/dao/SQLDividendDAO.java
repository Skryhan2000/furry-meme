package com.loneliness.server.dao;

import com.loneliness.entity.Credit;
import com.loneliness.entity.Dividend;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLDividendDAO implements IDAO<Dividend,String, Map<Integer,Dividend>> {
    private static final SQLDividendDAO instance=new SQLDividendDAO();
    private SQLDividendDAO(){}
    public static SQLDividendDAO getInstance() {
        return instance;
    }

    private Dividend getDataFromResultSet(ResultSet resultSet) throws SQLException {
        Dividend dividend  = new Dividend ();
        dividend.setDividendId(resultSet.getInt("id_дивидент"));
        dividend.setCompanyId(resultSet.getInt("id_компании"));
        dividend.setReportingPeriodId(resultSet.getInt("id_отчётного_периода"));
        dividend.setDividendPercentage(resultSet.getBigDecimal("процент_дивидента"));
        dividend.setRecipient(resultSet.getString("получатель"));
        return dividend;
    }

    @Override
    public String add(Dividend note) {
        String sql;
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            sql="INSERT дивиденты (id_компании , id_отчётного_периода , процент_дивидента, получатель) " +
                    "VALUES ( '"+
                    note.getCompanyId()+"',' "+
                    note.getReportingPeriodId()+"', '"+
                    note.getDividendPercentage()+"', '"+
                    note.getRecipient()+
                    "');";
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
    public String update(Dividend note) {
        String sql;
        sql = "UPDATE дивиденты SET " +
                "id_компании='" + note.getCompanyId() + "'," +
                "id_отчётного_периода='" + note.getReportingPeriodId()+ "'," +
                "процент_дивидента='" + note.getDividendPercentage() + "'," +
                "получатель='" +note.getRecipient() + "' " +
                "WHERE id_кредита=" + note.getDividendId() + ";";
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
    public Dividend receive(Dividend note) {
        ResultSet resultSet;
        String sql;
        sql= "SELECT * FROM дивиденты WHERE id_дивидент = " + note.getDividendId() + ";";
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
    public String delete(Dividend note) {
        String sql;
        sql="DELETE FROM дивиденты WHERE id_дивидент = " + note.getDividendId() + ";";
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
    public Map<Integer, Dividend> receiveAll() {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, Dividend> data=new ConcurrentHashMap<>();
        String sql;
        Dividend dividend;
        sql = "SELECT * FROM дивиденты ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                dividend=getDataFromResultSet(resultSet);
                data.put(dividend.getDividendId(),dividend);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<Integer, Dividend> receiveAllInLimit(int left, int right) {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, Dividend> data=new ConcurrentHashMap<>();
        String sql;
        Dividend dividend;
        sql = "SELECT * FROM дивиденты LIMIT "+left+" , "+right+" ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                dividend=getDataFromResultSet(resultSet);
                data.put(dividend.getDividendId(),dividend);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }
}
