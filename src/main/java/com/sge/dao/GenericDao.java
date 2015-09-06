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
