package com.AC1.Repository;

import com.AC1.Models.Produto;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    @Query("SELECT p FROM Produto p WHERE p.preco > :valor")
    public List<Produto> findByPrecoGreaterThan(Double valor);

    @Query("SELECT p FROM Produto p WHERE p.preco <= :valor")
    public List<Produto> findByPrecoLessThanOrPrecoEquals(Double valor);

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :nome")
    public List<Produto> findProdutoStartingWith(String nome);
}
