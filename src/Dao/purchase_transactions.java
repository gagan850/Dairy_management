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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author gagandeepbansal
 */
public class purchase_transactions {

    private int gid;
    private String aid;
    private Date tdate;
    private double mb_milk;
    private double eb_milk;
    private double mc_milk;
    private double ec_milk;
    private double receive;
    private double ammount;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public double getMb_milk() {
        return mb_milk;
    }

    public void setMb_milk(double mb_milk) {
        this.mb_milk = mb_milk;
    }

    public double getEb_milk() {
        return eb_milk;
    }

    public void setEb_milk(double eb_milk) {
        this.eb_milk = eb_milk;
    }

    public double getMc_milk() {
        return mc_milk;
    }

    public void setMc_milk(double mc_milk) {
        this.mc_milk = mc_milk;
    }

    public double getEc_milk() {
        return ec_milk;
    }

    public void setEc_milk(double ec_milk) {
        this.ec_milk = ec_milk;
    }

    public double getReceive() {
        return receive;
    }

    public void setReceive(double receive) {
        this.receive = receive;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public static void save(ArrayList<purchase_transactions> a) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            Iterator<purchase_transactions> it = a.iterator();
            purchase_transactions aa = new purchase_transactions();
            PreparedStatement ps = null;
            while (it.hasNext()) {
                aa = it.next();
                System.out.println("Save date:" + aa.getTdate());
                String ss = "insert into "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+"(gid,aid,tdate,mb_milk,eb_milk,mc_milk,ec_milk,receive,ammount) values(?,?,?,?,?,?,?,?,?)";
                ps = connection.prepareStatement(ss);
                ps.setInt(1, aa.getGid());
                ps.setString(2, aa.getAid());
                ps.setDate(3, aa.getTdate());
                ps.setDouble(4, aa.getMb_milk());
                ps.setDouble(5, aa.getEb_milk());
                ps.setDouble(6, aa.getMc_milk());
                ps.setDouble(7, aa.getEc_milk());
                ps.setDouble(8, aa.getReceive());
                ps.setDouble(9, aa.getAmmount());
                ps.execute();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void update(ArrayList<purchase_transactions> a) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            Iterator<purchase_transactions> it = a.iterator();
            purchase_transactions aa = new purchase_transactions();
            PreparedStatement ps = null;
            while (it.hasNext()) {
                aa = it.next();

                String ss = "update "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+" set  mb_milk=?,eb_milk=?,mc_milk=?,ec_milk=?,receive=?,ammount=? where gid=? and aid=? and tdate=? ";
                ps = connection.prepareStatement(ss);
                ps.setDouble(1, aa.getMb_milk());
                ps.setDouble(2, aa.getEb_milk());
                ps.setDouble(3, aa.getMc_milk());
                ps.setDouble(4, aa.getEc_milk());
                ps.setDouble(5, aa.getReceive());
                ps.setDouble(6, aa.getAmmount());
                ps.setInt(7, aa.getGid());
                ps.setString(8, aa.getAid());
                ps.setDate(9, aa.getTdate());
                ps.execute();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    //non static overloaded save method for single transaction
    public void save() throws Exception {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "insert into "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+"(gid,aid,tdate,mb_milk,eb_milk,mc_milk,ec_milk,receive,ammount) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getGid());
            ps.setString(2, this.getAid());
            ps.setDate(3, this.getTdate());
            ps.setDouble(4, this.getMb_milk());
            ps.setDouble(5, this.getEb_milk());
            ps.setDouble(6, this.getMc_milk());
            ps.setDouble(7, this.getEc_milk());
            ps.setDouble(8, this.getReceive());
            ps.setDouble(9, this.getAmmount());
            ps.executeQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    //non static overloaded update method for single transaction
    public void update(purchase_transactions a) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "update "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+" set  mb_milk=?,eb_milk=?,mc_milk=?,ec_milk=?,receive=?,ammount=? where gid=? and aid=? and tdate=? ";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setDouble(1, this.getMb_milk());
            ps.setDouble(2, this.getEb_milk());
            ps.setDouble(3, this.getMc_milk());
            ps.setDouble(4, this.getEc_milk());
            ps.setDouble(5, this.getReceive());
            ps.setDouble(6, this.getAmmount());
            ps.setInt(7, this.getGid());
            ps.setString(8, this.getAid());
            ps.setDate(9, this.getTdate());
            ps.executeQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public ArrayList<purchase_transactions> get() throws SQLException {
        Connection connection = null;
        ArrayList<purchase_transactions> aa = new ArrayList<purchase_transactions>();
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate>=to_date(?,'yyyy-mm-dd') and tdate<to_date(?,'yyyy-mm-dd')";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getGid());
            ps.setString(2, this.getAid());
            Date d = this.getTdate();
            d.setDate(1);
            ps.setString(3, d.toString());

            Date dd = d;
            dd.setMonth(dd.getMonth() + 1);

            ps.setString(4, dd.toString());
            //

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                purchase_transactions a = new purchase_transactions();
                a.setTdate(rs.getDate("tdate"));
                a.setMb_milk(rs.getDouble("mb_milk"));
                a.setEb_milk(rs.getDouble("eb_milk"));
                a.setAmmount(rs.getDouble("ammount"));
                a.setEc_milk(rs.getDouble("ec_milk"));
                a.setMc_milk(rs.getDouble("mc_milk"));
                a.setReceive(rs.getDouble("receive"));

                aa.add(a);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return aa;

    }

    public purchase_transactions getTransaction_aname_gname_date_given() throws SQLException {
        Connection connection = null;

        purchase_transactions a = new purchase_transactions();
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getGid());
            ps.setString(2, this.getAid());
            ps.setDate(3, this.getTdate());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a.setMb_milk(rs.getDouble("mb_milk"));

                a.setEb_milk(rs.getDouble("eb_milk"));

                a.setAmmount(rs.getDouble("ammount"));

                a.setEc_milk(rs.getDouble("ec_milk"));
                a.setMc_milk(rs.getDouble("mc_milk"));
                a.setReceive(rs.getDouble("receive"));
                a.setGid(rs.getInt("gid"));
                a.setAid(rs.getString("aid"));
                a.setTdate(rs.getDate("tdate"));
            } else {
                a = null;
            }
        } catch (Exception exception) {
        } finally {
            connection.close();
        }

        return a;

    }

    public static void divide_into_saved_N_new(ArrayList<purchase_transactions> entries) throws SQLException {
        Connection connection = null;

        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            Iterator<purchase_transactions> iterator = entries.iterator();
            while (iterator.hasNext()) {
                purchase_transactions entry = iterator.next();

                String ss = "select * from "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate=?";
                PreparedStatement ps = connection.prepareStatement(ss);
                ps.setInt(1, entry.getGid());
                ps.setString(2, entry.getAid());
                ps.setDate(3, entry.getTdate());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    Transactions.Purchase.Purchase.saved_enteries.add(entry);

                } else {
                    Transactions.Purchase.Purchase.new_enteries.add(entry);

                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

    }

    //search if there is a transaction on a particular day
    public boolean search_transaction_on_particular_day() throws SQLException {
        Connection connection = null;

        boolean result = false;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+ DBTableEnum.PURCHASE_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getGid());
            ps.setString(2, this.getAid());
            ps.setDate(3, this.getTdate());

            ResultSet rs = ps.executeQuery();
            result = rs.next();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
            return result;
        }
    }

}
