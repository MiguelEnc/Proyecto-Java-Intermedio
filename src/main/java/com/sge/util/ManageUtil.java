package com.sge.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ManageUtil {
    
    public static Date strToDate(String date) {
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        Date to=null;
        try {
            to=sdf.parse(date);
        } catch (Exception e) {
            System.out.println("strToDate Error:: "+ e);
        }
        
        return to;
    
    }
            
    
}
