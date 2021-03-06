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
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author gagandeepbansal
 */
public class daily_data {

    int gid;
    String gname;
    float sale_milk;
    float sale_ammount;
    float pur_milk;
    float pur_ammount;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public float getSale_milk() {
        return sale_milk;
    }

    public void setSale_milk(float sale_milk) {
        this.sale_milk = sale_milk;
    }

    public float getSale_ammount() {
        return sale_ammount;
    }

    public void setSale_ammount(float sale_ammount) {
        this.sale_ammount = sale_ammount;
    }

    public float getPur_milk() {
        return pur_milk;
    }

    public void setPur_milk(float pur_milk) {
        this.pur_milk = pur_milk;
    }

    public float getPur_ammount() {
        return pur_ammount;
    }

    public void setPur_ammount(float pur_ammount) {
        this.pur_ammount = pur_ammount;
    }

    public void createDaily_Data(ArrayList<Dao.groups> group_ids, Date date) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {

            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "delete from " + DBTableEnum.DAILY_DATA.getTableName();
            statement = connection.prepareStatement(query);
            statement.executeQuery();
            Iterator<Dao.groups> iterator = group_ids.iterator();
            while (iterator.hasNext()) {
                int id = iterator.next().getGid();
                String curr = (date.getYear() + constant.Constant.INTEGER_NINETEEN_HUNDRED) + constant.Constant.HYPHEN + (date.getMonth() + constant.Constant.INTEGER_ONE) + constant.Constant.HYPHEN + date.getDate();
                query = "select (select sum(ammount) from sale_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) samount,(select sum(mb_milk+eb_milk+ec_milk+mc_milk) from sale_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) smilk,"
                        + "(select sum(total_ammount) from sale_fat_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) sfamount,(select sum(mor_milk+eve_milk) from sale_fat_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) sfmilk,"
                        + "(select sum(total_ammount) from sale_snf_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) ssamount,(select sum(mor_milk+eve_milk) from sale_snf_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) ssmilk,"
                        + "(select sum(ammount) from purchase_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) pamount,(select sum(mb_milk+eb_milk+ec_milk+mc_milk) from purchase_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) pmilk,"
                        + "(select sum(total_ammount) from pur_fat_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) pfamount,(select sum(mor_milk+eve_milk) from pur_fat_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) pfmilk,"
                        + "(select sum(total_ammount) from pur_snf_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) psamount,(select sum(mor_milk+eve_milk) from pur_snf_transactions where tdate=to_date(?,'yyyy-mm-dd') and gid=?) psmilk "
                        + "from dual";
                statement = connection.prepareStatement(query);
                statement.setString(1, curr);
                statement.setString(3, curr);
                statement.setString(5, curr);
                statement.setString(7, curr);
                statement.setString(9, curr);
                statement.setString(11, curr);
                statement.setString(13, curr);
                statement.setString(15, curr);
                statement.setString(17, curr);
                statement.setString(19, curr);
                statement.setString(21, curr);
                statement.setString(23, curr);
                statement.setInt(2, id);
                statement.setInt(4, id);
                statement.setInt(6, id);
                statement.setInt(8, id);
                statement.setInt(10, id);
                statement.setInt(12, id);
                statement.setInt(14, id);
                statement.setInt(16, id);
                statement.setInt(18, id);
                statement.setInt(20, id);
                statement.setInt(22, id);
                statement.setInt(24, id);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    daily_data data = new daily_data();
                    data.setGid(id);
                    data.setSale_milk(rs.getFloat(2) + rs.getFloat(4) + rs.getFloat(6));
                    data.setPur_milk(rs.getFloat(8) + rs.getFloat(10) + rs.getFloat(12));
                    data.setSale_ammount(rs.getFloat(1) + rs.getFloat(3) + rs.getFloat(5));
                    data.setPur_ammount(rs.getFloat(7) + rs.getFloat(9) + rs.getFloat(11));
                    query = "insert into " + DBTableEnum.DAILY_DATA.getTableName() + " (gid,sale_milk,sale_ammount,pur_milk,pur_ammount) values(?,?,?,?,?)";
                    statement = connection.prepareStatement(query);
                    statement.setInt(1, data.getGid());
                    statement.setFloat(2, data.getSale_milk());
                    statement.setFloat(3, data.getSale_ammount());
                    statement.setFloat(4, data.getPur_milk());
                    statement.setFloat(5, data.getPur_ammount());
                    statement.executeQuery();
                }
            }

            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);

        }

    }

    private void deleteAll() {
        Connection connection;
        try {

            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            String query = "delete from " + DBTableEnum.DAILY_DATA.getTableName();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            connection.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);

        }
    }

}
