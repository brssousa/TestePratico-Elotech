package br.com.bruno.repository;

import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Contato;
import br.com.bruno.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {
    Page<Contato> findAll(Pageable pageable);
    List<Contato> findAllByPessoa(Pessoa pessoa) throws CustonException;
}
