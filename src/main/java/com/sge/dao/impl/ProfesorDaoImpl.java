package com.sge.dao.impl;

import com.sge.dao.ProfesorDao;
import static com.sge.dao.ServiceDao.em;
import com.sge.entity.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Usuario
 */
public class ProfesorDaoImpl implements ProfesorDao {
    
    private EntityTransaction et;

    List<Profesor> profesores;
    
    public ProfesorDaoImpl(){
        profesores = new ArrayList<Profesor>();
        et = em.getTransaction();
    }
    
    public void save(Profesor entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Profesor guardado.");
    }

    public void update(Profesor entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Profesor actualizado.");
    }

    public void delete(Profesor entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Profesor borrado.");
    }

    public Profesor findEntity(Integer id) {
        return (Profesor) em.find(Profesor.class, id);
    }

    public List<Profesor> getAll() {
        //TODO: implementar
        return profesores;
    }
    
}
