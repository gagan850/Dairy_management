/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Transactions.Sale.Sale;
import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 *
 * @author gagandeepbansal
 */
public class sale_transactions {

    private int gid;
    private String aid;
    private Date tdate;
    private double mb_milk;
    private double eb_milk;
    private double mc_milk;
    private double ec_milk;
    private double receive;
    private double ammount;
    private String receive_by;

    private int balance;

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

    public String getReceive_by() {
        return receive_by;
    }

    public void setReceive_by(String receive_by) {
        this.receive_by = receive_by;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static void save(ArrayList<sale_transactions> sale_transaction_list)
            throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            Iterator<sale_transactions> iterator = sale_transaction_list.iterator();
            sale_transactions sale_transacion = new sale_transactions();
            PreparedStatement statement = null;
            while (iterator.hasNext()) {
                sale_transacion = iterator.next();
                System.out.println("Save date:" + sale_transacion.getTdate());
                String query = "insert into " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + "(gid,aid,tdate,mb_milk,eb_milk,mc_milk,ec_milk,receive,ammount,receive_by) values(?,?,?,?,?,?,?,?,?,?)";
                statement = connection.prepareStatement(query);
                statement.setInt(constants.Constant.INTEGER_ONE, sale_transacion.getGid());
                statement.setString(constants.Constant.INTEGER_TWO, sale_transacion.getAid());
                statement.setDate(constants.Constant.INTEGER_THREE, sale_transacion.getTdate());
                statement.setDouble(constants.Constant.INTEGER_FOUR, sale_transacion.getMb_milk());
                statement.setDouble(constants.Constant.INTEGER_FIVE, sale_transacion.getEb_milk());
                statement.setDouble(constants.Constant.INTEGER_SIX, sale_transacion.getMc_milk());
                statement.setDouble(constants.Constant.INTEGER_SEVEN, sale_transacion.getEc_milk());
                statement.setDouble(constants.Constant.INTEGER_EIGHT, sale_transacion.getReceive());
                statement.setDouble(constants.Constant.INTEGER_NINE, sale_transacion.getAmmount());
                statement.setString(constants.Constant.INTEGER_TEN, sale_transacion.getReceive_by());
                statement.execute();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void update(ArrayList<sale_transactions> sale_transacion_list)
            throws SQLException {
        Connection connection = null;

        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            Iterator<sale_transactions> iterator = sale_transacion_list.iterator();
            sale_transactions sale_transacion = new sale_transactions();
            PreparedStatement statement = null;
            while (iterator.hasNext()) {
                sale_transacion = iterator.next();

                String query = "update " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " set  mb_milk=?,eb_milk=?,mc_milk=?,ec_milk=?,receive=?,ammount=?,receive_by=? where gid=? and aid=? and tdate=? ";
                statement = connection.prepareStatement(query);
                statement.setDouble(constants.Constant.INTEGER_ONE, sale_transacion.getMb_milk());
                statement.setDouble(constants.Constant.INTEGER_TWO, sale_transacion.getEb_milk());
                statement.setDouble(constants.Constant.INTEGER_THREE, sale_transacion.getMc_milk());
                statement.setDouble(constants.Constant.INTEGER_FOUR, sale_transacion.getEc_milk());
                statement.setDouble(constants.Constant.INTEGER_FIVE, sale_transacion.getReceive());
                statement.setDouble(constants.Constant.INTEGER_SIX, sale_transacion.getAmmount());
                statement.setString(constants.Constant.INTEGER_SEVEN, sale_transacion.getReceive_by());
                statement.setInt(constants.Constant.INTEGER_EIGHT, sale_transacion.getGid());
                statement.setString(constants.Constant.INTEGER_NINE, sale_transacion.getAid());
                statement.setDate(constants.Constant.INTEGER_TEN, sale_transacion.getTdate());
                statement.execute();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    //non static overloaded save method for single transaction
    public void save()
            throws Exception {
        Connection connection = null;

        try {

            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "insert into " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + "(gid,aid,tdate,mb_milk,eb_milk,mc_milk,ec_milk,receive,ammount,receive_by) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getGid());
            statement.setString(constants.Constant.INTEGER_TWO, this.getAid());
            statement.setDate(constants.Constant.INTEGER_THREE, this.getTdate());
            statement.setDouble(constants.Constant.INTEGER_FOUR, this.getMb_milk());
            statement.setDouble(constants.Constant.INTEGER_FIVE, this.getEb_milk());
            statement.setDouble(constants.Constant.INTEGER_SIX, this.getMc_milk());
            statement.setDouble(constants.Constant.INTEGER_SEVEN, this.getEc_milk());
            statement.setDouble(constants.Constant.INTEGER_EIGHT, this.getReceive());
            statement.setDouble(constants.Constant.INTEGER_NINE, this.getAmmount());
            statement.setString(constants.Constant.INTEGER_TEN, this.getReceive_by());
            statement.executeQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    //non static overloaded update method for single transaction
    public void update(sale_transactions a)
            throws SQLException {
        Connection connection = null;

        try {

            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "update " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " set  mb_milk=?,eb_milk=?,mc_milk=?,ec_milk=?,receive=?,ammount=?,receive_by=? where gid=? and aid=? and tdate=? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(constants.Constant.INTEGER_ONE, this.getMb_milk());
            statement.setDouble(constants.Constant.INTEGER_TWO, this.getEb_milk());
            statement.setDouble(constants.Constant.INTEGER_THREE, this.getMc_milk());
            statement.setDouble(constants.Constant.INTEGER_FOUR, this.getEc_milk());
            statement.setDouble(constants.Constant.INTEGER_FIVE, this.getReceive());
            statement.setDouble(constants.Constant.INTEGER_SIX, this.getAmmount());
            statement.setString(constants.Constant.INTEGER_SEVEN, this.getReceive_by());
            statement.setInt(constants.Constant.INTEGER_EIGHT, this.getGid());
            statement.setString(constants.Constant.INTEGER_NINE, this.getAid());
            statement.setDate(constants.Constant.INTEGER_TEN, this.getTdate());
            statement.executeQuery();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public ArrayList<sale_transactions> get()
            throws SQLException {
        Connection connection = null;

        ArrayList<sale_transactions> sale_transaction_list = new ArrayList<sale_transactions>();
        try {

            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select * from " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " where gid=? and aid=? and tdate>=to_date(?,'yyyy-mm-dd') and tdate<to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getGid());
            statement.setString(constants.Constant.INTEGER_TWO, this.getAid());
            Date d = this.getTdate();
            d.setDate(constants.Constant.INTEGER_ONE);
            statement.setString(constants.Constant.INTEGER_THREE, d.toString());

            Date dd = d;
            dd.setMonth(dd.getMonth() + constants.Constant.INTEGER_ONE);

            statement.setString(constants.Constant.INTEGER_FOUR, dd.toString());
            //

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                sale_transactions sale_transacion = new sale_transactions();
                sale_transacion.setTdate(resultSet.getDate("tdate"));
                sale_transacion.setMb_milk(resultSet.getDouble("mb_milk"));
                sale_transacion.setEb_milk(resultSet.getDouble("eb_milk"));
                sale_transacion.setAmmount(resultSet.getDouble("ammount"));
                sale_transacion.setEc_milk(resultSet.getDouble("ec_milk"));
                sale_transacion.setMc_milk(resultSet.getDouble("mc_milk"));
                sale_transacion.setReceive(resultSet.getDouble("receive"));
                sale_transacion.setReceive_by(resultSet.getString("receive_by"));
                sale_transaction_list.add(sale_transacion);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return sale_transaction_list;

    }

    public int getAmmountReceive_by(int gid1, Date tdate1, String receive_by1)
            throws SQLException {
        Connection connection = null;

        int amm = constants.Constant.INTEGER_ZERO;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select sum(receive) from " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " where gid=? and tdate=? and receive_by=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, gid1);

            statement.setDate(constants.Constant.INTEGER_TWO, tdate1);
            statement.setString(constants.Constant.INTEGER_THREE, receive_by1);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                amm = resultSet.getInt(1);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return amm;

    }

    public ArrayList<sale_transactions> getTransaction_aname_gname_date_given(ArrayList<sale_transactions> sst)
            throws SQLException {
        Connection connection = null;
        ArrayList<sale_transactions> last = new ArrayList<sale_transactions>();
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            Iterator<sale_transactions> it = sst.iterator();
            while (it.hasNext()) {
                sale_transactions sss = it.next();

                String query = "select * from " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " where gid=? and aid=? and tdate=? ";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, sss.getGid());
                statement.setString(constants.Constant.INTEGER_TWO, sss.getAid());
                statement.setDate(constants.Constant.INTEGER_THREE, sss.getTdate());

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {

                    sss.setMb_milk(resultSet.getDouble("mb_milk"));

                    sss.setEb_milk(resultSet.getDouble("eb_milk"));

                    sss.setAmmount(resultSet.getDouble("ammount"));

                    sss.setEc_milk(resultSet.getDouble("ec_milk"));
                    sss.setMc_milk(resultSet.getDouble("mc_milk"));
                    sss.setReceive(resultSet.getDouble("receive"));
                    sss.setGid(resultSet.getInt("gid"));
                    sss.setAid(resultSet.getString("aid"));
                    sss.setTdate(resultSet.getDate("tdate"));
                    sss.setReceive_by(resultSet.getString("receive_by"));
                    last.add(sss);
                } else {
                    sss = null;
                    last.add(sss);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
        return last;

    }

    public sale_transactions getTransactionBalance_aname_gname_date_given()
            throws SQLException {
        Connection connection = null;

        sale_transactions a = new sale_transactions();
        try {

            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String query = "select mb_milk,eb_milk,ammount,ec_milk,mc_milk,receive,gid,aid,tdate,receive_by,NVL(NVL((select sum(ammount) from " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " where aid=s.aid and tdate<=to_date(?,'yyyy-mm-dd')),0)-NVL((select sum(receive) from sale_transactions where aid=s.aid and tdate<=to_date(?,'yyyy-mm-dd')),0)+NVL((select abalance from accounts where aid=s.aid),0),0) balance from sale_transactions s where s.gid=? and s.aid=? and s.tdate=to_date(?,'yyyy-mm-dd')";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(constants.Constant.INTEGER_THREE, this.getGid());
            statement.setString(constants.Constant.INTEGER_FOUR, this.getAid());
            String da = constants.Constant.EMPTY_STRING + (this.getTdate().getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + (this.getTdate().getMonth() + constants.Constant.INTEGER_ONE) + constants.Constant.HYPHEN + this.getTdate().getDate();
            System.out.println(da);
            statement.setString(constants.Constant.INTEGER_FIVE, da);
            Date d = this.getTdate();

            d.setMonth(d.getMonth() - constants.Constant.INTEGER_ONE);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, d.getYear());
            calendar.set(Calendar.MONTH, d.getMonth());
            int day = calendar.getActualMaximum(calendar.DATE);
            d.setDate(day);
            da = constants.Constant.EMPTY_STRING + (d.getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + (d.getMonth() + constants.Constant.INTEGER_ONE) + constants.Constant.HYPHEN + d.getDate();
            statement.setString(constants.Constant.INTEGER_ONE, da);
            statement.setString(constants.Constant.INTEGER_TWO, da);
            System.out.println("new fn" + da + constants.Constant.NEW_LINE);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                a.setMb_milk(resultSet.getDouble("mb_milk"));

                a.setEb_milk(resultSet.getDouble("eb_milk"));

                a.setAmmount(resultSet.getDouble("ammount"));

                a.setEc_milk(resultSet.getDouble("ec_milk"));
                a.setMc_milk(resultSet.getDouble("mc_milk"));
                a.setReceive(resultSet.getDouble("receive"));
                a.setGid(resultSet.getInt("gid"));
                a.setAid(resultSet.getString("aid"));
                a.setTdate(resultSet.getDate("tdate"));
                a.setReceive_by(resultSet.getString("receive_by"));
                a.setBalance(resultSet.getInt("balance"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return a;

    }

    public static ArrayList<Integer> getTransactionBalance_aname_gname_date_given1(ArrayList<Dao.accounts> acc, java.sql.Date current, java.sql.Date tdate)
            throws SQLException {
        Connection connection = null;
        ArrayList<Integer> balan = new ArrayList<Integer>();
        int balance = constants.Constant.INTEGER_ZERO;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            Iterator<Dao.accounts> iterator = acc.iterator();
            while (iterator.hasNext()) {
                Dao.accounts account = iterator.next();
                String query = "select NVL(NVL((select sum(ammount) from " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " where aid=? and tdate<=to_date(?,'yyyy-mm-dd')),0)-NVL((select sum(receive) from sale_transactions where aid=? and tdate<=to_date(?,'yyyy-mm-dd')),0)+NVL((select abalance from accounts where aid=?),0),0) balance from dual";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(constants.Constant.INTEGER_ONE, account.getAid());
                statement.setString(constants.Constant.INTEGER_THREE, account.getAid());
                statement.setString(constants.Constant.INTEGER_FIVE, account.getAid());
                int month = (current.getMonth() + constants.Constant.INTEGER_ONE);
                String curr = constants.Constant.EMPTY_STRING + (current.getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + month + constants.Constant.HYPHEN + current.getDate();
                statement.setString(constants.Constant.INTEGER_FOUR, curr);
                int days = Transactions.Cal.getMaxDays((month - constants.Constant.INTEGER_ONE), (current.getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED));
                String da = constants.Constant.EMPTY_STRING + (current.getYear() + constants.Constant.INTEGER_NINETEEN_HUNDRED) + constants.Constant.HYPHEN + (month - constants.Constant.INTEGER_ONE) + constants.Constant.HYPHEN + days;
                statement.setString(constants.Constant.INTEGER_TWO, da);
                System.out.println(curr + "  " + da);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    balance = resultSet.getInt(constants.Constant.INTEGER_ONE);
                    balan.add(balance);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
        return balan;
    }

    public static void divide_into_saved_N_new(ArrayList<sale_transactions> entries)
            throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            Iterator<sale_transactions> iterator = entries.iterator();
            while (iterator.hasNext()) {
                sale_transactions entry = iterator.next();
                String query = "select * from " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " where gid=? and aid=? and tdate=?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(constants.Constant.INTEGER_ONE, entry.getGid());
                statement.setString(constants.Constant.INTEGER_TWO, entry.getAid());
                statement.setDate(constants.Constant.INTEGER_THREE, entry.getTdate());
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    Sale.saved_enteries.add(entry);
                } else {
                    Sale.new_enteries.add(entry);
        }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

    }

    //search if there is a transaction on a particular day
    public boolean search_transaction_on_particular_day()
            throws SQLException {
        Connection connection = null;

        boolean result = false;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DataBase.DBTableEnum.SALE_TRANSACTIONS.getTableName() + " where gid=? and aid=? and tdate=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getGid());
            statement.setString(constants.Constant.INTEGER_TWO, this.getAid());
            statement.setDate(constants.Constant.INTEGER_THREE, this.getTdate());
            ResultSet resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
            return result;
        }
    }

}
