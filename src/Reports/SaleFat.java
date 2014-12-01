/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Enum.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gagandeepbansal
 */
public class SaleFat {

    public SaleFat(int gid, String start_date, String end_date, ArrayList<Dao.accounts> accs) {

        try {
            Connection connection = null;
            Class.forName(constant.DBConstant.DRIVER_NAME);
            connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            HashMap parameter = new HashMap();
            parameter.put("GID", gid);
            parameter.put("START_DATE", start_date);
            parameter.put("END_DATE", end_date);

            for (int index = 0; index < accs.size(); index++) {
                parameter.put("AID", accs.get(index).getAid());

                JasperDesign jasDesign = JRXmlLoader.load(new File(constant.Constant.DOT).getCanonicalPath() + ReportEnum.SALE_FAT.getReportName());
                JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);

                JasperPrint Print = JasperFillManager.fillReport(jasReport, parameter, connection);
                JasperViewer.viewReport(Print, false);
                connection.close();
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), constant.ErrorType.DATABASE_ERROR, JOptionPane.ERROR_MESSAGE);
        }

    }
}
