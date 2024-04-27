package com.example.atividade2.repositories;

import com.example.atividade2.models.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    
}
