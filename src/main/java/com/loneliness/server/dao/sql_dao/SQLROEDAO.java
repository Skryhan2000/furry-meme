package com.loneliness.server.dao.sql_dao;

import com.loneliness.entity.Quarter;
import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.dao.DataBaseConnection;
import com.loneliness.server.dao.IDAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLROEDAO implements IDAO<ROE,String, Map<Integer,ROE>> {
    private String sql;
    private static final SQLROEDAO instance=new SQLROEDAO();
    private SQLROEDAO(){}
    public static SQLROEDAO getInstance() {
        return instance;
    }

    @Override
    public String add(ROE note) {
        try ( Connection connection= DataBaseConnection.getInstance().getConnection()){

            sql="INSERT roe (id_компании , id_исходных_данных , id_кредита,id_дивиденда," +
                    "ROE,EBIT,рентабельность_продаж,RONA,FL) " +
                    "VALUES ( '"+
                    note.getCompanyId()+"',' "+
                    note.getInitialDataId()+"', '"+
                    note.getCreditId()+"', '"+
                    note.getDividendID()+"', '"+
                    note.getROE()+"', '"+
                    note.getEBIT()+"', '"+
                    note.getProfR()+"', '"+
                    note.getRONA()+"', '"+
                    note.getFL()+
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
    public String update(ROE note) {

        sql = "UPDATE roe SET " +
                "id_компании='" + note.getCompanyId() + "'," +
                "id_исходных_данных='" + note.getInitialDataId()+ "'," +
                "id_кредита='" + note.getCreditId()+ "'," +
                "id_дивиденда='" + note.getDividendID()+ "'," +
                "ROE='" + note.getROE()+ "'," +
                "EBIT='" + note.getEBIT()+ "'," +
                "рентабельность_продаж='" + note.getProfR()+ "'," +
                "RONA='" + note.getRONA()+ "'," +
                "FL='" + note.getFL().toString()+  "' " +
                "WHERE id_ROE=" + note.getROEId() + ";";
        try ( Connection connection=DataBaseConnection.getInstance().getConnection()){

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
            logger.catching(e);
            return "ERROR база данных пока не доступна";
        }
    }

    @Override
    public ROE receive(ROE note) {
        sql= "SELECT * FROM roe WHERE id_ROE = " + note.getROEId() + ";";
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if( resultSet.next()){
                return getDataFromResultSet(resultSet);
            }
        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
        }
        return note;
    }
    public ROE receive(int note) {
        sql= "SELECT * FROM roe WHERE id_ROE = " + note + ";";
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if( resultSet.next()){
                return getDataFromResultSet(resultSet);
            }
        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
        }
        return new ROE();
    }

    @Override
    public String delete(ROE note) {
        sql="DELETE FROM roe WHERE id_ROE = " + note.getROEId() + ";";
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
    public Map<Integer, ROE> receiveAll() {
        sql = "SELECT * FROM roe ;";
        return receiveData(sql);
    }

    @Override
    public Map<Integer, ROE> receiveAllInLimit(int left, int right) {
        sql="SELECT * FROM roe LIMIT "+left+" , "+right+" ;";
        return receiveData(sql);
    }

    public ROE findRoeByReportingPeriodID(int id){
        sql = "SELECT * FROM `furry-meme`.roe \n" +
                "inner join `furry-meme`.исходные_данные\n" +
                "on `furry-meme`.исходные_данные.id_исходные_данные=`furry-meme`.roe.id_исходных_данных\n" +
                "where id_отчетного_периода="+id+";";
        Map<Integer, ROE> data=receiveData(sql);
        if(data.values().iterator().hasNext())
            return receiveData(sql).values().iterator().next();
        else return new ROE();
    }

    public Map<Quarter, ROE> findRoeByReportingPeriodYear(ReportingPeriod reportingPeriod){
        sql = "SELECT * FROM roe \n"+
                "inner join исходные_данные \n"+
                "on исходные_данные.id_исходные_данные=roe.id_исходных_данных\n"+
                "inner join отчётные_периоды\n"+
                "on исходные_данные.id_отчетного_периода=отчётные_периоды.id_отчетного_периода\n"+
                "where год="+reportingPeriod.getYear()+" and company_id="+reportingPeriod.getCompanyId()+";";
        ResultSet resultSet;
        ConcurrentHashMap<Quarter, ROE> data=new ConcurrentHashMap<>();
        ROE roe;
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                roe=getDataFromResultSet(resultSet);
                data.put(Quarter.valueOf(resultSet.getString("квартал")),roe);
            }
        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
        }
        return data;
    }

    private ROE getDataFromResultSet(ResultSet resultSet) throws SQLException {
        ROE roe  = new ROE ();
        roe.setROEId(resultSet.getInt("id_ROE"));
        roe.setCompanyId(resultSet.getInt("id_компании"));
        roe.setInitialDataId(resultSet.getInt("id_исходных_данных"));
        roe.setCreditId(resultSet.getInt("id_кредита"));
        roe.setDividendID(resultSet.getInt("id_дивиденда"));
        roe.setROE(resultSet.getBigDecimal("ROE"));
        roe.setEBIT(resultSet.getBigDecimal("EBIT"));
        roe.setProfR(resultSet.getBigDecimal("рентабельность_продаж"));
        roe.setRONA(resultSet.getBigDecimal("RONA"));
        roe.setFL(resultSet.getBigDecimal("FL"));
        return roe;
    }
    private Map<Integer, ROE> receiveData(String sql){
        ResultSet resultSet;
        ConcurrentHashMap<Integer, ROE> data=new ConcurrentHashMap<>();
        ROE roe;
        try (Connection connection= DataBaseConnection.getInstance().getConnection()){

            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                roe=getDataFromResultSet(resultSet);
                data.put(roe.getROEId(),roe);
            }
        } catch (SQLException | PropertyVetoException e) {
            logger.catching(e);
        }
        return data;
    }

}
