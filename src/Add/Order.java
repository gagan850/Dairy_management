/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Add;

import Enum.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.text.*;
import java.util.Iterator;
import javax.swing.*;
/**
 *
 * @author bansal
 */
public class Order extends javax.swing.JInternalFrame {

    //It's caches for the order list
    ArrayList<Dao.order_account> order_list=new ArrayList<Dao.order_account>();
    /**
     * Creates new form order_account
     */
    public Order(JDesktopPane desktopPane) {
         
        initComponents();
        this.setTitle(MessageFormat.format(MessageEnum.ADD.getMessage(), constant.Constant.ORDER));
        fillOrderCacheNUI();
        adate.setDate((new java.util.Date()));
        desktopPane.add(this);
    }

  //It fills the cache and UI order list
    public void fillOrderCacheNUI(){
       olist.clear();
       order_list.clear();
         Dao.order_account acc=new Dao.order_account();
         order_list=acc.returnAccounts();
         Iterator<Dao.order_account> iterator=order_list.iterator();
         while(iterator.hasNext()){
             olist.add(iterator.next().getAname());
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
        olist = new java.awt.List();
        jPanel2 = new javax.swing.JPanel();
        aname = new javax.swing.JTextField();
        aphone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        aaddress = new javax.swing.JTextArea();
        acity = new javax.swing.JTextField();
        advance = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        adate = new org.jdesktop.swingx.JXDatePicker();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

        olist.setBackground(new java.awt.Color(255, 255, 255));
        olist.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        olist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                olistItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(210, 180, 140));

        aaddress.setColumns(20);
        aaddress.setRows(5);
        jScrollPane1.setViewportView(aaddress);

        jLabel3.setText("Name");

        jLabel4.setText("Phone");

        jLabel5.setText("Address");

        jLabel6.setText("City");

        jLabel7.setText("Advance");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel5))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acity, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aphone, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(advance)))
                        .addGap(171, 171, 171))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(acity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(advance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Date");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Add Order Account");

        edit.setText("Edit");
        edit.setEnabled(false);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.setEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(olist, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(save)
                        .addGap(41, 41, 41)
                        .addComponent(reset)
                        .addGap(39, 39, 39)
                        .addComponent(exit)
                        .addGap(75, 75, 75))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit)
                            .addComponent(delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(olist, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(reset)
                    .addComponent(exit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        String nameToBeDeleted=aname.getText();
        if (JOptionPane.showConfirmDialog(this, MessageFormat.format(MessageEnum.DELETE_CONFIRM.getMessage(), nameToBeDeleted), MessageEnum.DELETE_CONFIRM.getMessageType(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(ImageEnum.CONFIRM.getImageName())) == 0) {
                Dao.order_account order_account =new Dao.order_account();
                order_account.setAname(olist.getSelectedItem());
                if(order_account.delete()){
                  JOptionPane.showMessageDialog(this, MessageFormat.format(MessageEnum.DELETE_SUCCESS.getMessage(), constant.Constant.ORDER, nameToBeDeleted), MessageEnum.DELETE_SUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageEnum.SUCCESS.getImageName()));
              fillOrderCacheNUI();    
                }else{
                       JOptionPane.showMessageDialog(this, MessageFormat.format(MessageEnum.DELETE_UNSUCCESS.getMessage(), constant.Constant.ORDER, nameToBeDeleted), MessageEnum.DELETE_UNSUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageEnum.UNSUCCESS.getImageName()));
              }
        }
       
        reset.doClick();
        edit.setEnabled(false);
        delete.setEnabled(false);
// TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        aphone.setEditable(true);
        aaddress.setEditable(true);
        acity.setEditable(true);
        advance.setEditable(true);
        adate.setEditable(true);
        save.setText(constant.Constant.UPDATE);

        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
save.setText(constant.Constant.SAVE);
        aname.setEditable(true);
        aphone.setEditable(true);
        aaddress.setEditable(true);
        advance.setEditable(true);acity.setEditable(true);
        adate.setEditable(true);
        aname.setText("");
        aphone.setText("");
        aaddress.setText("");
        advance.setText("");
        acity.setText("");
       
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try{

            if(evt.getActionCommand().equals(constant.Constant.UPDATE)){
                String nameToBeUpdated=aname.getText();
                Dao.order_account order_account =new Dao.order_account();
               
                order_account.setAname(aname.getText());
                order_account.setAaddress(aaddress.getText());
                order_account.setAphone(aphone.getText());
                order_account.setAdvance(validateInt(advance.getText()));
                order_account.setAcity(acity.getText());
                Date date=new Date(adate.getDate().getTime());
                order_account.setAdate(date);
                if(order_account.update()){
                          JOptionPane.showMessageDialog(this, MessageFormat.format(MessageEnum.UPDATE_SUCCESS.getMessage(), constant.Constant.ORDER, nameToBeUpdated), MessageEnum.UPDATE_SUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageEnum.SUCCESS.getImageName()));
                fillOrderCacheNUI();
                
                }else{
             JOptionPane.showMessageDialog(this, MessageFormat.format(MessageEnum.UPDATE_UNSUCCESS.getMessage(), constant.Constant.ORDER, nameToBeUpdated), MessageEnum.UPDATE_UNSUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageEnum.UNSUCCESS.getImageName()));
          
                }
                reset.doClick();
                save.setText(constant.Constant.SAVE);

            }else if(aname.getText()==null||aname.getText().equals("")){
              JOptionPane.showConfirmDialog(this, MessageFormat.format(MessageEnum.MANDATORY_FIELD.getMessage(), "Name"), MessageEnum.MANDATORY_FIELD.getMessageType(), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(ImageEnum.UNSUCCESS.getImageName()));
          }else{
                Dao.order_account order_account=new Dao.order_account();
                
                order_account.setAname(aname.getText());
                order_account.setAphone(aphone.getText());
                order_account.setAdvance(validateInt(advance.getText()));
                order_account.setAcity(acity.getText());
                Date date=new Date(adate.getDate().getTime());
                order_account.setAdate(date);
                if(order_account.search())
              JOptionPane.showConfirmDialog(this, MessageFormat.format(MessageEnum.ALREADY_EXIST.getMessage(), constant.Constant.ORDER, aname.getText()), MessageEnum.ALREADY_EXIST.getMessageType(), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(ImageEnum.UNSUCCESS.getImageName()));
                else
                {
               String nameToBeSaved=aname.getText();
                        if(order_account.add()){
                 Dao.order_transactions.addEmptyInTransactions(order_account.getAname());
                    fillOrderCacheNUI();
                            JOptionPane.showMessageDialog(this, MessageFormat.format(MessageEnum.SAVE_SUCCESS.getMessage(), constant.Constant.ORDER, nameToBeSaved), MessageEnum.SAVE_SUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageEnum.SUCCESS.getImageName()));
                  }
                    else{
                         JOptionPane.showMessageDialog(this, MessageFormat.format(MessageEnum.SAVE_UNSUCCESS.getMessage(), constant.Constant.ORDER, nameToBeSaved), MessageEnum.SAVE_UNSUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageEnum.UNSUCCESS.getImageName()));
                    }
                        reset.doClick();
                }
            }}catch(Exception exception){exception.printStackTrace();}
    }//GEN-LAST:event_saveActionPerformed

      public int validateInt(String text){
        if(text==null)  return 0;
        else if(!text.matches("\\d*")||text.equals("")){
            return 0;
        }else{
            return Integer.valueOf(text);
        }
    }
    
    private void olistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_olistItemStateChanged
        try {
            Dao.order_account a=new Dao.order_account();
            a.setAname(olist.getSelectedItem());
            a=a.get();
            aname.setText(a.getAname());
            aphone.setText(a.getAphone());
            aaddress.setText(a.getAaddress());
            acity.setText(a.getAcity());
            advance.setText(a.getAdvance()+"");
            adate.setDate(a.getAdate());
            System.out.println("IN ACCOUNT"+a.getAdate());

            aname.setEditable(false);
            aphone.setEditable(false);
            aaddress.setEditable(false);
            acity.setEditable(false);
            
            advance.setEditable(false);
            adate.setEditable(false);
            edit.setEnabled(true);
            delete.setEnabled(true);
            // TODO add your handling code here:
    }//GEN-LAST:event_olistItemStateChanged
    catch(Exception e){}}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea aaddress;
    private javax.swing.JTextField acity;
    private org.jdesktop.swingx.JXDatePicker adate;
    private javax.swing.JTextField advance;
    private javax.swing.JTextField aname;
    private javax.swing.JTextField aphone;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static java.awt.List olist;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

   

    
}
