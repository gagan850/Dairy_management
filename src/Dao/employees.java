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
import javax.swing.*;

/**
 *
 * @author bansal
 */
public class employees {

    private String ename;
    private String ephone;
    private String eaddress;
    private String ecity;
    private int esalary;
    private int eid;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getEcity() {
        return ecity;
    }

    public void setEcity(String ecity) {
        this.ecity = ecity;
    }

    public int getEsalary() {
        return esalary;
    }

    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public ArrayList<employees> returnEmployees() {
        ArrayList<employees> employee_list = new ArrayList<employees>();
       
        try {
        Connection connection = null;
        Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select * from "+DataBase.DBTableEnum.EMPLOYEES.getTableName()+" order by eid";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employees employee = new employees();
                employee.eid = resultSet.getInt("eid");
                employee.ename = resultSet.getString("ename");
                employee.ephone = resultSet.getString("ephone");
                employee.eaddress = resultSet.getString("eaddress");
                employee.ecity = resultSet.getString("ecity");
                employee.esalary = resultSet.getInt("esalary");
                employee_list.add(employee);
            }
            connection.close();
  } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
      } 
        return employee_list;
    }

    public boolean add(){
        int result=constants.Constant.INTEGER_ZERO;
        try {
        Connection connection = null;
        Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "insert into "+DataBase.DBTableEnum.EMPLOYEES.getTableName()+"(eid,ename,ephone,eaddress,ecity,esalary) values(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getEid());
            statement.setString(constants.Constant.INTEGER_TWO, this.getEname());
            statement.setString(constants.Constant.INTEGER_THREE, this.getEphone());
            statement.setString(constants.Constant.INTEGER_FOUR, this.getEaddress());
            statement.setString(constants.Constant.INTEGER_FIVE, this.getEcity());
            statement.setInt(constants.Constant.INTEGER_SIX, this.getEsalary());

            result=statement.executeUpdate();
connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
         } 
        return (result==constants.Constant.INTEGER_ONE)?true:false;
    }

    public employees get() {
        
        try {
            Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from "+DataBase.DBTableEnum.EMPLOYEES.getTableName()+" where eid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getEid());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.setEname(resultSet.getString("ename"));
                this.setEcity(resultSet.getString("ecity"));
                this.setEphone(resultSet.getString("ephone"));
                this.setEaddress(resultSet.getString("eaddress"));
                this.setEid(resultSet.getInt("eid"));
                this.setEsalary(resultSet.getInt("esalary"));

            }
            connection.close();
        } catch (Exception exception) {
           JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
         } 
        return this;
    }

    public int search(){
        int a = constants.Constant.INTEGER_ZERO;
        try {
        Connection connection = null;
        
        Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String ss = "select * from "+DataBase.DBTableEnum.EMPLOYEES.getTableName()+" where eid=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(constants.Constant.INTEGER_ONE, this.getEid());
            a = ps.executeUpdate();
        connection.close();
        } catch (Exception exception) {
           JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
         } 
        return a;
    }

    public boolean update() {
        int result = constants.Constant.INTEGER_ZERO;
        try {
        Connection connection = null;
        
        Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "update "+DataBase.DBTableEnum.EMPLOYEES.getTableName()+" set eaddress=?,ecity=?,ephone=?,ename=?,esalary=? where eid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(constants.Constant.INTEGER_ONE, this.getEaddress());
            statement.setString(constants.Constant.INTEGER_TWO, this.getEcity());
            statement.setString(constants.Constant.INTEGER_THREE, this.getEphone());
            statement.setString(constants.Constant.INTEGER_FOUR, this.getEname());
            statement.setInt(constants.Constant.INTEGER_FIVE, this.getEsalary());
            statement.setInt(constants.Constant.INTEGER_SIX, this.getEid());
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
        return (result==constants.Constant.INTEGER_ONE)?true:false;
    }

    public boolean delete()  {
        int result=constants.Constant.INTEGER_ZERO;
        try {
            Connection connection = null;
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String ss = "delete from "+DataBase.DBTableEnum.EMPLOYEES.getTableName()+" where eid=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(constants.Constant.INTEGER_ONE, this.getEid());
            result=ps.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return (result==constants.Constant.INTEGER_ONE)?true:false;
    }
}
