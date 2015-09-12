package com.sge.dao.impl;

import com.sge.dao.MateriaDao;
import static com.sge.dao.ServiceDao.em;
import com.sge.entity.Materia;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
public class MateriaDaoImpl implements MateriaDao{

    public EntityTransaction et;
    
    public MateriaDaoImpl(){
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
        try {
            Query query = em.createNamedQuery("Materia.findAll");
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
        
    }
    
}
