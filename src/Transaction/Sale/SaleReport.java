/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transaction.Sale;

import Reports.SaleBills;
import Reports.SaleList;
import Reports.SaleListPending;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDesktopPane;

/**
 *
 * @author bansal
 */
public class SaleReport extends javax.swing.JInternalFrame {
static String account_type="";
JDesktopPane d;
public static ArrayList<Dao.groups> group_list=new ArrayList<Dao.groups>();
    /**
     * Creates new form sale
     */
    public SaleReport(JDesktopPane d) {
        initComponents();
          this.setTitle("Sale Reports");
        
       fillGList();
       java.sql.Date current_date=new java.sql.Date((new Date()).getTime());
       Calendar calendar=Calendar.getInstance();
       int min=calendar.getActualMinimum(Calendar.DATE);
       int max=calendar.getActualMaximum(Calendar.DATE);
       current_date.setDate(min);
       start_date.setDate(current_date);
       current_date.setDate(max);
       end_date.setDate(current_date);
       this.d=d;
         d.add(this);
    }

    
       public static void  fillGList(){
    try{    Dao.groups g=new Dao.groups();
        group_list=g.returnGroups();
        for(int i=0;i<group_list.size();i++){
            group_name.addItem(group_list.get(i).getGname());
            
        } 
    }catch(Exception e){e.printStackTrace();
        
    }}
    
   
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        group_name = new java.awt.Choice();
        start_date = new org.jdesktop.swingx.JXDatePicker();
        end_date = new org.jdesktop.swingx.JXDatePicker();
        list = new javax.swing.JButton();
        bills = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("GROUP");

        exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        list.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        list.setText("List");
        list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listActionPerformed(evt);
            }
        });

        bills.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bills.setText("Bills");
        bills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billsActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("START DATE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("END DATE");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Pending Previous Balance");
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(list)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(bills))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(exit)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(group_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(list)
                    .addComponent(bills)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listActionPerformed

String start_d=(start_date.getDate().getYear()+1900)+"-"+(start_date.getDate().getMonth()+1)+"-"+(start_date.getDate().getDate());
String end_d=(end_date.getDate().getYear()+1900)+"-"+(end_date.getDate().getMonth()+1)+"-"+(end_date.getDate().getDate());
SaleList sale_list=new SaleList(group_list.get(group_name.getSelectedIndex()).getGid(),start_d,end_d);


// TODO add your handling code here:
    }//GEN-LAST:event_listActionPerformed

    private void billsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billsActionPerformed

String start_d=(start_date.getDate().getYear()+1900)+"-"+(start_date.getDate().getMonth()+1)+"-"+(start_date.getDate().getDate());        
String end_d=(end_date.getDate().getYear()+1900)+"-"+(end_date.getDate().getMonth()+1)+"-"+(end_date.getDate().getDate());
SaleBills sale_list=new SaleBills(group_list.get(group_name.getSelectedIndex()).getGid(),start_d,end_d);
// TODO add your handling code here:
    }//GEN-LAST:event_billsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

String end_d=(end_date.getDate().getYear()+1900)+"-"+(end_date.getDate().getMonth()+1)+"-"+(end_date.getDate().getDate());
Calendar c=Calendar.getInstance();
c.set(end_date.getDate().getYear()+1900, end_date.getDate().getMonth(), end_date.getDate().getDate());

String last_mon=(end_date.getDate().getYear()+1900)+"-"+(end_date.getDate().getMonth())+"-"+(c.getActualMaximum(c.DATE));
SaleListPending sale_list=new SaleListPending(group_list.get(group_name.getSelectedIndex()).getGid(),end_d,last_mon);

        


// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bills;
    private org.jdesktop.swingx.JXDatePicker end_date;
    private javax.swing.JButton exit;
    private static java.awt.Choice group_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton list;
    private org.jdesktop.swingx.JXDatePicker start_date;
    // End of variables declaration//GEN-END:variables
}