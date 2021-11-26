package br.com.bruno.service;

import br.com.bruno.core.service.AbstractCrudService;
import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Pessoa;
import br.com.bruno.repository.PessoaRepository;
import br.com.bruno.service.api.PessoaService;
import br.com.bruno.util.Utils;
import br.com.bruno.util.ValidaCPF;
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

    @Override
    public void validacao(Pessoa pessoa) throws CustonException{

        if (pessoa.getNome()==null || pessoa.getNome()==""){
            throw new CustonException("Nome não pode ser em branco.");
        }

        if (pessoa.getCpf()==null || pessoa.getCpf()==""){
            throw new CustonException("CPF não pode ser em branco.");
        }

        if(!ValidaCPF.isCPF(pessoa.getCpf())){
            throw new CustonException("Este CPF não é valido.");
        }

        if (pessoa.getDataNascimento()==null){
            throw new CustonException("Data de Nascimento não pode ser em branco.");
        }

        if(Utils.isDataFutura(pessoa.getDataNascimento())){
            throw new CustonException("A Data de Nascimento não pode ser maior que a data de hoje.");
        }

        if (pessoa.getContatoList()==null || pessoa.getContatoList().isEmpty()){
            throw new CustonException("A pessoa deve possuir ao menos um contato.");
        }

        super.validacao(pessoa);
    }
}
