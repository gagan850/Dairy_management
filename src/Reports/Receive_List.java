/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reports;


import Add.AddNChangeRate;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author bansal
 */
public class Receive_List extends javax.swing.JInternalFrame {
  public static ArrayList<Beans.groups> group_list=new ArrayList<Beans.groups>();  
  public static ArrayList<Beans.accounts> account_list=new ArrayList<Beans.accounts>();      
       


static int no_of_accounts=0;
    /**
     * Creates new form SaleFatSnf
     */
    public Receive_List(JDesktopPane d) throws Exception {    
    try{
       
        initComponents();
                this.setTitle("Receive List");
         fill_group_name_list();
       
         d.add(this);}
    catch(Exception e){
        e.printStackTrace();
    }
    
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker3 = new org.jdesktop.swingx.JXDatePicker();
        jPanel1 = new javax.swing.JPanel();
        label_group_name = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        g_list = new java.awt.Choice();
        GROUP = new java.awt.Label();
        print = new javax.swing.JButton();
        e_date = new org.jdesktop.swingx.JXDatePicker();
        start_date = new java.awt.Label();
        end_date = new java.awt.Label();
        s_date = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

        label_group_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_group_name.setText("RECEIVE LIST");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        g_list.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        g_list.setForeground(new java.awt.Color(102, 102, 102));
        g_list.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                g_listItemStateChanged(evt);
            }
        });

        GROUP.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        GROUP.setText("Group");

        print.setText("Receive List");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        start_date.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        start_date.setText("Start Date");

        end_date.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        end_date.setText("End Date");

        jButton1.setText("Compacted Receive List");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(g_list, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(GROUP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(print)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(e_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(exit)
                                .addGap(40, 40, 40))
                            .addComponent(jButton1))))
                .addGap(19, 160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GROUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(g_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(e_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(s_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(exit)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(print)
                    .addComponent(jButton1))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
    g_list.removeAll();

    no_of_accounts=0;
        this.dispose();
    
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void g_listItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_g_listItemStateChanged


// TODO add your handling code here:
    }//GEN-LAST:event_g_listItemStateChanged

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed

        if(s_date==null)
            JOptionPane.showMessageDialog(null, "select start date");
        else if(e_date==null) 
            JOptionPane.showMessageDialog(null, "select end date");
        else
        {
            
            
String start_d=s_date.getDate().getYear()+1900+"/"+(s_date.getDate().getMonth()+1)+"/"+s_date.getDate().getDate();
String end_d=e_date.getDate().getYear()+1900+"/"+(e_date.getDate().getMonth()+1)+"/"+e_date.getDate().getDate();
            
            
            
        
           try {
           
            File f=new File(".");
            String path=f.getCanonicalPath();
          
              String s="jdbc:oracle:thin:@localhost:1521:";
        Connection connection=DriverManager.getConnection(s,"dairy","bansal");
         String ss="select * from account_type order by account_typeid";
            HashMap parameter=new HashMap();
            parameter.put("GID",group_list.get(g_list.getSelectedIndex()).getGid());
            parameter.put("START_DATE",start_d);
            parameter.put("END_DATE",end_d);
            
              
            
            JasperDesign jasDesign = JRXmlLoader.load(new File(".").getCanonicalPath()+"\\Report\\Receive_List.jrxml");
            JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);

            JasperPrint Print=JasperFillManager.fillReport(jasReport,parameter,connection);
            JasperViewer.viewReport(Print,false);
            
                       
           
                   
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
    

            
            
            
            
            
            
            
            
            
            
        }
   // TODO add your handling code here:
    }//GEN-LAST:event_printActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(s_date==null)
            JOptionPane.showMessageDialog(null, "select start date");
        else if(e_date==null) 
            JOptionPane.showMessageDialog(null, "select end date");
        else
        {
            
            
String start_d=s_date.getDate().getYear()+1900+"/"+(s_date.getDate().getMonth()+1)+"/"+s_date.getDate().getDate();
String end_d=e_date.getDate().getYear()+1900+"/"+(e_date.getDate().getMonth()+1)+"/"+e_date.getDate().getDate();
            
            
            
        
           try {
           
            File f=new File(".");
            String path=f.getCanonicalPath();
          
              String s="jdbc:oracle:thin:@localhost:1521:";
        Connection connection=DriverManager.getConnection(s,"dairy","bansal");
            HashMap parameter=new HashMap();
          
            parameter.put("START_DATE",start_d);
            parameter.put("END_DATE",end_d);
            
              
            
            JasperDesign jasDesign = JRXmlLoader.load(new File(".").getCanonicalPath()+"\\Report\\Receive_list_compact.jrxml");
            JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);

            JasperPrint Print=JasperFillManager.fillReport(jasReport,parameter,connection);
            JasperViewer.viewReport(Print,false);
            
                       
           
                   
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }   
    

            
            
            
            
            
            
            
            
            
            
        }
   // TODO a        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label GROUP;
    private org.jdesktop.swingx.JXDatePicker e_date;
    private java.awt.Label end_date;
    private javax.swing.JButton exit;
    private static java.awt.Choice g_list;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    private static javax.swing.JLabel label_group_name;
    private javax.swing.JButton print;
    private org.jdesktop.swingx.JXDatePicker s_date;
    private java.awt.Label start_date;
    // End of variables declaration//GEN-END:variables

   
    

    
    
    
    
    
    
    
    
    
    public static void  fill_group_name_list() throws Exception{
        Beans.groups g=new Beans.groups();
        group_list=g.returnGroups();
       
        for(int i=0;i<group_list.size();i++){
            g_list.addItem(group_list.get(i).getGname());
        } 
     }
    
    
    
    
    
}
