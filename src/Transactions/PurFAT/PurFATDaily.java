/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transactions.PurFAT;


import Transactions.SaleFAT.*;
import java.awt.Color;
import java.awt.Component;


import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author bansal
 */
public class PurFATDaily extends javax.swing.JInternalFrame implements CellEditorListener{
  
static Date current_date=null;
static String group_name=null;
static int gid=0;
static int account_typeid=0;
static ArrayList<Dao.accounts> accounts_list=new ArrayList<Dao.accounts>();
int no_of_accounts=0;
    /**
     * Creates new form SaleFatSnf
     */
    public PurFATDaily(String gname,int gid1,int acc_typeid,JDesktopPane d,int no_of_accounts ) throws Exception {    
    
        current_date=new Date();
        this.no_of_accounts=no_of_accounts;
        initComponents();
        this.setTitle("Purchase Fat Daily Transaction");
        label_group_name.setText(gname);
        group_name=gname;
        gid=gid1;
        account_typeid=acc_typeid;

        table.getDefaultEditor(String.class).addCellEditorListener(this);
        fillTable();
         d.add(this);
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
        label_group_name = new javax.swing.JLabel();
        date = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){

            public boolean isCellEditable(int row,int column) {
                if(column==4||column==5||column==0||column ==9||column==10||column==11) // specify this depending upon ur requirement. Here the cell 2,3 is not editable.
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
        sum_mor_milk_l = new javax.swing.JLabel();
        sum_mor_ghee_l = new javax.swing.JLabel();
        sum_mor_ammount_l = new javax.swing.JLabel();
        Update = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        sum_eve_ammount_l = new javax.swing.JLabel();
        sum_eve_ghee_l = new javax.swing.JLabel();
        sum_eve_milk_l = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));
        jPanel1.setForeground(new java.awt.Color(255, 228, 192));

        label_group_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_group_name.setText("ACCOUNT_NAME");

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        date.setDate(new Date());

        Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
            row[i]=new Object[]{"","","","","","","","","","",""};
        }
        table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            row,
            new String [] {
                "Name","MMilk","FAT","FAT Rate","Ghee","Ammount","EMilk","FAT","FAT Rate","Ghee","Ammount","Total Ammount"
            }
        ));
        table.setShowGrid(true);
        table.setCellSelectionEnabled(true);
        for(int i=0;i<table.getRowCount();i++){
            table.setRowHeight(30);
        }
        table.setSelectionBackground(new java.awt.Color(255, 228, 196));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
        table.getColumnModel().getColumn(0).setMinWidth(200);
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

        sum_mor_milk_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_mor_milk_l.setText("TOTAL MILK-MOR:0");

        sum_mor_ghee_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_mor_ghee_l.setText("TOTAL GHEE-MOR:0");

        sum_mor_ammount_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_mor_ammount_l.setText("TOTAL AMMOUNT-MOR:0");

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        exit1.setText("Exit");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        sum_eve_ammount_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_eve_ammount_l.setText("TOTAL AMMOUNT-EVE:0");

        sum_eve_ghee_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_eve_ghee_l.setText("TOTAL GHEE-EVE:0");

        sum_eve_milk_l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_eve_milk_l.setText("TOTAL MILK-EVE:0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sum_mor_milk_l, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(sum_eve_milk_l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sum_mor_ghee_l, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(sum_eve_ghee_l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sum_mor_ammount_l, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                            .addComponent(sum_eve_ammount_l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 281, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(Update)
                .addGap(18, 18, 18)
                .addComponent(exit1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sum_mor_ghee_l, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sum_mor_milk_l, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sum_mor_ammount_l, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sum_eve_milk_l, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sum_eve_ghee_l, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sum_eve_ammount_l, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(exit1))
                .addContainerGap(82, Short.MAX_VALUE))
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

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
            sum_mor_milk_l.setText("TOTAL MILK-MOR:"+0);
            sum_mor_ghee_l.setText("TOTAL GHEE-MOR:"+0);
            sum_mor_ammount_l.setText("TOTAL AMMOUNT-MOR:"+0);
            sum_eve_ghee_l.setText("TOTAL GHEE-EVE:"+0);
            sum_eve_ammount_l.setText("TOTAL AMMOUNT-EVE:"+0);
            sum_eve_milk_l.setText("TOTAL MILK-EVE:"+0);
        
       
        try {
            current_date=date.getDate();

            Object row[][]=new Object[no_of_accounts][];

            for(int i=0;i<no_of_accounts;i++){
                row[i]=new Object[]{"","","","","","","","","","","",""};
                
            }
            table.setModel(new javax.swing.table.DefaultTableModel(
                row,
                new String [] {
                    "Name","MMilk","FAT","FAT RATE","Ghee","Ammount","EMILK","FAT","FAT RATE","GHEE","Ammount","Total AMMOUNT"
                }
            ));

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
for(int i=0;i<table.getColumnCount();i++){
table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
table.getColumnModel().getColumn(0).setMinWidth(200);
            
            fillTable();
        }catch(Exception e){e.printStackTrace();}
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {

            if(evt.getActionCommand().equals("Update")){
                int rows=table.getRowCount();
                ArrayList<Dao.pur_fat_transactions> entries=new ArrayList<Dao.pur_fat_transactions>();
                PurFAT.saved_enteries.clear();
                PurFAT.new_enteries.clear();

                for(int i=0;i<rows ;i++){
                    Dao.pur_fat_transactions aaa=new Dao.pur_fat_transactions();
                    aaa.setAid(accounts_list.get(i).getAid());
                    aaa.setGid(gid);
                    
                    SimpleDateFormat std=new SimpleDateFormat("dd-MMM-yyyy");
                    
                    aaa.setTdate(new java.sql.Date(date.getDate().getTime()));
                   

                    try{
                        if(((String)table.getValueAt(i, 1)).equals(""))
                        aaa.setMor_milk(0.0f);
                        else aaa.setMor_milk(Float.parseFloat((String)table.getValueAt(i, 1)));
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        aaa.setMor_milk(0);
                    }

                    try{
                        if(((String)table.getValueAt(i, 2)).equals(""))
                        aaa.setMor_fat(0.0f);
                        else
                        aaa.setMor_fat(Float.parseFloat((String)table.getValueAt(i, 2)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setMor_fat(0);
                    }

                    try{
                        if(((String)table.getValueAt(i, 3)).equals(""))
                        aaa.setMor_fat_rate(0.0f);
                        else
                        aaa.setMor_fat_rate(Float.parseFloat((String)table.getValueAt(i, 3)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setMor_fat_rate(0);
                    }

                    try{
                        if(((String)table.getValueAt(i, 4)).equals(""))
                        aaa.setMor_ghee(0.0f);
                        else
                        aaa.setMor_ghee(Float.parseFloat((String)table.getValueAt(i, 4)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setMor_ghee(0);
                    }

                    try{
                        if(((String)table.getValueAt(i, 5)).equals(""))
                        aaa.setMor_ammount(0.0f);
                        else
                        aaa.setMor_ammount(Float.parseFloat((String)table.getValueAt(i, 5)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setMor_ammount(0);
                    }

                    try{
                        if(((String)table.getValueAt(i, 6)).equals(""))
                        aaa.setEve_milk(0.0f);
                        else
                        aaa.setEve_milk(Float.parseFloat((String)table.getValueAt(i, 6)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setEve_milk(0);
                    }

                    try{
                        if(((String)table.getValueAt(i, 7)).equals(""))
                        aaa.setEve_fat(0.0f);
                        else
                        aaa.setEve_fat(Float.parseFloat((String)table.getValueAt(i, 7)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setEve_fat(0);
                    }

                    try{
                        if(((String)table.getValueAt(i, 8)).equals(""))
                        aaa.setEve_fat_rate(0.0f);
                        else
                        aaa.setEve_fat_rate(Float.parseFloat((String)table.getValueAt(i, 8)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setEve_fat_rate(0);
                    }

                    try{
                        if((table.getValueAt(i, 9)+"").equals(""))
                        aaa.setEve_ghee(0.0f);
                        else
                        {
                            if(table.getValueAt(i, 9) instanceof String)
                            aaa.setEve_ghee(Float.parseFloat((String)table.getValueAt(i, 9)));
                            else
                            aaa.setEve_ghee((float)table.getValueAt(i, 9));
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setEve_ghee(0.0f);
                    }

                    try{
                        if(((String)table.getValueAt(i, 10)).equals(""))
                        aaa.setEve_ammount(0.0f);
                        else
                        aaa.setEve_ammount(Float.parseFloat((String)table.getValueAt(i, 10)));
                    }catch(Exception e){
                        e.printStackTrace();
                        aaa.setEve_ammount(0);
                    }

                    try{
                        if((table.getValueAt(i, 11)+"").equals(""))
                        aaa.setTotal_ammount(0.0f);
                        else
                        {
                            if(table.getValueAt(i, 11) instanceof String)
                            aaa.setTotal_ammount(Float.parseFloat((String)table.getValueAt(i, 11)));
                            else
                            aaa.setTotal_ammount((float)table.getValueAt(i, 11));
                        }

                    }catch(Exception e) {
                        e.printStackTrace();
                        aaa.setTotal_ammount(0);
                    }
                    entries.add(aaa);

                    /////
                    ////

                }
                Dao.pur_fat_transactions.divide_into_saved_N_new(entries);

                Dao.pur_fat_transactions.update(PurFAT.saved_enteries);
                Dao.pur_fat_transactions.save(PurFAT.new_enteries);
                setLabels();
                JOptionPane.showMessageDialog(null, "Data Saved!!");
            }

            setLabels();
        }catch(Exception e){e.printStackTrace();}
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exit1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Update;
    private org.jdesktop.swingx.JXDatePicker date;
    private javax.swing.JButton exit1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel label_group_name;
    private javax.swing.JLabel sum_eve_ammount_l;
    private javax.swing.JLabel sum_eve_ghee_l;
    private javax.swing.JLabel sum_eve_milk_l;
    private javax.swing.JLabel sum_mor_ammount_l;
    private javax.swing.JLabel sum_mor_ghee_l;
    private javax.swing.JLabel sum_mor_milk_l;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    @Override
    public void editingStopped(ChangeEvent e) {
   
    String mor_milk=(String)table.getValueAt(table.getSelectedRow(), 1);
    String mor_fat=(String)table.getValueAt(table.getSelectedRow(), 2);
    String mor_fat_rate=(String)table.getValueAt(table.getSelectedRow(), 3);
    
    String eve_milk=(String)table.getValueAt(table.getSelectedRow(), 6);
    String eve_fat=(String)table.getValueAt(table.getSelectedRow(), 7);
    String eve_fat_rate=(String)table.getValueAt(table.getSelectedRow(), 8);
    

    float m_milk=0;
    float m_fat=0;
    float m_fat_rate=0;
    float e_milk=0;
    float e_fat=0;
    float e_fat_rate=0;
    float rec=0;
    int i=0;
    try{
    if(mor_milk.equals(""))m_milk=0;
    else 
    m_milk=Float.parseFloat(mor_milk);
    }catch(Exception e1){
    m_milk=0;
    table.setValueAt("", table.getSelectedRow(), 1);
    }
    
    try{
    if(eve_milk.equals(""))e_milk=0;
    else 
    e_milk=Float.parseFloat(eve_milk);
    }
    catch(Exception e2){
      e_milk=0;
      table.setValueAt("", table.getSelectedRow(), 6);
    }
    
    
    try{
    if(mor_fat.equals(""))m_fat=0;
    else 
    m_fat=Float.parseFloat(mor_fat);
    }catch(Exception e1){
        m_fat=0;
   table.setValueAt("", table.getSelectedRow(), 2);
    }
    
    try{
    if(eve_fat.equals(""))e_fat=0;
    else 
    e_fat=Float.parseFloat(eve_fat);
    }
    catch(Exception e2){
      e_fat=0;
      table.setValueAt("", table.getSelectedRow(), 7);
    }
    
    
    try{
    if(mor_fat_rate.equals(""))m_fat_rate=0;
    else 
    m_fat_rate=Float.parseFloat(mor_fat_rate);
    }catch(Exception e1){
   m_fat_rate=0;
   table.setValueAt("", table.getSelectedRow(), 3);
    }
    
    try{
    if(eve_fat_rate.equals(""))e_fat_rate=0;
    else 
    e_fat_rate=Float.parseFloat(eve_fat_rate);
    }
    catch(Exception e2){
     e_fat_rate=0;
     table.setValueAt("", table.getSelectedRow(), 8);
    }
    
    
    
    
  
    DecimalFormat df=new DecimalFormat("##.##");
    
    table.setValueAt(df.format((m_milk*m_fat)/1000), table.getSelectedRow(), 4);
    table.setValueAt(df.format((e_fat*e_milk)/1000), table.getSelectedRow(), 9); 
   
    
    table.setValueAt(df.format((m_milk*m_fat*m_fat_rate)/100), table.getSelectedRow(), 5);
    table.setValueAt(df.format(((e_fat*e_milk*e_fat_rate))/100), table.getSelectedRow(), 10); 
    float amm=(((m_milk*m_fat*m_fat_rate)/100)+((e_fat*e_milk*e_fat_rate))/100);
   table.setValueAt(df.format(amm), table.getSelectedRow(), 11);
    
    int r=table.getRowCount();
    
    
    float sum_mor_milk=0;
    for(i=0;i<r;i++){
    try{    if(((String)table.getValueAt(i, 1)).equals(""))
            sum_mor_milk+=0;
        else
    sum_mor_milk+=Float.parseFloat((String)table.getValueAt(i, 1));    
    }catch(Exception ee){sum_mor_milk+=0;
        
    }}
    
    
    float sum_eve_milk=0;
    for(i=0;i<r;i++){
    try{    if(((String)table.getValueAt(i, 6)).equals(""))
            sum_eve_milk+=0;
        else
    sum_eve_milk+=Float.parseFloat((String)table.getValueAt(i, 6));    
    }catch(Exception ee){sum_eve_milk+=0;
        
    }}
    
    
    float sum_mor_ghee=0;
       for(i=0;i<r;i++){
  try{ if(((String)table.getValueAt(i, 4)).equals(""))
            sum_mor_ghee+=0;
        else
    sum_mor_ghee+=Float.parseFloat((String)table.getValueAt(i, 4)); 
  }catch(Exception ea){sum_mor_ghee+=0;
      
  }}
    
   float sum_eve_ghee=0;
       for(i=0;i<r;i++){
  try{ if(((String)table.getValueAt(i, 9)).equals(""))
            sum_eve_ghee+=0;
        else
    sum_eve_ghee+=Float.parseFloat((String)table.getValueAt(i, 9)); 
  }catch(Exception ea){sum_eve_ghee+=0;
      
  }}
    
    
       float sum_mor_ammount=0;
       for(i=0;i<r;i++){
  try{ if(((String)table.getValueAt(i, 5)).equals(""))
            sum_mor_ammount+=0;
        else
    sum_mor_ammount+=Float.parseFloat((String)table.getValueAt(i, 5)); 
  }catch(Exception ea){sum_mor_ammount+=0;
      
  }}
    
   float sum_eve_ammount=0;
       for(i=0;i<r;i++){
  try{ if(((String)table.getValueAt(i, 10)).equals(""))
            sum_eve_ammount+=0;
        else
    sum_eve_ammount+=Float.parseFloat((String)table.getValueAt(i, 10)); 
  }catch(Exception ea){sum_eve_ammount+=0;
      
  }}
    
       
       
   
    
    
    
    sum_mor_milk_l.setText("TOTAL MILK-MOR:"+df.format(sum_mor_milk));
    sum_eve_milk_l.setText("TOTAL MILK-EVE:"+df.format(sum_eve_milk));
    sum_mor_ghee_l.setText("TOTAL GHEE-MOR:"+df.format(sum_mor_ghee));
    sum_eve_ghee_l.setText("TOTAL GHEE-EVE:"+df.format(sum_eve_ghee));
    sum_mor_ammount_l.setText("TOTAL AMMOUNT-MOR:"+df.format(sum_mor_ammount));
    sum_eve_ammount_l.setText("TOTAL AMMOUNT-EVE:"+df.format(sum_eve_ammount));
           
           }
    
    
   
    

    


    

    private void fillTable() throws SQLException, ParseException {
       
    Dao.accounts acc=new Dao.accounts();
   acc.setAccount_typeid(account_typeid);
    acc.setGid(gid);
    accounts_list=acc.get_All_Accounts_under_group_N_Account_Type();
    
    Iterator<Dao.accounts> iterator=accounts_list.iterator();
    int j=0;
    double milk=0,ghee=0,receive=0,ammount=0;
    
    DecimalFormat df = new DecimalFormat("##.##");
    while(iterator.hasNext()){
          acc=iterator.next();
       table.setValueAt(acc.getAname(), j, 0); 
         Dao.pur_fat_transactions trans=new Dao.pur_fat_transactions();
      trans.setGid(gid);
      
      trans.setAid(acc.getAid());
       trans.setTdate(new java.sql.Date(date.getDate().getTime()));
      trans=trans.getTransaction_aname_gname_date_given();
     if(trans!=null){
          
        milk=trans.getMor_milk();table.setValueAt((trans.getMor_milk()!=0.0)?df.format(trans.getMor_milk())+"":"", j, 1);
        float fat=trans.getMor_fat();table.setValueAt((trans.getMor_fat()!=0.0)?df.format(fat)+"":"", j, 2);
        fat=trans.getMor_fat_rate();table.setValueAt((trans.getMor_fat_rate()!=0.0)?df.format(fat)+"":"", j, 3);
        fat=trans.getMor_ghee();table.setValueAt((trans.getMor_ghee()!=0.0)?df.format(fat)+"":"", j, 4);
         fat=trans.getMor_ammount();table.setValueAt((trans.getMor_ammount()!=0.0)?df.format(fat)+"":"", j, 5);
        fat=trans.getEve_milk();table.setValueAt((trans.getEve_milk()!=0.0)?df.format(fat)+"":"", j, 6);
        
        fat=trans.getEve_fat();table.setValueAt((trans.getEve_fat()!=0.0)?df.format(fat)+"":"", j, 7);
        fat=trans.getEve_fat_rate();table.setValueAt((trans.getEve_fat_rate()!=0.0)?df.format(fat)+"":"", j, 8);
        fat=trans.getEve_ghee();table.setValueAt((trans.getEve_ghee()!=0.0)?df.format(fat)+"":"", j, 9);
        fat=trans.getEve_ammount();table.setValueAt((trans.getEve_ammount()!=0.0)?df.format(trans.getEve_ammount())+"":"", j, 10);
        fat=trans.getTotal_ammount();table.setValueAt((trans.getTotal_ammount()!=0.0)?df.format(trans.getTotal_ammount())+"":"", j, 11);
     }
     else{
        table.setValueAt("", j, 1);
        table.setValueAt("", j, 2);
        table.setValueAt("", j, 3);
        table.setValueAt("", j, 4);
        table.setValueAt("", j, 5);
        table.setValueAt("", j, 6);
        table.setValueAt("", j, 7);
        table.setValueAt("", j, 8);
        table.setValueAt("", j, 9);
        table.setValueAt("", j, 10);
        table.setValueAt("", j, 11); 
     }
      j++;
      
    }
setLabels();
    
    
    
    
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
      
    public void setLabels(){
        float mor_milk=0;
        float eve_milk=0;
        float mor_ghee=0;
        float eve_ghee=0;
        float mor_ammount=0;
        float eve_ammount=0;
        
        
        for(int i=0;i<table.getRowCount();i++){
            
            ///
            try {
                if(table.getValueAt(i, 1).equals(""))
               mor_milk+=0;
                else
                    mor_milk+=Float.parseFloat((String)table.getValueAt(i, 1));
               }catch(Exception e){
                   mor_milk+=0;
               }
            ///
            ///
            try {
                if(table.getValueAt(i, 6).equals(""))
               eve_milk+=0;
                else
                    eve_milk+=Float.parseFloat((String)table.getValueAt(i, 6));
               }catch(Exception e){
                   eve_milk+=0;
               }
            ///
            
             ///
            try {
                if(table.getValueAt(i, 4).equals(""))
                  mor_ghee+=0;
                else{
                       if(table.getValueAt(i, 4) instanceof Float)
                           mor_ghee+=(float)table.getValueAt(i, 4);
                       else
                       mor_ghee+=Float.parseFloat((String)table.getValueAt(i, 4));
                }}catch(Exception e){
                   e.printStackTrace();
                   mor_ghee+=0;
               }
            ///
            try {
                if(table.getValueAt(i, 9).equals(""))
                  eve_ghee+=0;
                else{
                       if(table.getValueAt(i, 9) instanceof Float)
                           eve_ghee+=(float)table.getValueAt(i, 9);
                       else
                       eve_ghee+=Float.parseFloat((String)table.getValueAt(i, 9));
                }}catch(Exception e){
                   e.printStackTrace();
                   eve_ghee+=0;
               }
            
            
            try {
                if(table.getValueAt(i, 5).equals(""))
                   mor_ammount+=0;
                else
                    mor_ammount+=Float.parseFloat((String)table.getValueAt(i, 5));
               }catch(Exception e){
                   mor_ammount+=0;
               }
            ///
            
            try {
                if(table.getValueAt(i, 10).equals(""))
                   eve_ammount+=0;
                else
                    eve_ammount+=Float.parseFloat((String)table.getValueAt(i, 10));
               }catch(Exception e){
                   eve_ammount+=0;
               }
            ///
            
            
            DecimalFormat df=new DecimalFormat("##.##");
            sum_mor_milk_l.setText("TOTAL MILK-MOR:"+df.format(mor_milk));
            sum_mor_ghee_l.setText("TOTAL GHEE-MOR:"+df.format(mor_ghee));
            sum_mor_ammount_l.setText("TOTAL AMMOUNT-MOR:"+df.format(mor_ammount));
            sum_eve_ghee_l.setText("TOTAL GHEE-EVE:"+df.format(eve_ghee));
            sum_eve_ammount_l.setText("TOTAL AMMOUNT-EVE:"+df.format(eve_ammount));
            sum_eve_milk_l.setText("TOTAL MILK-EVE:"+df.format(eve_milk));
        }
}
}
