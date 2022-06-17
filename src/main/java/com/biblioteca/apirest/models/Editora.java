package com.biblioteca.apirest.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="TB_EDITORA")
public class Editora implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String nome;

    @OneToMany
    private List<Livro> livros;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
