/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belife.policemanager.helper;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
/**
 *
 * @author fossouulrich
 */
public class Utilities {
    
	 /**
     * Check if a String given is an Integer.
     * @param s
     * @return  isValidInteger
     *          
     */
    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try
        {
           Integer.parseInt(s);
   
           // s is a valid integer
   
           isValidInteger = true;
        }
        catch (NumberFormatException ex)
        {
           // s is not an integer
        }
   
        return isValidInteger;
     }
    
    public static Date getCurrentDate() {
		return new Date();
	}
    
    
    public static void createDirectory(String chemin) {
		File file = new File(chemin);
		if (!file.exists()) {
			try {
				FileUtils.forceMkdir(file);
				//FileUtils.forceMkdir(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
    /**
     * Check if a Integer given is an String.
     * @param i
     * @return  isValidString
     *          
     */
    public static boolean isString(Integer i) {
        boolean isValidString = true;
        try
        {
           Integer.parseInt(i+"");
   
           // i is a valid integer
   
           isValidString = false;
        }
        catch (NumberFormatException ex)
        {
           // i is not an integer
        }
   
        return isValidString;
     }
}
