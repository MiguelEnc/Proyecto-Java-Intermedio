package com.sge.dao;

import com.sge.entity.Sesion;

/**
 *
 * @author Usuario
 */
public interface SesionDao extends GenericDao<Sesion,Integer>,ServiceDao{
    
    public Sesion findByCodigo(String codigo);
    public Sesion findByMateriaId(Integer materiaId) ;
   
}
