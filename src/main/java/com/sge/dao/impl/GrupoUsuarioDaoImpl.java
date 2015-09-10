package com.sge.dao.impl;

import com.sge.dao.GrupoUsuarioDao;
import com.sge.entity.GrupoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author miguel
 */
public class GrupoUsuarioDaoImpl implements GrupoUsuarioDao{
    
    public EntityTransaction et;
    
    List<GrupoUsuario> gruposUsuarios;

    public GrupoUsuarioDaoImpl() {
        gruposUsuarios = new ArrayList<GrupoUsuario>();
        et = em.getTransaction();
    }
    
    public void save(GrupoUsuario entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("GrupoUsuario guardado.");
    }

    public void update(GrupoUsuario entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("GrupoUsuario acualizado.");
    }

    public void delete(GrupoUsuario entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("GrupoUsuario borrado.");
    }

    public GrupoUsuario findEntity(Integer id) {
        return (GrupoUsuario) em.find(GrupoUsuario.class, id);
    }

    public List<GrupoUsuario> getAll() {
        //TODO:Implementar
        return gruposUsuarios;
    }
    
}
