/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Add;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.text.*;
import javax.swing.*;

/**
 *
 * @author bansal
 */
public class Account
        extends javax.swing.JInternalFrame {
//These lists works as cache, They gets filled at start(in  constructor) and remain till end.

    static public ArrayList<Beans.groups> group_list = new ArrayList<>();
    static public ArrayList<Beans.accounts> account_list = new ArrayList<>();
    static public ArrayList<Beans.account_type> account_type_list = new ArrayList<>();

    /**
     * Creates new form accounts
     */
    public Account(JDesktopPane desktopPane) {

        initComponents();
        this.setTitle(MessageFormat.format(constants.MessageEnum.ADD.getMessage(), constants.Constant.ACCOUNT));
        fillGroupCacheNUI();
        fillAccountTypeCacheNUI();
        adate.setDate((new java.util.Date()));
        desktopPane.add(this);
    }

    //It Fills the cache group_list and UI group list
    public static void fillGroupCacheNUI() {
        Beans.groups g = new Beans.groups();
        group_list = g.returnGroups();
        for (int index = 0; index < group_list.size(); index++) {
            glist.add(group_list.get(index).getGname());
        }
        groupCount.setText(MessageFormat.format(constants.MessageEnum.COUNT.getMessage(), constants.Constant.GROUP, group_list.size()));
    }

    //It fills the cache account_list
    public static void fillAccountCacheNUI() {
        account_list.clear();
        alist.clear();

        Beans.accounts account = new Beans.accounts();
        account.setAccount_typeid(account_type_list.get(aaccount_type.getSelectedIndex()).getAccount_typeid());

        if (glist.getSelectedIndex() > constants.Constant.INTEGER_MINUS_ONE) {
            account.setGid((group_list.get(glist.getSelectedIndex())).getGid());
            account_list = account.returnAccounts();
            for (int index = constants.Constant.INTEGER_ZERO; index < account_list.size(); index++) {
                alist.add(account_list.get(index).getAname());
            }
            acountCount.setText(MessageFormat.format(constants.MessageEnum.COUNT.getMessage(), constants.Constant.ACCOUNT, account_list.size()));
        }
    }

    //It fills the cache account_type_list
    private void fillAccountTypeCacheNUI() {
        account_type_list = (new Beans.account_type()).returnAccount_type();
        for (int index = 0; index < account_type_list.size(); index++) {
            aaccount_type.addItem(account_type_list.get(index).getAccount_type());
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
        glist = new java.awt.List();
        alist = new java.awt.List();
        jPanel2 = new javax.swing.JPanel();
        aname = new javax.swing.JTextField();
        aphone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        aaddress = new javax.swing.JTextArea();
        acity = new javax.swing.JTextField();
        abalance = new javax.swing.JTextField();
        cow_rate_txt = new javax.swing.JTextField();
        bfl_rate_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        cow_rate_lab = new javax.swing.JLabel();
        bfl_rate_lab = new javax.swing.JLabel();
        aaccount_type = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        atype = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        groupCount = new javax.swing.JLabel();
        acountCount = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        adate = new org.jdesktop.swingx.JXDatePicker();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

        glist.setBackground(new java.awt.Color(255, 255, 255));
        glist.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        glist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glistItemStateChanged(evt);
            }
        });
        glist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glistActionPerformed(evt);
            }
        });

        alist.setBackground(new java.awt.Color(255, 255, 255));
        alist.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        alist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                alistItemStateChanged(evt);
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

        balance.setText("Balance");

        cow_rate_lab.setText("Cow Milk Rate");

        bfl_rate_lab.setText("Bfl Milk Rate");

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cow_rate_lab)
                                    .addComponent(bfl_rate_lab))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bfl_rate_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addComponent(cow_rate_txt)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(acity, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(aname, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                            .addComponent(aphone))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(balance)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(abalance)))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(acity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cow_rate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cow_rate_lab)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balance)
                    .addComponent(abalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bfl_rate_lab)
                    .addComponent(bfl_rate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        aaccount_type.setSelectedIndex(-1);
        aaccount_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                aaccount_typeItemStateChanged(evt);
            }
        });
        aaccount_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aaccount_typeActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        atype.setText("Account Type");

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
        jLabel10.setText("Account's Detail");

        groupCount.setText("No of Groups:0");

        acountCount.setText("No of Accounts:0");
        acountCount.setMinimumSize(new java.awt.Dimension(78, 16));

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
                .addGap(205, 205, 205)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(glist, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(groupCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alist, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(acountCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(atype)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aaccount_type, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(save)
                        .addGap(41, 41, 41)
                        .addComponent(reset)
                        .addGap(39, 39, 39)
                        .addComponent(exit)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(glist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit)
                            .addComponent(delete))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(aaccount_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(atype))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(adate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acountCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(save)
                        .addComponent(reset)
                        .addComponent(exit))
                    .addComponent(groupCount))
                .addGap(100, 100, 100))
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

    private void glistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glistActionPerformed

        fillAccountCacheNUI(); // TODO add your handling code here:
    }//GEN-LAST:event_glistActionPerformed

    private void glistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glistItemStateChanged

edit.setEnabled(false);
delete.setEnabled(false);
        fillAccountCacheNUI();

// TODO add your handling code here:
    }//GEN-LAST:event_glistItemStateChanged

    //It populates the selected accounts's information in account's create form
    private void alistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_alistItemStateChanged
        Beans.accounts account = new Beans.accounts();
        account.setAid(account_list.get(alist.getSelectedIndex()).getAid());
        account = account.get();
        aname.setText(account.getAname());
        aphone.setText(account.getAphone());
        aaddress.setText(account.getAaddress());
        acity.setText(account.getAcity());
        bfl_rate_txt.setText(account.getAbfl_rate() + "");
        cow_rate_txt.setText(account.getAcow_rate() + "");
        abalance.setText(account.getAbalance() + "");
        adate.setDate(account.getAdate());

        aname.setEditable(false);
        aphone.setEditable(false);
        aaddress.setEditable(false);
        acity.setEditable(false);
        bfl_rate_txt.setEditable(false);
        cow_rate_txt.setEditable(false);
        abalance.setEditable(false);
        adate.setEditable(false);
        edit.setEnabled(true);
        delete.setEnabled(true);
        save.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_alistItemStateChanged


    private void aaccount_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_aaccount_typeItemStateChanged
        fillAccountCacheNUI();

        // TODO add your handling code here:
    }//GEN-LAST:event_aaccount_typeItemStateChanged

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
if (evt.getActionCommand().equals(constants.Constant.UPDATE)) {
                String nameToBeUpdated = aname.getText();
                Beans.accounts account = new Beans.accounts();
                account.setGid(group_list.get(glist.getSelectedIndex()).getGid());
                account.setAname(aname.getText());
                account.setAid(account_list.get(alist.getSelectedIndex()).getAid());
                account.setId(account_list.get(alist.getSelectedIndex()).getId());
                account.setAccount_typeid(account_type_list.get(aaccount_type.getSelectedIndex()).getAccount_typeid());
                account.setAaddress(aaddress.getText());
                account.setAphone(aphone.getText());
                int balance = validateInt(abalance.getText());
                account.setAbalance(balance);
                account.setAcity(acity.getText());
                float rate = validateDouble(cow_rate_txt.getText());
                account.setAcow_rate(rate);
                rate = validateDouble(bfl_rate_txt.getText());

                account.setAbfl_rate(rate);
                Date date = new Date(adate.getDate().getTime());
                account.setAdate(date);
                if (account.update()) {
                    JOptionPane.showMessageDialog(this, MessageFormat.format(constants.MessageEnum.UPDATE_SUCCESS.getMessage(), constants.Constant.ACCOUNT, nameToBeUpdated), constants.MessageEnum.UPDATE_SUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(constants.ImageEnum.SUCCESS.getImageName()));
                } else {
                    JOptionPane.showMessageDialog(this, MessageFormat.format(constants.MessageEnum.UPDATE_UNSUCCESS.getMessage(), constants.Constant.ACCOUNT, nameToBeUpdated), constants.MessageEnum.UPDATE_UNSUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(constants.ImageEnum.UNSUCCESS.getImageName()));

                }
                reset.doClick();
                fillAccountCacheNUI();
                save.setText(constants.Constant.SAVE);

            } else if (aname.getText() == null || aname.getText().equals("")) {
                JOptionPane.showConfirmDialog(this, MessageFormat.format(constants.MessageEnum.MANDATORY_FIELD.getMessage(), "Name"), constants.MessageEnum.MANDATORY_FIELD.getMessageType(), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(constants.ImageEnum.UNSUCCESS.getImageName()));

            } else {
                String nameToBeSaved = aname.getText();
                Beans.accounts account = new Beans.accounts();
                account.setId(account.getAccountId());
                account.setAid(glist.getSelectedItem().charAt(0) + "" + account.getNewAId() + "");
                account.setGid(group_list.get(glist.getSelectedIndex()).getGid());
                account.setAname(aname.getText());
                account.setAccount_typeid((account_type_list.get(aaccount_type.getSelectedIndex())).getAccount_typeid());
                account.setAphone(aphone.getText());

                int balance =validateInt(abalance.getText());
                account.setAbalance(balance);
                account.setAcity(acity.getText());
                account.setAaddress(aaddress.getText());
                float rate = validateDouble(cow_rate_txt.getText());
                account.setAcow_rate(rate);
                rate = validateDouble(bfl_rate_txt.getText());

                account.setAbfl_rate(rate);
                Date dd = new Date(adate.getDate().getTime());
                account.setAdate(dd);
                if (account.add()) {
                    JOptionPane.showMessageDialog(this, MessageFormat.format(constants.MessageEnum.SAVE_SUCCESS.getMessage(), constants.Constant.ACCOUNT, nameToBeSaved), constants.MessageEnum.SAVE_SUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(constants.ImageEnum.SUCCESS.getImageName()));

                    fillAccountCacheNUI();
                } else {
                    JOptionPane.showMessageDialog(this, MessageFormat.format(constants.MessageEnum.SAVE_UNSUCCESS.getMessage(), constants.Constant.ACCOUNT, nameToBeSaved), constants.MessageEnum.SAVE_UNSUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(constants.ImageEnum.UNSUCCESS.getImageName()));

                }

                reset.doClick();
                // TODO add your handling code here:
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    public int validateInt(String text){
        if(text==null)  return 0;
        else if(!text.matches("\\d*")){
            return 0;
        }else{
            return Integer.valueOf(text);
        }
    }
    
    
    public float validateDouble(String text){
        if(text==null)  return 0f;
        else if(!text.matches("\\d*")){
            return 0f;
        }else{
            return Float.valueOf(text);
        }
        
    }
    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    //It resets the account's create form
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        aname.setEditable(true);
        aphone.setEditable(true);
        aaddress.setEditable(true);
        abalance.setEditable(true);
        acity.setEditable(true);
        bfl_rate_txt.setEditable(true);
        cow_rate_txt.setEditable(true);
adate.setEditable(true);
        aname.setText("");
        aphone.setText("");
        aaddress.setText("");
        abalance.setText("");
        acity.setText("");
        bfl_rate_txt.setText("");
        cow_rate_txt.setText("");
        save.setEnabled(true);
// TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

//It Populate the selected account's info in edit form
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        aname.setEditable(true);
        aphone.setEditable(true);
        aaddress.setEditable(true);
        acity.setEditable(true);
        bfl_rate_txt.setEditable(true);
        cow_rate_txt.setEditable(true);
        abalance.setEditable(true);
        adate.setEditable(true);
        save.setText(constants.Constant.UPDATE);
save.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    //It deletes the selected account
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
System.out.println("In delete"+alist.getSelectedIndex());
String nameToBeDeleted = alist.getSelectedItem();
        if (JOptionPane.showConfirmDialog(this, MessageFormat.format(constants.MessageEnum.DELETE_CONFIRM.getMessage(), nameToBeDeleted), constants.MessageEnum.DELETE_CONFIRM.getMessageType(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(constants.ImageEnum.CONFIRM.getImageName())) == 0) {
            Beans.accounts a = new Beans.accounts();
            a.setAid(account_list.get(alist.getSelectedIndex()).getAid());
            if (a.delete()) {
                fillAccountCacheNUI();
                JOptionPane.showMessageDialog(this, MessageFormat.format(constants.MessageEnum.DELETE_SUCCESS.getMessage(), constants.Constant.ACCOUNT, nameToBeDeleted), constants.MessageEnum.DELETE_SUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(constants.ImageEnum.SUCCESS.getImageName()));
            } else {
                JOptionPane.showMessageDialog(this, MessageFormat.format(constants.MessageEnum.DELETE_UNSUCCESS.getMessage(), constants.Constant.ACCOUNT, nameToBeDeleted), constants.MessageEnum.DELETE_UNSUCCESS.getMessageType(), JOptionPane.INFORMATION_MESSAGE, new ImageIcon(constants.ImageEnum.UNSUCCESS.getImageName()));
            }
        }

        reset.doClick();
        edit.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_deleteActionPerformed

    private void aaccount_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aaccount_typeActionPerformed
        reset.doClick();

        if (((String) aaccount_type.getSelectedItem()).contains("Sale")) {
            balance.setText("Balance");
        } else {
            balance.setText("Advance");
        }

        if (((String) aaccount_type.getSelectedItem()).contains("Fat") || ((String) aaccount_type.getSelectedItem()).contains("SNF")) {
            bfl_rate_lab.setVisible(false);
            cow_rate_lab.setVisible(false);
            bfl_rate_txt.setVisible(false);
            cow_rate_txt.setVisible(false);
        } else {
            bfl_rate_lab.setVisible(true);
            cow_rate_lab.setVisible(true);
            bfl_rate_txt.setVisible(true);
            cow_rate_txt.setVisible(true);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_aaccount_typeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox aaccount_type;
    private javax.swing.JTextArea aaddress;
    private javax.swing.JTextField abalance;
    private javax.swing.JTextField acity;
    private static javax.swing.JLabel acountCount;
    private org.jdesktop.swingx.JXDatePicker adate;
    private static java.awt.List alist;
    private javax.swing.JTextField aname;
    private javax.swing.JTextField aphone;
    private javax.swing.JLabel atype;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bfl_rate_lab;
    private javax.swing.JTextField bfl_rate_txt;
    private javax.swing.JLabel cow_rate_lab;
    private javax.swing.JTextField cow_rate_txt;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton exit;
    private static java.awt.List glist;
    private static javax.swing.JLabel groupCount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

}
