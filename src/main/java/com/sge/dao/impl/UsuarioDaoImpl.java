package com.sge.dao.impl;

import static com.sge.dao.ServiceDao.em;
import com.sge.dao.UsuarioDao;
import com.sge.entity.Usuario;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
public class UsuarioDaoImpl implements UsuarioDao{

    public EntityTransaction et;
    
    public UsuarioDaoImpl(){
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
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }
    
}
