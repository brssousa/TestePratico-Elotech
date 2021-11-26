package br.com.bruno.resource;

import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Pessoa;
import br.com.bruno.service.api.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    PessoaService service;

    @GetMapping("/list")
    public ResponseEntity<List<Pessoa>> list() throws CustonException {
        List<Pessoa> pessoaList = service.findAll();
        if(pessoaList!=null && !pessoaList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(pessoaList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable(value = "id") Integer id){
        try {
            Pessoa pessoa = service.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(pessoa);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) throws CustonException {
        Pessoa save = service.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping("/edit")
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) throws CustonException {
        Pessoa update = service.update(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id) throws CustonException {
        service.delete(id);
    }
}
