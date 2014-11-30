/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reports;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
public class PurchaseFat {
    
    
     public PurchaseFat(int gid,String start_date,String end_date,ArrayList<Beans.accounts> accs) {

        
           try {
         String s="jdbc:oracle:thin:@localhost:1521:";
        Connection connection=DriverManager.getConnection(s,"dairy","bansal");
         String ss="select * from account_type order by account_typeid";
            File f=new File(".");
            String path=f.getCanonicalPath();
          
              
            HashMap parameter=new HashMap();
            parameter.put("GID",gid);
            parameter.put("START_DATE",start_date);
            parameter.put("END_DATE",end_date);
            
            for(int i=0;i<accs.size();i++){
                parameter.put("AID",accs.get(i).getAid());    
            
            JasperDesign jasDesign = JRXmlLoader.load(new File(".").getCanonicalPath()+"\\Report\\purchase_fat.jrxml");
            JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);

            JasperPrint Print=JasperFillManager.fillReport(jasReport,parameter,connection);
            JasperViewer.viewReport(Print,false);
            
            }
            
           
                   
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
    
}}
