/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author bansal
 */
public class groups {

    private String gname;
    private String gphone;
    private String gaddress;
    private String gcity;
    private int gid;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGphone() {
        return gphone;
    }

    public void setGphone(String gphone) {
        this.gphone = gphone;
    }

    public String getGaddress() {
        return gaddress;
    }

    public void setGaddress(String gaddress) {
        this.gaddress = gaddress;
    }

    public String getGcity() {
        return gcity;
    }

    public void setGcity(String gcity) {
        this.gcity = gcity;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public ArrayList<groups> returnGroups()
            {
        ArrayList<groups> groups = new ArrayList<groups>();
        try {
            Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DataBase.DBTableEnum.GROUPS.getTableName() + " order by gid";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                groups group = new groups();
                group.gid = resultSet.getInt("gid");
                group.gname = resultSet.getString("gname");
                group.gphone = resultSet.getString("gphone");
                group.gaddress = resultSet.getString("gaddress");
                group.gcity = resultSet.getString("gcity");
                groups.add(group);
            }
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return groups;
    }

    public boolean add()
            {
       int result=0;
        try {
             Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "insert into " + DataBase.DBTableEnum.GROUPS.getTableName() + " values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getGid());
            statement.setString(constants.Constant.INTEGER_TWO, this.getGname());
            statement.setString(constants.Constant.INTEGER_THREE, this.getGphone());
            statement.setString(constants.Constant.INTEGER_FOUR, this.getGaddress());
            statement.setString(constants.Constant.INTEGER_FIVE, this.getGcity());
            result=statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
        return (result==1)?true:false;
    }

    public groups get()
            throws Exception {
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select * from " + DataBase.DBTableEnum.GROUPS.getTableName() + " where gid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getGid());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.setGname(resultSet.getString("gname"));
                this.setGcity(resultSet.getString("gcity"));
                this.setGphone(resultSet.getString("gphone"));
                this.setGaddress(resultSet.getString("gaddress"));
                this.setGid(resultSet.getInt("gid"));

            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }

        return this;
    }

    public int search()
            throws Exception {
        Connection connection = null;
        int flag = 0;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select * from " + DataBase.DBTableEnum.GROUPS.getTableName() + " where gid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getGid());
            flag = statement.executeUpdate();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
        return flag;
    }

    public boolean update()
            {
        
        int result = 0;
        try {
        Connection connection = null;
        Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "update " + DataBase.DBTableEnum.GROUPS.getTableName() + " set gaddress=?,gcity=?,gphone=?,gname=? where gid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(constants.Constant.INTEGER_ONE, this.getGaddress());
            statement.setString(constants.Constant.INTEGER_TWO, this.getGcity());
            statement.setString(constants.Constant.INTEGER_THREE, this.getGphone());
            statement.setString(constants.Constant.INTEGER_FOUR, this.getGname());
            statement.setInt(constants.Constant.INTEGER_FIVE, this.getGid());
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return (result==1)?true:false;
    }

    public boolean delete()
            {
       int result=0;
        try {
            Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "delete from " + DataBase.DBTableEnum.GROUPS.getTableName() + " where gid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getGid());
            result=statement.executeUpdate();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return (result==1)?true:false;
    }
}
