package br.com.bruno.repository;

import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

    Pessoa findByNome(String nome) throws CustonException;
    Page<Pessoa> findAll(Pageable pageable);

}
