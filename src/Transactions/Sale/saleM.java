/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transactions.Sale;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JDesktopPane;

/**
 *
 * @author bansal
 */
public class saleM extends javax.swing.JInternalFrame {
static int account_typeid=constant.AccountType.SALE;
static int gid=0;
static ArrayList<Dao.groups> group_list=new ArrayList<Dao.groups>();
static ArrayList<Dao.accounts> account_list=new ArrayList<Dao.accounts>();

JDesktopPane d;
    /**
     * Creates new form sale
     */
    public saleM(JDesktopPane d) {
        initComponents();
          this.setTitle("Sale Monthly Transaction");
       fillGList();
       this.d=d;
         d.add(this);
    }

    
       public static void  fillGList(){
      try{  Dao.groups g=new Dao.groups();
        group_list=g.returnGroups();
        for(int i=0;i<group_list.size();i++){
            glist.addItem(group_list.get(i).getGname());
            
        } }catch(Exception e){e.printStackTrace();
            
        }
     }
    
     public static void  fillAList(){
      try{  Dao.accounts g=new Dao.accounts();
        g.setGid(group_list.get(glist.getSelectedIndex()).getGid());
        g.setAccount_typeid(account_typeid);
        account_list=g.returnAccounts();
        for(int i=0;i<account_list.size();i++){
            alist.addItem(account_list.get(i).getAname());
            
        } }catch(Exception e){e.printStackTrace();
            
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
        go = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        alist = new java.awt.Choice();
        glist = new java.awt.Choice();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 228, 196));

        go.setText("GO");
        go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Account ");

        jLabel1.setText("Select Group");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        glist.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                glistItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(exit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(glist, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alist, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(go)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(go)
                    .addComponent(alist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(glist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(exit)
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

    private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
this.dispose();
        try {
            
          SaleMonthly a=new SaleMonthly(account_list.get(alist.getSelectedIndex()),new Date(),d);
          a.setVisible(true);
           a.setSize(constant.Constant.width,constant.Constant.height-100);
          a.setIconifiable(true);
        } catch (Exception ex) {
            ex.printStackTrace();

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_goActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void glistItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_glistItemStateChanged
alist.removeAll();
        

        
        fillAList();        // TODO add your handling code here:
    }//GEN-LAST:event_glistItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static java.awt.Choice alist;
    private javax.swing.JButton exit;
    private static java.awt.Choice glist;
    private javax.swing.JButton go;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
