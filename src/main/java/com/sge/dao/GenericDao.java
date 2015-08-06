/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sge.dao;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface GenericDao<T,ID> {
    
    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T findEntity(ID id);
    public List<T> getAll(); 
    
}
