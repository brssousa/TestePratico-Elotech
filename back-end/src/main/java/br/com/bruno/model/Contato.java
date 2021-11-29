package br.com.bruno.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String telefone;

    private String email;

    @ManyToOne
    @JoinColumn(name = "pessoa")
    private Pessoa pessoa;

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato)) return false;
        Contato contato = (Contato) o;
        return Objects.equals(getId(), contato.getId()) &&
                Objects.equals(getNome(), contato.getNome()) &&
                Objects.equals(getTelefone(), contato.getTelefone()) &&
                Objects.equals(getEmail(), contato.getEmail()) &&
                Objects.equals(getPessoa(), contato.getPessoa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getTelefone(), getEmail(), getPessoa());
    }
}
