package com.sge.dao.impl;

import com.sge.dao.AulaDao;
import com.sge.entity.Aula;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author miguel
 */
public class AulaDaoImpl implements AulaDao{
    
    
    private EntityTransaction et;

    List<Aula> aulas;
    
    public AulaDaoImpl(){
        aulas = new ArrayList<Aula>();
        et = em.getTransaction();
    }
    
    public void save(Aula entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Aula guardada.");
    }

    public void update(Aula entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Aula actualizada.");
    }

    public void delete(Aula entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Aula borrada.");
    }

    public Aula findEntity(Integer id) {
        return (Aula) em.find(Aula.class, id);
    }

    public List<Aula> getAll() {
        //TODO: implementar
        return aulas;
    }
    
}
