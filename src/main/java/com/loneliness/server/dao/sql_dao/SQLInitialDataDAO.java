package com.loneliness.server.dao.sql_dao;

import com.loneliness.entity.InitialData;
import com.loneliness.entity.Quarter;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.dao.DataBaseConnection;
import com.loneliness.server.dao.IDAO;

import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLInitialDataDAO implements IDAO<InitialData,String, Map<Integer,InitialData>> {
    private static final SQLInitialDataDAO instance=new SQLInitialDataDAO();
    private SQLInitialDataDAO(){}

    public static SQLInitialDataDAO getInstance() {
        return instance;
    }

    private InitialData getDataFromResultSet(ResultSet resultSet) throws SQLException {
        InitialData initialData  = new InitialData();
        initialData.setInitialDataId(resultSet.getInt("id_исходные_данные"));
        initialData.setCompanyId(resultSet.getInt("id_компании"));
        initialData.setReportingDateId(resultSet.getInt("id_отчётного_периода"));
        initialData.setSales(resultSet.getBigDecimal("выручка_от_реализации"));
        initialData.setAssets(resultSet.getBigDecimal("активы"));
        initialData.setEquity(resultSet.getBigDecimal("собственный_капитал"));
        initialData.setPBIT(resultSet.getBigDecimal("чистая_прибыль"));
        initialData.setCredit(resultSet.getBigDecimal("привлеченный_капитал"));
        return initialData;
    }


    @Override
    public String add(InitialData note) {
        String sql;
        try {
            Connection connection= DataBaseConnection.getInstance().getConnection();
            sql="INSERT исходные_данные (id_компании , id_отчётного_периода , выручка_от_реализации, активы," +
                    "собственный_капитал,чистая_прибыль,привлеченный_капитал) " +
                    "VALUES ( '"+
                    note.getCompanyId()+"',' "+
                    note.getReportingDateId()+"', '"+
                    note.getSales()+"', '"+
                    note.getAssets()+"', '"+
                    note.getEquity()+"', '"+
                    note.getPBIT()+"', '"+
                    note.getCredit()+
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
    public String update(InitialData note) {
        String sql;
        sql = "UPDATE исходные_данные SET " +
                "id_компании='" + note.getCompanyId() + "'," +
                "id_отчётного_периода='" + note.getReportingDateId()+ "'," +
                "выручка_от_реализации='" + note.getSales() + "'," +
                "активы='" + note.getAssets() + "'," +
                "собственный_капитал='" + note.getEquity() + "'," +
                "чистая_прибыль='" + note.getPBIT() + "'," +
                "привлеченный_капитал='" +note.getCredit() + "' " +
                "WHERE id_исходные_данные=" + note.getInitialDataId() + ";";
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
    public InitialData receive(InitialData note) {
        ResultSet resultSet;
        String sql;
        sql= "SELECT * FROM исходные_данные WHERE id_исходные_данные = " + note.getInitialDataId() + ";";
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
    public String delete(InitialData note) {
        String sql;
        sql="DELETE FROM исходные_данные WHERE id_исходные_данные = " + note.getInitialDataId() + ";";
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
    public Map<Integer, InitialData> receiveAll() {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, InitialData> data=new ConcurrentHashMap<>();
        String sql;
        InitialData initialData;
        sql = "SELECT * FROM исходные_данные ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                initialData=getDataFromResultSet(resultSet);
                data.put(initialData.getInitialDataId(),initialData);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<Integer, InitialData> receiveAllInLimit(int left, int right) {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, InitialData> data=new ConcurrentHashMap<>();
        String sql;
        InitialData initialData;
        sql = "SELECT * FROM исходные_данные LIMIT "+left+" , "+right+" ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                initialData=getDataFromResultSet(resultSet);
                data.put(initialData.getInitialDataId(),initialData);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }
}
