package br.com.bruno.service;

import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Contato;
import br.com.bruno.service.api.ContatoService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContatoServiceImplTeste {

    private ContatoService service;
    private Contato contato;

    @Before
    public void setup() {
        service = new ContatoServiceImpl();
        contato = new Contato();
    }

    @Test
    public void testeSave_NomeVazio(){
        contato.setTelefone("35984552102");
        contato.setEmail("bruno@bruno.com.br");

        try {
            service.save(contato);
            Assert.fail("O nome deveria estar null");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Nome não pode ser em branco."));
        }
    }

    @Test
    public void testeSave_TelefoneVazio(){
        contato.setNome("Pablo");
        contato.setEmail("bruno@bruno.com.br");

        try {
            service.save(contato);
            Assert.fail("O Telefone deveria estar null");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Telefone não pode ser em branco."));
        }
    }

    @Test
    public void testeSave_EmailVazio(){
        contato.setNome("Pablo");
        contato.setTelefone("35984552102");

        try {
            service.save(contato);
            Assert.fail("O Email deveria estar null");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("E-mail não pode ser em branco."));
        }
    }

    @Test
    public void testeSave_EmailInvalido(){
        contato.setNome("Pablo");
        contato.setTelefone("35984552102");
        contato.setEmail("bruno@gmail.com");

        try {
            service.save(contato);
            Assert.fail("O Email deveria ser invalido");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Não é um e-mail valido"));
        }
    }
}
