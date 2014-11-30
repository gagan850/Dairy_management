/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Add;


import static Add.Account.group_list;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author bansal
 */
public class AddNChangeRate extends javax.swing.JInternalFrame {
      static public ArrayList<Beans.groups> glist=new ArrayList<Beans.groups>();
    static public ArrayList<Beans.accounts> account_list=new ArrayList<Beans.accounts>();
    static public ArrayList<Beans.account_type> account_type_list=new ArrayList<Beans.account_type>();

static int gid=0;
static int account_typeid=0;

static int no_of_accounts=0;
    /**
     * Creates new form SaleFatSnf
     */
    public AddNChangeRate(JDesktopPane d) throws Exception {    
    try{
       
        initComponents();
         this.setTitle("Change Rate");
         fillGList();
         fillAccount_type();
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

        jPanel1 = new javax.swing.JPanel();
        label_group_name = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(){

            public boolean isCellEditable(int row,int column) {
                if(column==1||column==2||column==3) // specify this depending upon ur requirement. Here the cell 2,3 is not editable.
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
                    case 2:
                    return Float.class;
                    case 3:
                    return Float.class;
                    default:
                    return Boolean.class;
                }
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
        exit = new javax.swing.JButton();
        select_all = new javax.swing.JButton();
        deselect_all = new javax.swing.JButton();
        bfl_rate = new javax.swing.JTextField();
        cow_rate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        change = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        g_list = new javax.swing.JComboBox();
        aaccount_type = new javax.swing.JComboBox();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        label_group_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_group_name.setText("CHANGE RATE");

        Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
            row[i]=new Object[]{false,"",0,0};
        }
        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            row,
            new String [] {
                "Check","Name","BFL Rate","Cow Rate"
            }
        ));
        table.setShowGrid(true);
        table.setCellSelectionEnabled(true);
        for(int i=0;i<table.getRowCount();i++){
            table.setRowHeight(30);
        }
        table.setSelectionBackground(new java.awt.Color(255, 228, 196));
        table.getColumnModel().getColumn(1).setMinWidth(200);
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

        bfl_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfl_rateActionPerformed(evt);
            }
        });

        jLabel1.setText("Cow Rate");

        jLabel2.setText("BFL Rate");

        change.setText("Change");
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Group");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Account Type");

        g_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_listActionPerformed(evt);
            }
        });

        aaccount_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaccount_typeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(g_list, 0, 116, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(aaccount_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(select_all)
                            .addComponent(deselect_all))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bfl_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(cow_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exit))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(select_all)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deselect_all)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bfl_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cow_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(change)
                        .addGap(18, 18, 18)
                        .addComponent(exit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(g_list, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(aaccount_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
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
    g_list.removeAll();
    aaccount_type.removeAll();
    no_of_accounts=0;
        this.dispose();
    
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void bfl_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfl_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bfl_rateActionPerformed

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
try{
  
   DecimalFormat df=new DecimalFormat("##.##");
        
   for(int i=0;i<account_list.size();i++){
       if((boolean)table.getValueAt(i, 0)==true){
           float b_rate=Float.parseFloat(bfl_rate.getText());
           
                   float c_rate=Float.parseFloat(cow_rate.getText());
             ((Beans.accounts)account_list.get(i)).setAbfl_rate(b_rate);
             ((Beans.accounts)account_list.get(i)).setAcow_rate(c_rate);
          System.out.println(((Beans.accounts)account_list.get(i)).getAid());
       }
       
   }     

   (new Beans.accounts()).update_rates(account_list);
    fillTable(account_list);
   bfl_rate.setText("");
   cow_rate.setText("");
   
}catch(Exception e){
    e.printStackTrace();
    
}

   // TODO add your handling code here:
    }//GEN-LAST:event_changeActionPerformed

    private void g_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_listActionPerformed
if(aaccount_type.getSelectedIndex()>-1&&g_list.getSelectedIndex()>-1){
    try{
Beans.accounts acc=new Beans.accounts();
acc.setGid(group_list.get(g_list.getSelectedIndex()).getGid());
gid=acc.getGid();
acc.setAccount_typeid(account_type_list.get(aaccount_type.getSelectedIndex()).getAccount_typeid());
account_typeid=account_type_list.get(aaccount_type.getSelectedIndex()).getAccount_typeid();
account_list=acc.get_All_Accounts_under_group_N_Account_Type();
no_of_accounts=account_list.size();
        fillTable(account_list);
// TODO add your handling code here:
}catch(Exception e){e.printStackTrace();
    
}
}
    }//GEN-LAST:event_g_listActionPerformed

    private void aaccount_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaccount_typeActionPerformed
if(aaccount_type.getSelectedIndex()>-1&&g_list.getSelectedIndex()>-1){
    try{
Beans.accounts acc=new Beans.accounts();
acc.setGid(group_list.get(g_list.getSelectedIndex()).getGid());
gid=acc.getGid();
acc.setAccount_typeid(account_type_list.get(aaccount_type.getSelectedIndex()).getAccount_typeid());
account_typeid=account_type_list.get(aaccount_type.getSelectedIndex()).getAccount_typeid();
account_list=acc.get_All_Accounts_under_group_N_Account_Type();
no_of_accounts=account_list.size();
        fillTable(account_list);
// TODO add your handling code here:
}catch(Exception e){e.printStackTrace();
    
}
}
        


// TODO add your handling code here:
    }//GEN-LAST:event_aaccount_typeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox aaccount_type;
    private javax.swing.JTextField bfl_rate;
    private javax.swing.JButton change;
    private javax.swing.JTextField cow_rate;
    private javax.swing.JButton deselect_all;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox g_list;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel label_group_name;
    private javax.swing.JButton select_all;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

   
    
    private void fillTable(ArrayList acc_list) throws SQLException, ParseException {
   
  Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
              Beans.accounts acc=(Beans.accounts)acc_list.get(i);
            row[i]=new Object[]{false,acc.getAname(),acc.getAbfl_rate(),acc.getAcow_rate()};
       }
table.setModel(new javax.swing.table.DefaultTableModel(
    row,
    new String [] {
        "Check","Name","BFL Rate","Cow Rate"
    }
));
table.getColumnModel().getColumn(1).setMinWidth(200);
        
    }

    
    
     
    public void  fillGList(){
     try{   Beans.groups g=new Beans.groups();
        group_list=g.returnGroups();
        for(int i=0;i<group_list.size();i++){
            g_list.addItem((group_list.get(i)).getGname());
           
        } 
     }catch(Exception e){e.printStackTrace() ;
         
     }}
    
   
    
     private void fillAccount_type() {
         account_type_list=(new Beans.account_type()).returnAccount_type();
     for(int i=0;i<account_type_list.size();i++){
         aaccount_type.addItem(account_type_list.get(i).getAccount_type());
     }
     
     }
    
    
    
}
