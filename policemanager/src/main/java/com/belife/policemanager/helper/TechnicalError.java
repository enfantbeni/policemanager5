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
public class TechnicalError{
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
   
    public static Status DB_NOT_CONNECT(String message){
        status.setCode(StatusCode.TECH_DB_NOT_CONNECT);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.TECH_DB_NOT_CONNECT);
        else 
           status.setMessage(StatusMessage.TECH_DB_NOT_CONNECT+" -- "+message);
        return status ;
    }
    
     public static Status DB_FAIL(String message){
        status.setCode(StatusCode.TECH_DB_FAIL);
        if(message==null || message.isEmpty())
        	status.setMessage(StatusMessage.TECH_DB_FAIL);
        else 
           status.setMessage(StatusMessage.TECH_DB_FAIL+" -- "+message);
        return status ;
    }
  
     public static Status INTERN_ERROR(String message){
         status.setCode(StatusCode.TECH_INTERN_ERROR);
         if(message==null || message.isEmpty())
         	status.setMessage(StatusMessage.TECH_INTERN_ERROR);
         else 
            status.setMessage(StatusMessage.TECH_INTERN_ERROR+" -- "+message);
         return status ;
     }
     
     public static Status DB_PERMISSION_DENIED(String message){
         status.setCode(StatusCode.TECH_DB_PERMISSION_DENIED);
         if(message==null || message.isEmpty())
          	status.setMessage(StatusMessage.TECH_DB_PERMISSION_DENIED);
          else 
             status.setMessage(StatusMessage.TECH_DB_PERMISSION_DENIED+" -- "+message);
         return status ;
     }
     
     public static Status DB_QUERY_REFUSED(String message){
         status.setCode(StatusCode.TECH_DB_QUERY_REFUSED);
         if(message==null || message.isEmpty())
          	status.setMessage(StatusMessage.TECH_DB_QUERY_REFUSED);
          else 
             status.setMessage(StatusMessage.TECH_DB_QUERY_REFUSED+" -- "+message);
         return status ;
     }
     
     
     

}
