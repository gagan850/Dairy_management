/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Enum.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author gaganbansal
 */
public class accounts {

    private String aname;
    private int gid;
    private int account_typeid;
    private String aphone;
    private String aaddress;
    private String acity;
    private int abalance;
    private double acow_rate;
    private double abfl_rate;
    private Date adate;
    private int Id;
    private String aid;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAphone() {
        return aphone;
    }

    public double getAcow_rate() {
        return acow_rate;
    }

    public void setAcow_rate(double acow_rate) {
        this.acow_rate = acow_rate;
    }

    public double getAbfl_rate() {
        return abfl_rate;
    }

    public void setAbfl_rate(double abfl_rate) {
        this.abfl_rate = abfl_rate;
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

    public int getAbalance() {
        return abalance;
    }

    public void setAbalance(int abalance) {
        this.abalance = abalance;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getAccount_typeid() {
        return account_typeid;
    }

    public void setAccount_typeid(int account_typeid) {
        this.account_typeid = account_typeid;
    }

    public int search() throws SQLException {
        int a = 0;
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String ss = "select * from "+DBTableEnum.ACCOUNTS.getTableName()+" where aid=?";
            PreparedStatement ps = connection.prepareStatement(ss);

            ps.setString(constant.Constant.INTEGER_ONE, this.aid);
            a = ps.executeUpdate();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }

        return a;
    }

    public ArrayList<accounts> returnAccounts(){
        ArrayList<accounts> accounts = new ArrayList<accounts>();
        try {
        Connection connection = null;
         Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.ACCOUNTS.getTableName() + " where gid=? and account_typeid=? order by id";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(constant.Constant.INTEGER_ONE, this.gid);
            statement.setInt(constant.Constant.INTEGER_TWO, this.account_typeid);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                accounts account = new accounts();
                account.aname = resultSet.getString("aname");
                account.gid = resultSet.getInt("gid");
                account.account_typeid = resultSet.getInt("account_typeid");
                account.aphone = resultSet.getString("aphone");
                account.aaddress = resultSet.getString("aaddress");
                account.acity = resultSet.getString("acity");
                account.abalance = resultSet.getInt("abalance");
                account.acow_rate = resultSet.getInt("acow_rate");
                account.abfl_rate = resultSet.getInt("abfl_rate");
                account.adate = resultSet.getDate("adate");
                account.aid = resultSet.getString("aid");
                accounts.add(account);
            }
          connection.close();
       
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
       return accounts;
    }

    public boolean add() throws SQLException {
        int result=0;
        try {
        Connection connection = null;
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "insert into " + DBTableEnum.ACCOUNTS.getTableName() + "(aid,aname,gid,account_typeid,aphone,aaddress,acity,abalance,acow_rate,abfl_rate,adate,id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(constant.Constant.INTEGER_ONE, this.getAid());
            statement.setString(constant.Constant.INTEGER_TWO, this.getAname());
            statement.setInt(constant.Constant.INTEGER_THREE, this.getGid());
            statement.setInt(constant.Constant.INTEGER_FOUR, this.getAccount_typeid());
            statement.setString(constant.Constant.INTEGER_FIVE, this.getAphone());
            statement.setString(constant.Constant.INTEGER_SIX, this.getAaddress());
            statement.setString(constant.Constant.INTEGER_SEVEN, this.getAcity());
            statement.setInt(constant.Constant.INTEGER_EIGHT, this.getAbalance());
            statement.setDouble(constant.Constant.INTEGER_NINE, this.getAcow_rate());
            statement.setDouble(constant.Constant.INTEGER_TEN, this.getAbfl_rate());
            statement.setDate(constant.Constant.INTEGER_ELEVEN, this.getAdate());
            statement.setInt(constant.Constant.INTEGER_TWELVE, this.getId());
            result=statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
        return (result==1)?true:false;
    }

    public accounts get(){
        try {
        Connection connection = null;
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.ACCOUNTS.getTableName() + " where aid=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(constant.Constant.INTEGER_ONE, this.getAid());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                this.aname = resultSet.getString("aname");
                this.gid = resultSet.getInt("gid");
                this.account_typeid = resultSet.getInt("account_typeid");
                this.aphone = resultSet.getString("aphone");
                this.aaddress = resultSet.getString("aaddress");
                this.acity = resultSet.getString("acity");
                this.abalance = resultSet.getInt("abalance");
                this.acow_rate = resultSet.getInt("acow_rate");
                this.abfl_rate = resultSet.getInt("abfl_rate");
                this.adate = resultSet.getDate("adate");
                this.Id = resultSet.getInt("id");
                this.aid = resultSet.getString("aid");
            }
             connection.close();
       } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
        return this;
    }

    public int getAccountId() throws Exception {
        Connection connection = null;
        int val = -1;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select account_id_add.nextval from dual";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                val = resultSet.getInt(constant.Constant.INTEGER_ONE);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
        return val;
    }

    public int getNewAId() throws Exception {
        Connection connection = null;
        int val = -1;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select aid_add.nextval from dual";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                val = resultSet.getInt(constant.Constant.INTEGER_ONE);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
        return val;
    }

    public boolean delete(){
        int result=0;
        try {
        Connection connection = null;
        Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "delete from " + DBTableEnum.ACCOUNTS.getTableName() + " where aid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(constant.Constant.INTEGER_ONE, this.getAid());
            result=statement.executeUpdate();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return (result==1)?true:false;
}

    public boolean update() throws SQLException {
        
        int result = 0;
        try {
        Connection connection = null;
        Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "update " + DBTableEnum.ACCOUNTS.getTableName() + " set aphone=?,aaddress=?,acity=?,abalance=?,acow_rate=?,abfl_rate=?,adate=?,aname=? where aid=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(constant.Constant.INTEGER_ONE, this.getAphone());
            statement.setString(constant.Constant.INTEGER_TWO, this.getAaddress());
            statement.setString(constant.Constant.INTEGER_THREE, this.getAcity());
            statement.setInt(constant.Constant.INTEGER_FOUR, this.getAbalance());
            statement.setDouble(constant.Constant.INTEGER_FIVE, this.getAcow_rate());
            statement.setDouble(constant.Constant.INTEGER_SIX, this.getAbfl_rate());
            statement.setDate(constant.Constant.INTEGER_SEVEN, this.getAdate());
            statement.setString(constant.Constant.INTEGER_EIGHT, this.getAname());
            statement.setString(constant.Constant.INTEGER_NINE, this.getAid());
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
        return (result==1)?true:false;
    }

    public int get_Number_Of_Accounts_under_group_N_Account_Type() throws SQLException {
        Connection connection = null;
        int count = 0;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select count(*) from " + DBTableEnum.ACCOUNTS.getTableName() + " where gid=? and account_typeid=? order by id";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(constant.Constant.INTEGER_ONE, this.getGid());
            statement.setInt(constant.Constant.INTEGER_TWO, this.getAccount_typeid());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(constant.Constant.INTEGER_ONE);
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
        return count;
    }

    public ArrayList get_All_Accounts_under_group_N_Account_Type(){
       
        ArrayList<accounts> accounts = new ArrayList<accounts>();
        try {
            Connection connection = null;
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.ACCOUNTS.getTableName() + " where gid=? and account_typeid=? order by id";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(constant.Constant.INTEGER_ONE, this.getGid());
            statement.setInt(constant.Constant.INTEGER_TWO, this.getAccount_typeid());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Dao.accounts account = new Dao.accounts();
                account.setGid(resultSet.getInt("gid"));
                account.setAccount_typeid(resultSet.getInt("account_typeid"));
                account.setAname(resultSet.getString("aname"));
                account.setAbfl_rate(resultSet.getDouble("abfl_rate"));
                account.setAcow_rate(resultSet.getDouble("acow_rate"));
                account.setAbalance(resultSet.getInt("abalance"));
                account.setAaddress(resultSet.getString("aaddress"));
                account.setAcity(resultSet.getString("acity"));
                account.setAphone(resultSet.getString("aphone"));
                account.setAid(resultSet.getString("aid"));
                accounts.add(account);
            }
            connection.close();
         } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
        return accounts;
    }

    public Map<String, String> get_AccountIdNNAme_under_group_N_Account_Type() throws SQLException {
        Connection connection = null;
        int a = 0;
        Map<String, String> accounts = new HashMap<String, String>();
        try {

            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DBTableEnum.ACCOUNTS.getTableName() + " where gid=? and account_typeid=? order by id";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(constant.Constant.INTEGER_ONE, this.getGid());
            statement.setInt(constant.Constant.INTEGER_TWO, this.getAccount_typeid());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                accounts.put(resultSet.getString("aid"), resultSet.getString("aname"));
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
        return accounts;
    }

    //it returns the id of the account
    public int get_Id() throws SQLException {
        Connection connection = null;
        int id = 0;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "select id from " + DBTableEnum.ACCOUNTS.getTableName() + " where gid=? and aid=? and account_typeid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constant.Constant.INTEGER_ONE, this.getGid());
            statement.setString(constant.Constant.INTEGER_TWO, this.getAid());
            statement.setInt(constant.Constant.INTEGER_THREE, this.getAccount_typeid());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
        return id;
    }

    public void set_Id() throws SQLException {

        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "update " + DBTableEnum.ACCOUNTS.getTableName() + " set id=?  where gid=? and aid=? and account_typeid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constant.Constant.INTEGER_ONE, this.getId());
            statement.setInt(constant.Constant.INTEGER_TWO, this.getGid());
            statement.setString(constant.Constant.INTEGER_THREE, this.getAid());
            statement.setInt(constant.Constant.INTEGER_FOUR, this.getAccount_typeid());
            ResultSet resultSet = statement.executeQuery();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
    }

    public void setSortIds(ArrayList<Dao.accounts> acc) {
        try {
            Connection connection = null;
            Iterator<Dao.accounts> iterator = acc.iterator();
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String query = "update " + DBTableEnum.ACCOUNTS.getTableName() + " set id=? where aid=?";
            PreparedStatement   statement = connection.prepareStatement(query);

            while (iterator.hasNext()) {
                Dao.accounts account = iterator.next();
                statement.setInt(constant.Constant.INTEGER_ONE, account.getId());
                statement.setString(constant.Constant.INTEGER_TWO, account.getAid());
                statement.addBatch();
            }
            statement.executeBatch();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update_rates(ArrayList accounts) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String ss = "update  " + DBTableEnum.ACCOUNTS.getTableName() + " set abfl_rate=?,acow_rate=? where aid=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            for (int i = 0; i < accounts.size(); i++) {
                Dao.accounts account = (Dao.accounts) accounts.get(i);
                ps.setDouble(constant.Constant.INTEGER_ONE, account.getAbfl_rate());
                ps.setDouble(constant.Constant.INTEGER_TWO, account.getAcow_rate());
                ps.setString(constant.Constant.INTEGER_THREE, account.getAid());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
    }

    public void update_balance(ArrayList<accounts> accounts) {
       
        try {
             Connection connection = null;
             Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "update " + DBTableEnum.ACCOUNTS.getTableName() + " set abalance=? where aid=?";
            PreparedStatement statement = connection.prepareStatement(query);
            for (int index = 0; index < accounts.size(); index++) {
                Dao.accounts account = (Dao.accounts) accounts.get(index);
                statement.setInt(constant.Constant.INTEGER_ONE, account.getAbalance());
                statement.setString(constant.Constant.INTEGER_TWO, account.getAid());

                statement.addBatch();
            }
            statement.executeBatch();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } 
    }

}
