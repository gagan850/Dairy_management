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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author gagandeepbansal
 */
public class pur_snf_transactions {

    private Date tdate;
    private int gid;
    private String aid;

    private float mor_milk;
    private float mor_fat;
    private float mor_snf;
    private float mor_fat_rate;
    private float mor_ghee;
    private float mor_powder;
    private float mor_ghee_ammount;
    private float mor_powder_ammount;
    private float mor_ammount;

    private float eve_milk;
    private float eve_fat;
    private float eve_snf;
    private float eve_fat_rate;
    private float eve_ghee;
    private float eve_powder;
    private float eve_ghee_ammount;
    private float eve_powder_ammount;
    private float eve_ammount;

    private float total_ammount;

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

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

    public float getMor_milk() {
        return mor_milk;
    }

    public void setMor_milk(float mor_milk) {
        this.mor_milk = mor_milk;
    }

    public float getMor_fat() {
        return mor_fat;
    }

    public void setMor_fat(float mor_fat) {
        this.mor_fat = mor_fat;
    }

    public float getMor_snf() {
        return mor_snf;
    }

    public void setMor_snf(float mor_snf) {
        this.mor_snf = mor_snf;
    }

    public float getMor_fat_rate() {
        return mor_fat_rate;
    }

    public void setMor_fat_rate(float mor_fat_rate) {
        this.mor_fat_rate = mor_fat_rate;
    }

    public float getMor_ghee() {
        return mor_ghee;
    }

    public void setMor_ghee(float mor_ghee) {
        this.mor_ghee = mor_ghee;
    }

    public float getMor_powder() {
        return mor_powder;
    }

    public void setMor_powder(float mor_powder) {
        this.mor_powder = mor_powder;
    }

    public float getMor_ghee_ammount() {
        return mor_ghee_ammount;
    }

    public void setMor_ghee_ammount(float mor_ghee_ammount) {
        this.mor_ghee_ammount = mor_ghee_ammount;
    }

    public float getMor_powder_ammount() {
        return mor_powder_ammount;
    }

    public void setMor_powder_ammount(float mor_powder_ammount) {
        this.mor_powder_ammount = mor_powder_ammount;
    }

    public float getMor_ammount() {
        return mor_ammount;
    }

    public void setMor_ammount(float mor_ammount) {
        this.mor_ammount = mor_ammount;
    }

    public float getEve_milk() {
        return eve_milk;
    }

    public void setEve_milk(float eve_milk) {
        this.eve_milk = eve_milk;
    }

    public float getEve_fat() {
        return eve_fat;
    }

    public void setEve_fat(float eve_fat) {
        this.eve_fat = eve_fat;
    }

    public float getEve_snf() {
        return eve_snf;
    }

    public void setEve_snf(float eve_snf) {
        this.eve_snf = eve_snf;
    }

    public float getEve_fat_rate() {
        return eve_fat_rate;
    }

    public void setEve_fat_rate(float eve_fat_rate) {
        this.eve_fat_rate = eve_fat_rate;
    }

    public float getEve_ghee() {
        return eve_ghee;
    }

    public void setEve_ghee(float eve_ghee) {
        this.eve_ghee = eve_ghee;
    }

    public float getEve_powder() {
        return eve_powder;
    }

    public void setEve_powder(float eve_powder) {
        this.eve_powder = eve_powder;
    }

    public float getEve_ghee_ammount() {
        return eve_ghee_ammount;
    }

    public void setEve_ghee_ammount(float eve_ghee_ammount) {
        this.eve_ghee_ammount = eve_ghee_ammount;
    }

    public float getEve_powder_ammount() {
        return eve_powder_ammount;
    }

    public void setEve_powder_ammount(float eve_powder_ammount) {
        this.eve_powder_ammount = eve_powder_ammount;
    }

    public float getEve_ammount() {
        return eve_ammount;
    }

    public void setEve_ammount(float eve_ammount) {
        this.eve_ammount = eve_ammount;
    }

    public float getTotal_ammount() {
        return total_ammount;
    }

    public void setTotal_ammount(float total_ammount) {
        this.total_ammount = total_ammount;
    }

    public static void save(ArrayList<pur_snf_transactions> a) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            Iterator<pur_snf_transactions> it = a.iterator();
            pur_snf_transactions aa = new pur_snf_transactions();
            PreparedStatement ps = null;
            while (it.hasNext()) {
                aa = it.next();
                System.out.println("Save date:" + aa.getTdate());
                String ss = "insert into "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+"(tdate,gid,aid,mor_milk,mor_fat,mor_snf,mor_fat_rate,mor_ghee,mor_powder,mor_ghee_ammount,mor_powder_ammount,mor_ammount,eve_milk,eve_fat,eve_snf,eve_fat_rate,eve_ghee,eve_powder,eve_ghee_ammount,eve_powder_ammount,eve_ammount,total_ammount) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                ps = connection.prepareStatement(ss);
                ps.setDate(1, aa.getTdate());
                ps.setInt(2, aa.getGid());
                ps.setString(3, aa.getAid());
                ps.setDouble(4, aa.getMor_milk());
                ps.setDouble(5, aa.getMor_fat());
                ps.setDouble(6, aa.getMor_snf());
                ps.setDouble(7, aa.getMor_fat_rate());

                ps.setDouble(8, aa.getMor_ghee());
                ps.setDouble(9, aa.getMor_powder());
                ps.setDouble(10, aa.getMor_ghee_ammount());
                ps.setDouble(11, aa.getMor_powder_ammount());
                ps.setDouble(12, aa.getMor_ammount());

                ps.setDouble(13, aa.getEve_milk());
                ps.setDouble(14, aa.getEve_fat());
                ps.setDouble(15, aa.getEve_snf());
                ps.setDouble(16, aa.getEve_fat_rate());
                ps.setDouble(17, aa.getEve_ghee());
                ps.setDouble(18, aa.getEve_powder());
                ps.setDouble(19, aa.getEve_ghee_ammount());
                ps.setDouble(20, aa.getEve_powder_ammount());
                ps.setDouble(21, aa.getEve_ammount());
                ps.setDouble(22, aa.getTotal_ammount());

                ps.execute();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void update(ArrayList<pur_snf_transactions> a) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            Iterator<pur_snf_transactions> it = a.iterator();
            pur_snf_transactions aa = new pur_snf_transactions();
            PreparedStatement ps = null;
            while (it.hasNext()) {
                aa = it.next();

                String ss = "update "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+" set mor_milk=?,mor_fat=?,mor_snf=?,mor_fat_rate=?,mor_ghee=?,mor_powder=?,mor_ghee_ammount=?,mor_powder_ammount=?,mor_ammount=?,eve_milk=?,eve_fat=?,eve_snf=?,eve_fat_rate=?,eve_ghee=?,eve_powder=?,eve_ghee_ammount=?,eve_powder_ammount=?,eve_ammount=?,total_ammount=? where gid=? and aid=? and tdate=? ";
                ps = connection.prepareStatement(ss);

                ps.setDouble(1, aa.getMor_milk());
                ps.setDouble(2, aa.getMor_fat());
                ps.setDouble(3, aa.getMor_snf());
                ps.setDouble(4, aa.getMor_fat_rate());
                ps.setDouble(5, aa.getMor_ghee());
                ps.setDouble(6, aa.getMor_powder());
                ps.setDouble(7, aa.getMor_ghee_ammount());
                ps.setDouble(8, aa.getMor_powder_ammount());
                ps.setDouble(9, aa.getMor_ammount());

                ps.setDouble(10, aa.getEve_milk());
                ps.setDouble(11, aa.getEve_fat());
                ps.setDouble(12, aa.getEve_snf());
                ps.setDouble(13, aa.getEve_fat_rate());
                ps.setDouble(14, aa.getEve_ghee());
                ps.setDouble(15, aa.getEve_powder());
                ps.setDouble(16, aa.getEve_ghee_ammount());
                ps.setDouble(17, aa.getEve_powder_ammount());
                ps.setDouble(18, aa.getEve_ammount());
                ps.setDouble(19, aa.getTotal_ammount());
                ps.setInt(20, aa.getGid());
                ps.setString(21, aa.getAid());
                ps.setDate(22, aa.getTdate());
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

            PreparedStatement ps = null;
            String ss = "insert into "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+"(tdate,gid,aid,mor_milk,mor_fat,mor_snf,mor_fat_rate,mor_ghee,mor_powder,mor_ghee_ammount,mor_powder_ammount,mor_ammount,eve_milk,eve_fat,eve_snf,eve_fat_rate,eve_ghee,eve_powder,eve_ghee_ammount,eve_powder_ammount,eve_ammount,total_ammount) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement(ss);
            ps.setDate(1, this.getTdate());
            ps.setInt(2, this.getGid());
            ps.setString(3, this.getAid());
            ps.setDouble(4, this.getMor_milk());
            ps.setDouble(5, this.getMor_fat());
            ps.setDouble(6, this.getMor_snf());
            ps.setDouble(7, this.getMor_fat_rate());
            ps.setDouble(8, this.getMor_ghee());
            ps.setDouble(9, this.getMor_powder());
            ps.setDouble(10, this.getMor_ghee_ammount());
            ps.setDouble(11, this.getMor_powder_ammount());
            ps.setDouble(12, this.getMor_ammount());

            ps.setDouble(13, this.getEve_milk());
            ps.setDouble(14, this.getEve_fat());
            ps.setDouble(15, this.getEve_snf());
            ps.setDouble(16, this.getEve_fat_rate());
            ps.setDouble(17, this.getEve_ghee());
            ps.setDouble(18, this.getEve_powder());
            ps.setDouble(19, this.getEve_ghee_ammount());
            ps.setDouble(20, this.getEve_powder_ammount());
            ps.setDouble(21, this.getEve_ammount());

            ps.setDouble(22, this.getTotal_ammount());

            ps.executeQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    //non static overloaded update method for single transaction
    public void update(pur_snf_transactions a) throws SQLException {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            PreparedStatement ps = null;
            String ss = "update "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+" set mor_milk=?,mor_fat=?,mor_snf=?,mor_fat_rate=?,mor_ghee=?,mor_powder=?,mor_ghee_ammount=?,mor_powder_ammount=?,mor_ammount=?,eve_milk=?,eve_fat=?,eve_snf=?,eve_fat_rate=?,eve_ghee=?,eve_powder=?,eve_ghee_ammount=?,eve_powder_ammount=?,eve_ammount=?,total_ammount=? where gid=? and aid=? and tdate=? ";
            ps = connection.prepareStatement(ss);

            ps.setDouble(1, a.getMor_milk());
            ps.setDouble(2, a.getMor_fat());
            ps.setDouble(3, a.getMor_snf());
            ps.setDouble(4, a.getMor_fat_rate());
            ps.setDouble(5, a.getMor_ghee());
            ps.setDouble(6, a.getMor_powder());
            ps.setDouble(7, a.getMor_ghee_ammount());
            ps.setDouble(8, a.getMor_powder_ammount());
            ps.setDouble(9, a.getMor_ammount());

            ps.setDouble(10, a.getEve_milk());
            ps.setDouble(11, a.getEve_fat());
            ps.setDouble(12, a.getMor_snf());
            ps.setDouble(13, a.getEve_fat_rate());
            ps.setDouble(14, a.getEve_ghee());
            ps.setDouble(15, a.getEve_powder());
            ps.setDouble(16, a.getEve_ghee_ammount());
            ps.setDouble(17, a.getEve_powder_ammount());
            ps.setDouble(18, a.getEve_ammount());
            ps.setDouble(19, a.getTotal_ammount());
            ps.setInt(20, a.getGid());
            ps.setString(21, a.getAid());
            ps.setDate(22, a.getTdate());
            ps.executeQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public ArrayList<pur_snf_transactions> get() throws SQLException {
        Connection connection = null;
        ArrayList<pur_snf_transactions> aa = new ArrayList<pur_snf_transactions>();
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate>=to_date(?,'yyyy-mm-dd') and tdate<to_date(?,'yyyy-mm-dd')";
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

                pur_snf_transactions a = new pur_snf_transactions();
                a.setTdate(rs.getDate("tdate"));
                a.setMor_milk(rs.getFloat("mor_milk"));
                a.setMor_fat(rs.getFloat("mor_fat"));
                a.setMor_snf(rs.getFloat("mor_snf"));
                a.setMor_fat_rate(rs.getFloat("mor_fat_rate"));
                a.setMor_ghee(rs.getFloat("mor_ghee"));
                a.setMor_powder(rs.getFloat("mor_powder"));
                a.setMor_ghee_ammount(rs.getFloat("mor_ghee_ammount"));
                a.setMor_powder_ammount(rs.getFloat("mor_powder_ammount"));
                a.setMor_ammount(rs.getFloat("mor_ammount"));
                a.setEve_milk(rs.getFloat("eve_milk"));
                a.setEve_fat(rs.getFloat("eve_fat"));
                a.setEve_snf(rs.getFloat("eve_snf"));
                a.setEve_fat_rate(rs.getFloat("eve_fat_rate"));
                a.setEve_ghee(rs.getFloat("eve_ghee"));
                a.setEve_powder(rs.getFloat("eve_powder"));
                a.setEve_ghee_ammount(rs.getFloat("eve_ghee_ammount"));
                a.setEve_powder_ammount(rs.getFloat("eve_powder_ammount"));
                a.setEve_ammount(rs.getFloat("eve_ammount"));
                a.setTotal_ammount(rs.getFloat("total_ammount"));
                a.setAid(rs.getString("aid"));
                a.setGid(rs.getInt("gid"));

                aa.add(a);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
        return aa;

    }

    public pur_snf_transactions getTransaction_aname_gname_date_given() throws SQLException {
        Connection connection = null;
        pur_snf_transactions a = new pur_snf_transactions();
        try {
            String aid = null;
            int gid = 0;
            Date tdate = null;
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getGid());
            ps.setString(2, this.getAid());
            ps.setDate(3, this.getTdate());
            gid = this.getGid();
            aid = this.getAid();
            tdate = this.getTdate();
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                a.setTdate(rs.getDate("tdate"));
                a.setMor_milk(rs.getFloat("mor_milk"));
                a.setMor_fat(rs.getFloat("mor_fat"));
                a.setMor_snf(rs.getFloat("mor_snf"));
                a.setMor_fat_rate(rs.getFloat("mor_fat_rate"));
                a.setMor_ghee(rs.getFloat("mor_ghee"));
                a.setMor_powder(rs.getFloat("mor_powder"));
                a.setMor_ghee_ammount(rs.getFloat("mor_ghee_ammount"));
                a.setMor_powder_ammount(rs.getFloat("mor_powder_ammount"));
                a.setMor_ammount(rs.getFloat("mor_ammount"));
                a.setEve_milk(rs.getFloat("eve_milk"));
                a.setEve_fat(rs.getFloat("eve_fat"));
                a.setEve_snf(rs.getFloat("eve_snf"));
                a.setEve_fat_rate(rs.getFloat("eve_fat_rate"));
                a.setEve_ghee(rs.getFloat("eve_ghee"));
                a.setEve_powder(rs.getFloat("eve_powder"));
                a.setEve_ghee_ammount(rs.getFloat("eve_ghee_ammount"));
                a.setEve_powder_ammount(rs.getFloat("eve_powder_ammount"));
                a.setEve_ammount(rs.getFloat("eve_ammount"));
                a.setTotal_ammount(rs.getFloat("total_ammount"));
                a.setAid(rs.getString("aid"));
                a.setGid(rs.getInt("gid"));
            } else {
                a.setTdate(tdate);
                a.setMor_milk(0);
                a.setMor_fat(0);
                a.setMor_snf(0);
                a.setMor_fat_rate(0);
                a.setMor_ghee(0);
                a.setMor_powder(0);
                a.setMor_ghee_ammount(0);
                a.setMor_powder_ammount(0);
                a.setMor_ammount(0);
                a.setEve_milk(0);
                a.setEve_fat(0);
                a.setEve_snf(0);
                a.setEve_fat_rate(0);
                a.setEve_ghee(0);
                a.setEve_powder(0);
                a.setEve_ghee_ammount(0);
                a.setEve_powder_ammount(0);
                a.setEve_ammount(0);
                a.setTotal_ammount(0);
                a.setAid(aid);
                a.setGid(gid);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {

            connection.close();
        }
        return a;

    }

    public Map<String, pur_snf_transactions> getTransaction_gname_date_given() throws SQLException {
        Connection connection = null;
        Map<String, pur_snf_transactions> transactions = new HashMap<String, pur_snf_transactions>();
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+" where gid=? and tdate=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getGid());
            ps.setDate(2, this.getTdate());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pur_snf_transactions a = new pur_snf_transactions();
                a.setTdate(rs.getDate("tdate"));
                a.setMor_milk(rs.getFloat("mor_milk"));
                a.setMor_fat(rs.getFloat("mor_fat"));
                a.setMor_snf(rs.getFloat("mor_snf"));
                a.setMor_fat_rate(rs.getFloat("mor_fat_rate"));
                a.setMor_ghee(rs.getFloat("mor_ghee"));
                a.setMor_powder(rs.getFloat("mor_powder"));
                a.setMor_ghee_ammount(rs.getFloat("mor_ghee_ammount"));
                a.setMor_powder_ammount(rs.getFloat("mor_powder_ammount"));
                a.setMor_ammount(rs.getFloat("mor_ammount"));
                a.setEve_milk(rs.getFloat("eve_milk"));
                a.setEve_fat(rs.getFloat("eve_fat"));
                a.setEve_snf(rs.getFloat("eve_snf"));
                a.setEve_fat_rate(rs.getFloat("eve_fat_rate"));
                a.setEve_ghee(rs.getFloat("eve_ghee"));
                a.setEve_powder(rs.getFloat("eve_powder"));
                a.setEve_ghee_ammount(rs.getFloat("eve_ghee_ammount"));
                a.setEve_powder_ammount(rs.getFloat("eve_powder_ammount"));
                a.setEve_ammount(rs.getFloat("eve_ammount"));
                a.setTotal_ammount(rs.getFloat("total_ammount"));
                a.setAid(rs.getString("aid"));
                a.setGid(rs.getInt("gid"));
                transactions.put(rs.getString("aid"), a);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {

            connection.close();
        }
        return transactions;

    }

    public static void divide_into_saved_N_new(ArrayList<pur_snf_transactions> entries) throws SQLException {
        Connection connection = null;

        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            Iterator<pur_snf_transactions> iterator = entries.iterator();
            while (iterator.hasNext()) {
                pur_snf_transactions entry = iterator.next();

                String ss = "select * from "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate=?";
                PreparedStatement ps = connection.prepareStatement(ss);
                ps.setInt(1, entry.getGid());
                ps.setString(2, entry.getAid());
                ps.setDate(3, entry.getTdate());

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    Transaction.PurSNF.PurSNF.saved_enteries.add(entry);

                } else {
                    Transaction.PurSNF.PurSNF.new_enteries.add(entry);

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

            String ss = "select * from "+ DBTableEnum.PUR_SNF_TRANSACTIONS.getTableName()+" where gid=? and aid=? and tdate=?";
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
