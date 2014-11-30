/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dairy_manage;
import Add.*;
import Enum.*;
import Misc.Note.Notes;
import Transactions.Purchase.PurchaseReport;
import Transactions.Sale.SaleReport;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
/**
 *
 * @author bansal
 */
public class Main extends javax.swing.JFrame {
JDesktopPane d;
static int width=0;
static int height=0;
ImageIcon icon=null;
static{
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double w = screenSize.getWidth();
        double h = screenSize.getHeight();
   width=(int)w;
   height=(int)h;
}
    /**
     * Creates new form MAin
     */
    public Main() {
        initComponents();
         d=this.desktopPane;
         back_ground.setBounds(0, 0, (int)width, (int)height);
        back_ground.setVisible(true);
       this.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        try{
        Date date=new Date();
      String d=date.getDate()+"-"+Transactions.Cal.month(date.getMonth()+1)+"-"+(date.getYear()+1900)+"_"+date.getHours()+"-"+date.getMinutes();
        Process process=Runtime.getRuntime().exec("expdp system/bansal schemas=dairy dumpfile=DAIRY_DBase_"+d+".dmp");
//while(process.)


}catch(Exception e){e.printStackTrace();

        }
    }

       });


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        try{
            back_ground = new javax.swing.JLabel(new ImageIcon("Img\\wall.jpg"));
            menuBar = new javax.swing.JMenuBar();
            addMenu = new javax.swing.JMenu();
            icon = new ImageIcon(ImageEnum.GROUPS.getImageName());
            groups = new javax.swing.JMenuItem(icon);
            accounts = new javax.swing.JMenuItem(new ImageIcon(ImageEnum.ACCOUNTS.getImageName()))
            ;
            arrange_accounts = new javax.swing.JMenuItem(new ImageIcon(ImageEnum.ARRANGE_ACCOUNTS.getImageName()));
            change_rate = new javax.swing.JMenuItem();
            add_balance = new javax.swing.JMenuItem();
            add_order_account = new javax.swing.JMenuItem();
            jMenuItem3 = new javax.swing.JMenuItem(new ImageIcon(ImageEnum.EMPLOYEE.getImageName()));
            exit = new javax.swing.JMenuItem();
            monthlyTransactionMenu = new javax.swing.JMenu();
            sale_monthly = new javax.swing.JMenuItem();
            purchase_monthly = new javax.swing.JMenuItem();
            sale_fat_monthly = new javax.swing.JMenuItem();
            purchase_fat_monthly = new javax.swing.JMenuItem();
            sale_snf_monthly = new javax.swing.JMenuItem();
            purchase_snf_monthly = new javax.swing.JMenuItem();
            reportMenu = new javax.swing.JMenu();
            account_report = new javax.swing.JMenuItem();
            group_report = new javax.swing.JMenuItem();
            sale_report = new javax.swing.JMenuItem();
            purchase_report = new javax.swing.JMenuItem();
            sale_fat_reports = new javax.swing.JMenuItem();
            purchase_fat_reports = new javax.swing.JMenuItem();
            sale_snf_report = new javax.swing.JMenuItem();
            purchase_snf_report = new javax.swing.JMenuItem();
            dailyTransactionMenu = new javax.swing.JMenu();
            sale_daily = new javax.swing.JMenuItem();
            purchase_daily = new javax.swing.JMenuItem();
            sale_fat_daily = new javax.swing.JMenuItem();
            purchase_fat_daily = new javax.swing.JMenuItem();
            sale_snf_daily = new javax.swing.JMenuItem();
            purchase_snf_daily = new javax.swing.JMenuItem();
            jMenu1 = new javax.swing.JMenu();
            receive_list = new javax.swing.JMenuItem();
            order_transaction = new javax.swing.JMenuItem();
            jMenuItem1 = new javax.swing.JMenuItem();
            jMenuItem4 = new javax.swing.JMenuItem();
            jMenuItem2 = new javax.swing.JMenuItem();
            setting = new javax.swing.JMenu();
            entries = new javax.swing.JMenuItem();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        }catch(Exception e){JOptionPane.showMessageDialog(null, "Background img not found");

        }
        back_ground.setText("");
        desktopPane.add(back_ground);
        back_ground.setBounds(4, 4, 390, 270);

        menuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addMenu.setMnemonic('a');
        addMenu.setText("Add");
        addMenu.setToolTipText("");

        groups.setMnemonic('o');
        groups.setText("Groups");
        groups.setSelected(true);
        groups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupsActionPerformed(evt);
            }
        });
        addMenu.add(groups);

        accounts.setMnemonic('s');
        accounts.setText("Accounts");
        accounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsActionPerformed(evt);
            }
        });
        addMenu.add(accounts);

        arrange_accounts.setText("Arrange Accounts");
        arrange_accounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrange_accountsActionPerformed(evt);
            }
        });
        addMenu.add(arrange_accounts);

        change_rate.setText("Change Rate");
        change_rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_rateActionPerformed(evt);
            }
        });
        addMenu.add(change_rate);
        addMenu.addSeparator();

        add_balance.setText("Add Balance");
        add_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_balanceActionPerformed(evt);
            }
        });
        addMenu.add(add_balance);

        add_order_account.setText("Order");
        add_order_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_order_accountActionPerformed(evt);
            }
        });
        addMenu.add(add_order_account);

        jMenuItem3.setText("Employee");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        addMenu.add(jMenuItem3);

        exit.setMnemonic('x');
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        addMenu.add(exit);

        menuBar.add(addMenu);

        monthlyTransactionMenu.setMnemonic('M');
        monthlyTransactionMenu.setText("Monthly Transaction");
        monthlyTransactionMenu.setToolTipText("");
        monthlyTransactionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyTransactionMenuActionPerformed(evt);
            }
        });

        sale_monthly.setMnemonic('t');
        sale_monthly.setText("Sale");
        sale_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_monthlyActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(sale_monthly);

        purchase_monthly.setMnemonic('y');
        purchase_monthly.setText("Purchase");
        purchase_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_monthlyActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(purchase_monthly);
        monthlyTransactionMenu.addSeparator();

        sale_fat_monthly.setMnemonic('p');
        sale_fat_monthly.setText("Sale Fat");
        sale_fat_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_fat_monthlyActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(sale_fat_monthly);

        purchase_fat_monthly.setMnemonic('d');
        purchase_fat_monthly.setText("Purchase Fat");
        purchase_fat_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_fat_monthlyActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(purchase_fat_monthly);
        monthlyTransactionMenu.addSeparator();

        sale_snf_monthly.setText("Sale SNF");
        sale_snf_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_snf_monthlyActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(sale_snf_monthly);

        purchase_snf_monthly.setText("Purchase SNF");
        purchase_snf_monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_snf_monthlyActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(purchase_snf_monthly);

        menuBar.add(monthlyTransactionMenu);

        reportMenu.setMnemonic('r');
        reportMenu.setText("Reports");
        reportMenu.setToolTipText("");

        account_report.setMnemonic('a');
        account_report.setText("Accounts");
        account_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_reportActionPerformed(evt);
            }
        });
        reportMenu.add(account_report);

        group_report.setMnemonic('c');
        group_report.setText("Groups");
        group_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                group_reportActionPerformed(evt);
            }
        });
        reportMenu.add(group_report);
        reportMenu.addSeparator();

        sale_report.setText("Sale");
        sale_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_reportActionPerformed(evt);
            }
        });
        reportMenu.add(sale_report);

        purchase_report.setText("Purchase");
        purchase_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_reportActionPerformed(evt);
            }
        });
        reportMenu.add(purchase_report);
        reportMenu.addSeparator();

        sale_fat_reports.setText("Sale Fat");
        sale_fat_reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_fat_reportsActionPerformed(evt);
            }
        });
        reportMenu.add(sale_fat_reports);

        purchase_fat_reports.setText("Purchase Fat");
        purchase_fat_reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_fat_reportsActionPerformed(evt);
            }
        });
        reportMenu.add(purchase_fat_reports);
        reportMenu.addSeparator();

        sale_snf_report.setText("Sale SNF");
        sale_snf_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_snf_reportActionPerformed(evt);
            }
        });
        reportMenu.add(sale_snf_report);

        purchase_snf_report.setText("Purcahse SNf");
        purchase_snf_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_snf_reportActionPerformed(evt);
            }
        });
        reportMenu.add(purchase_snf_report);

        menuBar.add(reportMenu);

        dailyTransactionMenu.setMnemonic('d');
        dailyTransactionMenu.setText("Daily Transaction");
        dailyTransactionMenu.setToolTipText("");

        sale_daily.setText("Sale");
        sale_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_dailyActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(sale_daily);

        purchase_daily.setText("Purchase");
        purchase_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_dailyActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(purchase_daily);
        dailyTransactionMenu.addSeparator();

        sale_fat_daily.setText("Sale Fat");
        sale_fat_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_fat_dailyActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(sale_fat_daily);

        purchase_fat_daily.setText("Purchase Fat");
        purchase_fat_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_fat_dailyActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(purchase_fat_daily);
        dailyTransactionMenu.addSeparator();

        sale_snf_daily.setText("Sale SNF");
        sale_snf_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sale_snf_dailyActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(sale_snf_daily);

        purchase_snf_daily.setText("Purcahse SNF");
        purchase_snf_daily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_snf_dailyActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(purchase_snf_daily);

        menuBar.add(dailyTransactionMenu);

        jMenu1.setMnemonic('M');
        jMenu1.setText("Misc");

        receive_list.setText("Receive List");
        receive_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receive_listActionPerformed(evt);
            }
        });
        jMenu1.add(receive_list);

        order_transaction.setText("Order Transaction");
        order_transaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_transactionActionPerformed(evt);
            }
        });
        jMenu1.add(order_transaction);

        jMenuItem1.setText("Notes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Add Cash / Spend");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem2.setText("Daily Data");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuBar.add(jMenu1);

        setting.setMnemonic('s');
        setting.setText("Settings");
        setting.setVisible(false);
        setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingActionPerformed(evt);
            }
        });

        entries.setText("Entries");
        entries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entriesActionPerformed(evt);
            }
        });
        setting.add(entries);

        menuBar.add(setting);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
try{
      Date date=new Date();
       String d=date.getDate()+"-"+Transactions.Cal.month(date.getMonth()+1)+"-"+(date.getYear()+1900)+"_"+date.getHours()+"-"+date.getMinutes();
          Process runTime=Runtime.getRuntime().exec("expdp system/bansal schemas=dairy dumpfile=DAIRY_DBase_"+d+".dmp");


        System.exit(0);
}catch(Exception e){e.printStackTrace();

        }
    }//GEN-LAST:event_exitActionPerformed

    private void groupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupsActionPerformed
try{
        Group g=new Group(d);
        g.setVisible(true);
      g.setSize(470, 400);

g.setIconifiable(true);
}catch(Exception e){
    e.printStackTrace();
}
// TODO add your handling code here:
    }//GEN-LAST:event_groupsActionPerformed

    private void accountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsActionPerformed
try{
        Account g=new Account(d);
        g.setVisible(true);
      g.setSize(700, 600);
      g.setIconifiable(true);


}catch(Exception e){
    e.printStackTrace();
}


// TODO add your handling code here:
    }//GEN-LAST:event_accountsActionPerformed

    private void group_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_group_reportActionPerformed
Reports.groups a=new Reports.groups(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_group_reportActionPerformed

    private void account_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_account_reportActionPerformed
Reports.accounts a=new Reports.accounts(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);


// TODO add your handling code here:
    }//GEN-LAST:event_account_reportActionPerformed

    private void monthlyTransactionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyTransactionMenuActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_monthlyTransactionMenuActionPerformed

    private void sale_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_monthlyActionPerformed

Transactions.Sale.saleM a=new Transactions.Sale.saleM(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_sale_monthlyActionPerformed

    private void purchase_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_monthlyActionPerformed

        Transactions.Purchase.PurchaseM a=new Transactions.Purchase.PurchaseM(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_purchase_monthlyActionPerformed

    private void sale_dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_dailyActionPerformed
Transactions.Sale.saleD a=new Transactions.Sale.saleD(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_sale_dailyActionPerformed

    private void arrange_accountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrange_accountsActionPerformed
      Add.ArrangeAccounts a=new Add.ArrangeAccounts(d);
a.setVisible(true);
a.setSize(600, 500);
a.setResizable(false);
  // TODO add your handling code here:
    }//GEN-LAST:event_arrange_accountsActionPerformed

    private void sale_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_reportActionPerformed

SaleReport sale_full_report=new SaleReport(d);
sale_full_report.setVisible(true);
sale_full_report.setSize(650, 500);



// TODO add your handling code here:
    }//GEN-LAST:event_sale_reportActionPerformed

    private void change_rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_rateActionPerformed
try{
    AddNChangeRate rate=new AddNChangeRate(d);


rate.setVisible(true);
rate.setSize(700, 500);
}catch(Exception e){
    e.printStackTrace();

}
// TODO add your handling code here:
    }//GEN-LAST:event_change_rateActionPerformed

    private void purchase_dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_dailyActionPerformed
Transactions.Purchase.PurchaseD a=new Transactions.Purchase.PurchaseD(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_dailyActionPerformed

    private void purchase_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_reportActionPerformed
PurchaseReport purchase_full_report=new PurchaseReport(d);
purchase_full_report.setVisible(true);
purchase_full_report.setSize(500, 500);
// TODO add your handling code here:
    }//GEN-LAST:event_purchase_reportActionPerformed

    private void sale_fat_reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_fat_reportsActionPerformed

        try{
            Reports.SaleFatBill sale_fat_report=new Reports.SaleFatBill(d);

sale_fat_report.setVisible(true);
sale_fat_report.setSize(700, 500);
        }catch(Exception e){e.printStackTrace();}
// TODO add your handling code here:
    }//GEN-LAST:event_sale_fat_reportsActionPerformed

    private void sale_fat_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_fat_monthlyActionPerformed
Transactions.SaleFAT.saleFATM a=new Transactions.SaleFAT.saleFATM(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_sale_fat_monthlyActionPerformed

    private void purchase_fat_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_fat_monthlyActionPerformed
Transactions.PurFAT.PurFATM a=new Transactions.PurFAT.PurFATM(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);
// TODO add your handling code here:
    }//GEN-LAST:event_purchase_fat_monthlyActionPerformed

    private void sale_fat_dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_fat_dailyActionPerformed
    Transactions.SaleFAT.saleFATD a=new Transactions.SaleFAT.saleFATD(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);
// TODO add your handling code here:
    }//GEN-LAST:event_sale_fat_dailyActionPerformed

    private void purchase_fat_dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_fat_dailyActionPerformed
    Transactions.PurFAT.PurFATD a=new Transactions.PurFAT.PurFATD(d);
    a.setVisible(true);
    a.setSize(500, 500);
    a.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_fat_dailyActionPerformed

    private void purchase_fat_reportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_fat_reportsActionPerformed

        try{
            Reports.PurchaseFatBill sale_fat_report=new Reports.PurchaseFatBill(d);

sale_fat_report.setVisible(true);
sale_fat_report.setSize(700, 500);
        }catch(Exception e){e.printStackTrace();}    // TODO add your handling code here:
    }//GEN-LAST:event_purchase_fat_reportsActionPerformed

    private void sale_snf_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_snf_monthlyActionPerformed

        Transactions.SaleSNF.saleSNFM a=new Transactions.SaleSNF.saleSNFM(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);



// TODO add your handling code here:
    }//GEN-LAST:event_sale_snf_monthlyActionPerformed

    private void sale_snf_dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_snf_dailyActionPerformed
Transactions.SaleSNF.saleSNFD a=new Transactions.SaleSNF.saleSNFD(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_sale_snf_dailyActionPerformed

    private void purchase_snf_monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_snf_monthlyActionPerformed
 Transactions.PurSNF.PurSNFM a=new Transactions.PurSNF.PurSNFM(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_snf_monthlyActionPerformed

    private void purchase_snf_dailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_snf_dailyActionPerformed
Transactions.PurSNF.PurSNFD a=new Transactions.PurSNF.PurSNFD(d);
a.setVisible(true);
a.setSize(500, 500);
a.setIconifiable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_snf_dailyActionPerformed

    private void sale_snf_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sale_snf_reportActionPerformed
  try{
            Reports.SaleSnfBill sale_fat_report=new Reports.SaleSnfBill(d);

sale_fat_report.setVisible(true);
sale_fat_report.setSize(700, 500);
        }catch(Exception e){e.printStackTrace();}
        // TODO add your handling code here:
    }//GEN-LAST:event_sale_snf_reportActionPerformed

    private void purchase_snf_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_snf_reportActionPerformed
try{
            Reports.PurchaseSnfBill sale_fat_report=new Reports.PurchaseSnfBill(d);

sale_fat_report.setVisible(true);
sale_fat_report.setSize(700, 500);
        }catch(Exception e){e.printStackTrace();}
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase_snf_reportActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
try{
Notes notes=new Notes(d);
notes.setVisible(true);
notes.setSize(700, 600);
}catch(Exception e){e.printStackTrace();}
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void add_order_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_order_accountActionPerformed

        try{
Add.Order order=new Add.Order(d);
order.setVisible(true);
order.setSize(700, 600);
}catch(Exception e){e.printStackTrace();}


// TODO add your handling code here:
    }//GEN-LAST:event_add_order_accountActionPerformed

    private void order_transactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_transactionActionPerformed

        try{
Misc.Order.order_transactions order=new Misc.Order.order_transactions(d);
order.setVisible(true);
order.setSize(700, 600);
}catch(Exception e){e.printStackTrace();}

// TODO add your handling code here:
    }//GEN-LAST:event_order_transactionActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
try{
    Add.Employee employee=new Add.Employee(d);
employee.setSize(500, 450);
employee.setVisible(true);
}catch(Exception e){
    e.printStackTrace();
}
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void receive_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receive_listActionPerformed
try{
Reports.Receive_List data=new Reports.Receive_List(d);
data.setSize(600, 600);
data.setVisible(true);

}catch(Exception e){e.printStackTrace();}

// TODO add your handling code here:
    }//GEN-LAST:event_receive_listActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
try{
    Misc.DailyData.DailyData report=new Misc.DailyData.DailyData(d);

  report.setSize(600, 600);
report.setVisible(true);}catch(Exception e){e.printStackTrace();
}// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
  try{Misc.Cash.Cash c1=new Misc.Cash.Cash(d);
  c1.setSize(500, 470);
  c1.setVisible(true);
  }catch(Exception e){e.printStackTrace();

  }
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingActionPerformed


// TODO add your handling code here:
    }//GEN-LAST:event_settingActionPerformed

    private void entriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entriesActionPerformed
  try{Setting.Entries.Entries c1=new Setting.Entries.Entries(d);
  c1.setSize(500, 400);
  c1.setVisible(true);
  }catch(Exception e){e.printStackTrace();

  }


// TODO add your handling code here:
    }//GEN-LAST:event_entriesActionPerformed

    private void add_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_balanceActionPerformed

  try{Add.AddNChangeBalance c1=new Add.AddNChangeBalance(d);
  c1.setSize(800, 500);
  c1.setVisible(true);
  }catch(Exception e){e.printStackTrace();

  }


// TODO add your handling code here:
    }//GEN-LAST:event_add_balanceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        Main a=new Main();
        a.setVisible(true);
        a.setTitle("Bansal Dairy");
        a.setSize((int)width, (int)height);
        a.setResizable(false);


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem account_report;
    private javax.swing.JMenuItem accounts;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem add_balance;
    private javax.swing.JMenuItem add_order_account;
    private javax.swing.JMenuItem arrange_accounts;
    private static javax.swing.JLabel back_ground;
    private javax.swing.JMenuItem change_rate;
    private javax.swing.JMenu dailyTransactionMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem entries;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuItem group_report;
    private javax.swing.JMenuItem groups;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu monthlyTransactionMenu;
    private javax.swing.JMenuItem order_transaction;
    private javax.swing.JMenuItem purchase_daily;
    private javax.swing.JMenuItem purchase_fat_daily;
    private javax.swing.JMenuItem purchase_fat_monthly;
    private javax.swing.JMenuItem purchase_fat_reports;
    private javax.swing.JMenuItem purchase_monthly;
    private javax.swing.JMenuItem purchase_report;
    private javax.swing.JMenuItem purchase_snf_daily;
    private javax.swing.JMenuItem purchase_snf_monthly;
    private javax.swing.JMenuItem purchase_snf_report;
    private javax.swing.JMenuItem receive_list;
    private javax.swing.JMenu reportMenu;
    private javax.swing.JMenuItem sale_daily;
    private javax.swing.JMenuItem sale_fat_daily;
    private javax.swing.JMenuItem sale_fat_monthly;
    private javax.swing.JMenuItem sale_fat_reports;
    private javax.swing.JMenuItem sale_monthly;
    private javax.swing.JMenuItem sale_report;
    private javax.swing.JMenuItem sale_snf_daily;
    private javax.swing.JMenuItem sale_snf_monthly;
    private javax.swing.JMenuItem sale_snf_report;
    private javax.swing.JMenu setting;
    // End of variables declaration//GEN-END:variables

}
