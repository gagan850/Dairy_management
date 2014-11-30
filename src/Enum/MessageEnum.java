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
public enum MessageEnum {

    DELETE_CONFIRM(Messages.DELETE_CONFIRM, MessagesType.CONFIRM),
    DELETE_SUCCESS(Messages.DELETE_SUCCESS, MessagesType.SUCCESS),
    DELETE_UNSUCCESS(Messages.DELETE_UNSUCCESS, MessagesType.UNSUCCESS),
    SAVE_SUCCESS(Messages.SAVE_SUCCESS, MessagesType.SUCCESS),
    SAVE_UNSUCCESS(Messages.SAVE_UNSUCCESS, MessagesType.UNSUCCESS),
    UPDATE_SUCCESS(Messages.UPDATE_SUCCESS, MessagesType.SUCCESS),
    UPDATE_UNSUCCESS(Messages.UPDATE_UNSUCCESS, MessagesType.UNSUCCESS),
    MANDATORY_FIELD(Messages.MANDATORY_FIELD, MessagesType.INFORM),
    ALREADY_EXIST(Messages.ALREADY_EXIST, MessagesType.INFORM),
    
    ADD(Messages.ADD, ""),
    COUNT(Messages.COUNT, ""),
    ADD_N_CHAANGE(Messages.ADD_N_CHANGE, ""),
    ARRANGE(Messages.ARRANGE, ""),
    WRONG_CHOICE(Messages.WRONG_CHOICE, ""),
    SELECT_NO_CHOICE(Messages.SELECT_NO_CHOICE, ""),
    MISS(Messages.MISS, ""),
    REPORT(Messages.REPORT, ""),
    TRANSACTION(Messages.TRANSACTION, "");
    
    String message;
    String messageType;

    private MessageEnum(String message, String messageType) {
        this.message = message;
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageType() {
        return messageType;
    }

}

class Messages {

    public static final String DELETE_CONFIRM = "Do you want to delete {0} \"s detail?";
    public static final String DELETE_SUCCESS = "{0}: {1} has deleted successfully";
    public static final String DELETE_UNSUCCESS = "{0}: {1} could not be deleted";
    public static final String SAVE_SUCCESS = "{0}: {1} has saved successfully";
    public static final String SAVE_UNSUCCESS = "{0}: {1} could not be saved";
    public static final String UPDATE_SUCCESS = "{0}: {1} has updated successfully";
    public static final String UPDATE_UNSUCCESS = "{0}: {1} could not be updated";
    public static final String MANDATORY_FIELD = "{0} is a mandatory field";
    public static final String ALREADY_EXIST = "{0}: {1} is already exists";

    public static final String ADD = "Add {0}";
    public static final String ADD_N_CHANGE = "Add/Change {0}";
    public static final String COUNT = "No of {0}s: {1}";
    public static final String ARRANGE = "Arrange {0}s";
    public static final String WRONG_CHOICE = "Wrong choice";
    public static final String SELECT_NO_CHOICE = "Please select {0} or {1}";
    public static final String MISS = "{0} Miss";
    public static final String REPORT = "{0} Report";
    public static final String TRANSACTION = "{0} Transaction";
}

class MessagesType {

    public static final String CONFIRM = "Confirmation Message";
    public static final String SUCCESS = "Success Message";
    public static final String UNSUCCESS = "Unsuccess Message";
    public static final String INFORM = "Information Message";

}
