package com.sge.dao.impl;

import com.sge.dao.RegistroDao;
import com.sge.entity.Registro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
public class RegistroDaoImpl implements RegistroDao{

    public EntityTransaction et;
    
    List<Registro> registros;
    
    public RegistroDaoImpl(){
        registros = new ArrayList<Registro>();
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
        //TODO: Implementar
        return registros;
    }

    public List<Registro> getRegistrosBySesion(int sesion) {
        return null;
    }
}
