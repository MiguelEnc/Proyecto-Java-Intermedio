package com.sge.dao;

import com.sge.entity.GrupoUsuario;

/**
 *
 * @author miguel
 */
public interface GrupoUsuarioDao extends GenericDao<GrupoUsuario,Integer>, ServiceDao{
    
    public GrupoUsuario getGrupoUsuarioByGrupoId(int grupoId);
}
