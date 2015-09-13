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
            case REGISTRO:
                validation=new RegistroValidation();
                break;
        }
        
        return validation;
    
    }
    
}
