package com.sge.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class ConnectionDB {
    
    private static EntityManagerFactory factory = null;

    private ConnectionDB(){}
    
    public static EntityManagerFactory getInstance() {
        
        try {
            if(factory==null) {                
                factory=Persistence.createEntityManagerFactory("SGE_PU");
            }
        } catch (Exception e) {
            System.out.println("Siglenton Error:: "+ e);
        }
        
        return factory;
    
    }
    
    
    
}
