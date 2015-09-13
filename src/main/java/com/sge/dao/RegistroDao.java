package com.sge.dao;

import com.sge.entity.Registro;

/**
 *
 * @author Usuario
 */
public interface RegistroDao extends GenericDao<Registro,Integer>,ServiceDao{
    
    public Registro getRegistrosByEstudianteId(int id );
}
