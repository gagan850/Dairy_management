/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        Connection connection;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from "+DataBase.DBTableEnum.SPEND+" where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + 1900) + "-" + (this.getTdate().getMonth() + 1) + "-" + this.getTdate().getDate();
            statement.setString(1, date);
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
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
            String query = "update "+DataBase.DBTableEnum.SPEND+" set ammount=? where tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + 1900) + "-" + (this.getTdate().getMonth() + 1) + "-" + this.getTdate().getDate();
            statement.setInt(1, this.getAmmount());

            statement.setString(2, date);
            statement.executeQuery();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void save() {

        Connection connection;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "insert into "+DataBase.DBTableEnum.SPEND+"(tdate,ammount) values(to_date(?,'yyyy-mm-dd'),?)";
            PreparedStatement statement = connection.prepareStatement(query);
            String date = (this.getTdate().getYear() + 1900) + "-" + (this.getTdate().getMonth() + 1) + "-" + this.getTdate().getDate();
            statement.setString(1, date);

            statement.setInt(2, this.getAmmount());
            statement.executeQuery();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void get() {

        Connection connection;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from "+DataBase.DBTableEnum.SPEND+" where tdate=to_date(?,'yyyy-mm-dd')";
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
            exception.printStackTrace();
        }
    }

}
