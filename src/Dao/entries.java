/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author gagandeepbansal
 */
public class entries {

    int account_type_id;
    int entries;

    public int getAccount_type_id() {
        return account_type_id;
    }

    public void setAccount_type_id(int account_type_id) {
        this.account_type_id = account_type_id;
    }

    public int getEntries() {
        return entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }

    public void update(ArrayList<entries> entriesList) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);

            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            Iterator<entries> iterator = entriesList.iterator();

            String query = "update " + DataBase.DBTableEnum.ENTRIES.getTableName() + " set entries=? where account_type_id=?";
            statement = connection.prepareStatement(query);
            while (iterator.hasNext()) {
                entries entry = iterator.next();
                statement.setInt(constants.Constant.INTEGER_ONE, entry.getEntries());

                statement.setInt(constants.Constant.INTEGER_TWO, entry.getAccount_type_id());
                statement.addBatch();

            }
            statement.executeBatch();
            connection.close();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        } finally {
            connection.close();
        }
    }

    public ArrayList<entries> get() throws Exception {
        ArrayList<entries> entriesList = new ArrayList<entries>();
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select * from " + DataBase.DBTableEnum.ENTRIES.getTableName() + " order by account_type_id";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entries entry = new entries();
                entry.setAccount_type_id(resultSet.getInt("account_type_id"));
                entry.setEntries(resultSet.getInt("entries"));
                entriesList.add(entry);
            }

            return entriesList;
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            connection.close();
        }

    }

    public int getEntryForAccount() throws Exception {
        int result = 0;
        Connection connection = null;
        try {
            Class.forName(DataBase.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(DataBase.DBConstant.CONNECTION_STRING, DataBase.DBConstant.SCHEMA_NAME, DataBase.DBConstant.SCHEMA_PASSWORD);
            String query = "select entries from " + DataBase.DBTableEnum.ENTRIES.getTableName() + " where account_type_id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(constants.Constant.INTEGER_ONE, this.getAccount_type_id());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt(constants.Constant.INTEGER_ONE);
            }
            return result;
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constants.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
            return 0;
        } finally {
            connection.close();
        }
    }

}
