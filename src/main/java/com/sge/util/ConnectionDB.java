/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class ConnectionDB {
    
    private static EntityManagerFactory factory;

    private ConnectionDB() {
    }
    
    
    public static EntityManagerFactory getInstance() {
        
        try {
            if(factory==null) {                
                factory=Persistence.createEntityManagerFactory("com.mycompany_SGE_jar_1.0-SNAPSHOTPU");
            }
        } catch (Exception e) {
            System.out.println("Siglenton Error:: "+ e);
        }
        
        return factory;
    
    }
    
    
    
}
