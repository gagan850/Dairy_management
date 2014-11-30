/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Enum.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gaganbansal
 */
public class notes {

    int id;
    String data;
    int red;
    int green;
    int blue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public static ArrayList<notes> get() throws Exception {
        Connection connection = null;
        ArrayList<notes> a = new ArrayList<notes>();
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "select * from "+ DBTableEnum.NOTES.getTableName()+" order by id";
            PreparedStatement ps = connection.prepareStatement(ss);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                notes g = new notes();
                g.setRed(rs.getInt("red"));
                g.setGreen(rs.getInt("green"));
                g.setBlue(rs.getInt("blue"));
                g.setData(rs.getString("data"));
                g.setId(rs.getInt("id"));

                a.add(g);
            }

        } catch (Exception exception) {
            exception.printStackTrace();

        } finally {
            connection.close();
        }
        return a;
    }

    public void add() throws Exception {
        Connection connection = null;
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);

            String ss = "update "+ DBTableEnum.NOTES.getTableName()+" set red=?,green=?,blue=?,data=? where id=?";
            PreparedStatement ps = connection.prepareStatement(ss);
            ps.setInt(1, this.getRed());
            ps.setInt(2, this.getGreen());
            ps.setInt(3, this.getBlue());
            ps.setString(4, this.getData());
            ps.setInt(5, this.getId());

            ps.executeQuery();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            connection.close();
        }
    }

}
