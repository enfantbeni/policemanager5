/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belife.policemanager.helper;


import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fossouulrich
 */
@XmlRootElement
public class FunctionalError{
    private String code;
    private String message;
    private static Status status=new Status();
  
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Status AUTH_FAIL(String message){
        status.setCode(StatusCode.FUNC_AUTH_FAIL);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_AUTH_FAIL);
        else 
           status.setMessage(StatusMessage.FUNC_AUTH_FAIL+" -- "+message);
        
        return status ;
    }
    
     public static Status DATA_NOT_EXIST(String message){
        status.setCode(StatusCode.FUNC_DATA_NOT_EXIST);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_DATA_NOT_EXIST);
        else 
           status.setMessage(StatusMessage.FUNC_DATA_NOT_EXIST+" -- "+message);
        return status ;
    }
     
    public static Status DATA_EMPTY(String message){
        status.setCode(StatusCode.FUNC_DATA_EMPTY);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_DATA_EMPTY);
        else 
           status.setMessage(StatusMessage.FUNC_DATA_EMPTY+" -- "+message);
        return status ;
    }
    
    public static Status DATA_EXIST(String message){
        status.setCode(StatusCode.FUNC_DATA_EXIST);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_DATA_EXIST);
        else 
           status.setMessage(StatusMessage.FUNC_DATA_EXIST+" -- "+message);
        
        return status ;
    }
     
    public static Status FIELD_EMPTY(String message){
        status.setCode(StatusCode.FUNC_FIELD_EMPTY);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_FIELD_EMPTY);
        else 
           status.setMessage(StatusMessage.FUNC_FIELD_EMPTY+" -- "+message);
        return status ;
    }
    
    public static Status USER_ALREADY_CONNECTED(String message){
        status.setCode(StatusCode.FUNC_USER_ALREADY_CONNECTED);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_USER_ALREADY_CONNECTED);
        else 
           status.setMessage(StatusMessage.FUNC_USER_ALREADY_CONNECTED+" -- "+message);
        return status ;
    }
    
    public static Status REQUEST_FAIL(String message){
        status.setCode(StatusCode.FUNC_REQUEST_FAIL);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_REQUEST_FAIL);
        else 
           status.setMessage(StatusMessage.FUNC_REQUEST_FAIL+" -- "+message);
        return status ;
    }
    
    public static Status TYPE_NOT_CORRECT(String message){
        status.setCode(StatusCode.FUNC_TYPE_NOT_CORRECT);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_TYPE_NOT_CORRECT);
        else 
           status.setMessage(StatusMessage.FUNC_TYPE_NOT_CORRECT+" -- "+message);
        return status ;
    }
    
    
    public static Status DATE_FORMAT_NOT_CORRECT(String message){
        status.setCode(StatusCode.FUNC_DATE_FORMAT_NOT_CORRECT);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_DATE_FORMAT_NOT_CORRECT);
        else 
           status.setMessage(StatusMessage.FUNC_DATE_FORMAT_NOT_CORRECT+" -- "+message);
        return status ;
    }
    
    public static Status INVALID_FORMAT(String message){
        status.setCode(StatusCode.FUNC_INVALID_FORMAT);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.FUNC_INVALID_FORMAT);
        else 
           status.setMessage(StatusMessage.FUNC_INVALID_FORMAT+" -- "+message);
        return status ;
    }
    
    
 
}
