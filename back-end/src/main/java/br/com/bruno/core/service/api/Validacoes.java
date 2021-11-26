package br.com.bruno.core.service.api;

import br.com.bruno.exception.CustonException;

public interface Validacoes<T> {

    void validacao(T entity) throws CustonException;
}
