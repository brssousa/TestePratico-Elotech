package br.com.bruno.service.api;

import br.com.bruno.core.service.api.BaseCrudService;
import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Contato;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContatoService extends BaseCrudService<Contato, Integer> {
    Page<Contato> findAll(Pageable pageable);
    List<Contato> findByIdPessoa(Integer id) throws CustonException;
}
