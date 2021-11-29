package br.com.bruno.core.service.api;

import br.com.bruno.exception.CustonException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseCrudService<T, ID> {

    JpaRepository getRepository();

    List<T> findAll() throws CustonException;
    T save(T entity) throws CustonException;
    T update(T entity) throws CustonException;
    T findById(Integer id) throws CustonException;
    void delete(Integer id) throws CustonException;
    void beforeSafe(T entity);
    void afterSafe(T entity);
}
