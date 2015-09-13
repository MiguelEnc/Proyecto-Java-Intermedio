package com.sge.dao;

import com.sge.entity.Estudiante;

/**
 *
 * @author miguel
 */
public interface EstudianteDao extends GenericDao<Estudiante,Integer>, ServiceDao{
    
    public Estudiante findEstudianteByMateria(String materia);
}