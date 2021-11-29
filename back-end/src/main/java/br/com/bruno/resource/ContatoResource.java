package br.com.bruno.resource;

import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Contato;
import br.com.bruno.model.Pessoa;
import br.com.bruno.service.api.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoResource {

    @Autowired
    ContatoService service;

    @GetMapping("/list")
    public ResponseEntity<Page<Contato>> findAll(Pageable pageable){
        Page<Contato> contatoList = service.findAll(pageable);
        if(contatoList!=null && !contatoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(contatoList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<List<Contato>> findByIdPessoa(@PathVariable(value = "id") Integer id) throws CustonException {
        List<Contato> contatoList = service.findByIdPessoa(id);
        if(contatoList!=null && !contatoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(contatoList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
