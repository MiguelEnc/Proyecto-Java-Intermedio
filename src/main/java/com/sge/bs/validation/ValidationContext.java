/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.bs.validation;

import com.sge.bs.ValidationEnum;
import com.sge.bs.ValidationFactory;

/**
 *
 * @author Usuario
 */
public class ValidationContext<T> {
    
    private Validation validation;

    public ValidationContext(ValidationEnum ve) {
        validation=ValidationFactory.getValidation(ve);
    }
    
    
    public void execute(T t) {
        validation.doExcution(t);
    }
    
}
