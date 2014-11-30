/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transactions.Sale;

import Transactions.*;
import Dao.sale_transactions;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author bansal
 */
public class SaleMonthly extends javax.swing.JInternalFrame implements CellEditorListener{

static Date dd=null;
static int gid=0;
static String qaname=null;
static int account_typeid=0;
static String aid="";
static double cow_milk_rate=0;
static double bfl_milk_rate=0;
Dao.accounts selectedAccount=new Dao.accounts();

    /**
     * Creates new form SaleFatSnf
     */
    public SaleMonthly(Dao.accounts account,Date dt,JDesktopPane d ) throws SQLException, ParseException {    
        
        dd=dt;
        initComponents();
        selectedAccount=account;
          this.setTitle("Sale Monthly Transaction");
         this.aname.setText(account.getAname());
         gid=account.getGid();
         aid=account.getAid();
        this.account_typeid=account.getAccount_typeid();
        this.qaname=account.getAname();

        cow_milk_rate=account.getAcow_rate();
        bfl_milk_rate=account.getAbfl_rate();
        table.getDefaultEditor(String.class).addCellEditorListener(this);
        fillTable();
        d.add(this);
        
        System.out.println(account.getGid());
        System.out.println(account.getAid());
        System.out.println(account.getAname());
        System.out.println(account.getAaddress());
        System.out.println(account.getAccount_typeid());
        System.out.println(account.getAbalance());
        System.out.println(account.getAbfl_rate());
        System.out.println(account.getAcow_rate());
        
        
        
    /*    String header[]={"Date","MorMilk","EveMilk","Ammount"};
        
        Object row[][]=new Object[30][];
        for(int i=0;i<30;i++){
            row[i]=new Object[]{new Date()+"","","",""};
       }
        DefaultTableModel dtm=new DefaultTableModel(row,header);
        JTable table=new JTable(dtm);
        table.setVisible(true);
        
        table.setBounds(50, 50, 400, 400);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aname = new javax.swing.JLabel();
        date = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){

            public boolean isCellEditable(int row,int column) {
                if(column==0||column ==7) // specify this depending upon ur requirement. Here the cell 2,3 is not editable.
                return false;
                else
                return true;
            }

            public Component prepareRenderer
            (TableCellRenderer renderer,int Index_row, int Index_col) {
                Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
                //even index, selected or not selected
                if (Index_row % 2 != 0 && !isCellSelected(Index_row, Index_col)) {
                    comp.setBackground(new Color(255, 228, 196));
                }
                else {
                    comp.setBackground(Color.white);
                }
                return comp;
            }

        };
        sum_mb = new javax.swing.JLabel();
        sum_eb = new javax.swing.JLabel();
        sum_amm = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        sum_mc = new javax.swing.JLabel();
        sum_ec = new javax.swing.JLabel();
        sum_rec = new javax.swing.JLabel();
        e_date = new org.jdesktop.swingx.JXDatePicker();
        s_date = new org.jdesktop.swingx.JXDatePicker();
        report = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));
        jPanel1.setForeground(new java.awt.Color(255, 228, 192));

        aname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aname.setText("GROUP_NAME");

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        date.setDate(dd);
        java.util.Date d=date.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, d.getYear());
        calendar.set(Calendar.MONTH, d.getMonth());
        int numDays = calendar.getActualMaximum(Calendar.DATE);
        System.out.println("###############Days in month:"+numDays);
        Object row[][]=new Object[numDays][];

        for(int i=0;i<numDays;i++){
            row[i]=new Object[]{(i+1)+"-"+Cal.month(d.getMonth()+1),"","","","","","",""};
        }
        table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            row,
            new String [] {
                "Date","MBMilk","EBMilk","MCMilk","ECMilk","Receive","Receive_by","Ammount"
            }
        ));
        TableColumn column=table.getColumnModel().getColumn(6);

        try{JComboBox comboBox=new JComboBox();
            ArrayList<Dao.employees> emps=(new Dao.employees()).returnEmployees();
            for(int i=0;i<emps.size();i++){
                comboBox.addItem(emps.get(i).getEname());

            }
            column.setCellEditor(new DefaultCellEditor(comboBox));
        }catch(Exception e){e.printStackTrace();

        }

        table.setShowGrid(true);
        table.setCellSelectionEnabled(true);
        for(int i=0;i<table.getRowCount();i++){
            table.setRowHeight(30);
        }
        table.setSelectionBackground(new java.awt.Color(255, 228, 196));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            if(i==6)continue;
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
        table.getColumnModel().getColumn(0).setMaxWidth(70);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocusLost(evt);
            }
        });
        table.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        sum_mb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_mb.setText("TOTAL BUFFALOW MILK-MORNING:0");

        sum_eb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_eb.setText("TOTAL BUFFALOW MILK-EVENING:0");

        sum_amm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_amm.setText("TOTAL AMMOUNT:0");

        save.setText("Update");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        sum_mc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_mc.setText("TOTAL COW MILK-MORNING:0");

        sum_ec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_ec.setText("TOTAL COE MILK-EVENING:0");

        sum_rec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_rec.setText("TOTAL RECEIVE:0");

        e_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_dateActionPerformed(evt);
            }
        });

        s_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_dateActionPerformed(evt);
            }
        });

        report.setText("Report");
        report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(aname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sum_mb, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sum_mc, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sum_eb, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sum_ec, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sum_rec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sum_amm, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(save)
                .addGap(58, 58, 58)
                .addComponent(s_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(e_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(report)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sum_eb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sum_mb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sum_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sum_mc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sum_ec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sum_amm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(s_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(report)
                    .addComponent(exit)
                    .addComponent(e_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
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

    private void tablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablePropertyChange

      
// TODO add your handling code here:
    }//GEN-LAST:event_tablePropertyChange

    private void tableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusLost


        
// TODO add your handling code here:
    }//GEN-LAST:event_tableFocusLost

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    try {
        
            int rows=table.getRowCount();
            ArrayList<Dao.sale_transactions> entries=new ArrayList<Dao.sale_transactions>();
            Sale.saved_enteries.clear();
            Sale.new_enteries.clear();
       
        for(int i=0;i<rows ;i++){
            Dao.sale_transactions aaa=new Dao.sale_transactions();
            aaa.setAid(aid);
            aaa.setGid(gid);
            String year=(date.getDate().getYear()+1900)+"";
            SimpleDateFormat std=new SimpleDateFormat("dd-MMM-yyyy");
            Date d=std.parse((String)table.getValueAt(i, 0)+"-"+year);
            java.sql.Date d1=new java.sql.Date(d.getTime());
            aaa.setTdate(d1);
            
            try{aaa.setMb_milk(Float.parseFloat((String)table.getValueAt(i, 1)));}catch(Exception e){aaa.setMb_milk(0);}
            try{aaa.setEb_milk(Float.parseFloat((String)table.getValueAt(i, 2)));}catch(Exception e){aaa.setEb_milk(0);}
            try{aaa.setMc_milk(Float.parseFloat((String)table.getValueAt(i, 3)));}catch(Exception e){aaa.setMc_milk(0);}
             try{aaa.setEc_milk(Float.parseFloat((String)table.getValueAt(i, 4)));}catch(Exception e){aaa.setEc_milk(0);}
              try{aaa.setReceive(Float.parseFloat((String)table.getValueAt(i, 5)));}catch(Exception e){aaa.setReceive(0);}
            try{aaa.setReceive_by(((String)table.getValueAt(i, 6)));}catch(Exception e){aaa.setReceive_by("");}
            aaa.setAmmount(((aaa.getMb_milk()+aaa.getEb_milk())*bfl_milk_rate)+(aaa.getMc_milk()+aaa.getEc_milk())*cow_milk_rate);
            entries.add(aaa);
            
        }
            Dao.sale_transactions.divide_into_saved_N_new(entries);
           
            Dao.sale_transactions.update(Sale.saved_enteries);
            Dao.sale_transactions.save(Sale.new_enteries);
            JOptionPane.showMessageDialog(null, "Data Saved!!");
    
    }catch(Exception e){e.printStackTrace();}

    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        sum_mb.setText("Total MB Milk:0");
        sum_eb.setText("Total EB Milk:0");
        sum_mc.setText("Total MC Milk:0");
        sum_ec.setText("Total EC Milk:0");
        sum_rec.setText("Total Receive:0");
        sum_amm.setText("Total Ammount:0");
        try {
            java.util.Date d=date.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, d.getYear());
            calendar.set(Calendar.MONTH, d.getMonth());
            int numDays = calendar.getActualMaximum(Calendar.DATE);
            Object row[][]=new Object[numDays][];

            for(int i=0;i<numDays;i++){
                row[i]=new Object[]{(i+1)+"-"+Cal.month(d.getMonth()+1),"","","","","","",""};
            }
            table.setModel(new javax.swing.table.DefaultTableModel(
                row,
                new String [] {
                    "Date","MBMilk","EBMilk","MCMILK","ECMILK","Receive","Receive_by","Ammount"
                }
            ));
            
            TableColumn column=table.getColumnModel().getColumn(6);
            try{
           JComboBox comboBox=new JComboBox();
            ArrayList<Dao.employees> emps=(new Dao.employees()).returnEmployees();
            for(int i=0;i<emps.size();i++){
                comboBox.addItem(emps.get(i).getEname());
            }
            column.setCellEditor(new DefaultCellEditor(comboBox)); 
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for(int i=0;i<table.getColumnCount();i++){
            if(i==6)continue;
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
            table.getColumnModel().getColumn(0).setMaxWidth(70);
            }catch(Exception e){e.printStackTrace();
                
            }
        

            fillTable();
        }catch(Exception e){e.printStackTrace();}
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void e_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_dateActionPerformed

    private void s_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_dateActionPerformed

    private void reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportActionPerformed

 ArrayList<Dao.accounts> accs=new ArrayList<Dao.accounts>();
        accs.add(selectedAccount);
        String start_d=s_date.getDate().getYear()+1900+"/"+(s_date.getDate().getMonth()+1)+"/"+s_date.getDate().getDate();
        String end_d=e_date.getDate().getYear()+1900+"/"+(e_date.getDate().getMonth()+1)+"/"+e_date.getDate().getDate();
        Reports.SaleMonthly sale_mon=new Reports.SaleMonthly(gid,start_d,end_d,accs);
        System.out.println(start_d);
System.out.println(end_d);
System.out.println(selectedAccount.getAid());
System.out.println(gid);

// TODO add your handling code here:
    }//GEN-LAST:event_reportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel aname;
    private org.jdesktop.swingx.JXDatePicker date;
    private org.jdesktop.swingx.JXDatePicker e_date;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton report;
    private org.jdesktop.swingx.JXDatePicker s_date;
    private javax.swing.JButton save;
    private javax.swing.JLabel sum_amm;
    private javax.swing.JLabel sum_eb;
    private javax.swing.JLabel sum_ec;
    private javax.swing.JLabel sum_mb;
    private javax.swing.JLabel sum_mc;
    private javax.swing.JLabel sum_rec;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void editingStopped(ChangeEvent e) {
    
    String mor_b_milk=(String)table.getValueAt(table.getSelectedRow(), 1);
    String mor_c_milk=(String)table.getValueAt(table.getSelectedRow(), 3);
    String eve_b_milk=(String)table.getValueAt(table.getSelectedRow(), 2);
    String eve_c_milk=(String)table.getValueAt(table.getSelectedRow(), 4);
    String receive_amm=(String)table.getValueAt(table.getSelectedRow(), 5);
        
    float bfl_milk=0;
    float cow_milk=0;
    float receive=0;
    int i=0;
    try{
    if(mor_b_milk.equals(""))bfl_milk=0;
    else 
    bfl_milk=Float.parseFloat(mor_b_milk);
    }catch(Exception e1){
    bfl_milk=0;
    table.setValueAt("", table.getSelectedRow(), 1);
    }
    
    try{
    if(eve_b_milk.equals(""))bfl_milk+=0;
    else 
    bfl_milk+=Float.parseFloat(eve_b_milk);
    }
    catch(Exception e2){
      bfl_milk+=0;
      table.setValueAt("", table.getSelectedRow(), 2);
    }
    
    
    try{
    if(receive_amm.equals(""))receive+=0;
    else 
    receive+=Float.parseFloat(receive_amm);
    }
    catch(Exception e2){
      receive+=0;
      table.setValueAt("", table.getSelectedRow(), 5);
    }
    
    
    
  
      try{
    if(mor_c_milk.equals(""))cow_milk=0;
    else 
    cow_milk=Float.parseFloat(mor_c_milk);
    }catch(Exception e1){
    cow_milk=0;
    table.setValueAt("", table.getSelectedRow(), 3);
    }
    
    try{
    if(eve_c_milk.equals(""))cow_milk+=0;
    else 
    cow_milk+=Float.parseFloat(eve_c_milk);
    }
    catch(Exception e2){
      cow_milk+=0;
      table.setValueAt("", table.getSelectedRow(), 4);
    }
    
    
    
    
    
    
    
    table.setValueAt((bfl_milk*bfl_milk_rate+cow_milk*cow_milk_rate), table.getSelectedRow(), 7);
    
    int r=table.getRowCount();
    
    float sum_mb_milk=0;
    for(i=0;i<r;i++){
    try{    if(((String)table.getValueAt(i, 1)).equals(""))
            sum_mb_milk+=0;
        else
    sum_mb_milk+=Float.parseFloat((String)table.getValueAt(i, 1));    
    }catch(Exception ee){sum_mb_milk+=0;
        
    }}
    
    float sum_eb_milk=0;
    for(i=0;i<r;i++){
  try{ if(((String)table.getValueAt(i, 2)).equals(""))
            sum_eb_milk+=0;
        else
    sum_eb_milk+=Float.parseFloat((String)table.getValueAt(i, 2)); 
  }catch(Exception ea){sum_eb_milk+=0;
      
  }}
    
    
     float sum_mc_milk=0;
    for(i=0;i<r;i++){
      try{  if(((String)table.getValueAt(i, 3)).equals(""))
            sum_mc_milk+=0;
        else
    sum_mc_milk+=Float.parseFloat((String)table.getValueAt(i, 3));    
    }catch(Exception eb){
        sum_mc_milk=0;
    }}
    
    
    
    float sum_ec_milk=0;
    for(i=0;i<r;i++){
   try{if(((String)table.getValueAt(i, 4)).equals(""))
            sum_ec_milk+=0;
        else
    sum_ec_milk+=Float.parseFloat((String)table.getValueAt(i, 4)); 
    }catch(Exception ec){sum_ec_milk+=0;
        
    }}
    
    
     float sum_receive=0;
    for(i=0;i<r;i++){
   try{if(((String)table.getValueAt(i, 5)).equals(""))
            sum_receive+=0;
        else
    sum_receive+=Float.parseFloat((String)table.getValueAt(i, 5)); 
    }catch(Exception ec){sum_receive+=0;
        
    }}
    
    
    double sum_ammount=((sum_mb_milk+sum_eb_milk)*bfl_milk_rate)+((sum_mc_milk+sum_ec_milk)*cow_milk_rate); 
    
    
     DecimalFormat df = new DecimalFormat("##.##");
    sum_mb.setText("TOTAL BUF MILK-MOR:"+df.format(sum_mb_milk));
    sum_eb.setText("TOTAL BUF MILK-EVE:"+df.format(sum_eb_milk));
    sum_mc.setText("TOTAL COW MILK-MOR:"+df.format(sum_mc_milk));
    sum_ec.setText("TOTAL COW MILK-EVE:"+df.format(sum_ec_milk));
    sum_rec.setText("TOTAL RECEIVE:"+df.format(sum_receive));
    sum_amm.setText("TOTAL AMMOUNT:"+df.format(sum_ammount));        
  }
    
    
   
    

    


    

    private void fillTable() throws SQLException, ParseException {
           sale_transactions a=new sale_transactions();
    a.setAid(aid);
    a.setGid(gid);
    
    SimpleDateFormat std=new SimpleDateFormat("dd-MMM-yyyy");
    
      String ss=date.getDate().getDate()+"-"+Cal.month(date.getDate().getMonth()+1)+"-"+(date.getDate().getYear()+1900)+"";
   
    java.sql.Date d=new java.sql.Date(std.parse(ss).getTime());
    a.setTdate(d);
    ArrayList<sale_transactions> aa=a.get();
    Iterator<sale_transactions> aaa=aa.iterator();
    int i=0;
    double mb=0,eb=0,mc=0,ec=0,ta=0,receive=0;

 DecimalFormat df = new DecimalFormat("##.##");
    while(aaa.hasNext()){
        
        sale_transactions aaaa=aaa.next();
        int date=aaaa.getTdate().getDate()-1;
                Double dd= aaaa.getMb_milk();
        mb+=dd;  
        table.setValueAt((dd==0)?"":df.format(dd), date, 1);
        
        dd= aaaa.getMc_milk();
        mc+=dd;  
        table.setValueAt((dd==0)?"":df.format(dd), date, 3);
        
        dd= aaaa.getEb_milk();
        eb+=dd;
        table.setValueAt((dd==0)?"":df.format(dd), date, 2);
        
        dd= aaaa.getEc_milk();
        ec+=dd;
        table.setValueAt((dd==0)?"":df.format(dd), date, 4);
                dd=aaaa.getReceive();
        receive+=dd;
        table.setValueAt((dd==0)?"":df.format(dd), date, 5);
        
        
        table.setValueAt(aaaa.getReceive_by(), date, 6);
        
        
        dd=aaaa.getAmmount();
        ta+=dd;
        table.setValueAt((dd==0)?"":df.format(dd), date, 7); 
    i++;    
        
    }
    
    
    
    
    sum_mb.setText("TOTAL BUF MILK-MOR:"+df.format(mb));
    sum_eb.setText("TOTAL BUF MILK-EVE:"+df.format(eb));
    sum_mc.setText("TOTAL COW MILK-MOR:"+df.format(mc));
    sum_ec.setText("TOTAL COW MILK-EVE:"+df.format(ec));
    sum_rec.setText("TOTAL RECEIVE:"+df.format(receive));
    sum_amm.setText("TOTAL AMMOUNT:"+df.format(ta));    
    
    
    
    
   }

    @Override
    public void editingCanceled(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
