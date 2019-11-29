package com.loneliness.server.dao.sql_dao;

import com.loneliness.entity.Credit;
import com.loneliness.server.dao.DataBaseConnection;
import com.loneliness.server.dao.IDAO;

import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SQLCreditDAO implements IDAO<Credit,String, Map<Integer,Credit>> {
    private static final SQLCreditDAO instance=new SQLCreditDAO();
    private SQLCreditDAO(){}
    public static SQLCreditDAO getInstance() {
        return instance;
    }

    private Credit getDataFromResultSet(ResultSet resultSet) throws SQLException {
        Credit credit  = new Credit ();
        credit.setCreditId(resultSet.getInt("id_кредита"));
        credit.setCompanyId(resultSet.getInt("id_компании"));
        credit.setLoanPercentage(resultSet.getBigDecimal("процент_кредита"));
        credit.setLoanTotal(resultSet.getBigDecimal("сумма_по_кредиту"));
        credit.setDateOfCollection(resultSet.getDate("дата_взятия").toLocalDate());
        credit.setPayDate(resultSet.getDate("дата_выплаты").toLocalDate());
        credit.setR(resultSet.getBigDecimal("кредитная_ставка"));
        return credit;
    }
    @Override
    public String add(Credit note) {
        String sql;
        try {
            Connection connection= DataBaseConnection.getInstance().getConnection();
            sql="INSERT кредиты (id_компании , процент_кредита , сумма_по_кредиту, дата_взятия,кредитная_ставка,дата_выплаты,) " +
                    "VALUES ( '"+
                    note.getCompanyId()+"',' "+
                    note.getLoanPercentage()+"', '"+
                    note.getLoanTotal()+"', '"+
                    note.getDateOfCollection().toString()+"', '"+
                    note.getR()+"', '"+
                    note.getPayDate().toString()+"' "+
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
    public String update(Credit note) {
        String sql;
        sql = "UPDATE кредиты SET " +
                "id_компании='" + note.getCompanyId() + "'," +
                "процент_кредита='" + note.getLoanPercentage()+ "'," +
                "сумма_по_кредиту='" + note.getLoanTotal() + "'," +
                "дата_взятия='" +note.getDateOfCollection() +"'," +
                "кредитная_ставка='" + note.getR()+"', '"+
                "дата_выплаты='" +note.getPayDate() + "' " +
                "WHERE id_кредита=" + note.getCreditId() + ";";
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
    public Credit receive(Credit note) {
        ResultSet resultSet;
        String sql;
        sql= "SELECT * FROM кредиты WHERE id_кредита = " + note.getCreditId() + ";";
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
    public String delete(Credit note) {
        String sql;
        sql="DELETE FROM кредиты WHERE id_кредита = " + note.getCreditId() + ";";
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
    public Map<Integer, Credit> receiveAll() {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, Credit> data=new ConcurrentHashMap<>();
        String sql;
        Credit credit;
        sql = "SELECT * FROM кредиты ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
               credit=getDataFromResultSet(resultSet);
                data.put(credit.getCreditId(),credit);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<Integer, Credit> receiveAllInLimit(int left, int right) {
        ResultSet resultSet;
        ConcurrentHashMap<Integer, Credit> data=new ConcurrentHashMap<>();
        String sql;
        Credit credit;
        sql = "SELECT * FROM кредиты LIMIT "+left+" , "+right+" ;";
        try {
            Connection connection=DataBaseConnection.getInstance().getConnection();
            resultSet=connection.createStatement().executeQuery(sql);
            while (resultSet.next()){
                credit=getDataFromResultSet(resultSet);
                data.put(credit.getCreditId(),credit);
            }
        } catch (SQLException | PropertyVetoException e) {
            e.printStackTrace();
        }
        return data;
    }

}
