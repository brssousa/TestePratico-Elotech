package br.com.bruno.service;

import br.com.bruno.exception.CustonException;
import br.com.bruno.model.Pessoa;
import br.com.bruno.service.api.PessoaService;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class PessoaServiceImplTeste {

    private PessoaService service;
    private Pessoa pessoa;

    @Before
    public void setup() {
        service = new PessoaServiceImpl();
        pessoa = new Pessoa();
    }

    @Test
    public void testeSave_NomeVazio(){
        pessoa.setCpf("543.550.215-21");
        pessoa.setDataNascimento(new Date());

        try {
            service.save(pessoa);
            Assert.fail("O nome deveria estar null");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Nome não pode ser em branco."));
        }
    }

    @Test
    public void testeSave_NascimentoVazio(){
        pessoa.setNome("Bruno Lucio");
        pessoa.setCpf("543.550.215-21");

        try {
            service.save(pessoa);
            Assert.fail("Data de Nascimento deveria estar null");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Data de Nascimento não pode ser em branco."));
        }
    }

    @Test
    public void testeSave_DataNascimentoMaiorHoje(){
        pessoa.setNome("Bruno Lucio");
        pessoa.setCpf("543.550.215-21");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        pessoa.setDataNascimento(calendar.getTime());

        try {
            service.save(pessoa);
            Assert.fail("Data de Nascimento deveria estar mais atual que hoje");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("A Data de Nascimento não pode ser maior que a data de hoje."));
        }

    }

    @Test
    public void testeSave_CPFVazio(){
        pessoa.setNome("Bruno Lucio");
        pessoa.setDataNascimento(new Date());

        try {
            service.save(pessoa);
            Assert.fail("CPF deveria estar null");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("CPF não pode ser em branco."));
        }
    }

    @Test
    public void testeValidaCPF_CpfInvalido(){
        String cpfInvalid = "095.856.445-21";
        pessoa.setNome("Bruno Lucio");
        pessoa.setCpf(cpfInvalid);
        pessoa.setDataNascimento(new Date());

        try {
            service.save(pessoa);
            Assert.fail("Cpf deveria ser invalido.");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("Este CPF não é valido."));
        }

    }

    @Test
    public void testeSave_ListaContatoVazio(){
        pessoa.setNome("Bruno Lucio");
        pessoa.setCpf("543.550.215-21");
        pessoa.setDataNascimento(new Date());

        try {
            service.save(pessoa);
            Assert.fail("Lista contato deveria estar null");
        } catch (CustonException e){
            MatcherAssert.assertThat(e.getMessage(), CoreMatchers.is("A pessoa deve possuir ao menos um contato."));
        }
    }


}
