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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoResource {

    @Autowired
    ContatoService service;

    @GetMapping("/listAll")
    public ResponseEntity<List<Contato>> listAll() throws CustonException {
        List<Contato> contatoList = service.findAll();
        if(contatoList!=null && !contatoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(contatoList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

    @PostMapping("/create")
    public ResponseEntity<Contato> save(@RequestBody Contato contato) throws CustonException {
        Contato save = service.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/edit")
    public ResponseEntity<Contato> update(@RequestBody Contato contato) throws CustonException {
        Contato update = service.update(contato);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id) throws CustonException {
        service.delete(id);
    }
}
