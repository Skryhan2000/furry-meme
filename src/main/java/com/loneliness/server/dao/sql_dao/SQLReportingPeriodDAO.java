package com.loneliness.server.dao.sql_dao;

import com.loneliness.entity.Dividend;
import com.loneliness.entity.Quarter;
import com.loneliness.entity.ReportingPeriod;
import com.loneliness.server.dao.DataBaseConnection;
import com.loneliness.server.dao.IDAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLReportingPeriodDAO implements IDAO<ReportingPeriod,String, Map<Integer,ReportingPeriod>> {

    private static final SQLReportingPeriodDAO instance=new SQLReportingPeriodDAO();
    private SQLReportingPeriodDAO(){}
    public static SQLReportingPeriodDAO getInstance() {
        return instance;
    }

    private ReportingPeriod getDataFromResultSet(ResultSet resultSet) throws SQLException {
        ReportingPeriod reportingPeriod  = new ReportingPeriod ();
        reportingPeriod.setReportingPeriodId(resultSet.getInt("id_отчетного_периода"));
        reportingPeriod.setCompanyId(resultSet.getInt("id_компании"));
        reportingPeriod.setYear(resultSet.getInt("год"));
        reportingPeriod.setQuarter(Quarter.valueOf(resultSet.getString("квартал")));
        return reportingPeriod;
    }

    @Override
    public String add(ReportingPeriod note) {
        String sql;
        try {
            Connection connection= DataBaseConnection.getInstance().getConnection();
            sql="INSERT отчётные_периоды (id_компании , год , квартал) " +
                    "VALUES ( '"+
                    note.getCompanyId()+"',' "+
                    note.getYear()+"', '"+
                    note.getQuarter()+
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
    public String update(ReportingPeriod note) {
        String sql;
        sql = "UPDATE отчётные_периоды SET " +
                "id_компании='" + note.getCompanyId() + "'," +
                "год='" + note.getYear()+ "'," +
                "квартал='" + note.getQuarter().toString()+  "' " +
                "WHERE id_отчетного_периода=" + note.getReportingPeriodId() + ";";
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
    public ReportingPeriod receive(ReportingPeriod note) {
        ResultSet resultSet;
        String sql;
        sql= "SELECT * FROM отчётные_периоды WHERE id_отчетного_периода = " + note.getReportingPeriodId() + ";";
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
    public String delete(ReportingPeriod note) {
        String sql;
        sql="DELETE FROM отчётные_периоды WHERE id_отчетного_периода = " + note.getReportingPeriodId() + ";";
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
    public Map<Integer, ReportingPeriod> receiveAll() {
        String sql = "SELECT * FROM отчётные_периоды ;";
        return receiveData(sql);
    }

    @Override
    public Map<Integer, ReportingPeriod> receiveAllInLimit(int left, int right) {
        String sql="SELECT * FROM отчётные_периоды LIMIT "+left+" , "+right+" ;";
        return receiveData(sql);
    }

    private Map<Integer, ReportingPeriod> receiveData(String sql){
        ResultSet resultSet;
        ConcurrentHashMap<Integer, ReportingPeriod> data=new ConcurrentHashMap<>();
        ReportingPeriod reportingPeriod;
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                reportingPeriod=getDataFromResultSet(resultSet);
                data.put(reportingPeriod.getReportingPeriodId(),reportingPeriod);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }
}
