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
public enum DBTableEnum {

    CASH(DBTableEnum.TableNames.CASH),
    DAILY_DATA(DBTableEnum.TableNames.DAILY_DATA),
    ENTRIES(DBTableEnum.TableNames.ENTRIES),
    ACCOUNTS(DBTableEnum.TableNames.ACCOUNTS),
    GROUPS(DBTableEnum.TableNames.GROUPS),
    SPEND(DBTableEnum.TableNames.SPEND),
    ACCOUNT_TYPE(DBTableEnum.TableNames.ACCOUNT_TYPE),
    EMPLOYEES(DBTableEnum.TableNames.EMPLOYEES),
    NOTES(DBTableEnum.TableNames.NOTES),
    ORDER_ACCOUNT(DBTableEnum.TableNames.ORDER_ACCOUNT),
    ORDER_TRANSACTIONS(DBTableEnum.TableNames.ORDER_TRANSACTIONS),
    SALE_TRANSACTIONS(DBTableEnum.TableNames.SALE_TRANSACTIONS),
    SALE_FAT_TRANSACTIONS(DBTableEnum.TableNames.SALE_FAT_TRANSACTIONS),
    SALE_SNF_TRANSACTIONS(DBTableEnum.TableNames.SALE_SNF_TRANSACTIONS),
    PURCHASE_TRANSACTIONS(DBTableEnum.TableNames.PURCHASE_TRANSACTIONS),
    PUR_FAT_TRANSACTIONS(DBTableEnum.TableNames.PUR_FAT_TRANSACTIONS),
    PUR_SNF_TRANSACTIONS(DBTableEnum.TableNames.PUR_SNF_TRANSACTIONS);
    public String tableName;

    DBTableEnum(String tableName) {
        this.tableName = tableName;

    }

    public String getTableName() {
        return tableName;
    }

    public class TableNames {

        public static final String CASH = "CASH";
        public static final String DAILY_DATA = "DAILY_DATA";
        public static final String ENTRIES = "ENTRIES";
        public static final String GROUPS = "GROUPS";
        public static final String ACCOUNTS = "ACCOUNTS";
        public static final String SALE_TRANSACTIONS = "SALE_TRANSACTIONS";
        public static final String SPEND = "SPEND";
        public static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";
        public static final String EMPLOYEES = "EMPLOYEES";
        public static final String NOTES = "NOTES";
        public static final String ORDER_ACCOUNT = "ORDER_ACCOUNT";
        public static final String ORDER_TRANSACTIONS = "ORDER_TRANSACTIONS";
        public static final String SALE_SNF_TRANSACTIONS = "SALE_SNF_TRANSACTIONS";
        public static final String SALE_FAT_TRANSACTIONS = "SALE_FAT_TRANSACTIONS";
        public static final String PURCHASE_TRANSACTIONS = "PURCHASE_TRANSACTIONS";
        public static final String PUR_SNF_TRANSACTIONS = "PUR_SNF_TRANSACTIONS";
        public static final String PUR_FAT_TRANSACTIONS = "PUR_FAT_TRANSACTIONS";
    }
}
