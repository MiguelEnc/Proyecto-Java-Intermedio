/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.dao.impl;

import com.sge.dao.ServiceDao;
import com.sge.dao.ProfesorDao;
import com.sge.entity.Profesor;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Usuario
 */
public class ProfesorDaoImpl implements ProfesorDao {
    
    private EntityTransaction tx;

    public void save(Profesor entity) {
        // write your code here
    
    }

    public void update(Profesor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Profesor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Profesor findEntity(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Profesor> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
