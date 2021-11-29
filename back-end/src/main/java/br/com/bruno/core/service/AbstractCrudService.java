package br.com.bruno.core.service;

import br.com.bruno.core.service.api.BaseCrudService;
import br.com.bruno.core.service.api.Validacoes;
import br.com.bruno.exception.CustonException;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T, ID> implements BaseCrudService<T, ID>, Validacoes<T> {

    @Override
    public List<T> findAll() throws CustonException {
        return getRepository().findAll();
    }

    @Override
    public T save(T entity) throws CustonException {
        Object obj;
        this.validacao(entity);
        this.beforeSafe(entity);
        this.getRepository().save(entity);
        this.afterSafe(entity);
        obj = entity;
        return (T) obj;
    }

    @Override
    public T update(T entity) throws CustonException {
        Object obj;
        this.validacao(entity);
        this.getRepository().save(entity);
        obj = entity;
        return (T) obj;
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

    @Override
    public void validacao(T entity) throws CustonException{
    }

    @Override
    public void beforeSafe(T entity) {

    }

    @Override
    public void afterSafe(T entity) {

    }
}
