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
