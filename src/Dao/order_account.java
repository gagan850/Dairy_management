/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bansal
 */
public class order_account {

    private String aname;
    private String aphone;
    private String aaddress;
    private String acity;

    private int advance;
    private Date adate;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public String getAaddress() {
        return aaddress;
    }

    public void setAaddress(String aaddress) {
        this.aaddress = aaddress;
    }

    public String getAcity() {
        return acity;
    }

    public void setAcity(String acity) {
        this.acity = acity;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public boolean search() {

        int result = constants.Constant.INTEGER_ZERO;
        try {
            Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select * from " + DataBase.DBTableEnum.ORDER_ACCOUNT.getTableName() + " where aname=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(constants.Constant.INTEGER_ONE, this.aname);
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return (result == constants.Constant.INTEGER_ONE) ? true : false;

    }

    public ArrayList<order_account> returnAccounts() {

        ArrayList<order_account> order_list = new ArrayList<order_account>();
        try {
            Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select * from " + DataBase.DBTableEnum.ORDER_ACCOUNT.getTableName() + " order by adate";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order_account g = new order_account();
                g.aname = resultSet.getString("aname");
                g.aphone = resultSet.getString("aphone");
                g.aaddress = resultSet.getString("aaddress");
                g.acity = resultSet.getString("acity");
                g.advance = resultSet.getInt("advance");
                g.adate = resultSet.getDate("adate");
                order_list.add(g);
            }

        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return order_list;

    }

    public boolean add() {
        int result = constants.Constant.INTEGER_ZERO;
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "insert into " + DataBase.DBTableEnum.ORDER_ACCOUNT.getTableName() + " values(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(constants.Constant.INTEGER_ONE, this.getAname());
            statement.setString(constants.Constant.INTEGER_TWO, this.getAphone());
            statement.setString(constants.Constant.INTEGER_THREE, this.getAaddress());
            statement.setString(constants.Constant.INTEGER_FOUR, this.getAcity());
            statement.setDate(constants.Constant.INTEGER_FIVE, this.getAdate());
            statement.setInt(constants.Constant.INTEGER_SIX, this.getAdvance());
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return (result == constants.Constant.INTEGER_ONE) ? true : false;
    }

    public order_account get() {
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select * from " + DataBase.DBTableEnum.ORDER_ACCOUNT.getTableName() + " where aname=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(constants.Constant.INTEGER_ONE, this.getAname());

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.aname = resultSet.getString("aname");

                this.aphone = resultSet.getString("aphone");
                this.aaddress = resultSet.getString("aaddress");
                this.acity = resultSet.getString("acity");
                this.advance = resultSet.getInt("advance");
                this.adate = resultSet.getDate("adate");

            }
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return this;
    }

    public boolean delete()
             {
        int result = constants.Constant.INTEGER_ZERO;
        try {
            Connection connection = null;

            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "delete from " + DataBase.DBTableEnum.ORDER_ACCOUNT.getTableName() + " where aname=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(constants.Constant.INTEGER_ONE, this.getAname());

            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return (result == constants.Constant.INTEGER_ONE) ? true : false;
    }

    public boolean update()
            throws SQLException {

        int result = constants.Constant.INTEGER_ZERO;
        try {
            Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "update  " + DataBase.DBTableEnum.ORDER_ACCOUNT.getTableName() + " set aphone=?,aaddress=?,acity=?,advance=?,adate=? where aname=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(constants.Constant.INTEGER_ONE, this.getAphone());
            statement.setString(constants.Constant.INTEGER_TWO, this.getAaddress());
            statement.setString(constants.Constant.INTEGER_THREE, this.getAcity());
            statement.setInt(constants.Constant.INTEGER_FOUR, this.getAdvance());

            statement.setDate(constants.Constant.INTEGER_FIVE, this.getAdate());
            statement.setString(constants.Constant.INTEGER_SIX, this.getAname());
            result = statement.executeUpdate();
            connection.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return (result == constants.Constant.INTEGER_ONE) ? true : false;
    }

}
