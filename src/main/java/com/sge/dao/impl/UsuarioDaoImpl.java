package com.sge.dao.impl;

import com.sge.dao.UsuarioDao;
import com.sge.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityTransaction;

/**
 *
 * @author miguel
 */
public class UsuarioDaoImpl implements UsuarioDao{

    public EntityTransaction et;
    
    List<Usuario> usuarios;
    
    public UsuarioDaoImpl(){
        usuarios = new ArrayList<Usuario>();
        et = em.getTransaction();
    }
    
    public void save(Usuario entity) {
        et.begin();
        em.persist(entity);
        et.commit();
        System.out.println("Usuario guardado.");
    }

    public void update(Usuario entity) {
        et.begin();
        em.merge(entity);
        et.commit();
        System.out.println("Usuario actualizado.");
    }

    public void delete(Usuario entity) {
        et.begin();
        em.remove(em.merge(entity));
        et.commit();
        System.out.println("Usuario borrado.");
    }

    public Usuario findEntity(Integer id) {
        return (Usuario) em.find(Usuario.class, id);
    }

    public List<Usuario> getAll() {
        //TODO: Implementar
        return usuarios;
    }
    
}
