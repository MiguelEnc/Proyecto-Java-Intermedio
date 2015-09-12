package com.sge.dao.impl;

import com.sge.dao.GrupoDao;
import static com.sge.dao.ServiceDao.em;
import com.sge.entity.Grupo;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
public class GrupoDaoImpl implements GrupoDao{
    
    public EntityTransaction et;
    
    public GrupoDaoImpl(){
        et = em.getTransaction();
    }
    
    public void save(Grupo entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Grupo guardado.");
    }

    public void update(Grupo entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Grupo actualizado.");
    }

    public void delete(Grupo entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Grupo borrado.");
    }

    public Grupo findEntity(Integer id) {
        return (Grupo) em.find(Grupo.class, id);
    }

    public List<Grupo> getAll() {
        try {
            Query query = em.createNamedQuery("Grupo.findAll");
        return query.getResultList();
        } catch (Exception e) {return null;
        }
        
    }
    
}
