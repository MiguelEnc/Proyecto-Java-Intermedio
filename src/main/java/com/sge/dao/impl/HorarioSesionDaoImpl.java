package com.sge.dao.impl;

import com.sge.dao.HorarioSesionDao;
import com.sge.entity.HorarioSesion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author miguel
 */
public class HorarioSesionDaoImpl implements HorarioSesionDao{

    public EntityTransaction et;
    
    List<HorarioSesion> horariosSesion;
    
    public HorarioSesionDaoImpl(){
        horariosSesion = new ArrayList<HorarioSesion>();
        et = em.getTransaction();
    }
    
    public void save(HorarioSesion entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("HorarioSesion guardado.");
    }

    public void update(HorarioSesion entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("HorarioSesion actualizado.");
    }

    public void delete(HorarioSesion entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Horariosesion eliminado");
    }

    public HorarioSesion findEntity(Integer id) {
        return (HorarioSesion) em.find(HorarioSesion.class, id);
    }

    public List<HorarioSesion> getAll() {
        //TODO: Implementar
        return horariosSesion;
    }
    
}
