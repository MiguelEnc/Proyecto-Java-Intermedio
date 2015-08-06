/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.dao;

import com.sge.util.ConnectionDB;
import javax.persistence.EntityManager;



/**
 *
 * @author Usuario
 */
public interface ServiceDao {
    
    public EntityManager em=ConnectionDB.getInstance().createEntityManager();
    
}
