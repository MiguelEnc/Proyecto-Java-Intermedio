package com.sge.dao.impl;

import com.sge.dao.SesionDao;
import com.sge.entity.Sesion;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class SesionDaoImpl implements SesionDao {

    public EntityTransaction et;
    
    public SesionDaoImpl(){
        et = em.getTransaction();
    }
    
    public void save(Sesion entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Sesion guardada.");
    }

    public void update(Sesion entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Sesion actualizada.");
    }

    public void delete(Sesion entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Sesion borrada.");
    }

    public Sesion findEntity(Integer id) {
        return (Sesion) em.find(Sesion.class, id);
    }

    public List<Sesion> getAll() {
        Query query = em.createNamedQuery("Sesion.findAll");
        return query.getResultList();
    }

    public Sesion findByMateriaId(Integer materiaId) {
        Query query = em.createNamedQuery("Sesion.findByMateriaId");
        query.setParameter("materiaId", materiaId);
        return (Sesion) query.getSingleResult();
    }
    
}
