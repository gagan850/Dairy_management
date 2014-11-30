/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author bansal
 */
public class order_transactions {

    private String aname;
    private int item_no;
    private String item_name;
    private float quantity;
    private float ammount;
    private float rate;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getItem_no() {
        return item_no;
    }

    public void setItem_no(int item_no) {
        this.item_no = item_no;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public ArrayList<order_transactions> returnOrder_Transactions() throws Exception {
        Connection connection = null;
        ArrayList<order_transactions> a = new ArrayList<order_transactions>();
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+DataBase.DBTableEnum.ORDER_TRANSACTIONS.getTableName()+" where aname=? order by item_no";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setString(1, this.getAname());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                order_transactions g = new order_transactions();
                g.aname = rs.getString("aname");
                g.item_no = rs.getInt("item_no");
                g.item_name = rs.getString("item_name");
                g.quantity = rs.getFloat("quantity");
                g.ammount = rs.getFloat("ammount");
                g.rate = rs.getFloat("rate");
                a.add(g);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }

        return a;
    }

    public void add(ArrayList<order_transactions> transactions) throws Exception {
        Connection connection = null;

        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            Iterator<order_transactions> iterator = transactions.iterator();
            while (iterator.hasNext()) {
                order_transactions transaction = iterator.next();
                String ss = "update "+DataBase.DBTableEnum.ORDER_TRANSACTIONS.getTableName()+" set item_name=?, quantity=?, ammount=?, rate=? where aname=? and item_no=?";
                PreparedStatement ps = connection.prepareStatement(ss);
                ps.setString(1, transaction.getItem_name());
                ps.setFloat(2, transaction.getQuantity());
                ps.setFloat(3, transaction.getAmmount());
                ps.setFloat(4, transaction.getRate());
                ps.setString(5, transaction.getAname());
                ps.setInt(6, transaction.getItem_no());
                ps.executeQuery();

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void addEmptyInTransactions(String name) throws Exception {
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);

            for (int i = 0; i < 20; i++) {

                String ss = "insert into "+DataBase.DBTableEnum.ORDER_TRANSACTIONS.getTableName()+" (item_name,item_no,quantity,ammount,rate,aname) values(?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(ss);
                ps.setString(1, "");
                ps.setFloat(2, (i + 1));
                ps.setFloat(3, 0.0f);
                ps.setFloat(4, 0.0f);
                ps.setFloat(5, 0.0f);
                ps.setString(6, name);
                ps.execute();

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /*
     public order_transactions get() throws Exception{
     try{
     Class.forName("oracle.jdbc.OracleDriver");
     String s="jdbc:oracle:thin:@localhost:1521:";
     con=DriverManager.getConnection(s,"dairy","bansal");
     String ss="select * from order_transactions where gname=?";
     PreparedStatement ps=con.prepareStatement(ss);
     ps.setString(1, this.getGname());
     ResultSet rs=ps.executeQuery();
     while(rs.next()){
     this.setGname(rs.getString("gname"));
     this.setGcity(rs.getString("gcity"));
     this.setGphone(rs.getString("gphone"));
     this.setGaddress(rs.getString("gaddress"));


     }
     }catch(Exception e){e.printStackTrace();}
     con.close();
     return this;
     }


     public int search() {
     int a=0;
     try{
     Class.forName("oracle.jdbc.OracleDriver");
     String s="jdbc:oracle:thin:@localhost:1521:";
     Connection con=DriverManager.getConnection(s,"dairy","bansal");
     String ss="select * from order_transactions where gname=?";
     PreparedStatement ps=con.prepareStatement(ss);
     ps.setString(1, this.getGname());
     a=ps.executeUpdate();
     con.close();
     }catch(Exception e){e.printStackTrace();}
     return a;
     }

     public int update() {
     int a=0;
     try{
     Class.forName("oracle.jdbc.OracleDriver");
     String s="jdbc:oracle:thin:@localhost:1521:";
     Connection con=DriverManager.getConnection(s,"dairy","bansal");
     String ss="update order_transactions set gaddress=?,gcity=?,gphone=?  where gname=?";
     PreparedStatement ps=con.prepareStatement(ss);
     ps.setString(1, this.getGaddress());
     ps.setString(2, this.getGcity());
     ps.setString(3, this.getGphone());
     ps.setString(4, this.getGname());
     a=ps.executeUpdate();
     con.close();
     }catch(Exception e){e.printStackTrace();}
     return a;
     }


     public void delete() {

     try{
     Class.forName("oracle.jdbc.OracleDriver");
     String s="jdbc:oracle:thin:@localhost:1521:";
     Connection con=DriverManager.getConnection(s,"dairy","bansal");
     String ss="delete from order_transactions where gname=?";
     PreparedStatement ps=con.prepareStatement(ss);
     ps.setString(1, this.getGname());
     ps.executeQuery();
     con.close();
     }catch(Exception e){e.printStackTrace();}

     }*/
}
