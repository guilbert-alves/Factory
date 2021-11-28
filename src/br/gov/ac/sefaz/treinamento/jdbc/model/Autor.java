package br.gov.ac.sefaz.treinamento.jdbc.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Autor implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    private Integer idade;

    private LocalDate nascimento;

    private String cometario;

    public Autor() {
    }

    public Autor(Integer id, String nome, Integer idade, LocalDate nascimento, String cometario) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.nascimento = nascimento;
        this.cometario = cometario;
    }

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getCometario() {
        return cometario;
    }

    public void setCometario(String cometario) {
        this.cometario = cometario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nome, autor.nome) && Objects.equals(idade, autor.idade) && Objects.equals(nascimento, autor.nascimento) && Objects.equals(cometario, autor.cometario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade, nascimento, cometario);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nascimento=" + nascimento +
                ", cometario='" + cometario + '\'' +
                '}';
    }
}