/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Add;


import Enum.*;
import java.text.*;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author gagandeepbansal
 */ 
public class ArrangeAccounts extends javax.swing.JInternalFrame {
    //Caches for groups,accounts,accountTypes
    static public ArrayList<Dao.groups> group_list=new ArrayList<Dao.groups>();
    static public ArrayList<Dao.accounts> account_list=new ArrayList<Dao.accounts>();
    static public ArrayList<Dao.account_type> account_type_list=new ArrayList<Dao.account_type>();
   
    public ArrangeAccounts(JDesktopPane desktopPane) {
    initComponents();
    this.setTitle(MessageFormat.format(MessageEnum.ARRANGE.getMessage(), constant.Constant.ACCOUNT));
    fillGroupCacheNUI();
    fillAccountTypeCacheNUI();
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    final_account_list.setVisible(true);
    this.setIconifiable(true);
    this.setClosable(true);
    desktopPane.add(this);
    }

      //It fills the groups cache and UI
    public void  fillGroupCacheNUI(){
        Dao.groups g=new Dao.groups();
        group_list=g.returnGroups();
        for(int index=constant.Constant.INTEGER_ZERO;index<group_list.size();index++){
            glist.add(group_list.get(index).getGname());
        } 
    }
    
    

    
    //It fills the accountType cache and UI
     private void fillAccountTypeCacheNUI() {
         account_type_list=(new Dao.account_type()).returnAccount_type();
     for(int index=constant.Constant.INTEGER_ZERO;index<account_type_list.size();index++){
         aaccount_type.addItem(account_type_list.get(index).getAccount_type());
     }
     }
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        arrange = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        before_account_list = new java.awt.List();
        after_account_list = new java.awt.List();
        glist = new java.awt.Choice();
        jLabel4 = new javax.swing.JLabel();
        aaccount_type = new java.awt.Choice();
        get = new javax.swing.JButton();
        final_account_list = new java.awt.List();
        Exit = new javax.swing.JButton();
        before = new javax.swing.JRadioButton();
        after = new javax.swing.JRadioButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Accounts");

        arrange.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        arrange.setText("Arrange");
        arrange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrangeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Select Group");

        before_account_list.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        after_account_list.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        glist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glistItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Account Type");

        aaccount_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                aaccount_typeItemStateChanged(evt);
            }
        });

        get.setText("GET");
        get.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getActionPerformed(evt);
            }
        });

        final_account_list.setVisible(false);

        Exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        before.setBackground(new java.awt.Color(255, 228, 196));
        before.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        before.setText("Before");
        before.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                beforeItemStateChanged(evt);
            }
        });

        after.setBackground(new java.awt.Color(255, 228, 196));
        after.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        after.setText("After");
        after.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                afterItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(before_account_list, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(glist, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aaccount_type, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(get)
                        .addGap(186, 186, 186))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(before)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(after)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(after_account_list, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(final_account_list, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(Exit))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arrange, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(aaccount_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(glist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(get, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(final_account_list, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(arrange)
                        .addGap(18, 18, 18)
                        .addComponent(Exit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(before)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(after))
                    .addComponent(after_account_list, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(before_account_list, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitActionPerformed

    private void getActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getActionPerformed
            before_account_list.clear();
            after_account_list.clear();
            final_account_list.clear();
            Dao.accounts account=new Dao.accounts();
            account.setGid(group_list.get(glist.getSelectedIndex()).getGid());
            account.setAccount_typeid(account_type_list.get(aaccount_type.getSelectedIndex()).getAccount_typeid());
            account_list=account.returnAccounts();
            for(int index=0;index<account_list.size();index++){
                before_account_list.add(account_list.get(index).getAname());
                after_account_list.add(account_list.get(index).getAname());
                final_account_list.add(account_list.get(index).getAname());
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_getActionPerformed

    private void aaccount_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_aaccount_typeItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_aaccount_typeItemStateChanged

    private void glistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glistItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_glistItemStateChanged

    private void arrangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrangeActionPerformed
        
        if(before.isSelected()){
            //If before is selected there are 3 cases
            //
            if(before_account_list.getSelectedIndex()==after_account_list.getSelectedIndex()){
                JOptionPane.showMessageDialog(null,MessageEnum.WRONG_CHOICE.getMessage());
            }
            else if(before_account_list.getSelectedIndex()<after_account_list.getSelectedIndex()){
                int account_list_afters_selected_index=after_account_list.getSelectedIndex();
                final_account_list.remove(before_account_list.getSelectedIndex());
                Dao.accounts acc=account_list.get(before_account_list.getSelectedIndex());
                account_list.remove(before_account_list.getSelectedIndex());
                final_account_list.add(before_account_list.getSelectedItem(),(account_list_afters_selected_index-1));
                account_list.add(account_list_afters_selected_index-1,acc);
            }
            else if(before_account_list.getSelectedIndex()>after_account_list.getSelectedIndex()){
                int account_list_afters_selected_index=after_account_list.getSelectedIndex();
                final_account_list.remove(before_account_list.getSelectedIndex());
                Dao.accounts acc=account_list.get(before_account_list.getSelectedIndex());
                account_list.remove(before_account_list.getSelectedIndex());
                final_account_list.add(before_account_list.getSelectedItem(),account_list_afters_selected_index);
                account_list.add(account_list_afters_selected_index,acc);
            }
            SortIds();
}
        else if(after.isSelected()){
            //If after is selected there are 3 cases
            if(before_account_list.getSelectedIndex()==after_account_list.getSelectedIndex()){
                JOptionPane.showMessageDialog(null,MessageEnum.WRONG_CHOICE.getMessage());
            }
            else if(before_account_list.getSelectedIndex()<after_account_list.getSelectedIndex()){
                int account_list_afters_selected_index=after_account_list.getSelectedIndex();
                final_account_list.remove(before_account_list.getSelectedIndex());
                Dao.accounts acc=account_list.get(before_account_list.getSelectedIndex());
                account_list.remove(before_account_list.getSelectedIndex());
                final_account_list.add(before_account_list.getSelectedItem(),account_list_afters_selected_index);
                account_list.add(account_list_afters_selected_index,acc);
            }
            else if(before_account_list.getSelectedIndex()>after_account_list.getSelectedIndex()){
                int account_list_afters_selected_index=after_account_list.getSelectedIndex();
                final_account_list.remove(before_account_list.getSelectedIndex());
                Dao.accounts acc=account_list.get(before_account_list.getSelectedIndex());
                account_list.remove(before_account_list.getSelectedIndex());
                final_account_list.add(before_account_list.getSelectedItem(),(account_list_afters_selected_index+1));
                account_list.add(account_list_afters_selected_index+1,acc);
            }
            SortIds();
        }
        else{
                JOptionPane.showMessageDialog(null,MessageFormat.format(MessageEnum.SELECT_NO_CHOICE.getMessage(),constant.Constant.BEFORE,constant.Constant.AFTER));
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_arrangeActionPerformed

    public void SortIds(){
        //Update Sort Id's for the updated account list
            Dao.accounts a=new Dao.accounts();
            ArrayList<Dao.accounts> accountListToBeUpdate=new ArrayList<Dao.accounts>();
            for(int index=0;index<account_list.size();index++){
                Dao.accounts account=account_list.get(index);
                account.setId(index);
                accountListToBeUpdate.add(account);
            }
            Dao.accounts account=new Dao.accounts();
            account.setSortIds(accountListToBeUpdate);   
       
    }
    
    private void beforeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_beforeItemStateChanged
        // TODO add your handling code here:
        
        if(before.isSelected())
            after.setSelected(false);
        else
            after.setSelected(true);
    }//GEN-LAST:event_beforeItemStateChanged

    private void afterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_afterItemStateChanged
        // TODO add your handling code here:
        if(after.isSelected())
            before.setSelected(false);
        else
            before.setSelected(true);
    }//GEN-LAST:event_afterItemStateChanged

    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private static java.awt.Choice aaccount_type;
    private javax.swing.JRadioButton after;
    private static java.awt.List after_account_list;
    private javax.swing.JButton arrange;
    private javax.swing.JRadioButton before;
    private static java.awt.List before_account_list;
    private static java.awt.List final_account_list;
    private javax.swing.JButton get;
    private static java.awt.Choice glist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
    
    
  

}