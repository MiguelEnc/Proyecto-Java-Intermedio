/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.bs;


import com.sge.dao.ServiceDao;
import com.sge.dao.impl.ProfesorDaoImpl;
import com.sge.dao.impl.RegistroDaoImpl;
import com.sge.dao.impl.SesionDaoImpl;

/**
 *
 * @author Usuario
 */
public class DaoFactory {
    
    public static ServiceDao getDao(DaoEnum de) {
        ServiceDao service=null;
        
        switch(de) {
            case PROFESOR:
                service=new ProfesorDaoImpl();
                break;
                
            case SESION:
                service=new SesionDaoImpl();
                break;
                
            case REGISTRO:
                service=new RegistroDaoImpl();
                break;
        }
        
        return service;
    
    }
    
}
