package com.facens.atividade3.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @ManyToMany(mappedBy = "projetos")
    private List<Funcionario> funcionarios;
    
    public Projeto() {
    }

    public Projeto(String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "Projeto [id=" + id + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
                + "]";
    }
}
