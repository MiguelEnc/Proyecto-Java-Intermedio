package com.sge.dao.impl;

import com.sge.dao.GrupoUsuarioDao;
import static com.sge.dao.ServiceDao.em;
import com.sge.entity.GrupoUsuario;
import com.sge.entity.Usuario;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author miguel
 */
public class GrupoUsuarioDaoImpl implements GrupoUsuarioDao{
    
    public EntityTransaction et;

    public GrupoUsuarioDaoImpl() {
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
        Query query = em.createNamedQuery("GrupoUsuario.findAll");
        return query.getResultList();
    }

    public GrupoUsuario getGrupoUsuarioByGrupoId(int grupoId) {
        Query query = em.createNamedQuery("GrupoUsuario.findByGrupo");
        query.setParameter("grupo", grupoId);
        
        if(query.getSingleResult() != null)
            return (GrupoUsuario) query.getSingleResult();
        else
            return null;
    }

    
    
}
