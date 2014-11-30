/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Enum.DBTableEnum;
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
public class account_type {

    private String account_type;
    private int account_typeid;

    public int getAccount_typeid() {
        return account_typeid;
    }

    public void setAccount_typeid(int account_typeid) {
        this.account_typeid = account_typeid;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public ArrayList<account_type> returnAccount_type() {
        ArrayList<account_type> account_type_list = new ArrayList<account_type>();
        try {
            Connection connection = null;
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String ss = "select * from "+DBTableEnum.ACCOUNT_TYPE+" order by account_typeid";
            PreparedStatement ps = connection.prepareStatement(ss);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account_type account_type = new account_type();
                account_type.setAccount_type(rs.getString("account_type"));
                account_type.setAccount_typeid(rs.getInt("account_typeid"));
                account_type_list.add(account_type);
            }
         } catch (Exception exception) {
               JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
         }
        return account_type_list;
    }

    public String getAccount() {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String ss = "select "+DBTableEnum.ACCOUNT_TYPE+" from account_type where account_typeid=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getAccount_typeid());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                this.account_type = rs.getString("account_type");

                this.account_typeid = rs.getInt("account_typeid");
            }
        } catch (Exception exception) {
               JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        return this.getAccount_type();
    }

}
