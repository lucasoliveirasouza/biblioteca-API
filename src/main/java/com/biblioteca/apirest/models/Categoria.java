package com.biblioteca.apirest.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TB_CATEGORIA")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String descricao;

    @OneToMany
    private List<Livro> livros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
