package br.com.bruno.service.api;

import br.com.bruno.core.service.api.BaseCrudService;
import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService extends BaseCrudService<Pessoa, Integer> {

    Pessoa findByNome(String nome) throws CustonException;
    Page<Pessoa> findAll(Pageable pageable);
}
