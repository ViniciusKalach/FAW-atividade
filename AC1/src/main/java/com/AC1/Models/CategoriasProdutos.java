package com.AC1.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_categorias")
public class CategoriasProdutos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private int id;
    @Column(name = "cat_nome",length = 200)
    private String catNome;
    @Column(name = "cat_descricao")
    private String catDescricao;

    @OneToMany(mappedBy = "categoriasProdutos")
    private List<Produtos> produtos;

    public CategoriasProdutos(int idCategoria, String catNome, String catDescricao) {
        this.id = idCategoria;
        this.catNome = catNome;
        this.catDescricao = catDescricao;
    }

    public CategoriasProdutos() {
    }

    @Override
    public String toString() {
        return "Categorias [id=" + id + ", nome=" + catNome + ", descrição=" + catDescricao + "]";
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }
}
