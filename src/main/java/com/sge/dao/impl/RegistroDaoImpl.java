/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.dao.impl;

import com.sge.dao.RegistroDao;
import com.sge.entity.Registro;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class RegistroDaoImpl implements RegistroDao{

    public void save(Registro entity) {
        // write your code here
    
    }

    public void update(Registro entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Registro entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Registro findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Registro> getAll() {
        return null; // write your code here
    
    }

    public List<Registro> getRegistrosBySesion(int sesion) {
        return null;
    
    }
    
}
