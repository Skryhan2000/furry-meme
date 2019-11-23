package com.loneliness.server.dao;

import com.loneliness.entity.DifferentialIndicators;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLDifferentialIndicatorsDAO implements IDAO<DifferentialIndicators,String, Map<Integer,DifferentialIndicators>>{
    private static final SQLDifferentialIndicatorsDAO instance=new SQLDifferentialIndicatorsDAO();
    private SQLDifferentialIndicatorsDAO(){}

    public static SQLDifferentialIndicatorsDAO getInstance() {
        return instance;
    }

    private DifferentialIndicators getDataFromResultSet(ResultSet resultSet) throws SQLException {
        DifferentialIndicators indicators = new DifferentialIndicators();
        indicators.setId(resultSet.getInt("id_дифференциальных_показателей"));
        indicators.setCompanyName(resultSet.getString("имя_компании"));
        indicators.setReportingPeriod(resultSet.getDate("отчетный_период").toLocalDate());
        indicators.setNetA(resultSet.getBigDecimal("оборачиваемость_чистых_активов"));
        indicators.setProfR(resultSet.getBigDecimal("рентабельность_продаж"));
        indicators.setRONA(resultSet.getBigDecimal("RONA"));
        indicators.setROE(resultSet.getBigDecimal("ROE"));
        indicators.setSG(resultSet.getBigDecimal("SG"));
        indicators.setWACC(resultSet.getBigDecimal("WACC"));
        return indicators;
    }

    @Override
    public String add(DifferentialIndicators note) {
        String sql;
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            sql="INSERT дифференциальные_показатели (имя_компании , отчетный_период , оборачиваемость_чистых_активов, " +
                    "рентабельность_продаж,RONA,ROE,SG,WACC) " +
                    "VALUES ( '"+
                    note.getCompanyName()+"',' "+
                    note.getReportingPeriod()+"', '"+
                    note.getNetA()+"', '"+
                    note.getProfR()+"', '"+
                    note.getRONA()+"', '"+
                    note.getROE()+"', '"+
                    note.getSG()+"', '"+
                    note.getWACC()+"' "+
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
    public String update(DifferentialIndicators note) {
        String sql;
        sql = "UPDATE дифференциальные_показатели SET " +
                "имя_компании='" + note.getCompanyName() + "'," +
                "отчетный_период='" + note.getReportingPeriod() + "'," +
                "оборачиваемость_чистых_активов='" + note.getNetA().toString() + "'," +
                "рентабельность_продаж='" + note.getProfR().toString() + "'," +
                "RONA='" + note.getRONA().toString() + "'," +
                "ROE='" + note.getROE().toString() + "'," +
                "SG='" + note.getSG().toString() + "'," +
                "WACC='" +note.getId() + "' " +
                "WHERE id_дифференциальных_показателей=" + note.getId() + ";";
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
    public DifferentialIndicators receive(DifferentialIndicators note) {
        ResultSet resultSet;
        String sql;
        sql = "SELECT * FROM дифференциальные_показатели WHERE id_дифференциальных_показателей = '" + note.getId() + "';";

        try {
            Connection connection = DataBaseConnection.getInstance().getConnection();
            resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {
                return getDataFromResultSet(resultSet);
            } else return note;
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return note;
    }

    @Override
    public String delete(DifferentialIndicators note) {
        String sql;
        sql="DELETE FROM дифференциальные_показатели WHERE id_дифференциальных_показателей = '"+note.getId()+"';";
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
    public Map<Integer, DifferentialIndicators> receiveAll() {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, DifferentialIndicators> data=new ConcurrentHashMap<>();
        String sql;
        DifferentialIndicators differentialIndicators;
        sql = "SELECT * FROM дифференциальные_показатели ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                differentialIndicators=getDataFromResultSet(resultSet);
                data.put(differentialIndicators.getId(),differentialIndicators);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<Integer, DifferentialIndicators> receiveAllInLimit(int left, int right) {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, DifferentialIndicators> data=new ConcurrentHashMap<>();
        String sql;
        DifferentialIndicators differentialIndicators;
        sql = "SELECT * FROM дифференциальные_показатели LIMIT "+left+" , "+right+" ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                differentialIndicators=getDataFromResultSet(resultSet);
                data.put(differentialIndicators.getId(),differentialIndicators);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }
}
