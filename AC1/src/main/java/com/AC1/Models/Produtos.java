package com.AC1.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int idProduto;
    @Column(name = "prod_nome",length = 200)
    private String prodNome;
    @Column(name = "prod_qtd")
    private int quantidade;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_categoria")
    private CategoriasProdutos categoriasProdutos;

    public Produtos(int idProduto, String prodNome, int quantidade) {
        this.idProduto = idProduto;
        this.prodNome = prodNome;
        this.quantidade = quantidade;
    }

    public Produtos() {
    }

    @Override
    public String toString() {
        return "Produtos [id=" + idProduto + ", nome=" + prodNome + ", quantidade=" + quantidade + "]";
    }

    public CategoriasProdutos getCategoriasProdutos() {
        return categoriasProdutos;
    }

    public void setCategoriasProdutos(CategoriasProdutos categoriasProdutos) {
        this.categoriasProdutos = categoriasProdutos;
    }

}
