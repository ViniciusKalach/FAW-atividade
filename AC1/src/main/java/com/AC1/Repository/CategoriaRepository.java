package com.AC1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.AC1.Models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNome(String nome);

    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.produtos WHERE c.id = :id")
    Categoria findCategoriaByProdutosID(@Param("id") Long id);
}
