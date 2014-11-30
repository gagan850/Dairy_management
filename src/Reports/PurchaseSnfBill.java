/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reports;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author bansal
 */
public class PurchaseSnfBill extends javax.swing.JInternalFrame {
  
static public ArrayList<Dao.groups> group_list=new ArrayList<Dao.groups>();
static public ArrayList<Dao.accounts> account_list=new ArrayList<Dao.accounts>();


static int no_of_accounts=0;
    /**
     * Creates new form SaleFatSnf
     */
    public PurchaseSnfBill(JDesktopPane d) throws Exception {    
    try{
       
        initComponents();
                this.setTitle("Purchase SNF Reports");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){

            public boolean isCellEditable(int row,int column) {
                if(column==1) // specify this depending upon ur requirement. Here the cell 2,3 is not editable.
                return false;
                else
                return true;
            }

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    return Boolean.class;
                    case 1:
                    return String.class;
                    default:
                    return Boolean.class;
                }
            }

        };
        exit = new javax.swing.JButton();
        glist = new java.awt.Choice();
        GROUP = new java.awt.Label();
        select_all = new javax.swing.JButton();
        deselect_all = new javax.swing.JButton();
        change = new javax.swing.JButton();
        e_date = new org.jdesktop.swingx.JXDatePicker();
        start_date = new java.awt.Label();
        end_date = new java.awt.Label();
        s_date = new org.jdesktop.swingx.JXDatePicker();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

        label_group_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_group_name.setText("PRINT");

        Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
            row[i]=new Object[]{false,"",};
        }
        table.setModel(new javax.swing.table.DefaultTableModel(
            row,
            new String [] {
                "Check","Name"
            }
        ));
        table.setShowGrid(true);
        table.setCellSelectionEnabled(true);
        table.setSelectionBackground(new java.awt.Color(255, 228, 196));
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

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        glist.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        glist.setForeground(new java.awt.Color(102, 102, 102));
        glist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glistItemStateChanged(evt);
            }
        });

        GROUP.setText("Group");

        select_all.setText("Select All");
        select_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_allActionPerformed(evt);
            }
        });

        deselect_all.setText("Deselect All");
        deselect_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselect_allActionPerformed(evt);
            }
        });

        change.setText("Print");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        start_date.setText("Start Date");

        end_date.setText("End Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(GROUP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(glist, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(select_all)
                            .addComponent(deselect_all))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(s_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(e_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(change)
                        .addGap(82, 82, 82)
                        .addComponent(exit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(GROUP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(glist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(select_all)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deselect_all)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(change)
                    .addComponent(exit))
                .addContainerGap())
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

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
    glist.removeAll();

    no_of_accounts=0;
        this.dispose();
    
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void glistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glistItemStateChanged
   try{
   
       Dao.accounts accounts=new Dao.accounts();
       accounts.setGid(group_list.get(glist.getSelectedIndex()).getGid());
       accounts.setAccount_typeid(constants.Account_type.PURCHASE_SNF);
       account_list=accounts.get_All_Accounts_under_group_N_Account_Type();
       no_of_accounts=account_list.size();
       fillTable(account_list);
   
   }catch(Exception e){
       e.printStackTrace();
       
   }

// TODO add your handling code here:
    }//GEN-LAST:event_glistItemStateChanged

    private void select_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_allActionPerformed

        
for(int i=0;i<no_of_accounts;i++){
    table.setValueAt(true, i, 0);
}


// TODO add your handling code here:
    }//GEN-LAST:event_select_allActionPerformed

    private void deselect_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselect_allActionPerformed

        for(int i=0;i<no_of_accounts;i++){
    table.setValueAt(false, i, 0);
}
// TODO add your handling code here:
    }//GEN-LAST:event_deselect_allActionPerformed

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed

        if(s_date==null)
            JOptionPane.showMessageDialog(null, "select start date");
        else if(e_date==null) 
            JOptionPane.showMessageDialog(null, "select end date");
        else
        {
            ArrayList<Dao.accounts> accs=new ArrayList<Dao.accounts>();
            for(int i=0;i<table.getRowCount();i++){
                if((Boolean)table.getValueAt(i, 0))accs.add(account_list.get(i));
            }
            
String start_d=s_date.getDate().getYear()+1900+"/"+(s_date.getDate().getMonth()+1)+"/"+s_date.getDate().getDate();
String end_d=e_date.getDate().getYear()+1900+"/"+(e_date.getDate().getMonth()+1)+"/"+e_date.getDate().getDate();
            PurchaseSnf sale_snf=new PurchaseSnf(group_list.get(glist.getSelectedIndex()).getGid(),start_d,end_d,accs);
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }
   // TODO add your handling code here:
    }//GEN-LAST:event_changeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label GROUP;
    private javax.swing.JButton change;
    private javax.swing.JButton deselect_all;
    private org.jdesktop.swingx.JXDatePicker e_date;
    private java.awt.Label end_date;
    private javax.swing.JButton exit;
    private static java.awt.Choice glist;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    private static javax.swing.JLabel label_group_name;
    private org.jdesktop.swingx.JXDatePicker s_date;
    private javax.swing.JButton select_all;
    private java.awt.Label start_date;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

   
    
    private void fillTable(ArrayList acc_list) throws SQLException, ParseException {
   
  Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
              Dao.accounts acc=(Dao.accounts)acc_list.get(i);
            row[i]=new Object[]{false,acc.getAname()};
       }
table.setModel(new javax.swing.table.DefaultTableModel(
    row,
    new String [] {
        "Check","Name"
    }
));

        
    }

    
    
    
    
    
    
    
    
    
    public static void  fill_group_name_list() throws Exception{
        Dao.groups g=new Dao.groups();
        group_list=g.returnGroups();
        for(int i=0;i<group_list.size();i++){
            glist.addItem(group_list.get(i).getGname());
        } 
     }
    
    
    
    
    
}
