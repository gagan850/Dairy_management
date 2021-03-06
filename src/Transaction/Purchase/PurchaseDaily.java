/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transaction.Purchase;



import Dao.purchase_transactions;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
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
public class PurchaseDaily extends javax.swing.JInternalFrame implements CellEditorListener{
  
static Date current_date=null;
static int gid=0;
static int account_typeid=1;
static ArrayList<Dao.accounts> accounts_list=new ArrayList<Dao.accounts>();
int no_of_accounts=0;
    /**
     * Creates new form SaleFatSnf
     */
    public PurchaseDaily(String gname1,int gid1,int account_typeid1,JDesktopPane d,int no_of_accounts1 ) throws Exception {    
        this.no_of_accounts=no_of_accounts1;
      
        
        
        current_date=new Date();
        initComponents();
        this.setTitle("Purchase Daily Transaction");
        label_group_name.setText(gname1);
        gid=gid1;
        account_typeid=account_typeid1;
        fillAccountList();
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
                if(column==0||column==1||column ==7) // specify this depending upon ur requirement. Here the cell 2,3 is not editable.
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
            row[i]=new Object[]{"","","","","","","",""};
        }
        table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            row,
            new String [] {
                "No.","Name","MBMilk","EBMilk","MCMilk","ECMilk","Send","Ammount"
            }
        ));
        table.setShowGrid(true);
        table.setCellSelectionEnabled(true);
        for(int i=0;i<table.getRowCount();i++){
            table.setRowHeight(30);
        }
        table.getColumnModel().getColumn(1).setMinWidth(200);
        table.getColumnModel().getColumn(0).setMaxWidth(25);
        table.setSelectionBackground(new java.awt.Color(255, 228, 196));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
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
        sum_mb.setText("Total MB Milk:0");

        sum_eb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_eb.setText("Total EB Milk:0");

        sum_amm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_amm.setText("ToTal Ammount:0");

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
        sum_mc.setText("Total MC Milk:0");

        sum_ec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_ec.setText("Total EC Milk:0");

        sum_rec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sum_rec.setText("ToTal Receive:0");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sum_mb, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(sum_mc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sum_ec, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(sum_eb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sum_amm, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(sum_rec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exit)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(sum_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sum_mb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(sum_eb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exit)
                            .addComponent(save)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sum_mc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sum_ec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sum_amm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed

save.setText("Save");
sum_mb.setText("TOTAL BUFALLOW MILK-MOR:0");
sum_eb.setText("TOTAL BUFALLOW MILK-EVE:0");
sum_mc.setText("TOTAL COW MILK-MOR:0");
sum_ec.setText("TOTAL COW MILK-EVE:0");
sum_rec.setText("TOTAL SEND:0");
sum_amm.setText("TOTAL AMMOUNT:0");
    try {
      current_date=date.getDate();

Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
            row[i]=new Object[]{"","","","","","","",""};
       }
table.setModel(new javax.swing.table.DefaultTableModel(
    row,
    new String [] {
        "No.","Name","MBMilk","EBMilk","MCMILK","ECMILK","Send","Ammount"
    }
));
        table.getColumnModel().getColumn(0).setMaxWidth(25);
           table.getColumnModel().getColumn(1).setMinWidth(200);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
for(int i=0;i<table.getColumnCount();i++){
table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}

fillTable();
    }catch(Exception e){e.printStackTrace();}   
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void tablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablePropertyChange

      
// TODO add your handling code here:
    }//GEN-LAST:event_tablePropertyChange

    private void tableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusLost


        
// TODO add your handling code here:
    }//GEN-LAST:event_tableFocusLost

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    try {
        
        
        Purchase.saved_enteries.clear();
        Purchase.new_enteries.clear();
               int rows=table.getRowCount();
               ArrayList<Dao.purchase_transactions> transactions=new ArrayList<Dao.purchase_transactions>();
        
        for(int i=0;i<rows ;i++){
            Dao.purchase_transactions trans=new Dao.purchase_transactions();
            trans.setAid(accounts_list.get(i).getAid());
            trans.setGid(gid);
           
            trans.setTdate(new java.sql.Date(current_date.getTime()));
            
            try{trans.setMb_milk(Float.parseFloat((String)table.getValueAt(i, 2)));}catch(Exception e){trans.setMb_milk(0);}
            try{trans.setEb_milk(Float.parseFloat((String)table.getValueAt(i, 3)));}catch(Exception e){trans.setEb_milk(0);}
            try{trans.setMc_milk(Float.parseFloat((String)table.getValueAt(i, 4)));}catch(Exception e){trans.setMc_milk(0);}
            try{trans.setEc_milk(Float.parseFloat((String)table.getValueAt(i, 5)));}catch(Exception e){trans.setEc_milk(0);}
            try{trans.setReceive(Float.parseFloat((String)table.getValueAt(i, 6)));}catch(Exception e){trans.setReceive(0);}
              trans.setAmmount(((trans.getMb_milk()+trans.getEb_milk())*accounts_list.get(i).getAbfl_rate())+(trans.getMc_milk()+trans.getEc_milk())*accounts_list.get(i).getAcow_rate());
            
            transactions.add(trans);
        }
        Dao.purchase_transactions.divide_into_saved_N_new(transactions);
         
        Dao.purchase_transactions.save(Purchase.new_enteries);
        Dao.purchase_transactions.update(Purchase.saved_enteries);
        JOptionPane.showMessageDialog(null, "Data Saved!!");
   
    }catch(Exception e){e.printStackTrace();}
// TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker date;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel label_group_name;
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
   
        
   
    String mor_b_milk=(String)table.getValueAt(table.getSelectedRow(), 2);
    String mor_c_milk=(String)table.getValueAt(table.getSelectedRow(), 4);
    String eve_b_milk=(String)table.getValueAt(table.getSelectedRow(), 3);
    String eve_c_milk=(String)table.getValueAt(table.getSelectedRow(), 5);
    String receive_amm=(String)table.getValueAt(table.getSelectedRow(), 6);
        
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
    table.setValueAt("", table.getSelectedRow(), 2);
    }
    
    try{
    if(eve_b_milk.equals(""))bfl_milk+=0;
    else 
    bfl_milk+=Float.parseFloat(eve_b_milk);
    }
    catch(Exception e2){
      bfl_milk+=0;
      table.setValueAt("", table.getSelectedRow(), 3);
    }
    
    
    try{
    if(receive_amm.equals(""))receive+=0;
    else 
    receive+=Float.parseFloat(receive_amm);
    }
    catch(Exception e2){
      receive+=0;
      table.setValueAt("", table.getSelectedRow(), 6);
    }
    
    
    
  
      try{
    if(mor_c_milk.equals(""))cow_milk=0;
    else 
    cow_milk=Float.parseFloat(mor_c_milk);
    }catch(Exception e1){
    cow_milk=0;
    table.setValueAt("", table.getSelectedRow(), 4);
    }
    
    try{
    if(eve_c_milk.equals(""))cow_milk+=0;
    else 
    cow_milk+=Float.parseFloat(eve_c_milk);
    }
    catch(Exception e2){
      cow_milk+=0;
      table.setValueAt("", table.getSelectedRow(), 5);
    }
    
    
    
    
    
    
    Dao.accounts acc=(Dao.accounts)accounts_list.get(table.getSelectedRow());
    table.setValueAt((bfl_milk*acc.getAbfl_rate()+cow_milk*acc.getAcow_rate()), table.getSelectedRow(), 7);
    
    int r=table.getRowCount();
    
    
    
    
    float sum_mb_milk=0;
    for(i=0;i<r;i++){
    try{    if(((String)table.getValueAt(i, 2)).equals(""))
            sum_mb_milk+=0;
        else
    sum_mb_milk+=Float.parseFloat((String)table.getValueAt(i, 2));    
    }catch(Exception ee){sum_mb_milk+=0;
        
    }}
    
    float sum_eb_milk=0;
    for(i=0;i<r;i++){
  try{ if(((String)table.getValueAt(i, 3)).equals(""))
            sum_eb_milk+=0;
        else
    sum_eb_milk+=Float.parseFloat((String)table.getValueAt(i, 3)); 
  }catch(Exception ea){sum_eb_milk+=0;
      
  }}
    
    
     float sum_mc_milk=0;
    for(i=0;i<r;i++){
      try{  if(((String)table.getValueAt(i, 4)).equals(""))
            sum_mc_milk+=0;
        else
    sum_mc_milk+=Float.parseFloat((String)table.getValueAt(i, 4));    
    }catch(Exception eb){
        sum_mc_milk=0;
    }}
    
    
    
    float sum_ec_milk=0;
    for(i=0;i<r;i++){
   try{if(((String)table.getValueAt(i, 5)).equals(""))
            sum_ec_milk+=0;
        else
    sum_ec_milk+=Float.parseFloat((String)table.getValueAt(i, 5)); 
    }catch(Exception ec){sum_ec_milk+=0;
        
    }}
    
    
     float sum_receive=0;
    for(i=0;i<r;i++){
   try{if(((String)table.getValueAt(i, 6)).equals(""))
            sum_receive+=0;
        else
    sum_receive+=Float.parseFloat((String)table.getValueAt(i, 6)); 
    }catch(Exception ec){sum_receive+=0;
        
    }}
    
    
     float sum_ammount=0;
    for(i=0;i<r;i++){
     ////
        float b_m=0;
   
        try{if(((String)table.getValueAt(i, 2)).equals(""))
            b_m+=0;
        else
    b_m+=Float.parseFloat((String)table.getValueAt(i, 2)); 
    }catch(Exception ec){b_m+=0;
   }
   
   
   try{if(((String)table.getValueAt(i, 3)).equals(""))
            b_m+=0;
        else
    b_m+=Float.parseFloat((String)table.getValueAt(i, 3)); 
    }catch(Exception ec){b_m+=0;
    }
    ////
       float c_m=0;
   
        try{if(((String)table.getValueAt(i, 4)).equals(""))
            c_m+=0;
        else
    c_m+=Float.parseFloat((String)table.getValueAt(i, 4)); 
    }catch(Exception ec){c_m+=0;
   }
   
   
   try{if(((String)table.getValueAt(i, 5)).equals(""))
            c_m+=0;
        else
    c_m+=Float.parseFloat((String)table.getValueAt(i, 5)); 
    }catch(Exception ec){c_m+=0;
    }
   Dao.accounts ac=(Dao.accounts)accounts_list.get(i);
   sum_ammount+=((ac.getAbfl_rate()*b_m)+(ac.getAcow_rate()*c_m));
   
    }
    
   
   
   
    
    
    DecimalFormat df = new DecimalFormat("##.##");
    
    sum_mb.setText("TOTAL BUF MILK-MOR:"+df.format(sum_mb_milk));
    sum_eb.setText("TOTAL BUF MILK-EVE:"+df.format(sum_eb_milk));
    sum_mc.setText("TOTAL COW MILK-MOR:"+df.format(sum_mc_milk));
    sum_ec.setText("TOTAL COW MILK-EVE:"+df.format(sum_ec_milk));
    sum_rec.setText("TOTAL SEND:"+df.format(sum_receive));
    sum_amm.setText("TOTAL AMMOUNT:"+df.format(sum_ammount));        
    }
    
    
   
    

    


    

    private void fillTable() throws SQLException, ParseException {
       Dao.accounts acc=null;
    Iterator<Dao.accounts> iterator=accounts_list.iterator();
    int j=0;
    double mb=0,eb=0,mc=0,ec=0,ta=0,receive=0;
    
    DecimalFormat df = new DecimalFormat("##.##");
    while(iterator.hasNext()){
          acc=iterator.next();
       table.setValueAt((j+1), j, 0);
       table.setValueAt(acc.getAname(), j, 1); 
         purchase_transactions trans=new purchase_transactions();
      trans.setGid(gid);
      
      trans.setAid(acc.getAid());
       trans.setTdate(new java.sql.Date(date.getDate().getTime()));
      trans=trans.getTransaction_aname_gname_date_given();
     if(trans!=null){
          save.setText("Update");
        mb+=trans.getMb_milk();table.setValueAt((trans.getMb_milk()!=0.0)?df.format(trans.getMb_milk())+"":"", j, 2);
        mc+=trans.getMc_milk();table.setValueAt((trans.getMc_milk()!=0.0)?df.format(trans.getMc_milk())+"":"", j, 4);
        eb+=trans.getEb_milk();table.setValueAt((trans.getEb_milk()!=0.0)?df.format(trans.getEb_milk())+"":"", j, 3);
        ec+=trans.getEc_milk();table.setValueAt((trans.getEc_milk()!=0.0)?df.format(trans.getEc_milk())+"":"", j, 5);
        receive+=trans.getReceive();table.setValueAt((trans.getReceive()!=0.0)?df.format(trans.getReceive())+"":"", j, 6);
        ta+=trans.getAmmount();table.setValueAt((trans.getAmmount()!=0.0)?df.format(trans.getAmmount())+"":"", j, 7);
     }
     else{
        table.setValueAt("", j, 2);
        table.setValueAt("", j, 4);
        table.setValueAt("", j, 3);
        table.setValueAt("", j, 5);
        table.setValueAt("", j, 6);
        table.setValueAt("", j, 7); 
     }
      j++;
      
    }

    sum_mb.setText("TOTAL BUF MILK-MOR:"+df.format(mb));
    sum_eb.setText("TOTAL BUF MILK-EVE:"+df.format(eb));
    sum_mc.setText("TOTAL COW MILK-MOR:"+df.format(mc));
    sum_ec.setText("TOTAL COW MILK-EVE:"+df.format(ec));
    sum_rec.setText("TOTAL SEND:"+df.format(receive));
    sum_amm.setText("TOTAL AMMOUNT:"+df.format(ta));    
    
    
    
    
    
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void fillAccountList() throws Exception{
        
        Dao.accounts acc=new Dao.accounts();
        acc.setGid(gid);
        acc.setAccount_typeid(account_typeid);
        accounts_list=acc.get_All_Accounts_under_group_N_Account_Type();
        
    }
}
