/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transaction.Sale;
import Dao.sale_transactions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
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
public class SaleDaily extends javax.swing.JInternalFrame implements CellEditorListener{
  
static Date current_date=null;
static int gid=0;
static int account_typeid=1;
static ArrayList<Dao.accounts> accounts_list=new ArrayList<Dao.accounts>();
int no_of_accounts=0;
static int total_balance=0;
static String gname=null;
    /**
     * Creates new form SaleFatSnf
     */
    public SaleDaily(String gname1,int gid1,int account_typeid1,JDesktopPane d,int no_of_accounts1 ) throws Exception {    
        this.no_of_accounts=no_of_accounts1;
      
        
        
        current_date=new Date();
        initComponents();
        table.setAutoscrolls(true);
        this.setTitle("Sale Daily Transaction");
        label_group_name.setText(gname1);
        gid=gid1;
        gname=gname1;
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
                if(column==0||column==1||column==2||column ==9) // specify this depending upon ur requirement. Here the cell 2,3 is not editable.
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
        jLabel2 = new javax.swing.JLabel();
        receive_by_l = new javax.swing.JTextField();
        total_balance_l = new javax.swing.JLabel();
        receive_by = new java.awt.Choice();
        searchName = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        sale_miss = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

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
            row[i]=new Object[]{"","","","","","","","","",""};
        }
        table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            row,
            new String [] {
                "No.","Name","Balance","MBMilk","EBMilk","MCMilk","ECMilk","Receive","Receive_by","Ammount"
            }
        ));
        table.setShowGrid(true);
        table.setCellSelectionEnabled(true);
        for(int i=0;i<table.getRowCount();i++){
            table.setRowHeight(30);
        }
        TableColumn column=table.getColumnModel().getColumn(8);
        try{
            JComboBox comboBox=new JComboBox();
            ArrayList<Dao.employees> emps=(new Dao.employees()).returnEmployees();
            for(int i=0;i<emps.size();i++){
                comboBox.addItem(emps.get(i).getEname());
                receive_by.addItem(emps.get(i).getEname());

            }

            table.getColumnModel().getColumn(1).setMinWidth(200);
            column.setCellEditor(new DefaultCellEditor(comboBox));
        }catch(Exception e){e.printStackTrace();

        }
        table.setSelectionBackground(new java.awt.Color(255, 228, 196));
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            if(i==8)continue;
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}

        DefaultTableCellRenderer columnColorRenderer = new DefaultTableCellRenderer();
        columnColorRenderer.setForeground(Color.BLUE);
        table.getColumnModel().getColumn(2).setCellRenderer(columnColorRenderer);
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
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        sum_mb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sum_mb.setForeground(new java.awt.Color(255, 0, 0));
        sum_mb.setText("TOTAL BUFFALOW MILK-MOR:0");

        sum_eb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sum_eb.setForeground(new java.awt.Color(255, 0, 0));
        sum_eb.setText("TOTAL BUFFALOW MILK-EVE:0");

        sum_amm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sum_amm.setForeground(new java.awt.Color(255, 0, 0));
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

        sum_mc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sum_mc.setForeground(new java.awt.Color(255, 0, 0));
        sum_mc.setText("TOTAL COW MILK-MOR:0");

        sum_ec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sum_ec.setForeground(new java.awt.Color(255, 0, 0));
        sum_ec.setText("TOTAL COW MILK-EVE:0");

        sum_rec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sum_rec.setForeground(new java.awt.Color(255, 0, 0));
        sum_rec.setText("TOTAL RECEIVE:0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Recive By:");

        receive_by_l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receive_by_lActionPerformed(evt);
            }
        });

        total_balance_l.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_balance_l.setForeground(new java.awt.Color(0, 0, 255));
        total_balance_l.setText("TOTAL BALANCE:0");

        receive_by.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                receive_byItemStateChanged(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        sale_miss.setText("Sale Miss");
        sale_miss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_missActionPerformed(evt);
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
                        .addGap(142, 142, 142)
                        .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(searchName, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sum_mc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sum_mb, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sum_ec, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sum_eb, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sum_amm, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sum_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(total_balance_l, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save)
                                .addGap(31, 31, 31)
                                .addComponent(exit)
                                .addGap(158, 158, 158)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(receive_by_l, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(receive_by, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sale_miss)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(sum_rec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sum_mc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sum_ec, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sum_amm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(total_balance_l, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(exit)
                                    .addComponent(save))
                                .addContainerGap(123, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sale_miss)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sum_mb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sum_eb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(7, 7, 7)
                                .addComponent(receive_by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receive_by_l, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(137, Short.MAX_VALUE))))
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


sum_mb.setText("TOTAL BUF MILK-MOR:0");
sum_eb.setText("TOTAL BUF MILK-EVE:0");
sum_mc.setText("TOTAL COW MILK-MOR:0");
sum_ec.setText("TOTAL COW MILK-EVE:0");
sum_rec.setText("TOTAL RECEIVE:0");
sum_amm.setText("TOTAL AMMOUNT:0");

      current_date=date.getDate();

Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
            row[i]=new Object[]{"","","","","","","","","",""};
       }
table.setModel(new javax.swing.table.DefaultTableModel(
    row,
    new String [] {
        "No.","Name","Balance","MBMilk","EBMilk","MCMILK","ECMILK","Receive","Receive_by","Ammount"
    }
));
try{     TableColumn column=table.getColumnModel().getColumn(8);
           JComboBox comboBox=new JComboBox();
            ArrayList<Dao.employees> emps=(new Dao.employees()).returnEmployees();
            comboBox.removeAll();
            receive_by.removeAll();
            for(int i=0;i<emps.size();i++){
                
                comboBox.addItem(emps.get(i).getEname());
                
                receive_by.addItem(emps.get(i).getEname());
            }
            column.setCellEditor(new DefaultCellEditor(comboBox));
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
for(int i=0;i<table.getColumnCount();i++){
if(i==8)continue;
table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}

DefaultTableCellRenderer columnColorRenderer = new DefaultTableCellRenderer();
columnColorRenderer.setForeground(Color.BLUE);
table.getColumnModel().getColumn(2).setCellRenderer(columnColorRenderer);

  table.getColumnModel().getColumn(0).setMaxWidth(40);
  table.getColumnModel().getColumn(1).setMinWidth(200);
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
        Sale.new_enteries.clear();
        Sale.saved_enteries.clear();
        
        
               int rows=table.getRowCount();
               ArrayList<Dao.sale_transactions> transactions=new ArrayList<Dao.sale_transactions>();
        
        for(int i=0;i<rows ;i++){
            Dao.sale_transactions trans=new Dao.sale_transactions();
            trans.setAid(accounts_list.get(i).getAid());
            trans.setGid(gid);
           
            trans.setTdate(new java.sql.Date(current_date.getTime()));
            
            try{trans.setMb_milk(Float.parseFloat((String)table.getValueAt(i, 3)));}catch(Exception e){trans.setMb_milk(0);}
            try{trans.setEb_milk(Float.parseFloat((String)table.getValueAt(i, 4)));}catch(Exception e){trans.setEb_milk(0);}
            try{trans.setMc_milk(Float.parseFloat((String)table.getValueAt(i, 5)));}catch(Exception e){trans.setMc_milk(0);}
             try{trans.setEc_milk(Float.parseFloat((String)table.getValueAt(i, 6)));}catch(Exception e){trans.setEc_milk(0);}
              try{trans.setReceive(Float.parseFloat((String)table.getValueAt(i, 7)));}catch(Exception e){trans.setReceive(0);}
              try{trans.setReceive_by((String)table.getValueAt(i, 8));}catch(Exception e){trans.setReceive_by("");}
              trans.setAmmount(((trans.getMb_milk()+trans.getEb_milk())*accounts_list.get(i).getAbfl_rate())+(trans.getMc_milk()+trans.getEc_milk())*accounts_list.get(i).getAcow_rate());
            
            transactions.add(trans);
        }
        Dao.sale_transactions.divide_into_saved_N_new(transactions);
         
        Dao.sale_transactions.save(Sale.new_enteries);
        Dao.sale_transactions.update(Sale.saved_enteries);
        JOptionPane.showMessageDialog(null, "Data Saved!!");
   
    }catch(Exception e){e.printStackTrace();}
// TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void receive_by_lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receive_by_lActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receive_by_lActionPerformed

    private void receive_byItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_receive_byItemStateChanged
  try{
            Dao.sale_transactions aa=new Dao.sale_transactions();
            Calendar calendar=Calendar.getInstance();
            SimpleDateFormat std=new SimpleDateFormat("dd-MMM-yyyy");
            Date d=std.parse(date.getDate().getDate()+"-"+Transaction.Cal.month(date.getDate().getMonth()+1)+"-"+(date.getDate().getYear()+1900));
            java.sql.Date d1=new java.sql.Date(d.getTime());
            System.out.println("aaa"+d1);
            int amm=aa.getAmmountReceive_by(gid, d1, (String)receive_by.getSelectedItem());
            receive_by_l.setText(amm+"");
            // System.out.println(gid+" "+new java.sql.Date(date.getDate().getTime())+" "+receive_by.getSelectedItem());
        }catch(Exception e){e.printStackTrace();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_receive_byItemStateChanged

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
String searchText=searchName.getText().trim();
  for(int i=0;i<table.getRowCount();i++){
      if(((String)table.getValueAt(i, 1)).equals(searchText))
         
          scrollToVisible(table, i, 1);
          table.repaint();
  }      


// TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void sale_missActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_missActionPerformed

        
        
         
        
        try {
            Class.forName(constant.DBConstant.DRIVER_NAME);
            Connection connection = DriverManager.getConnection(constant.DBConstant.CONNECTION_STRING, constant.DBConstant.SCHEMA_NAME, constant.DBConstant.SCHEMA_PASSWORD);
            JasperDesign jasDesign = JRXmlLoader.load(new File(".").getCanonicalPath()+"\\Report\\sale_miss.jrxml");
            JasperReport jasReport = JasperCompileManager.compileReport(jasDesign);
         
            HashMap parameter=new HashMap();
            parameter.put("GID",SaleDaily.gid);
            parameter.put("TDATE",SaleDaily.date.getDate().getDate()+constant.Constant.HYPHEN+(SaleDaily.date.getDate().getMonth()+1)+constant.Constant.HYPHEN+(SaleDaily.date.getDate().getYear()+constant.Constant.INTEGER_NINETEEN_HUNDRED));
            parameter.put("GNAME",SaleDaily.gname);
            JasperPrint Print=JasperFillManager.fillReport(jasReport,parameter,connection);
            JasperViewer.viewReport(Print,false);
           
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }   
    

        


// TODO add your handling code here:
    }//GEN-LAST:event_sale_missActionPerformed

    
    public static void scrollToVisible(JTable table, int rowIndex, int vColIndex)
{
    if (!(table.getParent() instanceof JViewport)) return;
    JViewport viewport = (JViewport)table.getParent();
    Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);
    Point pt = viewport.getViewPosition();
    rect.setLocation(rect.x-pt.x, rect.y-pt.y);
    viewport.scrollRectToVisible(rect);
}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static org.jdesktop.swingx.JXDatePicker date;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel label_group_name;
    private java.awt.Choice receive_by;
    private javax.swing.JTextField receive_by_l;
    private javax.swing.JButton sale_miss;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchName;
    private javax.swing.JLabel sum_amm;
    private javax.swing.JLabel sum_eb;
    private javax.swing.JLabel sum_ec;
    private javax.swing.JLabel sum_mb;
    private javax.swing.JLabel sum_mc;
    private javax.swing.JLabel sum_rec;
    private javax.swing.JTable table;
    private javax.swing.JLabel total_balance_l;
    // End of variables declaration//GEN-END:variables

    @Override
    public void editingStopped(ChangeEvent e) {
   
        
   
    String mor_b_milk=(String)table.getValueAt(table.getSelectedRow(), 3);
    String mor_c_milk=(String)table.getValueAt(table.getSelectedRow(), 5);
    String eve_b_milk=(String)table.getValueAt(table.getSelectedRow(), 4);
    String eve_c_milk=(String)table.getValueAt(table.getSelectedRow(), 6);
    String receive_amm=(String)table.getValueAt(table.getSelectedRow(), 7);
        
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
    table.setValueAt("", table.getSelectedRow(), 3);
    }
    
    try{
    if(eve_b_milk.equals(""))bfl_milk+=0;
    else 
    bfl_milk+=Float.parseFloat(eve_b_milk);
    }
    catch(Exception e2){
      bfl_milk+=0;
      table.setValueAt("", table.getSelectedRow(), 4);
    }
    
    
    try{
    if(receive_amm.equals(""))receive+=0;
    else 
    receive+=Float.parseFloat(receive_amm);
    }
    catch(Exception e2){
      receive+=0;
      table.setValueAt("", table.getSelectedRow(), 7);
    }
    
    
    
  
      try{
    if(mor_c_milk.equals(""))cow_milk=0;
    else 
    cow_milk=Float.parseFloat(mor_c_milk);
    }catch(Exception e1){
    cow_milk=0;
    table.setValueAt("", table.getSelectedRow(), 5);
    }
    
    try{
    if(eve_c_milk.equals(""))cow_milk+=0;
    else 
    cow_milk+=Float.parseFloat(eve_c_milk);
    }
    catch(Exception e2){
      cow_milk+=0;
      table.setValueAt("", table.getSelectedRow(), 6);
    }
    
    
    
    
    
    
    Dao.accounts acc=(Dao.accounts)accounts_list.get(table.getSelectedRow());
    table.setValueAt((bfl_milk*acc.getAbfl_rate()+cow_milk*acc.getAcow_rate()), table.getSelectedRow(), 9);
    
    int r=table.getRowCount();
    
    
    
    
    float sum_mb_milk=0;
    for(i=0;i<r;i++){
    try{    if(((String)table.getValueAt(i, 3)).equals(""))
            sum_mb_milk+=0;
        else
    sum_mb_milk+=Float.parseFloat((String)table.getValueAt(i, 3));    
    }catch(Exception ee){sum_mb_milk+=0;
        
    }}
    
    float sum_eb_milk=0;
    for(i=0;i<r;i++){
  try{ if(((String)table.getValueAt(i, 4)).equals(""))
            sum_eb_milk+=0;
        else
    sum_eb_milk+=Float.parseFloat((String)table.getValueAt(i, 4)); 
  }catch(Exception ea){sum_eb_milk+=0;
      
  }}
    
    
     float sum_mc_milk=0;
    for(i=0;i<r;i++){
      try{  if(((String)table.getValueAt(i, 5)).equals(""))
            sum_mc_milk+=0;
        else
    sum_mc_milk+=Float.parseFloat((String)table.getValueAt(i, 5));    
    }catch(Exception eb){
        sum_mc_milk=0;
    }}
    
    
    
    float sum_ec_milk=0;
    for(i=0;i<r;i++){
   try{if(((String)table.getValueAt(i, 6)).equals(""))
            sum_ec_milk+=0;
        else
    sum_ec_milk+=Float.parseFloat((String)table.getValueAt(i, 6)); 
    }catch(Exception ec){sum_ec_milk+=0;
        
    }}
    
    
     float sum_receive=0;
    for(i=0;i<r;i++){
   try{if(((String)table.getValueAt(i, 7)).equals(""))
            sum_receive+=0;
        else
    sum_receive+=Float.parseFloat((String)table.getValueAt(i, 7)); 
    }catch(Exception ec){sum_receive+=0;
        
    }}
    
    
     float sum_ammount=0;
    for(i=0;i<r;i++){
     ////
        float b_m=0;
   
        try{if(((String)table.getValueAt(i, 3)).equals(""))
            b_m+=0;
        else
    b_m+=Float.parseFloat((String)table.getValueAt(i, 3)); 
    }catch(Exception ec){b_m+=0;
   }
   
   
   try{if(((String)table.getValueAt(i, 4)).equals(""))
            b_m+=0;
        else
    b_m+=Float.parseFloat((String)table.getValueAt(i, 4)); 
    }catch(Exception ec){b_m+=0;
    }
    ////
       float c_m=0;
   
        try{if(((String)table.getValueAt(i, 5)).equals(""))
            c_m+=0;
        else
    c_m+=Float.parseFloat((String)table.getValueAt(i, 5)); 
    }catch(Exception ec){c_m+=0;
   }
   
   
   try{if(((String)table.getValueAt(i, 6)).equals(""))
            c_m+=0;
        else
    c_m+=Float.parseFloat((String)table.getValueAt(i, 6)); 
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
    sum_rec.setText("TOTAL RECEIVE:"+df.format(sum_receive));
    sum_amm.setText("TOTAL AMMOUNT:"+df.format(sum_ammount));        
    }
    
    
   
    

    


    

    private void fillTable() throws Exception, ParseException {
     total_balance=0;
        Dao.accounts acc=null;
    Iterator<Dao.accounts> iterator1=accounts_list.iterator();
    int j=0;
    double mb=0,eb=0,mc=0,ec=0,ta=0,receive=0;
    
    DecimalFormat df = new DecimalFormat("##.##");
    ArrayList<Integer> Balance=Dao.sale_transactions.getTransactionBalance_aname_gname_date_given1(accounts_list,new java.sql.Date(date.getDate().getTime()),new java.sql.Date(date.getDate().getTime()));
    ArrayList<sale_transactions> trans=new ArrayList<sale_transactions>();
    while(iterator1.hasNext()){
        acc=iterator1.next();
        sale_transactions s=new sale_transactions();
        s.setGid(gid);
        s.setAid(acc.getAid());
        s.setTdate(new java.sql.Date(date.getDate().getTime()));
        trans.add(s);
    }
    trans=(new sale_transactions()).getTransaction_aname_gname_date_given(trans);
    
    Iterator<sale_transactions> iterator=trans.iterator();
    
    for(int i=0;i<accounts_list.size();i++){
            table.setValueAt((i+1), i, 0);
            table.setValueAt( accounts_list.get(i).getAname() , i, 1);
          table.setValueAt(Balance.get(i), i, 2);
          total_balance+=Balance.get(i);
    
    }
    
    while(iterator.hasNext()){
     sale_transactions tran=new sale_transactions();
        
        tran=iterator.next();
     
        
     if(tran!=null){
          save.setText("Update");
        mb+=tran.getMb_milk();table.setValueAt((tran.getMb_milk()!=0.0)?df.format(tran.getMb_milk())+"":"", j, 3);
        mc+=tran.getMc_milk();table.setValueAt((tran.getMc_milk()!=0.0)?df.format(tran.getMc_milk())+"":"", j, 5);
        eb+=tran.getEb_milk();table.setValueAt((tran.getEb_milk()!=0.0)?df.format(tran.getEb_milk())+"":"", j, 4);
        ec+=tran.getEc_milk();table.setValueAt((tran.getEc_milk()!=0.0)?df.format(tran.getEc_milk())+"":"", j, 6);
        receive+=tran.getReceive();table.setValueAt((tran.getReceive()!=0.0)?df.format(tran.getReceive())+"":"", j, 7);
        table.setValueAt(tran.getReceive_by(), j, 8);
        ta+=tran.getAmmount();table.setValueAt((tran.getAmmount()!=0.0)?df.format(tran.getAmmount())+"":"", j, 9);
     }
     /* IF there is no entry for that account on that particular 
     date in sale_transaction table , which implies th
     is is a new account, so all the data should be 0*/ 
     
     else{
        table.setValueAt("", j, 3);
        table.setValueAt("", j, 5);
        table.setValueAt("", j, 4);
        table.setValueAt("", j, 6);
        table.setValueAt("", j, 7);
        table.setValueAt("", j, 8);
        table.setValueAt("", j, 9); 
     }
      j++;
      
    }

    sum_mb.setText("TOTAL BUF MILK-MOR:"+df.format(mb));
    sum_eb.setText("TOTAL BUF MILK-EVE:"+df.format(eb));
    sum_mc.setText("TOTAL COW MILK-MOR:"+df.format(mc));
    sum_ec.setText("TOTAL COW MILK-EVE:"+df.format(ec));
    sum_rec.setText("TOTAL RECEIVE:"+df.format(receive));
    sum_amm.setText("TOTAL AMMOUNT:"+df.format(ta));    
    total_balance_l.setText("TOTAL BALANCE:"+total_balance);    
    
    
    
    
    
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
