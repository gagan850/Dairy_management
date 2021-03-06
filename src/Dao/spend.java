/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Enum.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author gagandeepbansal
 */
public class spend {

    Date tdate;
    int ammount;

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public boolean exist() {
        int result = 0;
        try {
       Connection connection;
       Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from "+ DBTableEnum.SPEND+" where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + 1900) + "-" + (this.getTdate().getMonth() + 1) + "-" + this.getTdate().getDate();
            statement.setString(1, date);
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
               JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
         }
        return (result==1)?true:false;
}

    public boolean update() {
       int result=0;
        try {
             Connection connection;
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "update "+ DBTableEnum.SPEND+" set ammount=? where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + 1900) + "-" + (this.getTdate().getMonth() + 1) + "-" + this.getTdate().getDate();
            statement.setInt(1, this.getAmmount());

            statement.setString(2, date);
            result=statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
               JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return (result==1)?true:false;
    }

    public boolean save() {
        int result=0;
        try {
        Connection connection;
        Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "insert into "+ DBTableEnum.SPEND+"(tdate,ammount) values(to_date(?,'yyyy-mm-dd'),?)";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + 1900) + "-" + (this.getTdate().getMonth() + 1) + "-" + this.getTdate().getDate();
            statement.setString(1, date);

            statement.setInt(2, this.getAmmount());
            result=statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
               JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return (result==1)?true:false;
    }

   
    
    public void get() {
        try {
        Connection connection;
         Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from "+ DBTableEnum.SPEND+" where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + 1900) + "-" + (this.getTdate().getMonth() + 1) + "-" + this.getTdate().getDate();
            statement.setString(1, date);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                this.setTdate(rs.getDate("tdate"));

                this.setAmmount(rs.getInt("ammount"));
            }
            connection.close();
        } catch (Exception exception) {
               JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

}
