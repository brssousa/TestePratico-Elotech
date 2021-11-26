package br.com.bruno.service;

import br.com.bruno.core.service.AbstractCrudService;
import br.com.bruno.model.Pessoa;
import br.com.bruno.repository.PessoaRepository;
import br.com.bruno.service.api.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl  extends AbstractCrudService<Pessoa, Integer> implements PessoaService {

    @Autowired
    PessoaRepository repository;

    @Override
    public JpaRepository getRepository() {
        return repository;
    }
}
