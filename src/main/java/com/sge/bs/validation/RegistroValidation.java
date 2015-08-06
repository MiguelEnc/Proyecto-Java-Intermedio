/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.bs.validation;

import com.sge.bs.DaoEnum;
import com.sge.bs.DaoFactory;
import com.sge.dao.RegistroDao;
import com.sge.dao.SesionDao;
import com.sge.entity.Registro;
import com.sge.entity.Sesion;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class RegistroValidation implements Validation<Registro> {

    private RegistroDao registroDao=(RegistroDao) DaoFactory.getDao(DaoEnum.REGISTRO);
    private SesionDao sesionDao=(SesionDao) DaoFactory.getDao(DaoEnum.SESION);
    
    public void doExcution(Registro object) {
       // write your code here
    
    }

    private boolean validate(Registro reg) {
        
        
        return true; // write your code here
        
    
    }
    
    
    

   
    
}
