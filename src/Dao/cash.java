/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DataBase.DBTableEnum;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author gagandeepbansal
 */
public class cash {

    Date tdate;
    float milk;
    float ammount;

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public float getMilk() {
        return milk;
    }

    public void setMilk(float milk) {
        this.milk = milk;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public boolean exist() {
        int result = constants.Constant.INTEGER_ZERO;
        Connection connection;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.CASH.getTableName() + " where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + (this.getTdate().getMonth() + constants.Constant.INTEGER_ONE) + constants.Constant.HYPHEN + this.getTdate().getDate();
            statement.setString(constants.Constant.INTEGER_ONE, date);
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constants.Constant.INTEGER_ONE);
        }
        if (result > 0) {
            return true;
        } else {
            return false;
        }

    }

    public void update() {

        Connection connection;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "update " + DBTableEnum.CASH.getTableName() + " set milk=?,ammount=? where tdate=to_date(?,'yyyy-mm-dd')";
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + (this.getTdate().getMonth() + constants.Constant.INTEGER_ONE) + constants.Constant.HYPHEN + this.getTdate().getDate();
            statement.setFloat(constants.Constant.INTEGER_ONE, this.getMilk());
            statement.setFloat(constants.Constant.INTEGER_TWO, this.getAmmount());
            statement.setString(constants.Constant.INTEGER_THREE, date);
            statement.executeQuery();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constants.Constant.INTEGER_ONE);
        }
    }

    public void save() {

        Connection connection;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "insert into " + DBTableEnum.CASH.getTableName() + " (tdate,milk,ammount) values(to_date(?,'yyyy-mm-dd'),?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + (this.getTdate().getMonth() + constants.Constant.INTEGER_ONE) + constants.Constant.HYPHEN + this.getTdate().getDate();
            statement.setString(constants.Constant.INTEGER_ONE, date);
            statement.setFloat(constants.Constant.INTEGER_TWO, this.getMilk());
            statement.setFloat(constants.Constant.INTEGER_THREE, this.getAmmount());
            statement.executeQuery();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constants.Constant.INTEGER_ONE);
        }
    }

    public void get() {

        Connection connection;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.CASH.getTableName() + " where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + (this.getTdate().getMonth() + constants.Constant.INTEGER_ONE) + constants.Constant.HYPHEN + this.getTdate().getDate();
            statement.setString(constants.Constant.INTEGER_ONE, date);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.setTdate(resultSet.getDate("tdate"));
                this.setMilk(resultSet.getFloat("milk"));
                this.setAmmount(resultSet.getFloat("ammount"));
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constants.Constant.INTEGER_ONE);
        }
    }

}
