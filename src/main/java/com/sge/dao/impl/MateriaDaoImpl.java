package com.sge.dao.impl;

import com.sge.dao.MateriaDao;
import com.sge.entity.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author miguel
 */
public class MateriaDaoImpl implements MateriaDao{

    public EntityTransaction et;
    
    List<Materia> materias;
    
    public MateriaDaoImpl(){
        materias = new ArrayList<Materia>();
        et = em.getTransaction();
    }
    
    public void save(Materia entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Materia guardada.");
    }

    public void update(Materia entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Materia actualizada");
    }

    public void delete(Materia entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Materia borrada");
    }

    public Materia findEntity(Integer id) {
        return (Materia) em.find(Materia.class, id);
    }

    public List<Materia> getAll() {
        //TODO: implementar
        return materias;
    }
    
}
