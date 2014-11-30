/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package constant;

/**
 *
 * @author gagandeepbansal
 */
public class AccountType {
  
public static final int SALE=1;
public static final int PURCHASE=2;
public static final int SALE_FAT=3;
public static final int PURCHASE_FAT=4;
public static final int SALE_SNF=5;
public static final int PURCHASE_SNF=6;
public static final int FAT_SALE_MULTIPLE=7; 
public static final int FAT_PURCHASE_MULTIPLE=8;
public static final int SNF_SALE_MULTIPLE=9;
public static final int SNF_PURCHASE_MULTIPLE=10;


public static String getString(int choice){
    String answer="";
    switch(choice){
        case 7:
            answer="Fat Sale Multiple";
            break;
        case 8:
            answer="Fat Purchase Multiple";
            break;
            case 9:
            answer="SNF Sale Multiple";
            break;
            case 10:
            answer="SNF Purchase Multiple";
            break;
    }
    return answer;
}

public static int getInt(String choice){
    int answer=0;
    
    if(choice.equals("Fat Sale Multiple"))answer=7;
    if(choice.equals("Fat Purchase Multiple"))answer= 8;
    if(choice.equals("SNF Sale Multiple"))answer=9;
    if(choice.equals("SNF Purchase Multiple"))answer=10;
     
    return answer;
}


}


