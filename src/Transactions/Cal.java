/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transactions;

/**
 *
 * @author bansal
 */
public class Cal {
static String s="";
public static String month(int mon){
    switch(mon){
        case 1:
            s="JAN";
            break;
        case 2:
            s="FEB";
                    break;
        case 3:
            s="MAR";
            break;
            case 4:
            s="APR";
            break;
            case 5:
            s="MAY";
            break;
            case 6:
            s="JUN";
            break;
            case 7:
            s="JUL";
            break;
            case 8:
            s="AUG";
            break;
            case 9:
            s="SEP";
            break;
            case 10:
            s="OCT";
            break;
            case 11:
            s="NOV";
            break;
            case 12:
            s="DEC";
                break;
    }
    return s;
}

public static int getMaxDays(int mon,int year){
    int days=0;
    switch(mon){
        case 1:
            days=31;
            break;
        case 2:{
         if(year%4==0)
            days=29;
         else days=28;
            break;}
        
        case 3:
            days=31;
            break;
            case 4:
            days=30;
            break;
            case 5:
            days=31;
            break;
            case 6:
            days=30;
            break;
            case 7:
            days=31;
            break;
            case 8:
            days=31;
            break;
            case 9:
            days=30;
            break;
            case 10:
            days=31;
            break;
            case 11:
            days=30;
            break;
            case 12:
            days=31;
                break;
    }
    return days;
}
}
