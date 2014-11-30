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
public enum ImageEnum {

GROUPS(ImageName.GROUPS),
ACCOUNTS(ImageName.ACCOUNTS),
ARRANGE_ACCOUNTS(ImageName.ARRANGE_ACCOUNTS),

CONFIRM(ImageName.CONFIRM),
SUCCESS(ImageName.SUCCESS),
UNSUCCESS(ImageName.UNSUCCESS),

EMPLOYEE(ImageName.EMPLOYEE);

public String imageName;

    public String getImageName() {
        return constant.Constant.IMAGE_FOLDER_NAME+constant.Constant.DOUBLE_BWD_SLASH+imageName;
    }

    private ImageEnum(String imageName) {
    this.imageName=imageName;
    }



}
class ImageName{
    public static final String GROUPS = "groups.png";
public static final String ACCOUNTS = "accounts.png";
public static final String ARRANGE_ACCOUNTS = "atrrange_accounts.png";
public static final String EMPLOYEE = "employee.png";
public static final String EXIT = "exit.png";
public static final String ORDER = "order.png";
public static final String CONFIRM = "confirm.png";
public static final String SUCCESS = "success.png";
public static final String UNSUCCESS = "unsuccess.png";}

