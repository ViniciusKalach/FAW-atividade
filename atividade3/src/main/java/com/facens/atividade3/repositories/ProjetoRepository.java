package com.facens.atividade3.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facens.atividade3.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
    Projeto findProjetoWithFuncionarioById(@Param("id") Long id);

    @Query("SELECT p FROM Projeto p WHERE p.dataInicio BETWEEN :startDate AND :endDate")
    List<Projeto> findProjetosByDataInicioBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}

