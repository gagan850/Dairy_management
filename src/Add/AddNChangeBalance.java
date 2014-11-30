/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Add;

import java.awt.Color;
import java.awt.Component;
import java.text.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author bansal
 */
public class AddNChangeBalance
        extends javax.swing.JInternalFrame
        implements CellEditorListener {

    //These are the caches for groups, accounts, account_types
    static public ArrayList<Dao.groups> group_list = new ArrayList<Dao.groups>();
    static public ArrayList<Dao.accounts> account_list = new ArrayList<Dao.accounts>();
    static public ArrayList<Dao.account_type> account_type_list = new ArrayList<Dao.account_type>();

    static int gid = 0;
    static int account_typeid = 0;
    static int no_of_accounts = 0;

    /**
     * Creates new form SaleFatSnf
     */
    public AddNChangeBalance(JDesktopPane desktopPane)
            throws Exception {
        initComponents();
        this.setTitle(MessageFormat.format(constants.MessageEnum.ADD_N_CHAANGE.getMessage(), constants.Constant.BALANCE));
        fillGroupCacheNUI();
        fillAccountTypeCacheNUI();
        desktopPane.add(this);
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
                if(column==0) // specify this depending upon ur requirement. Here the cell 2,3 is not editable.
                return false;
                else
                return true;
            }

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    return String.class;
                    case 1:
                    return Integer.class;
                    default:
                    return String.class;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        glist = new javax.swing.JComboBox();
        accountTypeList = new javax.swing.JComboBox();
        save = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        label_group_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label_group_name.setText("CHANGE BALANCE");

        Object row[][]=new Object[no_of_accounts][];

        for(int i=0;i<no_of_accounts;i++){
            row[i]=new Object[]{"",0};
        }
        table.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        for(int i=0;i<table.getRowCount();i++){
            table.setRowHeight(30);
        }
        table.setModel(new javax.swing.table.DefaultTableModel(
            row,
            new String [] {
                "Name","Balance"
            }
        ));
        table.setShowGrid(true);
        table.setCellSelectionEnabled(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0;i<table.getColumnCount();i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
        table.setSelectionBackground(new java.awt.Color(255, 228, 196));
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

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Group");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Account Type");

        glist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glistActionPerformed(evt);
            }
        });

        accountTypeList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountTypeListActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addGap(207, 207, 207))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(glist, 0, 116, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(accountTypeList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label_group_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(glist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(accountTypeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(save))
                .addContainerGap(91, Short.MAX_VALUE))
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
        accountTypeList.removeAll();
        no_of_accounts = 0;
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    //It fills the table if group & acccount type is selected
    private void glistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glistActionPerformed
        if (accountTypeList.getSelectedIndex() > constants.Constant.INTEGER_MINUS_ONE && glist.getSelectedIndex() > constants.Constant.INTEGER_MINUS_ONE) {
            Dao.accounts account = new Dao.accounts();
            account.setGid(group_list.get(glist.getSelectedIndex()).getGid());
            gid = account.getGid();
            account.setAccount_typeid(account_type_list.get(accountTypeList.getSelectedIndex()).getAccount_typeid());
            account_typeid = account_type_list.get(accountTypeList.getSelectedIndex()).getAccount_typeid();
            account_list = account.get_All_Accounts_under_group_N_Account_Type();
            no_of_accounts = account_list.size();
            fillTable(account_list);
        }
    }//GEN-LAST:event_glistActionPerformed

    public int validateInt(String text) {
        if (text == null) {
            return 0;
        } else if (!text.matches("\\d*")) {
            return 0;
        } else {
            return Integer.valueOf(text);
        }
    }

    //It fills the table if group & acccount type is selected
    private void accountTypeListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountTypeListActionPerformed
        if (accountTypeList.getSelectedIndex() > constants.Constant.INTEGER_MINUS_ONE && glist.getSelectedIndex() > constants.Constant.INTEGER_ONE) {

            Dao.accounts acc = new Dao.accounts();
            acc.setGid(group_list.get(glist.getSelectedIndex()).getGid());
            gid = acc.getGid();
            acc.setAccount_typeid(account_type_list.get(accountTypeList.getSelectedIndex()).getAccount_typeid());
            account_typeid = account_type_list.get(accountTypeList.getSelectedIndex()).getAccount_typeid();
            account_list = acc.get_All_Accounts_under_group_N_Account_Type();
            no_of_accounts = account_list.size();
            fillTable(account_list);
// TODO add your handling code here:

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_accountTypeListActionPerformed

    //  It saves the balance
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        DecimalFormat df = new DecimalFormat("##.##");

        for (int index = 0; index < account_list.size(); index++) {
            ((Dao.accounts) account_list.get(index)).setAbalance((int) table.getValueAt(index, 1));

        }
        (new Dao.accounts()).update_balance(account_list);
        fillTable(account_list);

// TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accountTypeList;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox glist;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel label_group_name;
    private javax.swing.JButton save;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    //It fills the account_list's info in the table
    private void fillTable(ArrayList acc_list) {

        Object row[][] = new Object[no_of_accounts][];

        for (int index = 0; index < no_of_accounts; index++) {
            Dao.accounts account = (Dao.accounts) acc_list.get(index);
            row[index] = new Object[]{account.getAname(), account.getAbalance()};
        }
        table.setModel(new javax.swing.table.DefaultTableModel(
                row,
                new String[]{
                    "Name", "Balance",}
        ));

        table.getColumnModel().getColumn(0).setMinWidth(200);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int index = 0; index < table.getColumnCount(); index++) {
            table.getColumnModel().getColumn(index).setCellRenderer(centerRenderer);
        }
    }

    //It fills the groups cache and UI groups combo  
    public void fillGroupCacheNUI() {
        Dao.groups g = new Dao.groups();
        group_list = g.returnGroups();
        for (int index = constants.Constant.INTEGER_ZERO; index < group_list.size(); index++) {
            glist.addItem((group_list.get(index)).getGname());

        }
    }

    //It fills the account_type cache and UI combo
    private void fillAccountTypeCacheNUI() {
        account_type_list = (new Dao.account_type()).returnAccount_type();
        for (int index = constants.Constant.INTEGER_ZERO; index < account_type_list.size(); index++) {
            accountTypeList.addItem(account_type_list.get(index).getAccount_type());
        }

    }

    //It gets called at editing stopped of every cell
    @Override
    public void editingStopped(ChangeEvent e) {
        String balance = table.getValueAt(table.getSelectedRow(), 1).toString();

        table.setValueAt(validateInt(balance), table.getSelectedRow(), 1);

    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
