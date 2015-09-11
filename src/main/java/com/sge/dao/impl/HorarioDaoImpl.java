package com.sge.dao.impl;

import com.sge.dao.HorarioDao;
import static com.sge.dao.ServiceDao.em;
import com.sge.entity.Horario;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
public class HorarioDaoImpl implements HorarioDao{

    public EntityTransaction et;
    
    public HorarioDaoImpl(){
        et = em.getTransaction();
    }
    
    public void save(Horario entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Horario guardado.");
    }

    public void update(Horario entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Horario actualizado.");
    }

    public void delete(Horario entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Horario borrado.");
    }

    public Horario findEntity(Integer id) {
        return (Horario) em.find(Horario.class, id);
    }

    public List<Horario> getAll() {
        Query query = em.createNamedQuery("Horario.findAll");
        return query.getResultList();
    }
    
}
