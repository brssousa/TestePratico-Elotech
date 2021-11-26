package br.com.bruno.core.service;

import br.com.bruno.core.service.api.BaseCrudService;
import br.com.bruno.exception.CustonException;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T, ID> implements BaseCrudService<T, ID> {

    @Override
    public List<T> findAll() throws CustonException {
        return getRepository().findAll();
    }

    @Override
    public T save(T entity) throws CustonException {
        return (T) getRepository().save(entity);
    }

    @Override
    public T update(T entity) throws CustonException {
        return (T) getRepository().save(entity);
    }

    @Override
    public T findById(Integer id) throws CustonException {
        Optional<T> entity = getRepository().findById(id);
        return entity.get();
    }

    @Override
    public void delete(Integer id) throws CustonException {
        T entity = findById(id);
        if(entity != null) getRepository().delete(entity);
    }
}
