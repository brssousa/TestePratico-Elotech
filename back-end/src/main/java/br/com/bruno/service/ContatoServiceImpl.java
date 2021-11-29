package br.com.bruno.service;

import br.com.bruno.core.service.AbstractCrudService;
import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Contato;
import br.com.bruno.model.Pessoa;
import br.com.bruno.repository.ContatoRepository;
import br.com.bruno.service.api.ContatoService;
import br.com.bruno.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoServiceImpl extends AbstractCrudService<Contato, Integer> implements ContatoService {

    @Autowired
    ContatoRepository repository;

    @Override
    public JpaRepository getRepository() {
        return repository;
    }

    @Override
    public Page<Contato> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Contato> findByIdPessoa(Integer id) throws CustonException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        return repository.findAllByPessoa(pessoa);
    }

    @Override
    public void validacao(Contato contato) throws CustonException {

        if (contato.getNome()==null || contato.getNome()==""){
            throw new CustonException("Nome não pode ser em branco.");
        }

        if (contato.getTelefone()==null || contato.getTelefone()==""){
            throw new CustonException("Telefone não pode ser em branco.");
        }

        if (contato.getEmail()==null || contato.getEmail()==""){
            throw new CustonException("E-mail não pode ser em branco.");
        }

        if (!Utils.isEmail(contato.getEmail())){
            throw new CustonException("Não é um e-mail valido");
        }

        super.validacao(contato);
    }
}
