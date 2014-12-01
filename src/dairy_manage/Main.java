/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dairy_manage;

import Add.*;
import Misc.Note.Notes;
import Transaction.Purchase.PurchaseReport;
import Transaction.Sale.SaleReport;
import java.awt.*;
import java.awt.image.*;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author bansal
 */
public class Main
        extends javax.swing.JFrame {

    static int width = 0;
    static int height = 0;
    ImageIcon icon = null;
    Image image = null;
    BufferedImage bImage = null;

    static {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double w = screenSize.getWidth();
        double h = screenSize.getHeight();
        width = (int) w;
        height = (int) h;
    }

    /**
     * Creates new form MAin
     */
    public Main() {
        initComponents();
        back_ground.setBounds(0, 0, (int) width, (int) height);
        back_ground.setVisible(true);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    Date date = new Date();
                    String d = date.getDate() + "-" + Transaction.Cal.month(date.getMonth() + 1) + "-" + (date.getYear() + 1900) + "_" + date.getHours() + "-" + date.getMinutes();
                    Process process = Runtime.getRuntime().exec("expdp system/bansal schemas=dairy dumpfile=DAIRY_DBase_" + d + ".dmp");
//while(process.)

                } catch (Exception e) {
                    e.printStackTrace();

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
            //bImage = (BufferedImage)(new ImageIcon(ImageEnum.GROUPS.getImageName())).getImage();
            group = new javax.swing.JMenuItem();
            accounts = new javax.swing.JMenuItem()
            ;
            arrangeAccount = new javax.swing.JMenuItem();
            changeRate = new javax.swing.JMenuItem();
            Changebalance = new javax.swing.JMenuItem();
            order = new javax.swing.JMenuItem();
            employee = new javax.swing.JMenuItem();
            exit = new javax.swing.JMenuItem();
            monthlyTransactionMenu = new javax.swing.JMenu();
            saleMon = new javax.swing.JMenuItem();
            purMon = new javax.swing.JMenuItem();
            saleFatMon = new javax.swing.JMenuItem();
            purFatMon = new javax.swing.JMenuItem();
            saleSNFMon = new javax.swing.JMenuItem();
            purSNFMon = new javax.swing.JMenuItem();
            reportMenu = new javax.swing.JMenu();
            accountRep = new javax.swing.JMenuItem();
            groupRep = new javax.swing.JMenuItem();
            saleRep = new javax.swing.JMenuItem();
            purchaseRep = new javax.swing.JMenuItem();
            saleFatRep = new javax.swing.JMenuItem();
            purchaseFatRep = new javax.swing.JMenuItem();
            saleSNFRep = new javax.swing.JMenuItem();
            purchaseSNFRep = new javax.swing.JMenuItem();
            dailyTransactionMenu = new javax.swing.JMenu();
            saleDal = new javax.swing.JMenuItem();
            purchaseDal = new javax.swing.JMenuItem();
            saleFatDal = new javax.swing.JMenuItem();
            purchaseFatDal = new javax.swing.JMenuItem();
            saleSNFDal = new javax.swing.JMenuItem();
            purchaseSNFDal = new javax.swing.JMenuItem();
            jMenu1 = new javax.swing.JMenu();
            receiveList = new javax.swing.JMenuItem();
            orderTransaction = new javax.swing.JMenuItem();
            note = new javax.swing.JMenuItem();
            cashNSpend = new javax.swing.JMenuItem();
            dailyData = new javax.swing.JMenuItem();
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

        group.setMnemonic('o');
        group.setText("Group");
        group.setSelected(true);
        group.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupActionPerformed(evt);
            }
        });
        addMenu.add(group);

        accounts.setMnemonic('s');
        accounts.setText("Account");
        accounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsActionPerformed(evt);
            }
        });
        addMenu.add(accounts);

        arrangeAccount.setText("Arrange Account");
        arrangeAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrangeAccountActionPerformed(evt);
            }
        });
        addMenu.add(arrangeAccount);

        changeRate.setText("Change Rate");
        changeRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeRateActionPerformed(evt);
            }
        });
        addMenu.add(changeRate);
        addMenu.addSeparator();

        Changebalance.setText("Change Balance");
        Changebalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangebalanceActionPerformed(evt);
            }
        });
        addMenu.add(Changebalance);

        order.setText("Order");
        order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderActionPerformed(evt);
            }
        });
        addMenu.add(order);

        employee.setText("Employee");
        employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeActionPerformed(evt);
            }
        });
        addMenu.add(employee);

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

        saleMon.setMnemonic('t');
        saleMon.setText("Sale");
        saleMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleMonActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(saleMon);

        purMon.setMnemonic('y');
        purMon.setText("Purchase");
        purMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purMonActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(purMon);
        monthlyTransactionMenu.addSeparator();

        saleFatMon.setMnemonic('p');
        saleFatMon.setText("Sale Fat");
        saleFatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleFatMonActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(saleFatMon);

        purFatMon.setMnemonic('d');
        purFatMon.setText("Purchase Fat");
        purFatMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purFatMonActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(purFatMon);
        monthlyTransactionMenu.addSeparator();

        saleSNFMon.setText("Sale SNF");
        saleSNFMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleSNFMonActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(saleSNFMon);

        purSNFMon.setText("Purchase SNF");
        purSNFMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purSNFMonActionPerformed(evt);
            }
        });
        monthlyTransactionMenu.add(purSNFMon);

        menuBar.add(monthlyTransactionMenu);

        reportMenu.setMnemonic('r');
        reportMenu.setText("Reports");
        reportMenu.setToolTipText("");

        accountRep.setMnemonic('a');
        accountRep.setText("Account");
        accountRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountRepActionPerformed(evt);
            }
        });
        reportMenu.add(accountRep);

        groupRep.setMnemonic('c');
        groupRep.setText("Group");
        groupRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupRepActionPerformed(evt);
            }
        });
        reportMenu.add(groupRep);
        reportMenu.addSeparator();

        saleRep.setText("Sale");
        saleRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleRepActionPerformed(evt);
            }
        });
        reportMenu.add(saleRep);

        purchaseRep.setText("Purchase");
        purchaseRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseRepActionPerformed(evt);
            }
        });
        reportMenu.add(purchaseRep);
        reportMenu.addSeparator();

        saleFatRep.setText("Sale Fat");
        saleFatRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleFatRepActionPerformed(evt);
            }
        });
        reportMenu.add(saleFatRep);

        purchaseFatRep.setText("Purchase Fat");
        purchaseFatRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseFatRepActionPerformed(evt);
            }
        });
        reportMenu.add(purchaseFatRep);
        reportMenu.addSeparator();

        saleSNFRep.setText("Sale SNF");
        saleSNFRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleSNFRepActionPerformed(evt);
            }
        });
        reportMenu.add(saleSNFRep);

        purchaseSNFRep.setText("Purcahse SNf");
        purchaseSNFRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseSNFRepActionPerformed(evt);
            }
        });
        reportMenu.add(purchaseSNFRep);

        menuBar.add(reportMenu);

        dailyTransactionMenu.setMnemonic('d');
        dailyTransactionMenu.setText("Daily Transaction");
        dailyTransactionMenu.setToolTipText("");

        saleDal.setText("Sale");
        saleDal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleDalActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(saleDal);

        purchaseDal.setText("Purchase");
        purchaseDal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseDalActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(purchaseDal);
        dailyTransactionMenu.addSeparator();

        saleFatDal.setText("Sale Fat");
        saleFatDal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleFatDalActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(saleFatDal);

        purchaseFatDal.setText("Purchase Fat");
        purchaseFatDal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseFatDalActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(purchaseFatDal);
        dailyTransactionMenu.addSeparator();

        saleSNFDal.setText("Sale SNF");
        saleSNFDal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saleSNFDalActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(saleSNFDal);

        purchaseSNFDal.setText("Purcahse SNF");
        purchaseSNFDal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseSNFDalActionPerformed(evt);
            }
        });
        dailyTransactionMenu.add(purchaseSNFDal);

        menuBar.add(dailyTransactionMenu);

        jMenu1.setMnemonic('M');
        jMenu1.setText("Misc");

        receiveList.setText("Receive List");
        receiveList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiveListActionPerformed(evt);
            }
        });
        jMenu1.add(receiveList);

        orderTransaction.setText("Order Transaction");
        orderTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderTransactionActionPerformed(evt);
            }
        });
        jMenu1.add(orderTransaction);

        note.setText("Note");
        note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteActionPerformed(evt);
            }
        });
        jMenu1.add(note);

        cashNSpend.setText("Add Cash / Spend");
        cashNSpend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashNSpendActionPerformed(evt);
            }
        });
        jMenu1.add(cashNSpend);

        dailyData.setText("Daily Data");
        dailyData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dailyDataActionPerformed(evt);
            }
        });
        jMenu1.add(dailyData);

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
        try {
            Date date = new Date();
            String d = date.getDate() + "-" + Transaction.Cal.month(date.getMonth() + 1) + "-" + (date.getYear() + 1900) + "_" + date.getHours() + "-" + date.getMinutes();
            Process runTime = Runtime.getRuntime().exec("expdp system/bansal schemas=dairy dumpfile=DAIRY_DBase_" + d + ".dmp");

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_exitActionPerformed

    private void groupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupActionPerformed
        Group group = new Group(desktopPane);
        group.setVisible(true);
        group.setSize(470, 400);
        group.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_groupActionPerformed

    private void accountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsActionPerformed
        Account account = new Account(desktopPane);
        account.setVisible(true);
        account.setSize(700, 600);
        account.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_accountsActionPerformed

    private void groupRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupRepActionPerformed
        Reports.groups groupReport = new Reports.groups(desktopPane);
        groupReport.setVisible(true);
        groupReport.setSize(500, 500);
        groupReport.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_groupRepActionPerformed

    private void accountRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountRepActionPerformed
        Reports.accounts accountReport = new Reports.accounts(desktopPane);
        accountReport.setVisible(true);
        accountReport.setSize(500, 500);
        accountReport.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_accountRepActionPerformed

    private void monthlyTransactionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyTransactionMenuActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_monthlyTransactionMenuActionPerformed

    private void saleMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleMonActionPerformed

        Transaction.Sale.saleM saleMon = new Transaction.Sale.saleM(desktopPane);
        saleMon.setVisible(true);
        saleMon.setSize(500, 500);
        saleMon.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_saleMonActionPerformed

    private void purMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purMonActionPerformed

        Transaction.Purchase.PurchaseM purchaseMon = new Transaction.Purchase.PurchaseM(desktopPane);
        purchaseMon.setVisible(true);
        purchaseMon.setSize(500, 500);
        purchaseMon.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_purMonActionPerformed

    private void saleDalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleDalActionPerformed
        Transaction.Sale.saleD saleDal = new Transaction.Sale.saleD(desktopPane);
        saleDal.setVisible(true);
        saleDal.setSize(500, 500);
        saleDal.setIconifiable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_saleDalActionPerformed

    private void arrangeAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrangeAccountActionPerformed
        Add.ArrangeAccounts arrangeAccount = new Add.ArrangeAccounts(desktopPane);
        arrangeAccount.setVisible(true);
        arrangeAccount.setSize(600, 500);
        arrangeAccount.setResizable(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_arrangeAccountActionPerformed

    private void saleRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleRepActionPerformed

        SaleReport saleReport = new SaleReport(desktopPane);
        saleReport.setVisible(true);
        saleReport.setSize(650, 500);

// TODO add your handling code here:
    }//GEN-LAST:event_saleRepActionPerformed

    private void changeRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeRateActionPerformed
        AddNChangeRate changeRate = new AddNChangeRate(desktopPane);
        changeRate.setVisible(true);
        changeRate.setSize(700, 500);

// TODO add your handling code here:
    }//GEN-LAST:event_changeRateActionPerformed

    private void purchaseDalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseDalActionPerformed
        Transaction.Purchase.PurchaseD purchaseDal = new Transaction.Purchase.PurchaseD(desktopPane);
        purchaseDal.setVisible(true);
        purchaseDal.setSize(500, 500);
        purchaseDal.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseDalActionPerformed

    private void purchaseRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseRepActionPerformed
        PurchaseReport purchaseReport = new PurchaseReport(desktopPane);
        purchaseReport.setVisible(true);
        purchaseReport.setSize(500, 500);
// TODO add your handling code here:
    }//GEN-LAST:event_purchaseRepActionPerformed

    private void saleFatRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleFatRepActionPerformed

        Reports.SaleFatBill saleFatRep = new Reports.SaleFatBill(desktopPane);
        saleFatRep.setVisible(true);
        saleFatRep.setSize(700, 500);

    }//GEN-LAST:event_saleFatRepActionPerformed

    private void saleFatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleFatMonActionPerformed
        Transaction.SaleFAT.saleFATM saleFatMon = new Transaction.SaleFAT.saleFATM(desktopPane);
        saleFatMon.setVisible(true);
        saleFatMon.setSize(500, 500);
        saleFatMon.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_saleFatMonActionPerformed

    private void purFatMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purFatMonActionPerformed
        Transaction.PurFAT.PurFATM purFatMon = new Transaction.PurFAT.PurFATM(desktopPane);
        purFatMon.setVisible(true);
        purFatMon.setSize(500, 500);
        purFatMon.setIconifiable(true);
// TODO add your handling code here:
    }//GEN-LAST:event_purFatMonActionPerformed

    private void saleFatDalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleFatDalActionPerformed
        Transaction.SaleFAT.saleFATD saleFatDal = new Transaction.SaleFAT.saleFATD(desktopPane);
        saleFatDal.setVisible(true);
        saleFatDal.setSize(500, 500);
        saleFatDal.setIconifiable(true);
// TODO add your handling code here:
    }//GEN-LAST:event_saleFatDalActionPerformed

    private void purchaseFatDalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseFatDalActionPerformed
        Transaction.PurFAT.PurFATD purFatDal = new Transaction.PurFAT.PurFATD(desktopPane);
        purFatDal.setVisible(true);
        purFatDal.setSize(500, 500);
        purFatDal.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseFatDalActionPerformed

    private void purchaseFatRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseFatRepActionPerformed

        Reports.PurchaseFatBill purchaseFatReport = new Reports.PurchaseFatBill(desktopPane);
        purchaseFatReport.setVisible(true);
        purchaseFatReport.setSize(700, 500);
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseFatRepActionPerformed

    private void saleSNFMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleSNFMonActionPerformed

        Transaction.SaleSNF.saleSNFM saleSNFMon = new Transaction.SaleSNF.saleSNFM(desktopPane);
        saleSNFMon.setVisible(true);
        saleSNFMon.setSize(500, 500);
        saleSNFMon.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_saleSNFMonActionPerformed

    private void saleSNFDalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleSNFDalActionPerformed
        Transaction.SaleSNF.saleSNFD saleSNFDal = new Transaction.SaleSNF.saleSNFD(desktopPane);
        saleSNFDal.setVisible(true);
        saleSNFDal.setSize(500, 500);
        saleSNFDal.setIconifiable(true);

// TODO add your handling code here:
    }//GEN-LAST:event_saleSNFDalActionPerformed

    private void purSNFMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purSNFMonActionPerformed
        Transaction.PurSNF.PurSNFM purSNFMon = new Transaction.PurSNF.PurSNFM(desktopPane);
        purSNFMon.setVisible(true);
        purSNFMon.setSize(500, 500);
        purSNFMon.setIconifiable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_purSNFMonActionPerformed

    private void purchaseSNFDalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseSNFDalActionPerformed
        Transaction.PurSNF.PurSNFD purchaseSNFDal = new Transaction.PurSNF.PurSNFD(desktopPane);
        purchaseSNFDal.setVisible(true);
        purchaseSNFDal.setSize(500, 500);
        purchaseSNFDal.setIconifiable(true);        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseSNFDalActionPerformed

    private void saleSNFRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saleSNFRepActionPerformed
        Reports.SaleSnfBill saleSNFReport = new Reports.SaleSnfBill(desktopPane);
        saleSNFReport.setVisible(true);
        saleSNFReport.setSize(700, 500);
        // TODO add your handling code here:
    }//GEN-LAST:event_saleSNFRepActionPerformed

    private void purchaseSNFRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseSNFRepActionPerformed
        Reports.PurchaseSnfBill purchaseSNFReport = new Reports.PurchaseSnfBill(desktopPane);
        purchaseSNFReport.setVisible(true);
        purchaseSNFReport.setSize(700, 500);
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseSNFRepActionPerformed

    private void noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteActionPerformed
        Notes note = new Notes(desktopPane);
        note.setVisible(true);
        note.setSize(700, 600);
// TODO add your handling code here:
    }//GEN-LAST:event_noteActionPerformed

    private void orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderActionPerformed

        Add.Order order = new Add.Order(desktopPane);
        order.setVisible(true);
        order.setSize(700, 600);

// TODO add your handling code here:
    }//GEN-LAST:event_orderActionPerformed

    private void orderTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderTransactionActionPerformed

        Misc.Order.order_transactions orderTransaction = new Misc.Order.order_transactions(desktopPane);
        orderTransaction.setVisible(true);
        orderTransaction.setSize(700, 600);

// TODO add your handling code here:
    }//GEN-LAST:event_orderTransactionActionPerformed

    private void employeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeActionPerformed
        Add.Employee employee = new Add.Employee(desktopPane);
        employee.setSize(500, 450);
        employee.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_employeeActionPerformed

    private void receiveListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiveListActionPerformed
        Reports.Receive_List receiveList = new Reports.Receive_List(desktopPane);
        receiveList.setSize(600, 600);
        receiveList.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_receiveListActionPerformed

    private void dailyDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dailyDataActionPerformed
        Misc.DailyData.DailyData dailyData = new Misc.DailyData.DailyData(desktopPane);
        dailyData.setSize(600, 600);
        dailyData.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_dailyDataActionPerformed

    private void cashNSpendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashNSpendActionPerformed
        Misc.Cash.Cash cash = new Misc.Cash.Cash(desktopPane);
        cash.setSize(500, 470);
        cash.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_cashNSpendActionPerformed

    private void settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_settingActionPerformed

    private void entriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entriesActionPerformed
        Setting.Entries.Entries entry = new Setting.Entries.Entries(desktopPane);
        entry.setSize(500, 400);
        entry.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_entriesActionPerformed

    private void ChangebalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangebalanceActionPerformed

        Add.AddNChangeBalance changeBalance = new Add.AddNChangeBalance(desktopPane);
        changeBalance.setSize(800, 500);
        changeBalance.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_ChangebalanceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Main main = new Main();
        main.setVisible(true);
        main.setTitle(constant.Constant.FIRM_NAME);
        main.setSize((int) width, (int) height);
        main.setResizable(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Changebalance;
    private javax.swing.JMenuItem accountRep;
    private javax.swing.JMenuItem accounts;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem arrangeAccount;
    private static javax.swing.JLabel back_ground;
    private javax.swing.JMenuItem cashNSpend;
    private javax.swing.JMenuItem changeRate;
    private javax.swing.JMenuItem dailyData;
    private javax.swing.JMenu dailyTransactionMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem employee;
    private javax.swing.JMenuItem entries;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuItem group;
    private javax.swing.JMenuItem groupRep;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu monthlyTransactionMenu;
    private javax.swing.JMenuItem note;
    private javax.swing.JMenuItem order;
    private javax.swing.JMenuItem orderTransaction;
    private javax.swing.JMenuItem purFatMon;
    private javax.swing.JMenuItem purMon;
    private javax.swing.JMenuItem purSNFMon;
    private javax.swing.JMenuItem purchaseDal;
    private javax.swing.JMenuItem purchaseFatDal;
    private javax.swing.JMenuItem purchaseFatRep;
    private javax.swing.JMenuItem purchaseRep;
    private javax.swing.JMenuItem purchaseSNFDal;
    private javax.swing.JMenuItem purchaseSNFRep;
    private javax.swing.JMenuItem receiveList;
    private javax.swing.JMenu reportMenu;
    private javax.swing.JMenuItem saleDal;
    private javax.swing.JMenuItem saleFatDal;
    private javax.swing.JMenuItem saleFatMon;
    private javax.swing.JMenuItem saleFatRep;
    private javax.swing.JMenuItem saleMon;
    private javax.swing.JMenuItem saleRep;
    private javax.swing.JMenuItem saleSNFDal;
    private javax.swing.JMenuItem saleSNFMon;
    private javax.swing.JMenuItem saleSNFRep;
    private javax.swing.JMenu setting;
    // End of variables declaration//GEN-END:variables

}
