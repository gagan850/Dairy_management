/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author gagandeepbansal
 */
public class Constant {

    public final static ArrayList<String> account_name;

    static {
        account_name = new ArrayList<String>();
        account_name.add("Sale");
        account_name.add("Purchase");
        account_name.add("Fat Sale");
        account_name.add("Fat Purchase");
        account_name.add("SNF Sale");
        account_name.add("SNF Purchase");

    }

    public static final String FIRM_NAME = "Bansal Dairy";

    public static final String IMAGE_FOLDER_NAME = "Img";
    public static final String HYPHEN = "-";
    public static final String EMPTY_STRING = "";
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";
    public static final String DOT = ".";
    public static final String DOUBLE_BWD_SLASH = "\\";
    public static final String FORWARD_SLASH = "/";
    public static final String GROUP = "Group";
    public static final String ACCOUNT = "Account";
    public static final String EMPLOYEE = "Employee";
    public static final String SAVE = "Save";
    public static final String UPDATE = "Update";
    public static final String ORDER = "Order";
    public static final String BALANCE = "Balance";
    public static final String RATE = "Rate";
    public static final String BEFORE = "Before";
    public static final String AFTER = "After";
    public static final String START = "start";
    public static final String END = "end";
    public static final String SALE = "Sale";
    public static final String PURCHASE = "Purchase";
    public static final String CASH = "Cash";
    public static final String SALE_FAT = "Sale Fat";
    public static final String SALE_SNF = "Sale SNF";
    public static final String PURCHASE_FAT = "Purchase Fat";
    public static final String PURCHASE_SNF = "Purchase SNF";

    public static final String RECEIVE = "Receive";
    public static final String SPEND = "Spend";
    public static final String DAILY_DATA = "Daily Data";
    public static final String REPORT = "Report";

    public static final int INTEGER_MINUS_ONE = -1;
    public static final int INTEGER_ZERO = 0;
    public static final int INTEGER_ONE = 1;
    public static final int INTEGER_TWO = 2;
    public static final int INTEGER_THREE = 3;
    public static final int INTEGER_FOUR = 4;
    public static final int INTEGER_FIVE = 5;
    public static final int INTEGER_SIX = 6;
    public static final int INTEGER_SEVEN = 7;
    public static final int INTEGER_EIGHT = 8;
    public static final int INTEGER_NINE = 9;
    public static final int INTEGER_TEN = 10;
    public static final int INTEGER_ELEVEN = 11;
    public static final int INTEGER_TWELVE = 12;
    public static final int INTEGER_THIRTEEN = 13;
    public static final int INTEGER_FOURTEEN = 14;
    public static final int INTEGER_FIFTEEN = 15;
    public static final int INTEGER_SIXTEEN = 16;
    public static final int INTEGER_NINETEEN_HUNDRED = 1900;

    public static final String ONE = "1";
    public static final String TWO = "2";
    public static final String THREE = "3";
    public static final String FOUR = "4";
    public static final String FIVE = "5";

    public static String getAccountType(String acc) {
        if (acc.equalsIgnoreCase("s")) {
            return "Sale";
        } else if (acc.equalsIgnoreCase("p")) {
            return "Purchase";
        } else if (acc.equalsIgnoreCase("sfat")) {
            return "Fat Sale";
        } else if (acc.equalsIgnoreCase("pfat")) {
            return "Fat Purchase";
        } else if (acc.equalsIgnoreCase("ssnf")) {
            return "SNF Sale";
        } else {
            return "SNF Purchase";
        }
    }

    public static int width = 0;
    public static int height = 0;

    static {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double w = screenSize.getWidth();
        double h = screenSize.getHeight();
        width = (int) w;
        height = (int) h;
    }
}
