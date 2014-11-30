/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Enum.DBTableEnum;
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
        int result = constant.Constant.INTEGER_ZERO;
        Connection connection;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.CASH.getTableName() + " where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constant.Constant.INTEGER_NINETEEN_HUNDRED) + constant.Constant.HYPHEN + (this.getTdate().getMonth() + constant.Constant.INTEGER_ONE) + constant.Constant.HYPHEN + this.getTdate().getDate();
            statement.setString(constant.Constant.INTEGER_ONE, date);
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constant.Constant.INTEGER_ONE);
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
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "update " + DBTableEnum.CASH.getTableName() + " set milk=?,ammount=? where tdate=to_date(?,'yyyy-mm-dd')";
            System.out.println(query);
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constant.Constant.INTEGER_NINETEEN_HUNDRED) + constant.Constant.HYPHEN + (this.getTdate().getMonth() + constant.Constant.INTEGER_ONE) + constant.Constant.HYPHEN + this.getTdate().getDate();
            statement.setFloat(constant.Constant.INTEGER_ONE, this.getMilk());
            statement.setFloat(constant.Constant.INTEGER_TWO, this.getAmmount());
            statement.setString(constant.Constant.INTEGER_THREE, date);
            statement.executeQuery();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constant.Constant.INTEGER_ONE);
        }
    }

    public void save() {

        Connection connection;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "insert into " + DBTableEnum.CASH.getTableName() + " (tdate,milk,ammount) values(to_date(?,'yyyy-mm-dd'),?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constant.Constant.INTEGER_NINETEEN_HUNDRED) + constant.Constant.HYPHEN + (this.getTdate().getMonth() + constant.Constant.INTEGER_ONE) + constant.Constant.HYPHEN + this.getTdate().getDate();
            statement.setString(constant.Constant.INTEGER_ONE, date);
            statement.setFloat(constant.Constant.INTEGER_TWO, this.getMilk());
            statement.setFloat(constant.Constant.INTEGER_THREE, this.getAmmount());
            statement.executeQuery();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constant.Constant.INTEGER_ONE);
        }
    }

    public void get() {

        Connection connection;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.CASH.getTableName() + " where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + constant.Constant.INTEGER_NINETEEN_HUNDRED) + constant.Constant.HYPHEN + (this.getTdate().getMonth() + constant.Constant.INTEGER_ONE) + constant.Constant.HYPHEN + this.getTdate().getDate();
            statement.setString(constant.Constant.INTEGER_ONE, date);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.setTdate(resultSet.getDate("tdate"));
                this.setMilk(resultSet.getFloat("milk"));
                this.setAmmount(resultSet.getFloat("ammount"));
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            System.exit(constant.Constant.INTEGER_ONE);
        }
    }

}
