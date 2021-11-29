package br.com.bruno.model;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Contato> contatoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Contato> getContatoList() {
        return contatoList;
    }

    public void setContatoList(List<Contato> contatoList) {
        this.contatoList = contatoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getId(), pessoa.getId()) &&
                Objects.equals(getNome(), pessoa.getNome()) &&
                Objects.equals(getCpf(), pessoa.getCpf()) &&
                Objects.equals(getDataNascimento(), pessoa.getDataNascimento()) &&
                Objects.equals(getContatoList(), pessoa.getContatoList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getDataNascimento(), getContatoList());
    }
}
