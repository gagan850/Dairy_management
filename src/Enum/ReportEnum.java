/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Enum;

/**
 *
 * @author Dell
 */
public enum ReportEnum {
   DAILY_DATA(ReportName.DAILY_DATA),
   PURCHASE_BILL(ReportName.PURCHASE_BILL),
   PURCHASE_FAT(ReportName.PURCHASE_FAT),
   PURCHASE_LIST(ReportName.PURCHASE_LIST),
   PURCHASE_MONTHLY(ReportName.PURCHASE_MONTHLY),
   PURCHASE_SNF_ALL(ReportName.PURCHASE_SNF_ALL),
   RECEIVE_LIST(ReportName.RECEIVE_LIST),
   SALE_BILL(ReportName.SALE_BILL),
   SALE_FAT(ReportName.SALE_FAT),
   SALE_LIST(ReportName.SALE_LIST),
   SALE_LIST_PRE(ReportName.SALE_LIST_PRE),
   SALE_MONTHLY(ReportName.SALE_MONTHLY),
   SALE_SNF_ALL(ReportName.SALE_SNF_ALL),
   ACCOUNTS(ReportName.ACCOUNTS),
   GROUPS(ReportName.GROUPS),
   ORDER_BILL(ReportName.ORDER_BILL),
   RECEIVE_LIST_COMPACT(ReportName.RECEIVE_LIST_COMPACT);
   String reportName;
   
   ReportEnum(String reportName){
       this.reportName=reportName;
   }

    public String getReportName() {
        return "\\Report\\"+reportName;
    }

   
class ReportName{
    public static final String DAILY_DATA="Daily_Data.jrxml";
    public static final String PURCHASE_BILL="purchase_bill.jrxml";
    public static final String PURCHASE_FAT="purchase_fat.jrxml";
    public static final String PURCHASE_LIST="purchase_list.jrxml";
    public static final String PURCHASE_MONTHLY="purchase_monthly.jrxml";
    public static final String PURCHASE_SNF_ALL="purchase_snf_all.jrxml";
    public static final String RECEIVE_LIST="Receive_List.jrxml";
    public static final String SALE_BILL="sale_bill.jrxml";
    public static final String SALE_FAT="sale_fat.jrxml";
    public static final String SALE_LIST="sale_list.jrxml";
    public static final String SALE_LIST_PRE="sale_list_pre.jrxml";
    public static final String SALE_MONTHLY="sale_monthly.jrxml";
    public static final String SALE_SNF_ALL="sale_snf_all.jrxml";
    public static final String ACCOUNTS="accounts.jrxml";
    public static final String GROUPS="groups.jrxml";
    public static final String ORDER_BILL="order_bill.jrxml";
    public static final String RECEIVE_LIST_COMPACT="Receive_list_compact.jrxml";
}
}

