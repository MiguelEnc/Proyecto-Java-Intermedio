package com.sge.dao.impl;

import com.sge.dao.EstudianteDao;
import static com.sge.dao.ServiceDao.em;
import com.sge.entity.Estudiante;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
public class EstudianteDaoImpl implements EstudianteDao{

    private EntityTransaction et;
    
    public EstudianteDaoImpl(){
        et = em.getTransaction();
    }
    
    public void save(Estudiante entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Estudiante guardado.");
    }

    public void update(Estudiante entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Estudiante actualizado.");
    }

    public void delete(Estudiante entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Estudiante borrado.");
    }

    public Estudiante findEntity(Integer id) {
        return (Estudiante) em.find(Estudiante.class, id);
    }

    public List<Estudiante> getAll() {
        Query query = em.createNamedQuery("Estudiante.findAll");
        return query.getResultList();
    }    
}
