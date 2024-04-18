package com.facens.atividade3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facens.atividade3.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer>{

    @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionario WHERE funcionario.id = :id")
    Funcionario findProjetoWithFuncionarioById(@Param("id") Long id);
    
}
