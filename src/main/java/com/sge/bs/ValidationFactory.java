/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.bs;

import com.sge.bs.validation.RegistroValidation;
import com.sge.bs.validation.Validation;

/**
 *
 * @author Usuario
 */
public class ValidationFactory {
    
    public static Validation getValidation(ValidationEnum ve) {
    
        Validation validation=null;
        
        switch(ve) {
            case SESION:
                validation=new RegistroValidation();
                break;
        }
        
        return validation;
    
    }
    
}
