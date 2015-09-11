package com.sge.dao.impl;

import com.sge.dao.RegistroDao;
import com.sge.entity.Registro;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class RegistroDaoImpl implements RegistroDao{

    public EntityTransaction et;
    
    public RegistroDaoImpl(){
        et = em.getTransaction();
    }
    
    public void save(Registro entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Registro guardado.");
    }

    public void update(Registro entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Registro actualizado.");
    }

    public void delete(Registro entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Registro borrado.");
    }

    public Registro findEntity(Integer id) {
        return (Registro) em.find(Registro.class, id);
    }

    public List<Registro> getAll() {
        Query query = em.createNamedQuery("Registro.findAll");
        return query.getResultList();
    }

    public List<Registro> getRegistrosBySesion(int sesion) {
        Query query = em.createNamedQuery("Registro.findByHorarioSesionId");
        query.setParameter("horarioSesionId", sesion);
        return query.getResultList();
    }
}
