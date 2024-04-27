package com.example.atividade2.repositories;

import com.example.atividade2.models.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos,Long>{
    
}
