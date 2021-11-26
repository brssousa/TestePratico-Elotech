package br.com.bruno.service;

import br.com.bruno.core.service.AbstractCrudService;
import br.com.bruno.model.Contato;
import br.com.bruno.repository.ContatoRepository;
import br.com.bruno.service.api.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImpl extends AbstractCrudService<Contato, Integer> implements ContatoService {

    @Autowired
    ContatoRepository repository;

    @Override
    public JpaRepository getRepository() {
        return repository;
    }

}
